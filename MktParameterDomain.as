/**
 * MktParameterDomain.as
 * This file was auto-generated from WSDL by the Apache Axis2 generator modified by Adobe
 * Any change made to this file will be overwritten when the code is re-generated.
 */

package generated.sptws.promo
{
	import mx.utils.ObjectProxy;
	import flash.utils.ByteArray;
	import mx.rpc.soap.types.*;
	/**
	 * Wrapper class for a operation required type
	 */
    
	public class MktParameterDomain
	{
		/**
		 * Constructor, initializes the type class
		 */
		public function MktParameterDomain() {}
            
		public var entryDate:Date;
		public var id:generated.sptws.promo.MktParameterDomainId;
		public var mktParameter:generated.sptws.promo.MktParameter;
		public var modifyDate:Date;
		public var modifyUser:String;
		public var prmValueDate:Date;
		public var prmValueDef:String;
		public var prmValueDes:String;
		public var prmValueNumber:Number;
		public var prmValueString:String;
		public var recVersion:Number;
		[Transient]
		public var rateplan:Rateplan;
	}
}