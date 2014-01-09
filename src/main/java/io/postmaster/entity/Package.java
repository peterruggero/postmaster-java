package io.postmaster.entity;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Package {

	@SerializedName("dimension_units")
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
	@Expose
	@SerializedName("value")
	private String value;
	@Expose
	@SerializedName("customs")
	private Customs customs;
	@Expose
    @SerializedName("label_url")
    private String labelUrl;

	public Customs getCustoms() {
        return customs;
    }

    public Package setCustoms(Customs customs) {
        this.customs = customs;
        return this;
    }

    public static Package create() {
		return new Package();
	}

	public String getDimensionUnits() {
		return dimensionUnits;
	}

	public Package setDimensionUnits(String dimensionUnits) {
		this.dimensionUnits = dimensionUnits;
		return this;
	}

	public Number getHeight() {
		return height;
	}

	public Package setHeight(Number height) {
		this.height = height;
		return this;
	}

	public Number getLength() {
		return length;
	}

	public Package setLength(Number length) {
		this.length = length;
		return this;
	}

	public String getType() {
		return type;
	}

	public Package setType(String type) {
		this.type = type;
		return this;
	}

	public Number getWeight() {
		return weight;
	}

	public Package setWeight(Number weight) {
		this.weight = weight;
		return this;
	}

	public String getWeightUnits() {
		return weightUnits;
	}

	public Package setWeightUnits(String weightUnits) {
		this.weightUnits = weightUnits;
		return this;
	}

	public Number getWidth() {
		return width;
	}

	public String getValue() {
		return value;
	}

	public Package setValue(String value) {
		this.value = value;
		return this;
	}

	public Package setValue(Number value) {
		this.value = value.toString();
		return this;
	}
	
	public Package setWidth(Number width) {
		this.width = width;
		return this;
	}

	public String getLabelUrl() {
        return labelUrl;
    }

    public Package setLabelUrl(String labelUrl) {
        this.labelUrl = labelUrl;
        return this;
    }

    public Package setDimensions(Number width, Number height, Number length) {
		this.width = width;
		this.height = height;
		this.length = length;
		return this;
	}

	public Package setDimensions(Number... dimensions) {
		if (dimensions.length > 3) {
			throw new RuntimeException(
					"Please specify maximum 3 dimensions: width, height and length");
		}
		this.setDimensionFromArray(dimensions);
		return this;
	}

	public Package setDimensions(List<Number> dimensions) {
		Number[] array = dimensions.toArray(new Number[dimensions.size()]);
		this.setDimensionFromArray(array);
		return this;
	}

	private void setDimensionFromArray(Number[] dimensions) {
		if (dimensions.length >= 1) {
			this.width = dimensions[0];
		}
		if (dimensions.length >= 2) {
			this.height = dimensions[1];
		}
		if (dimensions.length >= 3) {
			this.length = dimensions[2];
		}
	}
	
}
