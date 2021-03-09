package com.lti.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 
public class ReadJSONFromFile
{
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) 
//    {
//        //JSON parser object to parse read file
//        JSONParser jsonParser = new JSONParser();
//         
//        try (FileReader reader = new FileReader("C:\\Users\\SHIVAPRASAD\\Documents\\JSON\\employees.json"))
//        {
//            //Read JSON file
//            Object obj = jsonParser.parse(reader);
// 
//            JSONArray employeeList = (JSONArray) obj;
//            System.out.println(employeeList);
//             
//            //Iterate over employee array
//            employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );
// 
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
 
    public static JSONObject getJSONFromFile(String fileName) {
    	  //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONObject response = new JSONObject();
    	 try (FileReader reader = new FileReader(fileName))
         {
             //Read JSON file
             response = (JSONObject) jsonParser.parse(reader);
  
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } catch (ParseException e) {
             e.printStackTrace();
         }
    	 return response;
    }
    public static String readFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
//    private static void parseEmployeeObject(JSONObject employee) 
//    {
//        //Get employee object within list
//        JSONObject employeeObject = (JSONObject) employee.get("employee");
//         
//        //Get employee first name
//        String firstName = (String) employeeObject.get("firstName");    
//        System.out.println(firstName);
//         
//        //Get employee last name
//        String lastName = (String) employeeObject.get("lastName");  
//        System.out.println(lastName);
//         
//        //Get employee website name
//        String website = (String) employeeObject.get("website");    
//        System.out.println(website);
//    }
    public static void main(String[] a) {
    	System.out.println("JSONObject "+ ReadJSONFromFile.readFile("."+File.separator+"dashboard_getCodeCoverage.json"));
    }
}
