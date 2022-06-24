package dev.morera.models;

public class Employee {

	private int e_id;
	private boolean fin_man;
	private String uname;
	private String pword;
	private String name;

	public Employee() {
		super();
	}

	public Employee(int e_id, boolean fin_man, String uname, String pword, String name) {
		super();
		this.e_id = e_id;
		this.fin_man = fin_man;
		this.uname = uname;
		this.pword = pword;
		this.name = name;
	}

	public int getE_id() {
		return e_id;
	}

	public void setE_id(int e_id) {
		this.e_id = e_id;
	}

	public boolean isFin_man() {
		return fin_man;
	}

	public void setFin_man(boolean fin_man) {
		this.fin_man = fin_man;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
