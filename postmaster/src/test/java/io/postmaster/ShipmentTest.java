package io.postmaster;

import static org.junit.Assert.assertNotNull;
import io.postmaster.entity.Shipment;
import io.postmaster.entity.result.ShipmentCreationResult;
import io.postmaster.entity.result.ShipmentFetchResult;
import io.postmaster.entity.result.ShipmentTrackByReferenceResult;
import io.postmaster.entity.result.ShipmentTrackResult;
import io.postmaster.errors.HTTPError;

import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;

public class ShipmentTest extends PostMasterTest {

	private static String ShipmentJson = "{ \"package\": {\"weight\": 1.5, \"height\": 8, \"width\": 6, \"length\": 10},  \"to\": {\"city\": \"Austin\", \"country\": \"US\", \"company\": \"ASLS\", \"phone_no\": \"9197207941\", \"line1\": \"1110 Algarita Ave.\", \"state\": \"TX\", \"contact\": \"Joe Smith\",  \"zip_code\": \"78704\"}, \"carrier\": \"fedex\"}";

	private static List<Shipment> receivedShipments;
	private static Shipment createdShipment;

	@Test
	public void testCreateShipment() throws HTTPError {
		Gson gson = new Gson();
		createdShipment = gson.fromJson(ShipmentJson, Shipment.class);
		createdShipment.setService("ground");
		ShipmentCreationResult result = createdShipment.create();
		// TODO there are errors while creating shipment on server. Sample CURL
		// receives same error as this lib
		result.getErrorCode();
	}

	@Test
	public void testVoidShipment() {
		// TODO void doesn't work properly on API side yet
	}

	@Test
	public void testFetchShipments() throws HTTPError {
		ShipmentFetchResult result = Shipment.fetch(null, null);
		assertNotNull(result.getResults());
		receivedShipments = result.getResults();
	}

	@Test
	public void testTrackShipment() throws HTTPError {

		ShipmentTrackResult result = Shipment.track(receivedShipments.get(0)
				.getId().intValue());
		assertNotNull(result.getTrackingDetails());

	}

	@Test
	public void testTrackByReferenceNumber() throws HTTPError {
		ShipmentTrackByReferenceResult result = Shipment
				.trackByReferenceNumber(receivedShipments.get(0).getTracking());
		assertNotNull(result.getTrackingHistoryList());
	}

}
