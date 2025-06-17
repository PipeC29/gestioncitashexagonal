package com.fcv.gestioncitas.domain.port.out;

import com.fcv.gestioncitas.domain.model.Paciente;

import java.util.Optional;

public interface BuscarPacientePort {
    Optional<Paciente> buscarPacientePorId(Long id);
}
