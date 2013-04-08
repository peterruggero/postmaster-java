package io.postmaster.entity.result;

import org.json.JSONException;
import org.json.JSONObject;

public class ShipmentCreationResult extends OperationResult {
	public ShipmentCreationResult(JSONObject input) {
		try {
			this.wrapJSONErrorData(input);

		} catch (JSONException e) {
			// TODO add data received in case of successfull creation
		}
	}
}