
package io.postmaster.entity.result;

import org.json.JSONException;
import org.json.JSONObject;

public class MonitorPackageResult extends OperationResult {

    private String status;

    public String getStatus() {
        return status;
    }

    public MonitorPackageResult(JSONObject input) {
        try {
            if (input.has("status")) {
                status = input.getString("status");
            } else {
                this.wrapJSONResponseData(input);
            }

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

}
