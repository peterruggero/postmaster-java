package io.postmaster.entity;

import io.postmaster.core.PostMasterClient;
import io.postmaster.entity.result.BoxCreationResult;
import io.postmaster.entity.result.FetchBoxResult;
import io.postmaster.entity.result.PackageFitResult;
import io.postmaster.errors.HTTPError;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Box extends Item{

    private static final String PATH_PACKAGES = "/v1/packages";
    private static final String PATH_FIT = "/v1/packages/fit";
    
    public static Box create(){
        return new Box();
    }
    
    public static FetchBoxResult fetch(String cursor, Integer limit) throws HTTPError {
        Map<String, String> params = new HashMap<String, String>();
        if (cursor != null) {
            params.put("cursor", cursor);
        }
        if (limit != null) {
            params.put("limit", String.valueOf(limit));
        }
        PostMasterClient client = PostMasterClient.getInstance();
        JSONObject result = client.get(PATH_PACKAGES,params);
        return new FetchBoxResult(result);

    }
    
    public BoxCreationResult createBox() throws HTTPError {
        PostMasterClient client = PostMasterClient.getInstance();
        JSONObject result = client.post(PATH_PACKAGES, this, null);
        return new BoxCreationResult(result);

    }
    
    public static PackageFitResult fit(PackageFitQueryMessage query) throws HTTPError {
        PostMasterClient client = PostMasterClient.getInstance();
        JSONObject result = client.post(PATH_FIT, query, null);
        return new PackageFitResult(result);
    }
    
    
    public Box setWidth(Number width) {
        this.width = width;
        return this;
    }

    public Box setHeight(Number height) {
        this.height = height;
        return this;
    }

    public Box setLength(Number length) {
        this.length = length;
        return this;
    }

    public Box setWeight(Number weight) {
        this.weight = weight;
        return this;
    }

    public Box setWeightUnits(String weightUnits) {
        this.weightUnits = weightUnits;
        return this;
    }

    public Box setSizeUnits(String sizeUnits) {
        this.sizeUnits = sizeUnits;
        return this;
    }

    public Box setName(String name) {
        this.name = name;
        return this;
    }

    public Box setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public Box setCount(Number count) {
        this.count = count;
        return this;
    }

    public Box setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
    
}
