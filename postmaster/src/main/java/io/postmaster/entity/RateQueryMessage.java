package io.postmaster.entity;

import com.google.gson.annotations.SerializedName;

public class RateQueryMessage {

	@SerializedName("from_zip")
	private Number fromZip;
	@SerializedName("to_zip")
	private Number toZip;
	@SerializedName("weight")
	private Number weight;
	@SerializedName("carrier")
	private String carrier;
	@SerializedName("commercial")
	private boolean commercial;
	@SerializedName("service")
	private String service;
	@SerializedName("packaging")
	private String packaging;

	public Number getFromZip() {
		return fromZip;
	}

	public void setFromZip(Number fromZip) {
		this.fromZip = fromZip;
	}

	public Number getToZip() {
		return toZip;
	}

	public void setToZip(Number toZip) {
		this.toZip = toZip;
	}

	public Number getWeight() {
		return weight;
	}

	public void setWeight(Number weight) {
		this.weight = weight;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public boolean isCommercial() {
		return commercial;
	}

	public void setCommercial(boolean commercial) {
		this.commercial = commercial;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

}
