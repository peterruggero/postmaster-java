package io.postmaster.entity.result;

import io.postmaster.entity.Shipment;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class ShipmentCreationResult extends OperationResult {

	private Shipment createdShipment;

	public Shipment getCreatedShipment() {
		return createdShipment;
	}

	public ShipmentCreationResult(JSONObject input) {
		try {
			if (input.has("id")) {
				Gson gson = new Gson();
				createdShipment = gson.fromJson(input.toString(),
						Shipment.class);
			} else {
				this.wrapJSONResponseData(input);
			}

		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}
}