
package io.postmaster;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import io.postmaster.core.PostMasterClient;
import io.postmaster.entity.Address;
import io.postmaster.entity.Customs;
import io.postmaster.entity.CustomsContent;
import io.postmaster.entity.DeliveryTimeQueryMessage;
import io.postmaster.entity.Package;
import io.postmaster.entity.RateQueryMessage;
import io.postmaster.entity.Shipment;
import io.postmaster.entity.result.DeliveryTimeResult;
import io.postmaster.entity.result.RateResult;
import io.postmaster.entity.result.ShipmentCreationResult;
import io.postmaster.entity.result.ShipmentFetchResult;
import io.postmaster.entity.result.ShipmentTrackByReferenceResult;
import io.postmaster.entity.result.ShipmentTrackResult;
import io.postmaster.errors.HTTPError;

import java.util.List;

import org.junit.Test;

public class ShipmentTest extends PostMasterTest {

    private static List<Shipment> receivedShipments;
    private static Shipment oldestShipment;

    @Test
    public void testCreateShipment() throws HTTPError {
        Shipment sh = PostMasterClient
                .createShipment()
                .setTo(Address.create().setCompany("ASLS")
                        .setContact("Joe Smith")
                        .setStreet("1110 Someplace Ave.").setCity("Austin")
                        .setPhoneNumber("1231231239").setState("TX")
                        .setZipCode("78704"))
                .setCarrier(PostMasterClient.UPS)
                .setService(PostMasterClient.Service2Day)
                .setPackageInfo(
                        Package.create()
                                .setDimensions(10, 6, 8)
                                .setWeight(1.5)
                                .setValue(55)
                                .setCustoms(
                                        Customs.create()
                                                .setComments("Comments on the commercial invoice")
                                                .setInvoiceNumber("050912173216-1234")
                                                .setType("Gift")
                                                .addContent(CustomsContent.create()
                                                        .setCountryOfOrigin("AI")
                                                        .setDescription("description")
                                                        .setHsTariffNumber("060110")
                                                        .setQuantity(1)
                                                        .setValue("15")
                                                        .setWeight(2.5)
                                                        .setWeightUnits("LB"))
                                                .addContent(CustomsContent.create()
                                                        .setCountryOfOrigin("AI")
                                                        .setDescription("description")
                                                        .setHsTariffNumber("060110")
                                                        .setQuantity(1)
                                                        .setValue("15")
                                                        .setWeight(2.5)
                                                        .setWeightUnits("LB"))))
                .setReference("Order # 54321");

        ShipmentCreationResult result = sh.createShipment();
        assertNotNull(result);
        assertNotNull(result.getCreatedShipment());
        assertNull(result.getErrorCode());
    }

    @Test
    public void testVoidShipment() throws HTTPError {
        // TODO void doesn't work properly on API side yet
    }

    @Test
    public void testFetchShipments() throws HTTPError {
        ShipmentFetchResult result = PostMasterClient.fetch(null, null);
        assertNotNull(result.getResults());
        receivedShipments = result.getResults();
        oldestShipment = receivedShipments.get(receivedShipments.size() - 1);
    }

    @Test
    public void testTrackShipment() throws HTTPError {
        // this id is used because for KEY used in code (and database) it has
        // any tracking details
        // server should have return any convenient message if no tracking info
        // found instead of 500
        ShipmentTrackResult result = Shipment.track(1002);
        assertNotNull(result.getTrackingDetails());

    }

    @Test
    public void testTrackByReferenceNumber() throws HTTPError {
        ShipmentTrackByReferenceResult result = Shipment
                .trackByReferenceNumber(oldestShipment.getTracking().get(0));

        assertNotNull(result);
        if (result.getErrorCode() != null) {
            if (!(result.getErrorCode().intValue() == 400 && result
                    .getErrorMessage().contains("No tracking information"))) {
                fail();
            }
        } else {
            assertNotNull(result.getTrackingHistoryList());
        }
    }

    @Test
    public void testDeliveryTime() throws HTTPError {
        DeliveryTimeQueryMessage queryTime = DeliveryTimeQueryMessage.create()
                .setCarrier("ups").setFromZip("28771").setToZip("78704")
                .setWeight(1.0);

        DeliveryTimeResult result = Shipment.time(queryTime);

        assertNotNull(result);
        assertNotNull(result.getServices());
        assertNull(result.getErrorCode());
    }

    @Test
    public void testRates() throws HTTPError {
        RateQueryMessage rateQuery = RateQueryMessage.create()
                .setCarrier("fedex").setFromZip("28771").setToZip("78704")
                .setWeight(1.0);

        RateResult result = Shipment.rates(rateQuery);

        assertNotNull(result);
        assertNotNull(result.getRate());
        assertNull(result.getErrorCode());
    }

}
