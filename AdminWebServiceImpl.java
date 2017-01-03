package com.xpress.spt.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.annotation.Secured;

import com.xpress.spt.bean.SptCriteria;
import com.xpress.spt.bean.SptCriteriaService;
import com.xpress.spt.bean.SptRestricted;
import com.xpress.spt.bean.SptRestrictedId;
import com.xpress.spt.bean.SptType;
import com.xpress.spt.bean.bscs.FuPack;
import com.xpress.spt.bean.bscs.Mpulktmb;
import com.xpress.spt.bean.bscs.Mpusntab;
import com.xpress.spt.bean.bscs.PricegroupAll;
import com.xpress.spt.bean.bscs.Rateplan;
import com.xpress.spt.bean.bscs.RulePack;
import com.xpress.spt.bean.bscs.SyAmountsuser;
import com.xpress.spt.bean.bscs.SyAmountvalues;
import com.xpress.spt.bean.bscs.Users;
import com.xpress.spt.service.LookUpService;
import com.xpress.spt.service.PromoAdminService;
import com.xpress.spt.util.Utils;

@Secured ({"ROLE_USER"})
@WebService(endpointInterface = "com.xpress.spt.ws.AdminWebService")
public class AdminWebServiceImpl implements AdminWebService {
	Logger logger = Logger.getLogger(AdminWebServiceImpl.class);
	
	public void addRestrictedPricegroupsWs(List<String> list) {
		logger.info("Adding " + list.size()+ " Restricted PriceGroups");
		ApplicationContext context = Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		
		for (int i = 0; i < list.size(); i++) {
			Long num = new Long(list.get(i));
			SptRestrictedId sr = new SptRestrictedId();
			SptRestricted srs = new SptRestricted();
			sr.setPrgcode(num);
			srs.setId(sr);
			srv.addSptRestricted(srs);
		}
	}
	public void addRestrictedRateplansWs(List<String> list) {
		logger.info("Adding " + list.size()+ " Restricted Rateplans");
		ApplicationContext context = Utils.getContext();

		PromoAdminService srv = (PromoAdminService) context
				.getBean("PromoAdminService");

		for (int i = 0; i < list.size(); i++) {
			Long num = new Long(list.get(i));
			SptRestrictedId sr = new SptRestrictedId();
			SptRestricted srs = new SptRestricted();
			sr.setTmcode(num);
			srs.setId(sr);
			srv.addSptRestricted(srs);
		}

	}

	public void addRestrictedServicesWs(List<String> list) {
		logger.info("Adding " + list.size()+ " Restricted Services");
		ApplicationContext context = Utils.getContext();

		PromoAdminService srv = (PromoAdminService) context
				.getBean("PromoAdminService");
		for (int i = 0; i < list.size(); i++) {
			Long num = new Long(list.get(i));
			SptRestrictedId sr = new SptRestrictedId();
			SptRestricted srs = new SptRestricted();
			sr.setSncode(num);
			srs.setId(sr);
			srv.addSptRestricted(srs);
		}
	}

	public List<PricegroupAll> getNonRestrictedPricegroupsWs() {
		logger.info("Getting Non_Restricted_PriceGroups");
		ApplicationContext context = Utils.getContext();
		LookUpService lookUpService = (LookUpService) context.getBean("lookupService");
		List<PricegroupAll> lst = lookUpService.getNonRestrictedPricegroups();
		logger.info("Found " + lst.size()+ " Non_Restricted_PriceGroups");
		return lst;
	}

	public List<Rateplan> getNonRestrictedRateplansWs() {
		logger.info("Getting Non_Restricted_RatePlans");
		ApplicationContext context = Utils.getContext();
		LookUpService lookUpService = (LookUpService) context
				.getBean("lookupService");
		logger.info("Found " + lookUpService.getNonRestrictedRateplansAll1().size()+ " Non_Resticted_Rate_Plan");
		return lookUpService.getNonRestrictedRateplansAll1();
	}

