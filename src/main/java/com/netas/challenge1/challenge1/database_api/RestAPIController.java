package com.netas.challenge1.challenge1.database_api;


import com.netas.challenge1.challenge1.models.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestAPIController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/dememetext")
    public String getText() {

        return "Deneme String";
    }

    @GetMapping("/devices")
    public List<Device> findAllPaginated(@RequestParam("pageNumber") int pageNumber) {

        Page<Device> resultPage = deviceService.getAllDevicesAsPage(pageNumber);
        return resultPage.getContent();
    }


    @PostMapping("/devices")
    private String createDevices(@RequestBody ArrayList<Device> devices) {

        for(Device device : devices){

            System.out.println("Device Model: "+ device.getModel());
            System.out.println("Device Brand: "+ device.getBrand());
            System.out.println("Device OS: "+ device.getOs());
            System.out.println("Device OSVersion: "+ device.getOsVersion());
        }

        Device savedDevice = deviceService.saveDevicesToDB(devices);
        System.out.println("DeviceDBID :" + savedDevice.getDatabaseId());

        return "Device DatabaseID : "+savedDevice.getDatabaseId();
    }
}
