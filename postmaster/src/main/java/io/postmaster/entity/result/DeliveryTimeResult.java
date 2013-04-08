package io.postmaster.entity.result;

import io.postmaster.entity.Service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class DeliveryTimeResult extends OperationResult {

	private List<Service> services;

	public List<Service> getServices() {
		return services;
	}

	public DeliveryTimeResult(JSONObject input) {
		try {
			if (input.has("services")) {
				Gson gson = new Gson();
				services = gson.fromJson(input.getString("services"),
						new TypeToken<List<Service>>() {
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