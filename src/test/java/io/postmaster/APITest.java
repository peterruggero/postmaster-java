package io.postmaster;

import static org.junit.Assert.assertEquals;
import io.postmaster.core.PostMasterClient;
import io.postmaster.entity.Address;
import io.postmaster.entity.Address.AddressValidationResult;
import io.postmaster.errors.HTTPError;

import org.junit.Test;

import com.google.gson.Gson;

public class APITest extends PostMasterTest {

	private static String AddressJson = "{\"city\": \"Austin\", \"country\": \"US\", \"company\": \"ASLS\", \"phone_no\": \"919-720-7941\", \"line1\": \"1110 Algarita Ave.\", \"state\": \"TX\", \"contact\": \"Joe Smith\", \"residential\": true, \"zip_code\": \"78704\"}";

	@Test
	public void testNoApiKey() throws HTTPError, SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {
		//PostMasterClient client = PostMasterClient.getInstance();
		PostMasterClient.setApiKey("");

		Gson gson = new Gson();
		Address address = gson.fromJson(AddressJson, Address.class);
		AddressValidationResult result = address.validate();
		assertEquals(result.getCode().intValue(), 401);
	}

}
