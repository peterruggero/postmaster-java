package io.postmaster.entity.result;

import org.json.JSONException;
import org.json.JSONObject;

public class OperationResult {

	private String errorMessage;
	private Integer errorCode;

	protected void wrapJSONErrorData(JSONObject data) throws JSONException {
		if (data.has("message")) {
			this.errorMessage = data.getString("message");
		}
		if (data.has("code")) {
			this.errorCode = (Integer) data.get("code");
		}
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

}
