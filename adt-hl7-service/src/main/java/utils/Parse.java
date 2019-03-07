package utils;


import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.datatype.AD;
import ca.uhn.hl7v2.model.v22.datatype.PN;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v22.message.ADT_A02;
import ca.uhn.hl7v2.model.v22.message.ADT_A03;
import ca.uhn.hl7v2.model.v22.segment.MSH;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import ca.uhn.hl7v2.app.*;
import ca.uhn.hl7v2.llp.LLPException;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationExceptionHandler;


public class Parse {
	
	
	public String typeOfMessage(String message) {
		String msg = "MSH|^~\\&|HIS|RIH|EKG|EKG|199904140038||ADT^A01||P|2.2\r"
                + "PID|0001|00009874|00001122|A00977|SMITH^JOHN^M|MOM|19581119|F|NOTREAL^LINDA^M|C|564 SPRING ST^^NEEDHAM^MA^02494^US|0002|(818)565-1551|(425)828-3344|E|S|C|0000444444|252-00-4414||||SA|||SA||||NONE|V1|0001|I|D.ER^50A^M110^01|ER|P00055|11B^M011^02|070615^BATMAN^GEORGE^L|555888^NOTREAL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^NOTREAL^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|199904101200||||5555112333|||666097^NOTREAL^MANNY^P\r"
                + "NK1|0222555|NOTREAL^JAMES^R|FA|STREET^OTHER STREET^CITY^ST^55566|(222)111-3333|(888)999-0000|||||||ORGANIZATION\r"
                + "PV1|0001|I|D.ER^1F^M950^01|ER|P000998|11B^M011^02|070615^BATMAN^GEORGE^L|555888^OKNEL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^VOICE^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|||||5555112333|||666097^DNOTREAL^MANNY^P\r"
                + "PV2|||0112^TESTING|55555^PATIENT IS NORMAL|NONE|||19990225|19990226|1|1|TESTING|555888^NOTREAL^BOB^K^DR^MD||||||||||PROD^003^099|02|ER||NONE|19990225|19990223|19990316|NONE\r"
                + "AL1||SEV|001^POLLEN\r"
                + "GT1||0222PL|NOTREAL^BOB^B||STREET^OTHER STREET^CITY^ST^77787|(444)999-3333|(222)777-5555||||MO|111-33-5555||||NOTREAL GILL N|STREET^OTHER STREET^CITY^ST^99999|(111)222-3333\r"
                + "IN1||022254P|4558PD|BLUE CROSS|STREET^OTHER STREET^CITY^ST^00990||(333)333-6666||221K|LENIX|||19980515|19990515|||PATIENT01 TEST D||||||||||||||||||02LL|022LP554";
        HapiContext context = new DefaultHapiContext();
        Parser p = context.getGenericParser();

        Message hapiMsg;
        try {
            hapiMsg = p.parse(msg);
        } catch (EncodingNotSupportedException e) {
            e.printStackTrace();
            return null;
        } catch (HL7Exception e) {
            e.printStackTrace();
            return null;
        }
		return hapiMsg.getName();
		
	}
	
	public Map<String, String> ADT01(Message msg) {
		
		ADT_A01 adtMsg = (ADT_A01)msg;
        MSH msh = adtMsg.getMSH();
       PN patientName = adtMsg.getPID().getPatientName();
       AD[] patientDir = adtMsg.getPID().getPatientAddress();
       String familyName = patientName.getFamilyName().getValue();
       String Apellido = patientName.getGivenName().getValue();
       System.out.println(familyName);
       System.out.println(Apellido);
       String Direccion = null;
       String Zip = null;
       String City = null;
       for (int i = 0; i < patientDir.length; i++) {
     	  Direccion = patientDir[i].getStreetAddress().getValue();
     	  Zip = patientDir[i].getZipOrPostalCode().getValue();
     	  City = patientDir[i].getCity().getValue();
			System.out.println(Direccion+" "+Zip+" "+City);
		}
		
		
	    HashMap<String, String> map = new HashMap<>();
	    HashMap<String, String> mapdir = new HashMap<>();
	    map.put("nombre", Apellido);
	    map.put("apellido", familyName);
	    map.put("direccion", Direccion);
	    map.put("codigopostal", Zip);
	    map.put("estado", City);
	    return map;
	}	
	
public Map<String, String> ADT02(Message msg) {
		
		ADT_A02 adtMsg = (ADT_A02)msg;
        MSH msh = adtMsg.getMSH();
       PN patientName = adtMsg.getPID().getPatientName();
       AD[] patientDir = adtMsg.getPID().getPatientAddress();
       String familyName = patientName.getFamilyName().getValue();
       String Apellido = patientName.getGivenName().getValue();
       System.out.println(familyName);
       System.out.println(Apellido);
       String Direccion = null;
       String Zip = null;
       String City = null;
       for (int i = 0; i < patientDir.length; i++) {
     	  Direccion = patientDir[i].getStreetAddress().getValue();
     	  Zip = patientDir[i].getZipOrPostalCode().getValue();
     	  City = patientDir[i].getCity().getValue();
			System.out.println(Direccion+" "+Zip+" "+City);
		}
		
		
	    HashMap<String, String> map = new HashMap<>();
	    HashMap<String, String> mapdir = new HashMap<>();
	    map.put("nombre", Apellido);
	    map.put("apellido", familyName);
	    map.put("direccion", Direccion);
	    map.put("codigopostal", Zip);
	    map.put("estado", City);
	    return map;
	}	


public Map<String, String> ADT03(Message msg) {
	
	ADT_A03 adtMsg = (ADT_A03)msg;
    MSH msh = adtMsg.getMSH();
   PN patientName = adtMsg.getPID().getPatientName();
   AD[] patientDir = adtMsg.getPID().getPatientAddress();
   String familyName = patientName.getFamilyName().getValue();
   String Apellido = patientName.getGivenName().getValue();
   System.out.println(familyName);
   System.out.println(Apellido);
   String Direccion = null;
   String Zip = null;
   String City = null;
   for (int i = 0; i < patientDir.length; i++) {
 	  Direccion = patientDir[i].getStreetAddress().getValue();
 	  Zip = patientDir[i].getZipOrPostalCode().getValue();
 	  City = patientDir[i].getCity().getValue();
		System.out.println(Direccion+" "+Zip+" "+City);
	}
	
	
    HashMap<String, String> map = new HashMap<>();
    HashMap<String, String> mapdir = new HashMap<>();
    map.put("nombre", Apellido);
    map.put("apellido", familyName);
    map.put("direccion", Direccion);
    map.put("codigopostal", Zip);
    map.put("estado", City);
    return map;
}

}
