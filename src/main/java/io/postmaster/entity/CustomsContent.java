
package io.postmaster.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomsContent {

    @Expose
    @SerializedName("description")
    private String description;
    @Expose
    @SerializedName("value")
    private String value;
    @Expose
    @SerializedName("weight")
    private Number weight;
    @Expose
    @SerializedName("weightUnits")
    private String weightUnits;
    @Expose
    @SerializedName("quantity")
    private Number quantity;
    @Expose
    @SerializedName("hs_tariff_number")
    private String hsTariffNumber;
    @Expose
    @SerializedName("country_of_origin")
    private String countryOfOrigin;

    public String getDescription() {
        return description;
    }

    public CustomsContent setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getValue() {
        return value;
    }

    public CustomsContent setValue(String value) {
        this.value = value;
        return this;
    }

    public Number getWeight() {
        return weight;
    }

    public CustomsContent setWeight(Number weight) {
        this.weight = weight;
        return this;
    }

    public String getWeightUnits() {
        return weightUnits;
    }

    public CustomsContent setWeightUnits(String weightUnits) {
        this.weightUnits = weightUnits;
        return this;
    }

    public Number getQuantity() {
        return quantity;
    }

    public CustomsContent setQuantity(Number quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getHsTariffNumber() {
        return hsTariffNumber;
    }

    public CustomsContent setHsTariffNumber(String hsTariffNumber) {
        this.hsTariffNumber = hsTariffNumber;
        return this;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public CustomsContent setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
        return this;
    }

    public static CustomsContent create() {
        return new CustomsContent();
    }

}
