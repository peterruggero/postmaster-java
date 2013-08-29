package io.postmaster.entity.result;

import org.json.JSONException;
import org.json.JSONObject;

public class OperationResult {

	private String message;
	private Integer code;

	public void wrapJSONResponseData(JSONObject data) throws JSONException {
		if (data.has("message")) {
			this.message = data.getString("message");
		}
		if (data.has("code")) {
			this.code = (Integer) data.get("code");
		}
	}

	public String getMessage() {
		return message;
	}

	public Integer getCode() {
		return code;
	}

}
