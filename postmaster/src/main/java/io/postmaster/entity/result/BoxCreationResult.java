package io.postmaster.entity.result;

import org.json.JSONException;
import org.json.JSONObject;

public class BoxCreationResult  extends OperationResult {

    private Long createdPackageId;

    public Long getCreatedPackageId() {
        return createdPackageId;
    }

    public BoxCreationResult(JSONObject input) {
        try {
            if (input.has("id")) {
                createdPackageId = Long.parseLong(input.getString("id"));
            } else {
                this.wrapJSONErrorData(input);
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}