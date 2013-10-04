package io.postmaster.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RateQueryMessage {

	@Expose
	@SerializedName("carrier")
	private String carrier;
	@Expose
	@SerializedName("from_zip")
	private String fromZip;
	@Expose
	@SerializedName("weight")
	private Number weight;
	@Expose
	@SerializedName("service")
	private String service;
	@Expose
	@SerializedName("to_zip")
	private String toZip;
	@Expose
	@SerializedName("commercial")
	private boolean commercial;
	@Expose
	@SerializedName("packaging")
	private String packaging;

	public static RateQueryMessage create(){
		return new RateQueryMessage();
	}
	
	public String getFromZip() {
		return fromZip;
	}

	public RateQueryMessage setFromZip(String fromZip) {
		this.fromZip = fromZip;
		return this;
	}

	public String getToZip() {
		return toZip;
	}

	public RateQueryMessage setToZip(String toZip) {
		this.toZip = toZip;
		return this;
	}

	public Number getWeight() {
		return weight;
	}

	public RateQueryMessage setWeight(Number weight) {
		this.weight = weight;
		return this;
	}

	public String getCarrier() {
		return carrier;
	}

	public RateQueryMessage setCarrier(String carrier) {
		this.carrier = carrier;
		return this;
	}

	public boolean isCommercial() {
		return commercial;
	}

	public RateQueryMessage setCommercial(boolean commercial) {
		this.commercial = commercial;
		return this;
	}

	public String getService() {
		return service;
	}

	public RateQueryMessage setService(String service) {
		this.service = service;
		return this;
	}

	public String getPackaging() {
		return packaging;
	}

	public RateQueryMessage setPackaging(String packaging) {
		this.packaging = packaging;
		return this;
	}

}
