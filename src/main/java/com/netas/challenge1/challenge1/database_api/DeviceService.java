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

    public Page<Device> getAllDevicesAsPage(int pageNumber){

        PageRequest pageable = PageRequest.of(pageNumber - 1, 2);
        Page<Device> resultPage = deviceDao.findAll(pageable);

        return resultPage;
    }


    public ArrayList<Device> getAllDevices(){

        ArrayList<Device> devicesFromDB = new ArrayList<>();

        /*corresponding SELECT * FROM statement in spring boot
        * data is being loading to arraylist
        * */
        deviceDao.findAll().forEach(device -> devicesFromDB.add(device));
        return devicesFromDB;

    }
}
