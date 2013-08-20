package io.postmaster.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @Expose
    @SerializedName("width")
    protected Number width;
    
    @Expose
    @SerializedName("height")
    protected Number height;
    
    @Expose
    @SerializedName("image_url")
    protected String imageUrl;
    
    @Expose
    @SerializedName("length")
    protected Number length;
    
    @Expose
    @SerializedName("weight")
    protected Number weight;
    
    @Expose
    @SerializedName("weight_units")
    protected String weightUnits;
    
    @Expose
    @SerializedName("size_units")
    protected String sizeUnits;
    
    @Expose
    @SerializedName("name")
    protected String name;
    
    @Expose
    @SerializedName("sku")
    protected String sku;
    
    @Expose
    @SerializedName("count")
    protected Number count;

    public Number getWidth() {
        return width;
    }

    public Item setWidth(Number width) {
        this.width = width;
        return this;
    }

    public Number getHeight() {
        return height;
    }

    public Item setHeight(Number height) {
        this.height = height;
        return this;
    }

    public Number getLength() {
        return length;
    }

    public Item setLength(Number length) {
        this.length = length;
        return this;
    }

    public Number getWeight() {
        return weight;
    }

    public Item setWeight(Number weight) {
        this.weight = weight;
        return this;
    }

    public String getWeightUnits() {
        return weightUnits;
    }

    public Item setWeightUnits(String weightUnits) {
        this.weightUnits = weightUnits;
        return this;
    }

    public String getSizeUnits() {
        return sizeUnits;
    }

    public Item setSizeUnits(String sizeUnits) {
        this.sizeUnits = sizeUnits;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public Item setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public Number getCount() {
        return count;
    }

    public Item setCount(Number count) {
        this.count = count;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Item setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
    
    
}
