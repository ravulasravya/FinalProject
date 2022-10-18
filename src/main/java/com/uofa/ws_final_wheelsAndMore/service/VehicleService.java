package com.uofa.ws_final_wheelsAndMore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import com.uofa.ws_final_wheelsAndMore.model.VehiclesDB;
import com.uofa.ws_final_wheelsAndMore.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public List<VehiclesDB> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public void saveVehicle(VehiclesDB vehicles){
        this.vehicleRepository.save(vehicles);
    }

     public VehiclesDB getVehicleById(int id_vehicles) {
        Optional<VehiclesDB> optional = vehicleRepository.findById(id_vehicles);
         VehiclesDB vehicles = null;
        if (optional.isPresent()) {
            vehicles = optional.get();
        } else {
            throw new RuntimeException(" Vehicle not found for id :: " + id_vehicles);
        }
        return vehicles;
    }

      public void deleteVehicleById(int id_vehicles) {
        this.vehicleRepository.deleteById(id_vehicles);
    }

//    public Page<VehiclesDB> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
//        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
//                Sort.by(sortField).descending();
//
//        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
//        return this.vehicleRepository.findAll(pageable);
//    }
}
