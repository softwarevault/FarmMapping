package com.ray.farm.mapping.service.photos;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ExifReaderService {

    public void getExifData() throws IOException, ImageProcessingException {

        Path photosDir = Path.of("data", "photos");  // relative, no drive letter
        Files.createDirectories(photosDir);          // safe even if it exists

        Path imagePath = photosDir.resolve("room.jpg");
        File file = imagePath.toFile();

        Metadata metadata = ImageMetadataReader.readMetadata(file);

        // 1) GPS directory
        GpsDirectory gpsDir = metadata.getFirstDirectoryOfType(GpsDirectory.class);

        double lat = gpsDir.getGeoLocation().getLatitude();
        double lon = gpsDir.getGeoLocation().getLongitude();

        GeoRecord point = new GeoRecord(lat, lon);

        System.out.println(point);




    }
}
