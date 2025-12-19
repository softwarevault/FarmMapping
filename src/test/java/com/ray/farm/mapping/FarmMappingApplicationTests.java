package com.ray.farm.mapping;

import com.drew.imaging.ImageProcessingException;
import com.ray.farm.mapping.service.photos.ExifReaderService;
import com.ray.farm.mapping.service.photos.GeoRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(properties = {
        "app.storage.photoDir =./data/photos"
})
class FarmMappingApplicationTests {

    @Autowired 
    private final ExifReaderService exifReaderService = null;


	@Test
	void checkGPSLibraryIsReadingGPSData() throws ImageProcessingException, IOException {

        GeoRecord record = exifReaderService.getExifData();

        assertEquals(40.2004238, record.getLat());
        assertEquals(-7.636439599999999, record.getLon());
	}

}
