/**
 * SptProfile.as
 * This file was auto-generated from WSDL by the Apache Axis2 generator modified by Adobe
 * Any change made to this file will be overwritten when the code is re-generated.
 */

package generated.sptws.promo
{
	import mx.collections.ArrayCollection;
	import mx.rpc.soap.types.*;
	/**
	 * Wrapper class for a operation required type
	 */
    
	public class SptProfile
	{
		/**
		 * Constructor, initializes the type class
		 */
		public function SptProfile() {}
            
		public var advFlag:String;
		public var creationDate:Date;
		public var endDateCur:Date;
		public var endDateMig:Date;
		public var endDateNew:Date;
		public var glAccountDiscount:String;
		public var glAccountMincom:String;
		public var glAccountPenalty:String;
		public var jobId:Number;
		public var lastRunDate:Date;
		public var monthsPenalty:Number;
		public var priority:Number;
		public var sptBcStartDate:Date;
		public var sptDesc:String;
		public var sptLabelDynamic:String;
		public var sptLabelPenalty:String;
		public var sptLabelPromo:String;
		public var sptMaxMigSubscripers:Number;
		public var sptMaxNewSubscripers:Number;
		public var sptNumBc:Number;
		public var sptPenaltyValue:Number;
		public var sptPromoValue:Number;
		public var sptPromoValueType:String;
		[ArrayElementType("SptPromo")]
		public var sptPromos:Array;
		[ArrayElementType("SptRateplan")]
		public var sptRateplans:Array;
		public var sptShdes:String;
		public var sptStatus:generated.sptws.promo.SptStatus;
		[ArrayElementType("SptStatusHist")]
		public var sptStatusHists:Array;
		public var sptType:generated.sptws.promo.SptType;
		public var sptcode:Number;
		public var startDateCur:Date;
		public var startDateMig:Date;
		public var startDateNew:Date;
		public var username:String;
		
		[Transient]
		public var profileEvaluations:ArrayCollection = new ArrayCollection();
		[Transient]
		public var profileApplications:ArrayCollection = new ArrayCollection();
		[Transient]
		public var profileCascade:ArrayCollection = new ArrayCollection();
	}
}