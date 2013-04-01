package io.postmaster.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Package {

	@SerializedName("dimention_units")
	private String dimensionUnits;
	@Expose
	@SerializedName("height")
	private Number height;
	@Expose
	@SerializedName("length")
	private Number length;
	@SerializedName("type")
	private String type;
	@Expose
	@SerializedName("weight")
	private Number weight;
	@SerializedName("weight_units")
	private String weightUnits;
	@Expose
	@SerializedName("width")
	private Number width;

	public String getDimensionUnits() {
		return dimensionUnits;
	}

	public void setDimensionUnits(String dimensionUnits) {
		this.dimensionUnits = dimensionUnits;
	}

	public Number getHeight() {
		return height;
	}

	public void setHeight(Number height) {
		this.height = height;
	}

	public Number getLength() {
		return length;
	}

	public void setLength(Number length) {
		this.length = length;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Number getWeight() {
		return weight;
	}

	public void setWeight(Number weight) {
		this.weight = weight;
	}

	public String getWeightUnits() {
		return weightUnits;
	}

	public void setWeightUnits(String weightUnits) {
		this.weightUnits = weightUnits;
	}

	public Number getWidth() {
		return width;
	}

	public void setWidth(Number width) {
		this.width = width;
	}

}
