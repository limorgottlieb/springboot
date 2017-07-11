package com.dtos;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by gotli01 on 4/3/2017.
 */
@Document
public class Restaurant {
    @Id
    private String id;
    @Field
    private String name;
    @Field
    private double longitude;
    @Field
    private double latitude;
    @Max(value=10, message="Rate is between 1 to 10")
    @Min(value=1, message="Rate is between 1 to 10")
    @Field
    private int rate;

    public Restaurant(){}

    public Restaurant(String id, String name, double longitude, double latitude, int rate) {
        this.id = id;
        this.name = name;
        this.longitude = longitude;
            this.latitude = latitude;
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
