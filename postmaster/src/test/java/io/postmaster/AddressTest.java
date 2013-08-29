package io.postmaster;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import io.postmaster.entity.Address;
import io.postmaster.entity.Address.AddressValidationResult;
import io.postmaster.errors.HTTPError;

import org.junit.Test;

import com.google.gson.Gson;

public class AddressTest extends PostMasterTest {

	private static String AddressJson = "{\"city\": \"Austin\", \"country\": \"US\", \"company\": \"ASLS\", \"phone_no\": \"919-720-7941\", \"line1\": \"1110 Algarita Ave.\", \"state\": \"TX\", \"contact\": \"Joe Smith\", \"residential\": true, \"zip_code\": \"78704\"}";

	@Test
	public void testValidateWithoutChanges() throws HTTPError {

		Gson gson = new Gson();
		Address address = gson.fromJson(AddressJson, Address.class);
		AddressValidationResult result = address.validate();

		assertNotNull(result);
		assertNotNull(result.getStandarizedAddress());
		assertTrue(result.getStandarizedAddress().size() > 0);

		Address standarized = result.getStandarizedAddress().get(0);
		assertEquals(standarized.getCity(), address.getCity());
		assertEquals(standarized.getState(), address.getState());
		assertEquals(standarized.getZipCode(), address.getZipCode());
	}

	@Test
	public void testValidateWrongAddress() throws HTTPError {
		Gson gson = new Gson();
		Address address = gson.fromJson(AddressJson, Address.class);
		address.setCity(null);
		address.setCountry(null);
		address.setZipCode(null);
		AddressValidationResult result = address.validate();

		assertNotNull(result);
		assertNull(result.getStandarizedAddress());
		assertEquals(result.getCode(), Integer.valueOf(400));
		assertEquals(result.getMessage(), "Wrong address");
	}

}
