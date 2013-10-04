package io.postmaster.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customs {

    @Expose
    @SerializedName("type")
    private String type;
    @Expose
    @SerializedName("invoice_number")
    private String invoiceNumber;
    @Expose
    @SerializedName("comments")
    private String comments;
    @Expose
    @SerializedName("contents")
    private List<CustomsContent> contents;
    
    
    public String getType() {
        return type;
    }
    public Customs setType(String type) {
        this.type = type;
        return this;
    }
    public String getInvoiceNumber() {
        return invoiceNumber;
    }
    public Customs setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
        return this;
    }
    public String getComments() {
        return comments;
    }
    public Customs setComments(String comments) {
        this.comments = comments;
        return this;
    }
    public List<CustomsContent> getContents() {
        return contents;
    }
    public Customs setContents(List<CustomsContent> contents) {
        this.contents = contents;
        return this;
    }
    
    public Customs addContent(CustomsContent content){
        if(this.contents==null){
            this.contents = new ArrayList<CustomsContent>();
        }
        this.contents.add(content);
        return this;
    }
    
    public static Customs create() {
        return new Customs();
    }
    
}
