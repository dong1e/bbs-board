package yju.wdb.domain;

public class SampleVO {

	private int Mno;
	private String firstName;
	private String lastName;
	

	public SampleVO(int mno, String firstName, String lastName) {
		super();
		Mno = mno;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public SampleVO() {
		super();
		
	}
	
	public int getMno() {
		return Mno;
	}
	
	public void setMno(int mno) {
		Mno = mno;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
