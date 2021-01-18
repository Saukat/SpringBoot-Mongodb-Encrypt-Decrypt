package com.vinod.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.bol.secure.Encrypted;

@Document
public class Salary {

	@Id
	private int id;
	@Field
	@Encrypted
	private String basic;
	//@Field
	@Encrypted
	private String da;
	//@Field
	@Encrypted
	private String ca;
	//@Field
	@Encrypted
	private String pf;
	//@Field
	@Encrypted
	private String hra;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBasic() {
		return basic;
	}
	public void setBasic(String basic) {
		this.basic = basic;
	}
	public String getDa() {
		return da;
	}
	public void setDa(String da) {
		this.da = da;
	}
	public String getCa() {
		return ca;
	}
	public void setCa(String ca) {
		this.ca = ca;
	}
	public String getPf() {
		return pf;
	}
	public void setPf(String pf) {
		this.pf = pf;
	}
	public String getHra() {
		return hra;
	}
	public void setHra(String hra) {
		this.hra = hra;
	}
	
	
	
	
	
}
