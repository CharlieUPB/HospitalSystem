package com.hl7.hospital.adthl7service.utils;


import java.util.HashMap;
import java.util.Map;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
  import ca.uhn.hl7v2.model.GenericMessage;
  import ca.uhn.hl7v2.model.Message;
  import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
  import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
  import ca.uhn.hl7v2.parser.GenericModelClassFactory;
  import ca.uhn.hl7v2.parser.PipeParser;
  import ca.uhn.hl7v2.util.Terser;


public class Parse {
	
	
	public String typeOfMessage(String messagep) throws HL7Exception {
		String msg = "MSH|^~\\&|HIS|RIH|EKG|EKG|199904140038||ADT^A01||P|2.2\r"
                + "PID|0001|00009874|00001122|A00977|SMITH^JOHN^M|MOM|19581119|F|NOTREAL^LINDA^M|C|564 SPRING ST^^NEEDHAM^MA^02494^US|0002|(818)565-1551|(425)828-3344|E|S|C|0000444444|252-00-4414||||SA|||SA||||NONE|V1|0001|I|D.ER^50A^M110^01|ER|P00055|11B^M011^02|070615^BATMAN^GEORGE^L|555888^NOTREAL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^NOTREAL^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|199904101200||||5555112333|||666097^NOTREAL^MANNY^P\r"
                + "NK1|0222555|NOTREAL^JAMES^R|FA|STREET^OTHER STREET^CITY^ST^55566|(222)111-3333|(888)999-0000|||||||ORGANIZATION\r"
                + "PV1|0001|I|D.ER^1F^M950^01|ER|P000998|11B^M011^02|070615^BATMAN^GEORGE^L|555888^OKNEL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^VOICE^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|||||5555112333|||666097^DNOTREAL^MANNY^P\r"
                + "PV2|||0112^TESTING|55555^PATIENT IS NORMAL|NONE|||19990225|19990226|1|1|TESTING|555888^NOTREAL^BOB^K^DR^MD||||||||||PROD^003^099|02|ER||NONE|19990225|19990223|19990316|NONE\r"
                + "AL1||SEV|001^POLLEN\r"
                + "GT1||0222PL|NOTREAL^BOB^B||STREET^OTHER STREET^CITY^ST^77787|(444)999-3333|(222)777-5555||||MO|111-33-5555||||NOTREAL GILL N|STREET^OTHER STREET^CITY^ST^99999|(111)222-3333\r"
                + "IN1||022254P|4558PD|BLUE CROSS|STREET^OTHER STREET^CITY^ST^00990||(333)333-6666||221K|LENIX|||19980515|19990515|||PATIENT01 TEST D||||||||||||||||||02LL|022LP554";
        HapiContext context = new DefaultHapiContext();
        context.setModelClassFactory(new GenericModelClassFactory());
        GenericMessage message = (GenericMessage) context.getPipeParser().parse(messagep);
        Terser t = new Terser(message);
		return t.get("/MSH-8-1")+t.get("/MSH-8-2");
		
	}
	