	public List<Mpusntab> getNonRestrictedServicesByTmWs(Rateplan rp) {
		logger.info("Getting Non_Restricted_Services in a certain RatePlan");
		ApplicationContext context = Utils.getContext();
		LookUpService lookUpService = (LookUpService) context.getBean("lookupService");
		List<Mpusntab> list = lookUpService.getNonRestrictedServicesByTm(rp);
		logger.info("Found " + list.size()+ " Non_Restricted_PriceGroups in Rateplan "+ rp.getDes());
		return list;
	}
	public List<Mpusntab> getNonRestrictedServicesByTm2Ws(Long tmcode) {
		logger.info("Getting Non_Restricted_Services in a certain RatePlan");
		ApplicationContext context = Utils.getContext();
		LookUpService lookUpService = (LookUpService) context.getBean("lookupService");
		List<Mpusntab> list = lookUpService.getNonRestrictedServicesByTm(tmcode);
		logger.info("Found " + list.size()+ " Non_Restricted_PriceGroups in Rateplan having tmcode:"+tmcode);
		return list;
	}

	public List<PricegroupAll> getRestrictedPricegroupsWs() {
		logger.info("Getting Restricted_PriceGroups");
		ApplicationContext context = Utils.getContext();
		PromoAdminService promoadminservice = (PromoAdminService) context
				.getBean("PromoAdminService");
		List<PricegroupAll> prgList = new ArrayList<PricegroupAll>();
		prgList = promoadminservice.getSptRestrictedPRGByName();
		logger.info("Found " + prgList.size()+ "Restricted_PriceGroups");
		return prgList;
	}

	public List<Rateplan> getRestrictedRateplansWs() {
		logger.info("Getting Restricted_RatePlans");
		ApplicationContext context = Utils.getContext();
		PromoAdminService promoadminservice = (PromoAdminService) context
				.getBean("PromoAdminService");
		List<Rateplan> prgList = new ArrayList<Rateplan>();

		prgList = promoadminservice.getSptRestrictedTM();
		logger.info("Found " + prgList.size()+ "Restricted_Rateplans");
		return prgList;
	}

	public List<Mpusntab> getRestrictedServicesWs() {
		logger.info("Getting Restricted_Services");
		ApplicationContext context = Utils.getContext();
		PromoAdminService promoadminservice = (PromoAdminService) context
				.getBean("PromoAdminService");
		List<Mpusntab> prgList = new ArrayList<Mpusntab>();
		prgList = promoadminservice.getSptRestrictedSN();
		logger.info("Found " + prgList.size()+ "Restricted_Services");
		return prgList;
	}

	public void deleteRestrictedPricegroupsWs(List<String> list) {
		logger.info("Deleting Restricted_PriceGroups instances");
		ApplicationContext context = Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		for (int i = 0; i < list.size(); i++) {
			SptRestrictedId sr = new SptRestrictedId();			
			Long num = new Long(list.get(i));
			sr.setPrgcode(num);
			SptRestricted srs = new SptRestricted(sr);
			srv.deleteSptRestricted(srs);
		}
		logger.info("Deleted All");
	}

	public void deleteRestrictedRateplansWs(List<String> list) {
		logger.info("Deleting Restricted_Rateplans instances");
		ApplicationContext context = Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		for (int i = 0; i < list.size(); i++) {
			SptRestrictedId sr = new SptRestrictedId();
			Long num = new Long(list.get(i));
			sr.setTmcode(num);
			SptRestricted srs = new SptRestricted(sr);
			srv.deleteSptRestricted(srs);
		}
		logger.info("Deleted All RatePlans");
	}

