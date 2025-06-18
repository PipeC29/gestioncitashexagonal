package com.fcv.gestioncitas.application.service;

import com.fcv.gestioncitas.domain.model.Paciente;
import com.fcv.gestioncitas.domain.port.in.CrearPacienteUseCase;
import com.fcv.gestioncitas.domain.port.out.GuardarPacientePort;
import org.springframework.stereotype.Service;

@Service
public class CrearPacienteServiceImpl implements CrearPacienteUseCase {

    private final GuardarPacientePort guardarPacientePort;

    public CrearPacienteServiceImpl(GuardarPacientePort guardarPacientePort) {
        this.guardarPacientePort = guardarPacientePort;
    }

    public Paciente crear(Paciente paciente) {
        if (paciente.getNombre() == null || paciente.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del paciente es obligatorio");
        }
        if (paciente.getIdentificacion() == null || paciente.getIdentificacion().trim().isEmpty()) {
            throw new IllegalArgumentException("La identificación del paciente es obligatoria");
        }
        return guardarPacientePort.guardar(paciente);
    }
}