	public Map<String, Object> ADT(String msg) throws HL7Exception {
		
		HapiContext context = new DefaultHapiContext();
        context.setModelClassFactory(new GenericModelClassFactory());

        String v25message = "MSH|^~\\&|system1|W|system2|UHN|200105231927||ADT^A01^ADT_A01|22139243|P|2.4\r\n" + 
        		"EVN|A01|200105231927|\r\n" + 
        		"PID|13|9999999999^^|2216506^||Duck^Donald^^^MR.^MR.||19720227|M|||123 Foo ST.^^TORONTO^ON^M6G 3E6^CA^H^~123 Foo ST.^^TORONTO^ON^M6G 3E6^CA^M^|1811|(416)111-1111||E^ ENGLISH|S| PATIENT DID NOT INDICATE|211004554^||||||||||||\r\n" + 
        		"PV1|123||ZFAST TRACK^WAITING^13|E^EMERGENCY||369^6^13^U EM EMERGENCY DEPARTMENT^ZFAST TRACK WAITING^FT WAIT 13^FTWAIT13^FT WAITING^FTWAIT13|^MOUSE^MICKEY^M^^DR.^MD|||SUR||||||||I|211004554^||||||||||||||||||||W|||||200105231927|||||\r\n" + 
        		"PV2||F|^R/O APPENDICIAL ABSCESS|||||||||||||||||||||||||\r\n" + 
        		"IN1|1||001001|  OHIP||||||||||||^^^^^|||^^^^^^M^|||||||||||||||||||||||||^^^^^^M^|||||\r\n" + 
        		"ACC|";

        // The parser will always parse this as a "GenericMessage"
       GenericMessage message = (GenericMessage) context.getPipeParser().parse(msg);
        
        /* 
         * A generic message has a flat structure, so you can ask for any
         * field by only its segment name, not a complex path 
         */
        Terser t = new Terser(message);
        String name = t.get("/PID-5-2");
        String lastName = t.get("/PID-5-1");
        int codPatient = Integer.parseInt(t.get("/PID-1"));
        int gender = 3;
        if (t.get("/PID-8").equals("F")) {
       	 gender = 0;
        }
        
        else if (t.get("/PID-8").equals("M")) {
       	 gender = 1;
        }
        else if (t.get("/PID-8").equals("O")) {
       	 gender = 2;
        }
        else if (t.get("/PID-8").equals("A")) {
       	 gender = 4;
        }
        else if (t.get("/PID-8").equals("N")) {
       	 gender = 5;
        }
        
        
        String birthDate = t.get("/PID-7");
        String phone = t.get("/PID-13");
        String cellPhone = t.get("/PID-14");
        String address = t.get("/PID-11-1");
        Boolean deceased = false;
        if (t.get("/PID-13").equals("Y")) {
       	 deceased = true;
        }
        String maritalStatus = t.get("/PID-16");
        String nationality = t.get("/PID-28");
        String city = t.get("/PID-26");
        
        int codSecure = 0;
        String nameOrganization = null;
        String vecDate = null;
        try {
        codSecure = Integer.parseInt(t.get("/IN1-1"));
        nameOrganization = t.get("/IN1-4");
        vecDate = t.get("/IN1-13");
        } catch (Exception e) {
     		System.out.println("El mensaje no tiene un componente IN-1");
     	}
        int codDoctor = 0;
        String nameDoctor = null;
        String speciality = null;
        try {
        codDoctor = Integer.parseInt(t.get("/PV1-1"));
        nameDoctor = t.get("/PV1-7-3");
        speciality = t.get("/PV1-7-7");
        } catch (Exception e) {
    		System.out.println("El mensaje no tiene un componente PV1");
    	}
      
        String diagnostic = null;
        try {
       	 diagnostic=t.get("/OBX-5");
       	} catch (Exception e) {
       		System.out.println("El mensaje no tiene un componente OBX");
       	}
        

 		
 	    HashMap<String, Object> map = new HashMap<>();
 	    HashMap<String, String> mapdir = new HashMap<>();
 	    map.put("codPatient",codPatient);
 	    map.put("name", name);
 	    map.put("lastName", lastName);
 	    map.put("gender", gender);
 	    map.put("birthDate", birthDate);
 	    map.put("phone", phone);
 	    map.put("cellPhone", cellPhone);
 	   map.put("address", address);
 	    map.put("deceased", deceased);
 	    map.put("maritalStatus", maritalStatus);
 	    map.put("nationality", nationality);
 	    map.put("city", city);
 	    map.put("codSecure", codSecure);
 	    map.put("nameOrganization", nameOrganization);
 	    map.put("vecDate", vecDate);
 	    map.put("codDoctor", codDoctor);
 	    map.put("nameDoctor", nameDoctor);
 	    map.put("speciality", speciality);
 	    map.put("diagnostic", diagnostic);
 	    System.out.println(map.toString());
	    return map;
	}	
	
public Map<String, Object> ORU(String msg) throws HL7Exception {
		
		HapiContext context = new DefaultHapiContext();
        context.setModelClassFactory(new GenericModelClassFactory());

        String v25message = "MSH|^~\\&|system1|W|system2|UHN|200105231927||ADT^A01^ADT_A01|22139243|P|2.4\r\n" + 
        		"EVN|A01|200105231927|\r\n" + 
        		"PID|13|9999999999^^|2216506^||Duck^Donald^^^MR.^MR.||19720227|M|||123 Foo ST.^^TORONTO^ON^M6G 3E6^CA^H^~123 Foo ST.^^TORONTO^ON^M6G 3E6^CA^M^|1811|(416)111-1111||E^ ENGLISH|S| PATIENT DID NOT INDICATE|211004554^||||||||||||\r\n" + 
        		"PV1|123||ZFAST TRACK^WAITING^13|E^EMERGENCY||369^6^13^U EM EMERGENCY DEPARTMENT^ZFAST TRACK WAITING^FT WAIT 13^FTWAIT13^FT WAITING^FTWAIT13|^MOUSE^MICKEY^M^^DR.^MD|||SUR||||||||I|211004554^||||||||||||||||||||W|||||200105231927|||||\r\n" + 
        		"PV2||F|^R/O APPENDICIAL ABSCESS|||||||||||||||||||||||||\r\n" + 
        		"IN1|1||001001|  OHIP||||||||||||^^^^^|||^^^^^^M^|||||||||||||||||||||||||^^^^^^M^|||||\r\n" + 
        		"ACC|";

        // The parser will always parse this as a "GenericMessage"
       GenericMessage message = (GenericMessage) context.getPipeParser().parse(msg);
        
        /* 
         * A generic message has a flat structure, so you can ask for any
         * field by only its segment name, not a complex path 
         */
        Terser t = new Terser(message);
        String name = t.get("/PID-5-2");
        String lastName = t.get("/PID-5-1");
        int codPatient = Integer.parseInt(t.get("/PID-1"));
        int gender = 3;
        if (t.get("/PID-8").equals("F")) {
       	 gender = 0;
        }
        
        else if (t.get("/PID-8").equals("M")) {
       	 gender = 1;
        }
        else if (t.get("/PID-8").equals("O")) {
       	 gender = 2;
        }
        else if (t.get("/PID-8").equals("A")) {
       	 gender = 4;
        }
        else if (t.get("/PID-8").equals("N")) {
       	 gender = 5;
        }
        
        
        String birthDate = t.get("/PID-7");
        String phone = t.get("/PID-13");
        String cellPhone = t.get("/PID-14");
        String address = t.get("/PID-11-1");
        Boolean deceased = false;
        if (t.get("/PID-13").equals("Y")) {
       	 deceased = true;
        }
        String maritalStatus = t.get("/PID-16");
        String nationality = t.get("/PID-28");
        String city = t.get("/PID-26");
        
        int codSecure = 0;
        String nameOrganization = null;
        String vecDate = null;
        try {
        codSecure = Integer.parseInt(t.get("/IN1-1"));
        nameOrganization = t.get("/IN1-4");
        vecDate = t.get("/IN1-13");
        } catch (Exception e) {
     		System.out.println("El mensaje no tiene un componente IN-1");
     	}
        int codDoctor = 0;
        String nameDoctor = null;
        String speciality = null;
        try {
        codDoctor = Integer.parseInt(t.get("/PV1-1"));
        nameDoctor = t.get("/PV1-7-3");
        speciality = t.get("/PV1-7-7");
        } catch (Exception e) {
    		System.out.println("El mensaje no tiene un componente PV1");
    	}
      
        String diagnostic = null;
        try {
       	 diagnostic=t.get("/OBX-5");
       	} catch (Exception e) {
       		System.out.println("El mensaje no tiene un componente OBX");
       	}
        

 		
 	    HashMap<String, Object> map = new HashMap<>();
 	    HashMap<String, String> mapdir = new HashMap<>();
 	    map.put("codPatient",codPatient);
 	    map.put("name", name);
 	    map.put("lastName", lastName);
 	    map.put("gender", gender);
 	    map.put("birthDate", birthDate);
 	    map.put("phone", phone);
 	    map.put("cellPhone", cellPhone);
 	   map.put("address", address);
 	    map.put("deceased", deceased);
 	    map.put("maritalStatus", maritalStatus);
 	    map.put("nationality", nationality);
 	    map.put("city", city);
 	    map.put("codSecure", codSecure);
 	    map.put("nameOrganization", nameOrganization);
 	    map.put("vecDate", vecDate);
 	    map.put("codDoctor", codDoctor);
 	    map.put("nameDoctor", nameDoctor);
 	    map.put("speciality", speciality);
 	    map.put("diagnostic", diagnostic);
 	    System.out.println(map.toString());
	    return map;
	}	
	

}
