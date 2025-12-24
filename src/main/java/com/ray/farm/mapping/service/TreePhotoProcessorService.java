package com.ray.farm.mapping.service;

import com.ray.farm.mapping.controller.ObservationUploadResource;
import com.ray.farm.mapping.controller.model.PhotoSubmissionDTO;
import com.ray.farm.mapping.entity.ObservationEntity;
import com.ray.farm.mapping.entity.ObservationRepository;
import lombok.AllArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TreePhotoProcessorService {


    public static final int WGS84_SRID = 4326; //Standard for lon, lat usage, doesnt need to mimic basemap projection
     private static final GeometryFactory geometryFactory =
            new GeometryFactory(new PrecisionModel(), WGS84_SRID);


    private final ObservationRepository repo;

    public PhotoSubmissionDTO createFromPhoto(ObservationUploadResource observationUploadResource) {


        // 2) persist
        ObservationEntity e = new ObservationEntity();
        e.setOriginalFilename(observationUploadResource.getOriginalFilename());
        e.setContentType(observationUploadResource.getContentType());
        e.setImageBytes(observationUploadResource.getBytes());
        e.setLocation(createPoint(observationUploadResource.getGpsLat(), observationUploadResource.getGpsLon()));
        // e.setCapturedAt(...optional: extract from ExifSubIFDDirectory)
        ObservationEntity saved = repo.save(e);

        return new PhotoSubmissionDTO(saved.getId(), observationUploadResource.getGpsLat(), observationUploadResource.getGpsLon(), saved.getOriginalFilename());
    }
    public static Point createPoint(double lat, double lon) {
        Point p = geometryFactory.createPoint(new Coordinate(lon, lat));
        p.setSRID(WGS84_SRID);
        return p;
    }


}
