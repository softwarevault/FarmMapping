package com.ray.farm.mapping.service.photos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GeoRecord {

    private double lat;
    private double lon;

    public GeoRecord(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
