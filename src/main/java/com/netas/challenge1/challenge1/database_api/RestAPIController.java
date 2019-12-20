package com.netas.challenge1.challenge1.database_api;


import com.netas.challenge1.challenge1.models.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RestAPIController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/devices")
    public List<Device> findAllPaginated(@RequestParam("page") Integer page) {

        System.out.println("Page Number is : "+page.toString());

        Page<Device> resultPage = deviceService.getAllDevicesAsPage(page);
        return resultPage.getContent();
    }

    @RequestMapping(value = "/devices", params = "brand", method = GET)
    @ResponseBody
    public List<Device> getDevicesByParams1(@RequestParam("brand") String brand) {

        System.out.println("brand is : "+ brand);

        ArrayList<Device> devicesResult = deviceService.getDeviceByBrand(brand);
        return devicesResult;
    }

    @RequestMapping(value = "/devices", params = "model", method = GET)
    @ResponseBody
    public List<Device> getDevicesByParams2(@RequestParam("model") String model) {

        System.out.println("model is : "+ model);

        ArrayList<Device> devicesResult = deviceService.getDeviceByModel(model);
        return devicesResult;
    }

    @RequestMapping(value = "/devices", params = {"brand","model"}, method = GET)
    @ResponseBody
    public List<Device> getDevicesByParams3(@RequestParam("brand") String brand, @RequestParam("model") String model) {

        System.out.println("brand is : "+ brand);
        System.out.println("model is : "+ model);

        ArrayList<Device> devicesResult = deviceService.getDeviceByBrandModel(brand,model);
        return devicesResult;
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
