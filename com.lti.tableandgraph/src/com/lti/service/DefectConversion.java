package com.lti.service;
import com.google.gson.Gson;
import com.lti.model.Defect;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class DefectConversion {

    public static void main(String[] args) {
    	
    	Object defect = new Defect();
    	defect = getDefectObject();
    	System.out.println(defect);
    
    }

    private static Defect[] getDefectObject()
    {
    	 Defect[] defectArray = null;
    	 try (Reader reader = new FileReader("C:\\Users\\SHIVAPRASAD\\Documents\\menuExtendedService_getHotspotData.json")) {
    	   Gson gson = new Gson();
           

            // Convert JSON File to Java Object
             defectArray = gson.fromJson(reader, Defect[].class);
            
             for(Defect defect : defectArray) {
            	    System.out.println(defect);
            	}

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    	 return defectArray;
            
    }
}
