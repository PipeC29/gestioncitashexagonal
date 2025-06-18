package com.fcv.gestioncitas.domain.port.out;

import com.fcv.gestioncitas.domain.model.Paciente;

public interface GuardarPacientePort {
    Paciente guardar(Paciente paciente);
}
