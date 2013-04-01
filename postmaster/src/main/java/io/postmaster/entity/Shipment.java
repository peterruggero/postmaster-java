package io.postmaster.entity;

import io.postmaster.core.PostMasterClient;
import io.postmaster.entity.result.DeliveryTimeResult;
import io.postmaster.entity.result.RateResult;
import io.postmaster.entity.result.ShipmentCreationResult;
import io.postmaster.entity.result.ShipmentFetchResult;
import io.postmaster.entity.result.ShipmentTrackByReferenceResult;
import io.postmaster.entity.result.ShipmentTrackResult;
import io.postmaster.errors.HTTPError;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Shipment {

	static final String FETCH_PATH = "/v1/shipments";
	static final String TRACK_PATH = "/v1/shipments/%d/track";
	static final String TRACK_BY_REF_PATH = "/v1/track";
	static final String VOID_PATH = "/v1/shipments/%d/void";
	static final String TIMES_PATH = "/v1/times";
	static final String RATES_PATH = "/v1/rates";

	@Expose
	@SerializedName("carrier")
	private String carrier;
	@SerializedName("created_at")
	private Number createdAt;
	@Expose
	@SerializedName("from")
	private Address from;
	@SerializedName("id")
	private Number id;
	@Expose
	@SerializedName("package")
	private Package packageInfo;
	@SerializedName("package_count")
	private Number packageCount;
	@SerializedName("packages")
	private List<Package> packages;
	@SerializedName("status")
	private String status;
	@Expose
	@SerializedName("to")
	private Address to;
	@SerializedName("tracking")
	private String tracking;
	@Expose
	private String service;

	
	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	public Number getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Number createdAt) {
		this.createdAt = createdAt;
	}

	public Address getFrom() {
		return from;
	}

	public void setFrom(Address from) {
		this.from = from;
	}

	public Number getId() {
		return id;
	}

	public Package getPackageInfo() {
		return packageInfo;
	}

	public void setPackageInfo(Package packageInfo) {
		this.packageInfo = packageInfo;
	}

	public Number getPackageCount() {
		return packageCount;
	}

	public void setPackageCount(Number packageCount) {
		this.packageCount = packageCount;
	}

	public List<Package> getPackages() {
		return packages;
	}

	public void setPackages(List<Package> packages) {
		this.packages = packages;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getTo() {
		return to;
	}

	public void setTo(Address to) {
		this.to = to;
	}

	public String getTracking() {
		return tracking;
	}

	public void setTracking(String tracking) {
		this.tracking = tracking;
	}

	public static ShipmentFetchResult fetch(String cursor,Integer limit)
			throws HTTPError {
		Map<String,String> params = new HashMap<String,String>();
		if(cursor != null){
			params.put("cursor", cursor);
		}
		if(limit!=null){
			params.put("limit", String.valueOf(limit));
		}
		
		JSONObject response = PostMasterClient.getInstance().get(FETCH_PATH,params);
		return new ShipmentFetchResult(response);
	}

	public ShipmentCreationResult create() throws 
			HTTPError {

		PostMasterClient client = PostMasterClient.getInstance();
		GsonBuilder builder = new GsonBuilder();
		Gson gsonExposeAware =  builder.excludeFieldsWithoutExposeAnnotation().create();
		String jsonData = gsonExposeAware.toJson(this);
		JSONObject response = client.post(FETCH_PATH, null,jsonData);
		return new ShipmentCreationResult(response);
	}

	public static ShipmentTrackResult track(int id) throws HTTPError {
		String path = String.format(TRACK_PATH, id);
		PostMasterClient client = PostMasterClient.getInstance();
		JSONObject response = client.get(path);
		return new ShipmentTrackResult(response);
	}

	public ShipmentTrackResult track() throws HTTPError {
		return track(this.id.intValue());
	}

	public static ShipmentTrackByReferenceResult trackByReferenceNumber(
			String trackingNumber) throws HTTPError {
		String path = String.format(TRACK_BY_REF_PATH + "?tracking=%s",
				trackingNumber);
		PostMasterClient client = PostMasterClient.getInstance();
		JSONObject response = client.get(path);
		return new ShipmentTrackByReferenceResult(response);
	}

	public void voidShipment() throws HTTPError {
		voidShipment(this.id.intValue());
	}

	public static void voidShipment(int shipmentId) throws HTTPError {
		String path = String.format(VOID_PATH, shipmentId);
		PostMasterClient client = PostMasterClient.getInstance();
		client.delete(path);

	}

	public static DeliveryTimeResult time(DeliveryTimeQueryMessage time)
			throws UnsupportedEncodingException, HTTPError, JSONException {
		PostMasterClient client = PostMasterClient.getInstance();
		// TODO server doesn't recognize from_zip parameter in sent json

		JSONObject response = client.post(TIMES_PATH, time,null);
		return new DeliveryTimeResult(response);
	}

	public static RateResult rates(RateQueryMessage rate)
			throws UnsupportedEncodingException, HTTPError, JSONException {
		PostMasterClient client = PostMasterClient.getInstance();

		JSONObject response = client.post(RATES_PATH, rate,null);
		return new RateResult(response);
	}

}
