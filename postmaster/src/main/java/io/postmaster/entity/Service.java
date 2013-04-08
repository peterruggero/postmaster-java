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

	public Service setDeliveryTimestamp(Number delivery_timestamp) {
		this.deliveryTimestamp = delivery_timestamp;
		return this;
	}

	public String getService() {
		return this.service;
	}

	public Service setService(String service) {
		this.service = service;
		return this;
	}

	public static Service create() {
		return new Service();
	}

}