	public void deleteRestrictedServicesWs(List<String> list) {
		logger.info("Deleting Restricted_Services instances");
		ApplicationContext context = Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context
				.getBean("PromoAdminService");
		for (int i = 0; i < list.size(); i++) {
			SptRestrictedId sr = new SptRestrictedId();
			Long num = new Long(list.get(i));
			sr.setSncode(num);
			SptRestricted srs = new SptRestricted(sr);
			srv.deleteSptRestricted(srs);
		}
		logger.info("Deleted All Services");
	}
	public List<Rateplan> getNonRestrictedRateplansWsByPrg(PricegroupAll prg) {
		logger.info("Getting Non_Restricted_RatePlans Within a certain PriceGroup");
		ApplicationContext context = Utils.getContext();
		LookUpService lookUpService = (LookUpService) context.getBean("lookupService");
		List<Rateplan> lst = lookUpService.getNonRestrictedRateplans(prg);
		logger.info("Found " +lst.size()+ "Rateplans in " +prg.getPrgname()+ "PricGroup");
		return lst;
	}

	public List<Mpusntab> getNonRestrictedServices() {
		logger.info("Getting Non_Restricted_Services");
		ApplicationContext context = Utils.getContext();
		LookUpService lookUpService = (LookUpService) context
				.getBean("lookupService");
		logger.info("Found " +lookUpService.getNonRestrictedServices()+ " Non_Restricted_Services");
		return lookUpService.getNonRestrictedServices();
	}

	public List<SptType> getSptTypes() {
		logger.info("Getting All SptTypes");
		ApplicationContext context = Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context
				.getBean("PromoAdminService");
		logger.info("Found "+ srv.getSptTypes().size()+ " SptTypes Instances");
		return srv.getSptTypes();
	}

	public List<Mpusntab> getNonRestrictedServicesWithParam(Rateplan rp) {
		logger.info("Getting Non_Restricted_Services with One_Parameter Within a Certain RatePlan");
		ApplicationContext context = Utils.getContext();
		LookUpService lookUpService = (LookUpService) context
				.getBean("lookupService");
		logger.info("Found " +lookUpService.getNonRestrictedServicesWithParam(rp).size()+ "Non_Restricted_Services with One_Parameter in " +rp.getDes()+ " Rateplan");
		return lookUpService.getNonRestrictedServicesWithParam(rp);
	}
	public List<Mpusntab> getNonRestrictedServicesWithOneParam(Rateplan rp) {
		logger.info("Getting Non_Restricted_Services_With One_Parameter Within a Certain Rateplan");
		ApplicationContext context = Utils.getContext();
		LookUpService lookUpService = (LookUpService) context
				.getBean("lookupService");
		logger.info("Found "+lookUpService.getNonRestrictedServicesWithOneParam(rp).size()+"Services_with_one_parameter in "+rp.getDes()+"Rateplan");
		return lookUpService.getNonRestrictedServicesWithOneParam(rp);
	}

	public List<FuPack> getParamValueForCascadeWs(Mpulktmb tm) {
		logger.info("Getting Parameter_Value_for_Services_Having_Only_one_Parameter ");
		ApplicationContext context = Utils.getContext();
		LookUpService lookUpService = (LookUpService) context
				.getBean("lookupService");
		logger.info("found "+lookUpService.getParamValueForCascade(tm).size()+"");
		return lookUpService.getParamValueForCascade(tm);
	}

	public void addSptCriteria(SptCriteria sptcriteria) {
		logger.info("Adding Criteria : "+sptcriteria.getCriteriaName());
		ApplicationContext context = Utils.getContext();
		PromoAdminService promoadminservice = (PromoAdminService) context
				.getBean("PromoAdminService");
		promoadminservice.addSptCriteria(sptcriteria);
		
		

	}
	public List<SptCriteria> getSptCriteriaByLetter(String s, String ss) {
		logger.info("Getting Spt_Criteria By Letter");
		ApplicationContext context = Utils.getContext();
		PromoAdminService promoadminservice = (PromoAdminService)context.getBean("PromoAdminService");
		List<SptCriteria> lst = promoadminservice.getSptCriteriaByLetter(s,ss);
		return lst;
	}

