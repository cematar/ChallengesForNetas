package com.netas.challenge1.challenge1.database_api;

import com.netas.challenge1.challenge1.models.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface DeviceDao extends CrudRepository<Device,Long> {

    Page<Device> findAll(Pageable pageable);


    @Query(value = "SELECT COUNT(*) FROM Devices WHERE BRAND =:brand AND MODEL =:model AND OS_VERSION =:osVersion",nativeQuery = true)
    int countOfRecord(@Param("brand") String brand, @Param("model") String model,
                      @Param("osVersion") String osVersion);

    @Query(value = "SELECT * FROM Devices WHERE BRAND =:brand",nativeQuery = true)
    ArrayList<Device> getDevicesByBrand(@Param("brand") String brand);

    @Query(value = "SELECT * FROM Devices WHERE model =:model",nativeQuery = true)
    ArrayList<Device> getDevicesByModel(@Param("model") String model);

    @Query(value = "SELECT * FROM Devices WHERE BRAND =:brand AND MODEL =:model",nativeQuery = true)
    ArrayList<Device> getDevicesByBrandModel(@Param("brand") String brand, @Param("model") String model);

}
