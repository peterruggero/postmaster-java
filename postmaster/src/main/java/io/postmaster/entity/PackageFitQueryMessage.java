package io.postmaster.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PackageFitQueryMessage {

    @Expose
    @SerializedName("items")
    private List<Item> items = new ArrayList<Item>();
    
    @Expose
    @SerializedName("packages")
    private List<Box> packages = new ArrayList<Box>();

    public static PackageFitQueryMessage create(){
        return new PackageFitQueryMessage();
    }
    
    public List<Item> getItems() {
        return items;
    }

    public PackageFitQueryMessage addItem(Item item){
        items.add(item);
        return this;
    }
    
    public PackageFitQueryMessage addBox(Box box){
        packages.add(box);
        return this;
    }
    
    public PackageFitQueryMessage setItems(List<Item> items) {
        this.items = items;
        return this;
    }

    public List<Box> getPackages() {
        return packages;
    }

    public PackageFitQueryMessage setPackages(List<Box> packages) {
        this.packages = packages;
        return this;
    }
    
    
}