	@SuppressWarnings("unused")
	public List<RulePack> getBscsPromoWs() {
		logger.info("Finding Bscs Promtion WS");
		ApplicationContext context = Utils.getContext();
		PromoAdminService srv = (PromoAdminService)context.getBean("PromoAdminService");
		List<RulePack> bscsPromo = new ArrayList<RulePack>();
		bscsPromo = srv.getBscsPromo();
	    return bscsPromo;
	}
	public List<RulePack> getRestrictedPromotionsWs() {
		logger.info("Finding Restricted Promtion WS");
		ApplicationContext context =   Utils.getContext();
		PromoAdminService srv = (PromoAdminService)context.getBean("PromoAdminService");
		List<RulePack> restPromo = new ArrayList<RulePack>();
		restPromo = srv.getSptRestrictedSPT();
	    return restPromo;
	}
	public void addRestrictedPromotionsWs(List<String> list) {
		logger.info("Adding " + list.size()+ " Restricted PriceGroups");
		ApplicationContext context =  Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		for (int i = 0; i < list.size(); i++) {
			Long num = new Long(list.get(i));
			SptRestrictedId sr = new SptRestrictedId();
			SptRestricted srs = new SptRestricted();
			sr.setSptrole(num);
			srs.setId(sr);
			srv.addSptRestricted(srs);
		}
		
	}
	public void deleteRestrictedPromotionsWs(List<String> list) {
		logger.info("Deleting Restricted_Promotions instances");
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		PromoAdminService srv = (PromoAdminService) context
				.getBean("PromoAdminService");
		for (int i = 0; i < list.size(); i++) {
			SptRestrictedId sr = new SptRestrictedId();
			Long num = new Long(list.get(i));
			sr.setSptrole(num);
			SptRestricted srs = new SptRestricted(sr);
			srv.deleteSptRestricted(srs);
		}
		logger.info("Deleted All Promotions");
	}

	public List<String> getUsersWs() {
		ApplicationContext context =  Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		List<String> list = new ArrayList<String>();
		list = srv.getUsers();
		return list;
	}
	
	public List<SyAmountvalues> getPenAbsValueWs(String username) {
		ApplicationContext context =  Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		List<SyAmountvalues> list = new ArrayList<SyAmountvalues>();
		list = srv.getPenAbsValues(username);
		return list;
	}
	public List<SyAmountvalues> getPromoAbsValueWs(String username) {
		ApplicationContext context =  Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		List<SyAmountvalues> list = new ArrayList<SyAmountvalues>();
		list = srv.getPromoAbsValues(username);
		return list;
	}
	public List<SyAmountvalues> getPromoRelValueWs(String username) {
		ApplicationContext context =  Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		List<SyAmountvalues> list = new ArrayList<SyAmountvalues>();
		list = srv.getPromoRelValues(username);
		return list;
	}
	public List<SyAmountvalues> getPenAbsAllValuesWS() {
		ApplicationContext context =  Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		List<SyAmountvalues> list = new ArrayList<SyAmountvalues>();
		list = srv.getPenAbsAllValues();
		return list;
	}
	public List<SyAmountvalues> getPromoAbsAllValuesWS() {
		ApplicationContext context =  Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		List<SyAmountvalues> list = new ArrayList<SyAmountvalues>();
		list = srv.getPromoAbsAllValues();
		return list;
	}
	public List<SyAmountvalues> getPromoRelAllValuesWS() {
		ApplicationContext context =  Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		List<SyAmountvalues> list = new ArrayList<SyAmountvalues>();
		list = srv.getPromoRelAllValues();
		return list;
	}
	public List<SyAmountsuser> getAllUsers() {
		ApplicationContext context =  Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		List<SyAmountsuser> list = new ArrayList<SyAmountsuser>();
		list = srv.getAllUsers();
		return list;
	}
	public void updatePenAbsValuesWS(String username, Long value) {
		ApplicationContext context =  Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		srv.updatePenAbsValues(username, value);
		
	}
	public void updatePromoAbsValuesWS(String username, Long value) {
		ApplicationContext context =  Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		srv.updatePromoAbsValues(username, value);
	}
	public void updatePromoRelValuesWS(String username, Long value) {
		ApplicationContext context =  Utils.getContext();
		PromoAdminService srv = (PromoAdminService) context.getBean("PromoAdminService");
		srv.updatePromoRelValues(username, value);
		
	}
	public List<Rateplan> getRatePlanByTmWs(Long tmid) {
		ApplicationContext context =   Utils.getContext();
		PromoAdminService promoadminservice = (PromoAdminService)context.getBean("PromoAdminService");
		List<Rateplan> rptm = promoadminservice.getRatePlanByTmWs(tmid);
		return rptm;
	}
	public List<FuPack> getParamValueForCascade2(Long tmcode, Long sncode) {
			logger.info("Getting Parameter_Value_for_Services_Having_Only_one_Parameter ");
			ApplicationContext context =  Utils.getContext();
			LookUpService lookUpService = (LookUpService) context.getBean("lookupService");
			List<FuPack> list = lookUpService.getParamValueForCascade2(tmcode,sncode);
			logger.info("found "+list.size()+"");
			return list;

	}

