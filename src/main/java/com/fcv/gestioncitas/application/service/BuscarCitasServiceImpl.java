package com.fcv.gestioncitas.application.service;

import com.fcv.gestioncitas.domain.model.Cita;
import com.fcv.gestioncitas.domain.port.in.BuscarCitasUseCase;
import com.fcv.gestioncitas.domain.port.out.CitaConsultaPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarCitasServiceImpl implements BuscarCitasUseCase {

    private final CitaConsultaPort citaConsultaPort;

    public BuscarCitasServiceImpl(CitaConsultaPort citaConsultaPort) {
        this.citaConsultaPort = citaConsultaPort;
    }

    @Override
    public List<Cita> obtenerCitasPorDoctor(Long idDoctor) {
        return citaConsultaPort.obtenerCitasPorDoctorOrdenadas(idDoctor);
    }
}

