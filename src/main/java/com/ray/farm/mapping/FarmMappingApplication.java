package com.ray.farm.mapping;

import com.drew.imaging.ImageProcessingException;
import com.ray.farm.mapping.service.photos.ExifReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.IOException;

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan
public class FarmMappingApplication {

    @Autowired
    static ExifReaderService exifReaderService;

	static void main(String[] args) throws IOException, ImageProcessingException {

        SpringApplication.run(FarmMappingApplication.class, args);

        exifReaderService.getExifData();

    }

}
