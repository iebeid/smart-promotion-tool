package com.xpress.spt.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.annotation.Secured;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.User;
import org.springframework.security.userdetails.UserDetails;

import com.xpress.spt.bean.SptCriteria;
import com.xpress.spt.bean.SptProfile;
import com.xpress.spt.bean.SptStatusHist;
import com.xpress.spt.bean.SptType;
import com.xpress.spt.bean.SptUser;
import com.xpress.spt.bean.bscs.MktParameterDomain;
import com.xpress.spt.bean.bscs.MktParameterEngagement;
import com.xpress.spt.bean.bscs.Mpusntab;
import com.xpress.spt.bean.bscs.PricegroupAll;
import com.xpress.spt.bean.bscs.Rateplan;
import com.xpress.spt.bean.bscs.RulePack;
import com.xpress.spt.service.PromoAdminService;
import com.xpress.spt.service.PromotionService;
import com.xpress.spt.util.Utils;


@WebService(endpointInterface = "com.xpress.spt.ws.PromotionServiceWs") 
public class PromotionServiceWsImpl implements PromotionServiceWs{
	Logger logger = Logger.getLogger(PromotionServiceWsImpl.class);
	
	@SuppressWarnings("unchecked")
	@Secured ({"ROLE_USER"})
	public void savePromoWs(SptProfile modelprofile) {
		logger.info("Adding promotion : "+modelprofile.getSptLabelPromo());
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		srv.savePromo(modelprofile);
	}
	
