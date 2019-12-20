package com.netas.challenge1.challenge1.database_api;

import com.netas.challenge1.challenge1.models.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;

public interface DeviceDao extends CrudRepository<Device,Integer> {

    Page<Device> findAll(Pageable pageable);

}
