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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLine3() {
		return line3;
	}

	public void setLine3(String line3) {
		this.line3 = line3;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isResidential() {
		return residential;
	}

	public void setResidential(boolean residential) {
		this.residential = residential;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public AddressValidationResult validate()
			throws HTTPError {
		PostMasterClient client = PostMasterClient.getInstance();
		JSONObject result = client.post(PATH_VALIDATE, this,null);
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
