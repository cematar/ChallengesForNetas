package com.netas.challenge1.challenge1.database_api;

import com.netas.challenge1.challenge1.models.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;

@Service
public class DeviceService {

    @Autowired
    DeviceDao deviceDao;

    public void saveDeviceToDB(Device device){

        deviceDao.save(device);
    }

    public ArrayList<Device> getAllDevices(){

        ArrayList<Device> devicesFromDB = new ArrayList<>();

        /*corresponding SELECT * FROM statement in spring boot
        * data is being loading to arraylist
        * */
        deviceDao.findAll().forEach(device -> devicesFromDB.add(device));
        return devicesFromDB;

    }

    public Page<Device> getAllDevicesAsPage(int pageNumber){

        PageRequest pageable = PageRequest.of(pageNumber - 1, 2);
        Page<Device> resultPage = deviceDao.findAll((Pageable) pageable);

        return resultPage;
    }

}
