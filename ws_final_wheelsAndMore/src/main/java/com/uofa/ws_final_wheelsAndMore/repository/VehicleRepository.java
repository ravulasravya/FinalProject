package com.uofa.ws_final_wheelsAndMore.repository;

import java.util.List;
import com.uofa.ws_final_wheelsAndMore.model.VehiclesDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<VehiclesDB, Integer> {
    List<VehiclesDB> findByMake(String make);
    List<VehiclesDB> findByModel(String model);
}
