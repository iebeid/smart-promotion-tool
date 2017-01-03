/**
 * PricegroupAll.as
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
    
	public class PricegroupAll
	{
		/**
		 * Constructor, initializes the type class
		 */
		public function PricegroupAll() {}
            
		public var forward:String;
		public var lettertype:String;
		public var listdirectory:String;
		public var prgDef:String;
		public var prgcode:String;
		public var prgentdate:Date;
		public var prgmod:String;
		public var prgmoddate:Date;
		public var prgname:String;
		public var prgseqnum:Number;
		public var recVersion:Number;
		public var secret:String;
		[Transient]
		public var rateplans:ArrayCollection = new ArrayCollection();
		
		public function toString():String{
			return prgcode;
		}
	}
}