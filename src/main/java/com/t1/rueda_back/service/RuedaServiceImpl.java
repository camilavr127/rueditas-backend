package com.t1.rueda_back.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.t1.rueda_back.dto.RuedaRequest;

@Service
public class RuedaServiceImpl implements RuedasService{
    @Autowired
    ResourceLoader loader;

    @Override
    public String[] validarPlaca(RuedaRequest request) throws IOException {
        String[] datosVehiculo = null;
        Resource resource = loader.getResource("classpath:vehiculos.txt");
        
        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");
                
                if(request.placa().equals(datos[1])){
                    datosVehiculo = new String[5];
                    datosVehiculo[0] = datos[2]; //marca
                    datosVehiculo[1] = datos[3]; //modelo
                    datosVehiculo[2] = (datos[4]); //nro asientos
                    datosVehiculo[3] = datos[5]; //precio
                    datosVehiculo[4] = datos[6]; //color
                }
            }
        } catch (IOException e) {
            datosVehiculo = null;
            throw new IOException(e);
        }
        return datosVehiculo;
    }

}
