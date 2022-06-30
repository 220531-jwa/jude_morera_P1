package dev.morera.models;

public class Status {

	private int req_id;
	private int status;
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Status(int req_id, int status) {
		super();
		this.req_id = req_id;
		this.status = status;
	}
	public int getReq_id() {
		return req_id;
	}
	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Status [req_id=" + req_id + ", status=" + status + "]";
	}
	
	
	
}
