package it.polito.tdp.borders.model;

public class Border {
	private int state1no;
	private int state2no;
	
	
	public Border(int state1no,  int state2no) {
		
		this.state1no = state1no;
		this.state2no = state2no;
		
	}
	
	public int getSate1no(){
		return state1no;
	}
	
	public int getSate2no(){
		return state2no;
	}


}
