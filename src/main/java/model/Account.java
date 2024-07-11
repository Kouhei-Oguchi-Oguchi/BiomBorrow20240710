package model;

public class Account {
	private String userId;
	private String pass;
	private String institutionName;
	private String mail;

	public Account (String userId, String pass, String institutionName, String mail) {
		this.userId = userId;
		this.pass = pass;
		this.institutionName = institutionName;
		this.mail = mail;
	}
	public String getUserId() {
		return userId;
	}
	public String getPass() {
		return pass;
	}
	public String getInstitutionName(){
		return institutionName;
	}
	public String getMail() {
		return mail;
	}
}
