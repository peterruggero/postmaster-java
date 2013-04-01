package io.postmaster.entity;

import com.google.gson.annotations.SerializedName;

public class Service {

	@SerializedName("delivery_timestamp")
	private Number deliveryTimestamp;
	@SerializedName("service")
	private String service;

	public Number getDeliveryTimestamp() {
		return this.deliveryTimestamp;
	}

	public void setDeliveryTimestamp(Number delivery_timestamp) {
		this.deliveryTimestamp = delivery_timestamp;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

}
