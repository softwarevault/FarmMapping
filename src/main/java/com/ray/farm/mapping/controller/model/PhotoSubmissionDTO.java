package com.ray.farm.mapping.controller.model;

import lombok.Data;

@Data
public class PhotoSubmissionDTO {

    private final int id;
    private final double gpsLat;
    private final double gpsLon;
    private final String originalFilename;

    public PhotoSubmissionDTO(Long id, double gpsLat, double gpsLon, String originalFilename) {

        this.id = id.intValue();

        this.gpsLat = gpsLat;
        this.gpsLon = gpsLon;
        this.originalFilename = originalFilename;
    }
}
