package com.t1.rueda_back.service;

import java.io.IOException;

import com.t1.rueda_back.dto.RuedaRequest;

public interface RuedasService {
    String[] validarPlaca(RuedaRequest request) throws IOException;
}
