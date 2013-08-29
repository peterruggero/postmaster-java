package io.postmaster.entity.result;

import io.postmaster.entity.TrackingDetailsHistory;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class ShipmentTrackByReferenceResult extends OperationResult {

	private List<TrackingDetailsHistory> trackingHistoryList;

	public List<TrackingDetailsHistory> getTrackingHistoryList() {
		return trackingHistoryList;
	}

	public ShipmentTrackByReferenceResult(JSONObject input) {
		try {
			if (input.has("history")) {
				Gson gson = new Gson();
				trackingHistoryList = gson.fromJson(input.getString("history"),
						new TypeToken<List<TrackingDetailsHistory>>() {
						}.getType());
			} else {
				this.wrapJSONResponseData(input);
			}
		} catch (JsonSyntaxException e) {
			throw new RuntimeException(e);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}

}