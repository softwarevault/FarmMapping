package com.ray.farm.mapping.controller;

import lombok.Data;
import org.jspecify.annotations.Nullable;

@Data
public class ObservationUploadResource {
    private double gpsLat = 0;
    private double gpsLon = 0;
    private String originalFilename;
    private String contentType;
    private long size;
    private byte[] bytes;

    public ObservationUploadResource(@Nullable String originalFilename, @Nullable String contentType, long size, byte[] bytes, double gpsLon, double gpsLat) {
        this.originalFilename = originalFilename;
        this.contentType = contentType;
        this.size = size;
        this.bytes = bytes;
        this.gpsLon = gpsLon;
        this.gpsLat = gpsLat;
    }
}
