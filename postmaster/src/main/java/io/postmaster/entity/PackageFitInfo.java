package io.postmaster.entity;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PackageFitInfo {

    @Expose
    @SerializedName("leftovers")
    private List<Box> leftovers;
    @Expose
    @SerializedName("boxes")
    private List<BoxData> boxes;
    @Expose
    @SerializedName("all_fit")
    private Boolean allFit;
    @Expose
    @SerializedName("image_url")
    private String imageUrl;
    
    
    public List<Box> getLeftovers() {
        return leftovers;
    }
    public void setLeftovers(List<Box> leftovers) {
        this.leftovers = leftovers;
    }
    public List<BoxData> getBoxes() {
        return boxes;
    }
    public void setBoxes(List<BoxData> boxes) {
        this.boxes = boxes;
    }
    public Boolean getAllFit() {
        return allFit;
    }
    public void setAllFit(Boolean allFit) {
        this.allFit = allFit;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public class BoxData{
        
        @Expose
        @SerializedName("box")
        private Box box;
        
        @Expose
        @SerializedName("items")
        private List<Item> items;

        public Box getBox() {
            return box;
        }

        public void setBox(Box box) {
            this.box = box;
        }

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }
    }
}
