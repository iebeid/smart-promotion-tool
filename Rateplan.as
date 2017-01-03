/**
 * Rateplan.as
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
    
	public class Rateplan
	{
		/**
		 * Constructor, initializes the type class
		 */
		public function Rateplan() {}
            
		public var des:String;
		public var pdeRateplan:String;
		public var preratedTapRpInd:String;
		public var recVersion:Number;
		public var serviceMixType:Number;
		public var shdes:String;
		public var tmcode:Number;
		public var tmglobal:String;
		[Transient]
		public var pricegroup:PricegroupAll;
		[Transient]
		public var evaluationServices:ArrayCollection;
		[Transient]
		public var applicationService:Mpusntab;
		[Transient]
		public var promoType:String;
		[Transient]
		public var promoValue:String;
		[Transient]
		public var penalityMonthes:int;
		[Transient]
		public var penalityValue:Number;
		[Transient]
		public var cascadeService:SptCriteria;
				
		[Transient]
		public var engagement:ArrayCollection;
		[Transient]
		public var pack:ArrayCollection;
			
		[Transient]
		public var packService:Mpusntab;
		
		public function toString():String{
			return tmcode+":"+pricegroup.prgcode
		}
	}
}