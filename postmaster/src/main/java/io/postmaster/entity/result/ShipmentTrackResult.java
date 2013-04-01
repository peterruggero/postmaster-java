package io.postmaster.entity.result;

import io.postmaster.entity.TrackingDetails;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class ShipmentTrackResult extends OperationResult {

	private List<TrackingDetails> trackingDetails;

	public List<TrackingDetails> getTrackingDetails() {
		return trackingDetails;
	}

	public ShipmentTrackResult(JSONObject input) {
		try {
			if (input.has("results")) {
				Gson gson = new Gson();
				trackingDetails = gson.fromJson(input.getString("results"),
						new TypeToken<List<TrackingDetails>>() {
						}.getType());
			} else {
				this.wrapJSONErrorData(input);
			}
		} catch (JsonSyntaxException e) {
			throw new RuntimeException(e);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}
}