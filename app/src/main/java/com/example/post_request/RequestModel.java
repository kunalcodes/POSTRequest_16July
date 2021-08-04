package com.example.post_request;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RequestModel implements Serializable {

	@SerializedName("email")
	private String email;

	@SerializedName("password")
	private String password;

	@SerializedName("title")
	private String title;

	@SerializedName("requestType")
	private String requestType;

	public void setEmail(String email){
		this.email = email;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public void setRequestType(String requestType){
		this.requestType = requestType;
	}
}