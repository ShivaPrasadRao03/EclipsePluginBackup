package com.lti.service;
import com.google.gson.Gson;
import com.lti.model.Defect;
import com.lti.model.FileList;

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

    private static FileList[] getDefectObject()
    {
    	 FileList[] defectArray = null;
    	
    	 try (Reader reader = new FileReader("C:\\Users\\SHIVAPRASAD\\Documents\\JSON\\CodeCoverage.json")) {
    	   Gson gson = new Gson();
    	  

            // Convert JSON File to Java Object
             defectArray = gson.fromJson(reader, FileList[].class);
            
             for(FileList defect : defectArray) {
            	    System.out.println(defect);
            	}

            
        } catch (IOException e) {
            e.printStackTrace();
        }
    	 return defectArray;
            
    }
}
