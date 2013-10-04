package io.postmaster.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MonitorPackageQueryMessage {

    @Expose
    @SerializedName("tracking_no")
    private String tracking;
    @Expose
    @SerializedName("url")
    private String callbackUrl;
    @Expose
    @SerializedName("sms")
    private Number callbackPhoneNumber;
    @Expose
    @SerializedName("events")
    private List<String> events = new ArrayList<String>();
    
    public static MonitorPackageQueryMessage create(){
        return new MonitorPackageQueryMessage();
    }
    
    public String getTracking() {
        return tracking;
    }
    public MonitorPackageQueryMessage setTracking(String tracking) {
        this.tracking = tracking;
        return this;
    }
    public String getCallbackUrl() {
        return callbackUrl;
    }
    public MonitorPackageQueryMessage addEvent(PackageEvent event){
        events.add(event.name());
        return this;
    }
    
    public MonitorPackageQueryMessage setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }
    public Number getCallbackPhoneNumber() {
        return callbackPhoneNumber;
    }
    public MonitorPackageQueryMessage setCallbackPhoneNumber(Number callbackPhoneNumber) {
        this.callbackPhoneNumber = callbackPhoneNumber;
        return this;
    }
    public List<String> getEvents() {
        return events;
    }
    public MonitorPackageQueryMessage setEvents(List<String> events) {
        this.events = events;
        return this;
    }
    
    public enum PackageEvent{
        
        InTransit("In-Transit"),
        OutOfDelivery("Out For Delivery"),
        Delivered("Delivered"),
        Voided("Voided"),
        Exception("Exception"),
        Returned("Returned");
        
        private String name;
        PackageEvent(String name){
            this.name = name;
        }
    }
    
}