	public SptUser getLoggedInUser() {
		try{
			Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
			if (obj instanceof UserDetails) {
			  return new SptUser((UserDetails)obj);
			} else {
				UserDetails user = new User("",null,true,true,true,true,new GrantedAuthorityImpl[] {});
				return new SptUser(user);
			}
		}catch(Throwable e){
			logger.error(e,e);
			return new SptUser();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Secured ({"ROLE_USER"})
	public List<SptProfile> getPromoWs(){
		logger.info("Getting Promotion");
		List<SptProfile> lst = new ArrayList<SptProfile>();
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		lst = srv.getPromo();
		logger.info("Found "+lst.size()+" Promotions");
		return lst;
		
	}
	@SuppressWarnings("unchecked")
	@Secured ({"ROLE_USER"})
	public void updatePromoWs(SptProfile modelprofile){
		logger.info("updating Promotion"+ modelprofile.getSptLabelPromo());
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		srv.updatePromo(modelprofile);
	}
	

	
	@Secured ({"ROLE_USER"})
	public void saveSptStatusHistWs(SptStatusHist statushist) {
		logger.info("Adding "+statushist.getId().getHistno() );
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		srv.saveSptStatusHist(statushist);
		
	}

	@Secured ({"ROLE_USER"})
	public List<PricegroupAll> getNonRestrictedPricegroupWs() {
		logger.info("Getting Non_Restricted_PriceGroups");
		ApplicationContext context =   Utils.getContext();
		PromotionService promotionservice = (PromotionService) context
				.getBean("PromotionService");
		logger.info("Found " + promotionservice.getNonRestrictedPricegroup().size()+ " Non_Restricted_PriceGroups");
		return promotionservice.getNonRestrictedPricegroup();
	}

	@Secured ({"ROLE_USER"})
	public List<Rateplan> getNonRestrictedRateplansWsByPrg(PricegroupAll prg) {
		logger.info("Getting Non_Restricted_RatePlans Within a certain PriceGroup");
		ApplicationContext context =   Utils.getContext();
		PromotionService promotionservice = (PromotionService) context
				.getBean("PromotionService");
		logger.info("Found " +promotionservice.getNonRestrictedRateplans2(prg).size()+ "Rateplans in " +prg.getPrgname()+ "PricGroup");
		return promotionservice.getNonRestrictedRateplans2(prg);
	}

	@Secured ({"ROLE_USER"})
	public List<Mpusntab> getNonRestrictedServicesByTmWs(Rateplan rp) {
		logger.info("Getting Non_Restricted_Services in a certain RatePlan");
		ApplicationContext context =   Utils.getContext();
		PromotionService promotionservice = (PromotionService) context
				.getBean("PromotionService");
		logger.info("Found " + promotionservice.getNonRestrictedServicesByTm1(rp).size()+ " Non_Restricted_PriceGroups in Rateplan "+ rp.getDes());
		return promotionservice.getNonRestrictedServicesByTm1(rp);
	}
	@Secured ({"ROLE_USER"})
	public List<Mpusntab> getNonRestrictedServicesWithOneParam(Rateplan rp) {
		logger.info("Getting Non_Restricted_Services_With One_Parameter Within a Certain Rateplan");
		ApplicationContext context =   Utils.getContext();
		PromotionService promotionservice = (PromotionService) context
				.getBean("PromotionService");
		logger.info("Found "+promotionservice.getNonRestrictedServicesWithOneParam1(rp).size()+"Services_with_one_parameter in "+rp.getDes()+"Rateplan");
		return promotionservice.getNonRestrictedServicesWithOneParam1(rp);
	}

	
	@Secured ({"ROLE_USER"})
	public List<SptType> getTypesWs() {
		logger.info("Getting All Instances From Spt_Type");
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<SptType> lst = new ArrayList<SptType>();
		lst = srv.getTypes();
		logger.info("Found "+ lst.size()+ "Spt_Types");
		return lst;
	}
	@Secured ({"ROLE_USER"})
	public List<Rateplan> getPromoRateplans() {
		logger.info("Getting RatePlans from BSCS Using Tmcode of SptRateplan");
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		return srv.getPromoRateplans();
	}
	@Secured ({"ROLE_USER"})
	public List<PricegroupAll> getPromoPrg() {
		logger.info("Getting PriceGroups from BSCS Using Prgcode of SptRateplan");
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		return srv.getPromoPrg();
	}
	@Secured ({"ROLE_USER"})
	public List<Mpusntab> getServiceBylist_RP(List<Rateplan> ratep) {
		logger.info("Getting PriceGroups from BSCS Using Prgcode of SptRateplan");
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<Mpusntab> snserv = new ArrayList<Mpusntab>();
		snserv = srv.getServiceBylist_RP(ratep);
		return snserv;
	}
	@Secured ({"ROLE_USER"})
	public List<SptProfile> getSptProfileByName(String s, int l) {
		logger.info("Getting Spt_Profile By Name");
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List <SptProfile> list = srv.getSptProfileByName(s, l);
		logger.info("Found "+list.size()+ " Having The Name : "+ s);
		return list;
	}
	@Secured ({"ROLE_USER"})
	public List<RulePack> getBscsPromoWs() {
		logger.info("Finding Bscs Promtion WS");
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<RulePack> bscsPromo = new ArrayList<RulePack>();
		bscsPromo = srv.getBscsPromo1();
	    return bscsPromo;
	}

	@Secured ({"ROLE_USER"})
	public List<Mpusntab> getNonRestrictedServicesWithAmountByRatePlan(
			Rateplan ratep) {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<Mpusntab> l = srv.getNonRestrictedServicesWithAmountByRatePlan(ratep);
		logger.info("Found "+l.size());
		return l;
	}
	@Secured ({"ROLE_USER"})
	public List<Mpusntab> getNonRestrictedWithTwoParam(Rateplan ratep) {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<Mpusntab> l = srv.getNonRestrictedWithTwoParam(ratep);
		logger.info("Found "+l.size());
		return l;
	}
	@Secured ({"ROLE_USER"})
	public List<MktParameterEngagement> getEngagement(Long tmcode, Long sncode) {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<MktParameterEngagement> l = srv.getEngagement(tmcode, sncode);
		logger.info("Found "+l.size());
		return l;
	}
	@Secured ({"ROLE_USER"})
	public List<MktParameterDomain> getEngagement2(Long tmcode, Long sncode) {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<MktParameterDomain> l = srv.getEngagement2(tmcode, sncode);
		logger.info("Found "+l.size());
		return l;
	}
	@Secured ({"ROLE_USER"})
	public List<MktParameterDomain> getPack(Long tmcode, Long sncode) {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<MktParameterDomain> lst = srv.getPack(tmcode, sncode);
		return lst;
	}
	@Secured ({"ROLE_USER"})
	public List<SptCriteria> getSptCriteriaByRateplan(Long tmcode) {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<SptCriteria> lst = srv.getSptCriteriaByRateplan(tmcode);
		logger.info("found: "+lst.size()+ " SptCriteria");
		return lst;
		
	}
	@Secured ({"ROLE_USER"})
	public List<Mpusntab> getCascadeServiceByRateplanWS(Long tmid) {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<Mpusntab> lst = srv.getCascadeServiceByRateplan(tmid);
		return lst;
	}
	
	@Secured ({"ROLE_USER"})
	public String getPromoCount() {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		String s = srv.getPromoCount();
		return s;
	}
	@Secured ({"ROLE_USER"})
	public List<PricegroupAll> getPriceGroupByPrg(List<String> prgs){
		
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		return srv.findPriceGroupByPrgWs(prgs);
	}
	@Secured ({"ROLE_USER"})
	public List<MktParameterDomain> getParamDescWS(final Long paramId,final Long seqNo) {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<MktParameterDomain> mktList = new ArrayList<MktParameterDomain>();
		mktList = srv.getParamDesc(paramId, seqNo);
		return mktList; 
	}
	@Secured ({"ROLE_USER"})
	public List<Rateplan> getRatePlanByTmWs(Long tmid) {
		ApplicationContext context =   Utils.getContext();
		PromotionService promoservice = (PromotionService)context.getBean("PromotionService");
		List<Rateplan> promoservices = promoservice.getRatePlanByTmWs(tmid);
		return promoservices;
	}
	@Secured ({"ROLE_USER"})
	public List<SptProfile> getAllSptProfile() {
		ApplicationContext context =   Utils.getContext();
		PromotionService promoservice = (PromotionService)context.getBean("PromotionService");
		List<SptProfile> sptp = promoservice.getAllSptProfile();
		return sptp;
	}
	@Secured ({"ROLE_USER"})
	public SptProfile updateStatus(SptProfile sptprofile, SptStatusHist sptsh) {
		logger.info("Updating Status_TYPE of SPT_PROMOTION");
		ApplicationContext context =   Utils.getContext();
		PromotionService promoservice = (PromotionService)context.getBean("PromotionService");
		SptProfile sptp = promoservice.updateStatus(sptprofile, sptsh);
		logger.info("Update Of Status_Type Successful");
		return sptp;		
	}
	@Secured ({"ROLE_USER"})
	 public List<Mpusntab> getServiceBySnWs(Long snid) {
		  ApplicationContext context =   Utils.getContext();
			PromoAdminService promoadminservice = (PromoAdminService)context.getBean("PromoAdminService");
			List<Mpusntab> sn = promoadminservice.getServiceBySnWs(snid);
			return sn;
		  
	  }
	@Secured ({"ROLE_USER"})
	public List<SptProfile> getPromoBySptCodeLocalWs(Long sptCode) {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<SptProfile> bscsPromoList = new ArrayList<SptProfile>();
		bscsPromoList = srv.getPromoBySptCodeLocal(sptCode);
		return bscsPromoList;
		
	}
	@Secured ({"ROLE_USER"})
	public List<RulePack> getPromoBySptCodeWs(SptProfile spt) {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<RulePack> bscsPromoList = new ArrayList<RulePack>();
		bscsPromoList = srv.getPromoBySptCode(spt);
		return bscsPromoList;
	}
	@Secured ({"ROLE_USER"})
	public List<String> getRateplanPricegroupCombinedWs(Long sptCode) {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		List<PricegroupAll> listPRG = new ArrayList<PricegroupAll>();
		listPRG = srv.getRateplanPricegroupService2(sptCode);
		List<Rateplan> listRP = new ArrayList<Rateplan>();
		listRP = srv.getRateplanPricegroupService(sptCode);
		List<String> listString = new ArrayList<String>();
		for(int i=0;i<listPRG.size();i++){
			PricegroupAll prg = listPRG.get(i);
			Rateplan rp = listRP.get(i);
			String str = rp.getDes() + "/" + prg.getPrgname();
			listString.add(str);
		}
		for(int j=0;j<listString.size();j++){
			String var1 = listString.get(j);
			String var2 = listString.get(j+1);
			if(var2.equals(var1)){
				listString.remove(j+1);
			}else{
				
			}
		}
		return listString;
	}
	
	@Secured ({"ROLE_USER"})
	public int getGlaccountById(String id , String idMincom , String idPen){
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		int temp = srv.getGlaccountById(id , idMincom , idPen);		
		return temp;
	}
	
	@Secured ({"ROLE_USER"})
	public boolean isUniqueLabel(String promotionLabel) {
		ApplicationContext context =   Utils.getContext();
		PromotionService srv = (PromotionService)context.getBean("PromotionService");
		
		if(srv.isUniqueLabel(promotionLabel))
			return true ;
		
		return false ;
	}

}
