package com.ray.farm.mapping.service.photos;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.GpsDirectory;
import com.ray.farm.mapping.config.StorageConfig;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@Service
public class ExifReaderService {

    private final Path photosDir;


    public ExifReaderService(StorageConfig config) {
        this.photosDir = Path.of(config.photosDir()).toAbsolutePath().normalize();
    }


    public GeoRecord getExifData() throws IOException, ImageProcessingException {

        Path imagePath = photosDir.resolve("room.jpg");
        File file = imagePath.toFile();

        Metadata metadata = ImageMetadataReader.readMetadata(file);

        // 1) GPS directory
        GpsDirectory gpsDir = metadata.getFirstDirectoryOfType(GpsDirectory.class);

        double lat = gpsDir.getGeoLocation().getLatitude();
        double lon = gpsDir.getGeoLocation().getLongitude();

        return new GeoRecord(lat, lon);
    }
}
