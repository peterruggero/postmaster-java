package io.postmaster.entity.result;

import io.postmaster.entity.Shipment;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class FetchShipmentResult extends OperationResult{

    protected String previousCursor;
    protected String cursor;
    protected List<Shipment> results;
    
    public String getPreviousCursor() {
        return previousCursor;
    }

    public String getCursor() {
        return cursor;
    }

    public List<Shipment> getResults() {
        return results;
    }

    public FetchShipmentResult(JSONObject input) {
        try {
            if (input.has("results")) {
                Gson gson = new Gson();
                results = gson.fromJson(input.getString("results"),
                        new TypeToken<List<Shipment>>() {
                        }.getType());

                if (input.has("previousCursor")) {
                    previousCursor = input.getString("previousCursor");
                }
                if (input.has("cursor")) {
                    cursor = input.getString("cursor");
                }
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
