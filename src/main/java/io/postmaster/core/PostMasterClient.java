
package io.postmaster.core;

import io.postmaster.entity.Shipment;
import io.postmaster.entity.result.FetchShipmentResult;
import io.postmaster.errors.HTTPError;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.google.gson.Gson;

public class PostMasterClient extends DefaultPostMasterHTTPClient {

    protected static PostMasterClient _instance;
    protected static String _apiKey;

    public static PostMasterClient getInstance() {
        if (_instance == null) {
            _instance = new PostMasterClient(_apiKey);
        }
        return _instance;
    }

    private PostMasterClient(String key) {
        super(key);
    }

    public static Shipment createShipment() {
        return Shipment.create();
    }

    public static void setApiKey(String apiKey) {
        _apiKey = apiKey;
        PostMasterClient.getInstance().key = apiKey;
    }

    public static FetchShipmentResult fetch(String cursor, Integer limit)
            throws HTTPError {
        Map<String, String> params = new HashMap<String, String>();
        if (cursor != null) {
            params.put("cursor", cursor);
        }
        if (limit != null) {
            params.put("limit", String.valueOf(limit));
        }

        JSONObject response = PostMasterClient.getInstance().get(
                Shipment.FETCH_PATH, params);
        return new FetchShipmentResult(response);
    }

    public static Shipment fetchById(Long shipmentId) throws HTTPError {

        JSONObject response = PostMasterClient.getInstance().get(
                String.format(Shipment.RETREIVE_PATH, shipmentId), null);
        Gson gson = new Gson();
        return gson.fromJson(response.toString(), Shipment.class);
    }

    // TODO : create enums in related classes instead of holding those here as static fileds
    
    // Carrier definitions
    public static final String UPS = "ups";
    public static final String USPS = "usps";
    public static final String Fedex = "fedex";

    // Service definitions
    public static final String Service2Day = "2DAY";
    public static final String Service3Day = "3DAY";
    public static final String ServiceGround = "GROUND";
    public static final String Service2DayEarly = "2DAY_EARLY";
    public static final String Service1Day = "1DAY";
    public static final String Service1DayEarly = "1DAY_EARLY";
    public static final String Service1DayMorning = "1DAY_MORNING";
    public static final String ServiceInternational = "INTL_PRIORITY";

}
