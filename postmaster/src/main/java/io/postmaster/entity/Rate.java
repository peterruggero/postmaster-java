package io.postmaster.entity;

import com.google.gson.annotations.SerializedName;

public class Rate {

	@SerializedName("charge")
	private String charge;
	@SerializedName("currency")
	private String currency;
	@SerializedName("service")
	private String service;

	public String getCharge() {
		return this.charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

}
