package com.netas.challenge1.challenge1.database_api;

import com.netas.challenge1.challenge1.models.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DeviceService {

    @Autowired
    private DeviceDao deviceDao;

    public Device saveDevicesToDB(ArrayList<Device> devices){

        System.out.println("saveDevicesToDB called");

        Device savedDevice = new Device();

        for(Device device : devices){

            String deviceBrand = device.getBrand();
            String deviceModel = device.getModel();
            String deviceOsVersion = device.getOsVersion();

            if(deviceDao.countOfRecord(deviceBrand,deviceModel,deviceOsVersion) < 1){

                System.out.println("No other records found, OK");

                savedDevice =  deviceDao.save(device);

            }else{

                System.out.println("It can not be recorded, already exists!");
            }
        }
        return savedDevice;
    }

    public Page<Device> getAllDevicesAsPage(int page){

        PageRequest pageable = PageRequest.of(page - 1, 5);
        Page<Device> resultPage = deviceDao.findAll(pageable);

        return resultPage;
    }

    public ArrayList<Device> getDeviceByBrand(String brandName) {

        ArrayList<Device> deviceResult = deviceDao.getDevicesByBrand(brandName);

        return deviceResult;
    }

    public ArrayList<Device> getDeviceByModel(String modelName) {

        ArrayList<Device> deviceResult = deviceDao.getDevicesByModel(modelName);

        return deviceResult;
    }

    public ArrayList<Device> getDeviceByBrandModel(String brandName, String modelName) {

        ArrayList<Device> deviceResult = deviceDao.getDevicesByBrandModel(brandName, modelName);

        return deviceResult;
    }
}
