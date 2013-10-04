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

	public Rate setCharge(String charge) {
		this.charge = charge;
		return this;
	}

	public String getCurrency() {
		return this.currency;
	}

	public Rate setCurrency(String currency) {
		this.currency = currency;
		return this;
	}

	public String getService() {
		return this.service;
	}

	public Rate setService(String service) {
		this.service = service;
		return this;
	}

	public static Rate create() {
		return new Rate();
	}

}
