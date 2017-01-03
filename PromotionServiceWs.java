package com.xpress.spt.ws;

import java.util.List;

import javax.jws.WebService;

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

@WebService
public interface PromotionServiceWs {
	
@SuppressWarnings("unchecked")
public void savePromoWs(SptProfile modelprofile); 
public List<SptProfile> getPromoWs();
public void updatePromoWs(SptProfile modelprofile);

public void saveSptStatusHistWs(SptStatusHist statushist);
public List<Mpusntab> getNonRestrictedServicesByTmWs(Rateplan rp);
public List<PricegroupAll> getNonRestrictedPricegroupWs();
public List<Mpusntab> getNonRestrictedServicesWithOneParam(Rateplan rp);
public List<Rateplan> getNonRestrictedRateplansWsByPrg(PricegroupAll prg);
public List<SptType> getTypesWs();
public List<Rateplan> getPromoRateplans();
public List<PricegroupAll> getPromoPrg();
public List<RulePack> getBscsPromoWs();
public List<Mpusntab> getServiceBylist_RP(List<Rateplan> ratep);
public List<SptProfile> getSptProfileByName(final String s, int l);
public List<MktParameterEngagement> getEngagement(Long tmcode, Long sncode);
public List<MktParameterDomain> getEngagement2(Long tmcode, Long sncode);
public List<Mpusntab> getNonRestrictedServicesWithAmountByRatePlan(Rateplan ratep);
public List<Mpusntab> getNonRestrictedWithTwoParam(Rateplan ratep);
public List<MktParameterDomain> getPack(Long tmcode, Long sncode);
public List<SptCriteria> getSptCriteriaByRateplan(Long tmcode);
public List<Mpusntab> getCascadeServiceByRateplanWS(Long tmid); 
public String getPromoCount(); 
public List<PricegroupAll> getPriceGroupByPrg(List<String> prgs);
public List<MktParameterDomain> getParamDescWS(final Long paramId,final Long seqNo);
public List<Rateplan> getRatePlanByTmWs(Long tmid) ;
public SptUser getLoggedInUser();
public List<SptProfile> getAllSptProfile() ;
public SptProfile updateStatus(SptProfile sptprofile, SptStatusHist sptsh);
public List<Mpusntab> getServiceBySnWs(Long snid);
public List<SptProfile> getPromoBySptCodeLocalWs(Long sptCode);
public List<RulePack> getPromoBySptCodeWs(SptProfile spt); 
public List<String> getRateplanPricegroupCombinedWs(Long sptCode);
public int getGlaccountById(String id , String idMincom , String idPen);
public boolean isUniqueLabel(String promotionLabel);
}
