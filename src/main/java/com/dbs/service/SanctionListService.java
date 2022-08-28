package com.dbs.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public class SanctionListService {
	
	private final Status status = new Status();
    boolean matched = false;
    
    public Status getUserInSanctionList(String name) throws IOException {

         String inputFileName = "src/main/resources/sdnlist.txt";
         FileReader fr = new FileReader(inputFileName);  
         BufferedReader br = new BufferedReader(fr); 
         String s;
         status.setMessage("Not Found");
         while((s = br.readLine()) != null) 
         {
             if (s.contains(name)) {
                 status.setMessage("Found");
                 fr.close();;
                 return status;
             }
         }
         return status;
     }
	
	

}
