package io.postmaster;

import static org.junit.Assert.assertNotNull;
import io.postmaster.core.PostMasterClient;
import io.postmaster.entity.Address;
import io.postmaster.entity.Package;
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
		Shipment sh = PostMasterClient.createShipment().
				  setTo(
				    Address.create().
				      setCompany("ASLS").
				      setContact("Joe Smith").
				      setStreet("1110 Someplace Ave.").
				      setCity("Austin").
				      setPhoneNumber("123-123-123").
				      setState("TX").
				      setZipCode("78704")).
				  setCarrier(PostMasterClient.UPS).
				  setService(PostMasterClient.Service2Day).
				  setPackageInfo(
				    Package.create().
				      setDimensions(10, 6, 8).
				      setWeight(1.5).
				      setValue(55)).
				  setReference("Order # 54321");
				
				sh.createShipment();
		ShipmentCreationResult result = sh.createShipment();
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
		ShipmentFetchResult result = PostMasterClient.fetch(null, null);
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
