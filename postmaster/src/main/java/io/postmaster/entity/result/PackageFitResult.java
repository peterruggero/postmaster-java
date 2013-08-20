package io.postmaster.entity.result;

import io.postmaster.entity.PackageFitInfo;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

public class PackageFitResult extends OperationResult{

    private PackageFitInfo fitInfo;
    
    public PackageFitInfo getFitInfo() {
        return fitInfo;
    }

    public PackageFitResult(JSONObject input) {
        try {
            if (input.has("boxes")) {
                Gson gson = new Gson();
                fitInfo = gson.fromJson(input.toString(),
                        PackageFitInfo.class);
            } else {
                this.wrapJSONErrorData(input);
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    
}
