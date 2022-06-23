package dev.morera.models;

public class Request_Type {

	private int t_id;
	private String type;
	private double reimbursement_percent;

	public Request_Type() {
		super();
	}

	public Request_Type(int t_id, String type, double reimbursement_percent) {
		super();
		this.t_id = t_id;
		this.type = type;
		this.reimbursement_percent = reimbursement_percent;
	}

	public int getT_id() {
		return t_id;
	}

	public String getType() {
		return type;
	}

	public double getReimbursement_percent() {
		return reimbursement_percent;
	}




}
