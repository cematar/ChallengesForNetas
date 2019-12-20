package com.netas.challenge1.challenge1.Parsers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netas.challenge1.challenge1.models.Device;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseJson {

    private void writeJson(){
        ArrayList<Device> devices = new ArrayList<>();
        devices.add(new Device("Huawei P20","Huawei", "Android","9.0.1"));
        devices.add(new Device("Samsung Galaxy","Samsung", "Android","9.1.1"));

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            objectMapper.writeValue(new File("C:\\challenge1\\denemejson.json"),devices);

        }catch (Exception e){

            System.out.println("Exception Olustu");
        }
    }

    public List<Device> readJson(String jsonFile){

        List<Device> devices = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        try{

            devices = objectMapper.readValue(new File(jsonFile), new TypeReference<List<Device>>(){});

        }catch (JsonMappingException jme){
            System.out.println("Mapping Ex");
        }catch (JsonParseException jpe){
            System.out.println("Parse Ex");
        }catch (IOException ioe){
            System.out.println("IO Ex");

        }
        for(Device device : devices){

            System.out.println("Model "+ device.getModel());
            System.out.println("Brand "+ device.getBrand());
            System.out.println("OS "+ device.getOs());
        }

        return devices;
    }
}
