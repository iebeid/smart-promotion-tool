 package com.xpress.spt.ws;

import java.util.List;

import javax.jws.WebService;

import com.xpress.spt.bean.SptCriteria;
import com.xpress.spt.bean.bscs.FuPack;
import com.xpress.spt.bean.bscs.Mpulktmb;
import com.xpress.spt.bean.bscs.Mpusntab;
import com.xpress.spt.bean.bscs.PricegroupAll;
import com.xpress.spt.bean.bscs.Rateplan;
import com.xpress.spt.bean.bscs.RulePack;
import com.xpress.spt.bean.bscs.SyAmountsuser;
import com.xpress.spt.bean.bscs.SyAmountvalues;
import com.xpress.spt.bean.bscs.Users;

@WebService
public interface AdminWebService {
public List<Mpusntab> getNonRestrictedServicesByTmWs(Rateplan rp);
public List<Mpusntab> getNonRestrictedServicesByTm2Ws(Long tmcode);
public List<Rateplan> getNonRestrictedRateplansWs();
public List<PricegroupAll> getNonRestrictedPricegroupsWs();
public List<Mpusntab> getNonRestrictedServices();
public List<Mpusntab> getNonRestrictedServicesWithParam(Rateplan rp);
public List<Mpusntab> getNonRestrictedServicesWithOneParam(Rateplan rp);
public List<Rateplan> getNonRestrictedRateplansWsByPrg(PricegroupAll prg);

public List<Rateplan> getRestrictedRateplansWs();
public List<Mpusntab> getRestrictedServicesWs();
public List<FuPack> getParamValueForCascadeWs(Mpulktmb tm);
public List<PricegroupAll> getRestrictedPricegroupsWs();
public void addRestrictedRateplansWs(List<String> rp);
public void addRestrictedPricegroupsWs(List<String> prg);
public void addRestrictedServicesWs(List<String> sn);
public void addRestrictedPromotionsWs(List<String> list);
public void deleteRestrictedRateplansWs(List<String> rp);
public void deleteRestrictedPricegroupsWs(List<String> rp);
public void deleteRestrictedServicesWs(List<String> rp);
public void deleteRestrictedPromotionsWs(List<String> list);
public void addSptCriteria(SptCriteria sptcriteria);
public List<SptCriteria> getSptCriteriaByLetter(String s, String ss);
public List<RulePack> getBscsPromoWs();
public List<RulePack> getRestrictedPromotionsWs();
public List<FuPack> getParamValueForCascade2(Long tmcode, Long sncode);
public List<String> getUsersWs();
public List<SyAmountsuser> getAllUsers();
public List<SyAmountvalues> getPromoAbsValueWs(String username);
public List<SyAmountvalues> getPromoRelValueWs(String username);
public List<SyAmountvalues> getPenAbsValueWs(String username);
public int updateSptCriteria2(SptCriteria entity);
public List<SyAmountvalues> getPromoAbsAllValuesWS();

public List<SyAmountvalues> getPromoRelAllValuesWS();

public List<SyAmountvalues> getPenAbsAllValuesWS();

public void updatePenAbsValuesWS(String username,Long value);

public void updatePromoAbsValuesWS(String username,Long value);

public void updatePromoRelValuesWS(String username,Long value);

public List<Rateplan> getRatePlanByTmWs(Long tmid) ;

public List<Mpusntab> getServiceBySnWs(Long snid) ;
public List<Mpusntab> getNonRestrictedWithOneParamTWO(Long tmcode);
public List<Mpulktmb> getNonRestrictedServicePackage(final Long tm,final Long sn);
public List<Users> findBSCSUserWS(String username);
}
