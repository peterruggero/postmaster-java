package io.postmaster.entity;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class TrackingDetails {

	@SerializedName("history")
	private List<TrackingDetailsHistory> history;
	@SerializedName("last_update")
	private Number lastUpdate;
	@SerializedName("status")
	private String status;

	public List<TrackingDetailsHistory> getHistory() {
		return history;
	}

	public void setHistory(List<TrackingDetailsHistory> history) {
		this.history = history;
	}

	public Number getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Number lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
