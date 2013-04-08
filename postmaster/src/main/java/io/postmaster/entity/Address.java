package io.postmaster.entity;

import io.postmaster.core.PostMasterClient;
import io.postmaster.entity.result.OperationResult;
import io.postmaster.errors.HTTPError;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

public class Address {

	static final String PATH_VALIDATE = "/v1/validate";

	@Expose
	@SerializedName("city")
	private String city;
	@Expose
	@SerializedName("company")
	private String company;
	@Expose
	@SerializedName("contact")
	private String contact;
	@SerializedName("country")
	private String country;
	@Expose
	@SerializedName("line1")
	private String line1;
	@Expose
	@SerializedName("line2")
	private String line2;
	@Expose
	@SerializedName("line3")
	private String line3;
	@Expose
	@SerializedName("phone_no")
	private String phoneNumber;
	@SerializedName("residential")
	private boolean residential;
	@Expose
	@SerializedName("state")
	private String state;
	@Expose
	@SerializedName("zip_code")
	private String zipCode;

	public static Address create() {
		return new Address();
	}
	
	public String getCity() {
		return city;
	}

	public Address setCity(String city) {
		this.city = city;
		return this;
	}

	public String getCompany() {
		return company;
	}

	public Address setCompany(String company) {
		this.company = company;
		return this;
	}

	public String getContact() {
		return contact;
	}

	public Address setContact(String contact) {
		this.contact = contact;
		return this;
	}

	public String getCountry() {
		return country;
	}

	public Address setCountry(String country) {
		this.country = country;
		return this;
	}

	public String getLine1() {
		return line1;
	}

	public Address setLine1(String line1) {
		this.line1 = line1;
		return this;
	}

	public String getLine2() {
		return line2;
	}

	public Address setLine2(String line2) {
		this.line2 = line2;
		return this;
	}

	public String getLine3() {
		return line3;
	}

	public Address setLine3(String line3) {
		this.line3 = line3;
		return this;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Address setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}

	public boolean isResidential() {
		return residential;
	}

	public Address setResidential(boolean residential) {
		this.residential = residential;
		return this;
	}

	public String getState() {
		return state;
	}

	public Address setState(String state) {
		this.state = state;
		return this;
	}

	public String getZipCode() {
		return zipCode;
	}

	public Address setZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	public Address setStreet(String... lines) {
		if (lines.length > 3) {
			throw new RuntimeException("Street property has maximum 3 lines");
		}
		this.setStreetLines(lines);
		return this;
	}

	public Address setStreet(String line1, String line2, String line3) {
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		return this;
	}

	public Address setStreet(List<String> lines) {
		String[] array = lines.toArray(new String[lines.size()]);
		this.setStreetLines(array);
		return this;
	}

	private void setStreetLines(String[] lines) {
		if (lines.length >= 1) {
			this.line1 = lines[0];
		}
		if (lines.length >= 2) {
			this.line2 = lines[1];
		}
		if (lines.length >= 3) {
			this.line3 = lines[2];
		}
	}

	public AddressValidationResult validate() throws HTTPError {
		PostMasterClient client = PostMasterClient.getInstance();
		JSONObject result = client.post(PATH_VALIDATE, this, null);
		return new AddressValidationResult(result);

	}

	public class AddressValidationResult extends OperationResult {
		private List<Address> standarizedAddress;

		public AddressValidationResult(JSONObject input) {
			try {
				if (input.has("addresses")) {
					Gson gson = new Gson();
					standarizedAddress = gson.fromJson(
							input.getString("addresses"),
							new TypeToken<List<Address>>() {
							}.getType());
				} else {
					this.wrapJSONErrorData(input);
				}

			} catch (JSONException e) {
				throw new RuntimeException(e);
			}
		}

		public List<Address> getStandarizedAddress() {
			return standarizedAddress;
		}
	}

}
