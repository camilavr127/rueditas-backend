package com.t1.rueda_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t1.rueda_back.dto.RuedaRequest;
import com.t1.rueda_back.dto.RuedaResponse;
import com.t1.rueda_back.service.RuedasService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("")
public class RuedaController {
    @Autowired
    RuedasService ruedaService;

    @PostMapping("/buscar")
    public RuedaResponse response(@RequestBody RuedaRequest request) {
        try {
            String[] datosVehiculo = ruedaService.validarPlaca(request);
            if (datosVehiculo == null) {
                return new RuedaResponse("01","", "", 0, 0, "");
            }
            return new RuedaResponse("00",datosVehiculo[0], datosVehiculo[1], Integer.parseInt(datosVehiculo[2]), Double.parseDouble(datosVehiculo[3]),  datosVehiculo[4]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new RuedaResponse("99", "Error", "Error", 0, 0,"Error");
        }
    }
    

}
