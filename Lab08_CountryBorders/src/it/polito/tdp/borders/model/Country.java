package it.polito.tdp.borders.model;

public class Country {
	private String stateAbb;
	private int cCode;
	private String stateNme;
	int confinanti;
	public Country(String stateAbb, int cCode, String stateNme) {
		
		this.stateAbb = stateAbb;
		this.cCode = cCode;
		this.stateNme = stateNme;
		confinanti=0;
	}
	
    public int getCCode(){
    	return cCode;
    }
    public String getName(){
    	return stateNme;
    }
    public void setConfinanti(int i){
    	confinanti=i;
    }
    public int getConfinanti(){
    	return confinanti;
    }

}
