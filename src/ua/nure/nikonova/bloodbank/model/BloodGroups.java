package ua.nure.nikonova.bloodbank.model;

import java.util.ArrayList;
import java.util.List;

public enum BloodGroups {
	 
	 
	FIRST (1,false,false),
	SECOND (2,true,false),
	THIRD (3,false, true),
	FORTH (4,true,true);
	
	private int bloodCode;
	private boolean hasA, hasB;
	
	     
    BloodGroups(int bloodCode, boolean hasA, boolean hasB) {
    	this.bloodCode=bloodCode;
        this.hasA = hasA;
        this.hasB = hasB;
       
        
    }
    public boolean hasA() { return hasA; }
    public boolean hasB() { return hasB; }
    public int getBloodCode() {return bloodCode;}
    
    public List<BloodGroups> getDonours() {
    	List<BloodGroups> donours=new ArrayList<BloodGroups>();
    	donours.add(FIRST);
    	if(hasA) {
    		donours.add(SECOND);
    	}
    	if(hasB) {
    		donours.add(THIRD);
    	}
    	if(hasA&&hasB) {
    		donours.add(FORTH);
    	}
    	
    	return donours;
   	
    }
    
    public List<BloodGroups> getRecipients() {
    	List<BloodGroups> recipients=new ArrayList<BloodGroups>();
    	recipients.add(FORTH);
    	if(!hasB&&!hasA) {
    		recipients.add(FIRST);
    	}
    	if(!hasB) {
    		recipients.add(SECOND);
    	}
    	if(!hasA) {
    		recipients.add(THIRD);
    	}
    	return recipients;
   	
    }
    
  
  
}