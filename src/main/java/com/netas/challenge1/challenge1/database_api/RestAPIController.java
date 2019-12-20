package com.netas.challenge1.challenge1.database_api;


import com.netas.challenge1.challenge1.models.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestAPIController {

    @Autowired
    DeviceService deviceService;

    @GetMapping("/devices")
    public List<Device> findAllPaginated(@RequestParam("pageNumber") int pageNumber) {

        Page<Device> resultPage = deviceService.getAllDevicesAsPage(pageNumber);
        return resultPage.getContent();
    }

    @PostMapping("/devices")
    private long savePerson(@RequestBody Device device) {

        deviceService.saveDeviceToDB(device);
        return device.getDeviceID();
    }
}
