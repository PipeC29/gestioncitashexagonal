package com.fcv.gestioncitas.domain.port.in;

import com.fcv.gestioncitas.domain.model.Paciente;

public interface CrearPacienteUseCase {
    Paciente crear(Paciente paciente);
}