	  public List<Mpusntab> getServiceBySnWs(Long snid) {
		  ApplicationContext context =   Utils.getContext();
			PromoAdminService promoadminservice = (PromoAdminService)context.getBean("PromoAdminService");
			List<Mpusntab> sn = promoadminservice.getServiceBySnWs(snid);
			return sn;
		  
	  }
	  public List<Mpusntab> getNonRestrictedWithOneParamTWO(Long tmcode) {
		ApplicationContext context =  Utils.getContext();
		LookUpService lookUpService = (LookUpService) context
		.getBean("lookupService");
List<Mpusntab> listsn = lookUpService.getNonRestrictedWithOneParamTWO(tmcode);
		return listsn;
	}
	  public int updateSptCriteria2(SptCriteria entity) {
			logger.info("Updating Criteria : "+ entity.getCriteriaName());
			ApplicationContext context =  Utils.getContext();
			PromoAdminService promoadminservice = (PromoAdminService) context.getBean("PromoAdminService");
			setSp(entity);
			int i = promoadminservice.updateSptCriteria2(entity);
			return i;
		}
		public void setSp(SptCriteria entity){
			Set<SptCriteriaService> criteriaServ = entity.getSptCriteriaServices();
			SptCriteriaService criteriaServObj = new SptCriteriaService();
			List<Mpulktmb> tmbList = new ArrayList<Mpulktmb>();
			for(int i = 0;i<criteriaServ.size();i++){
				criteriaServObj = (SptCriteriaService) criteriaServ.toArray()[i];
				tmbList = getNonRestrictedServicePackage(criteriaServObj.getId().getTmcode(),criteriaServObj.getId().getSncode());
				criteriaServObj.getId().setSpcode(tmbList.get(0).getId().getSpcode());
			}
			
		}
		public List<Mpulktmb> getNonRestrictedServicePackage(Long tm, Long sn) {
			logger.info("Getting Service Package");
			ApplicationContext context =   Utils.getContext();
			PromoAdminService promoadminservice = (PromoAdminService)context.getBean("PromoAdminService");
			List<Mpulktmb> list = new ArrayList<Mpulktmb>();
			list = promoadminservice.getNonRestrictedServicePackage(tm, sn);
			
			return list;
		}

	public List<Users> findBSCSUserWS(String username) {
		logger.info("Getting BSCS USer");
		ApplicationContext context =   Utils.getContext();
		PromoAdminService promoadminservice = (PromoAdminService)context.getBean("PromoAdminService");
		List<Users> list = new ArrayList<Users>();
		list = promoadminservice.findBSCSUserService(username);
		return list;
	}
}
