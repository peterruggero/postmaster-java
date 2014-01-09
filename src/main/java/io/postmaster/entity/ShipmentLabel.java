
package io.postmaster.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShipmentLabel {

    @Expose
    @SerializedName("type")
    private String type;
    @Expose
    @SerializedName("format")
    private String format;
    @Expose
    @SerializedName("size")
    private String size;

    public static ShipmentLabel create() {
        return new ShipmentLabel();
    }

    public ShipmentLabel() {
    };

    public ShipmentLabel(String type, String format, String size) {
        this.type = type;
        this.format = format;
        this.size = size;
    }

    public String getType() {
        return this.type;
    }

    public ShipmentLabel setType(String type) {
        this.type = type;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public ShipmentLabel setFormat(String format) {
        this.format = format;
        return this;
    }

    public String getSize() {
        return size;
    }

    public ShipmentLabel setSize(String size) {
        this.size = size;
        return this;
    }
    
    public static final String LabelTypeNormal = "NORMAL";
    public static final String LabelTypeThermal = "THERMAL";

    public static final String LabelSizeSmall = "SMALL";
    public static final String LabelSizeMedium = "MEDIUM";
    public static final String LabelSizeLarge = "LARGE";

    public static final String LabelFormatEPL = "EPL";
    public static final String LabelFormatZPL = "ZPL";
    public static final String LabelFormatGIF = "GIF";
    public static final String LabelFormatPDF = "PDF";
    public static final String LabelFormatPNG = "PNG";
}
