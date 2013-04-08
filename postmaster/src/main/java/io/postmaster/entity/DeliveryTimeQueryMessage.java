package io.postmaster.entity;

import com.google.gson.annotations.SerializedName;

public class DeliveryTimeQueryMessage {

	@SerializedName("from_zip")
	private Number fromZip;
	@SerializedName("to_zip")
	private Number toZip;
	@SerializedName("weight")
	private Number weight;
	@SerializedName("carrier")
	private String carrier;

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

}
