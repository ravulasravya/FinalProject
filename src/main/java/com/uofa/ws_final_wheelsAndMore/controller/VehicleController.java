package com.uofa.ws_final_wheelsAndMore.controller;

import com.uofa.ws_final_wheelsAndMore.model.VehiclesDB;
import com.uofa.ws_final_wheelsAndMore.repository.VehicleRepository;
import com.uofa.ws_final_wheelsAndMore.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/")
    public String listVehicles(Model model) {
        model.addAttribute("listVehicles", vehicleService.getAllVehicles());
        return "index";
    }

    @GetMapping("/showNewVehicleForm")
    public String showNewVehicleForm(Model model){
        //create model attribute to bind the form data
        VehiclesDB vehicles = new VehiclesDB();
        model.addAttribute("vehicles", vehicles);
        return "new_vehicle";
    }

    @PostMapping("/saveVehicle")
    public String saveVehicle(@Valid @ModelAttribute("vehicles") VehiclesDB vehicles, BindingResult result,Model model) {
        try {
            vehicleService.saveVehicle(vehicles);
            return "redirect:/";
        }catch (Exception e){
            return "new_vehicle";
        }
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") int id_vehicles, Model model) {
        VehiclesDB vehicles = vehicleService.getVehicleById(id_vehicles);
        model.addAttribute("vehicles", vehicles);
        return "update_vehicle";
    }

    @PostMapping("/saveVehicleUpdate")
    public String saveVehicleUpdate(@Valid @ModelAttribute("vehicles") VehiclesDB vehicles, BindingResult result,Model model) {
        try {
            vehicleService.saveVehicle(vehicles);
            return "redirect:/";
        } catch (Exception e) {
            return "update_vehicle";
        }
    }

    @GetMapping("/deleteVehicle/{id}")
    public String deleteVehicle(@PathVariable (value = "id") int id_vehicles) {
        this.vehicleService.deleteVehicleById(id_vehicles);
        return "redirect:/";
    }
}
