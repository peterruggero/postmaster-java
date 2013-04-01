package io.postmaster.entity;

import com.google.gson.annotations.SerializedName;

public class TrackingDetailsHistory {

	@SerializedName("city")
	private String city;
	@SerializedName("code")
	private String code;
	@SerializedName("country_code")
	private String countryCode;
	@SerializedName("description")
	private String description;
	@SerializedName("postal_code")
	private String postalCode;
	@SerializedName("state")
	private String state;
	@SerializedName("status")
	private String status;
	@SerializedName("timestamp")
	private Number timestamp;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Number getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Number timestamp) {
		this.timestamp = timestamp;
	}

}
