package io.postmaster.entity.result;

import io.postmaster.entity.Rate;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class RateResult extends OperationResult {

	private Rate rate;

	public Rate getRate() {
		return rate;
	}

	public RateResult(JSONObject input) {
		try {
			this.wrapJSONResponseData(input);
			if (this.getCode() == null) {
				Gson gson = new Gson();
				rate = gson.fromJson(input.toString(), Rate.class);
			}
		} catch (JsonSyntaxException e) {
			throw new RuntimeException(e);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}

}
