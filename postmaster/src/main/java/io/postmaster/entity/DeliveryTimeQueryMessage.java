package io.postmaster.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DeliveryTimeQueryMessage {

	@Expose
	@SerializedName("from_zip")
	private String fromZip;
	@Expose
	@SerializedName("to_zip")
	private String toZip;
	@Expose
	@SerializedName("weight")
	private Number weight;
	@Expose
	@SerializedName("carrier")
	private String carrier;

	public static DeliveryTimeQueryMessage create(){
		return new DeliveryTimeQueryMessage();
	}
	
	public String getFromZip() {
		return fromZip;
	}

	public DeliveryTimeQueryMessage setFromZip(String fromZip) {
		this.fromZip = fromZip;
		return this;
	}

	public String getToZip() {
		return toZip;
	}

	public DeliveryTimeQueryMessage setToZip(String toZip) {
		this.toZip = toZip;
		return this;
	}

	public Number getWeight() {
		return weight;
	}

	public DeliveryTimeQueryMessage setWeight(Number weight) {
		this.weight = weight;
		return this;
	}

	public String getCarrier() {
		return carrier;
	}

	public DeliveryTimeQueryMessage setCarrier(String carrier) {
		this.carrier = carrier;
		return this;
	}

}
