package io.postmaster.entity.result;

import io.postmaster.entity.Box;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

public class FetchBoxResult extends OperationResult{

    protected String previousCursor;
    protected String cursor;
    protected List<Box> results = new ArrayList<Box>();
    
    public String getPreviousCursor() {
        return previousCursor;
    }

    public String getCursor() {
        return cursor;
    }

    public List<Box> getResults() {
        return results;
    }

    public FetchBoxResult(JSONObject input) {
        try {
            if (input.has("results")) {
                Gson gson = new Gson();
                results = gson.fromJson(input.getString("results"),
                        new TypeToken<List<Box>>() {
                        }.getType());

                if (input.has("previousCursor")) {
                    previousCursor = input.getString("previousCursor");
                }
                if (input.has("cursor")) {
                    cursor = input.getString("cursor");
                }
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
