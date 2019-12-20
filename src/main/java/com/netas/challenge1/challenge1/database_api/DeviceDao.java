package com.netas.challenge1.challenge1.database_api;

import com.netas.challenge1.challenge1.models.Device;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DeviceDao extends CrudRepository<Device,Long> {

    Page<Device> findAll(Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM Devices WHERE BRAND =:brand AND MODEL =:model AND OS_VERSION =:osVersion",nativeQuery = true)
    int countOfRecord(@Param("brand") String brand, @Param("model") String model,
                      @Param("osVersion") String osVersion);

}
