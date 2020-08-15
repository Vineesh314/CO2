package com.co2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private Long clientId;
    private String clientCode;
    private String clientName;
    
    
	public Client(Long clientId, String clientCode, String clientName) {
		super();
		this.clientId = clientId;
		this.clientCode = clientCode;
		this.clientName = clientName;
	}
	
	public Client() {
		
	}

	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientCode=" + clientCode + ", clientName=" + clientName + "]";
	}



}
