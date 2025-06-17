package com.fcv.gestioncitas.infrastructure.mapper;

import com.fcv.gestioncitas.domain.model.Paciente;
import com.fcv.gestioncitas.infrastructure.repository.jpa.PacienteEntity;

public class PacienteMapper {

    public static PacienteEntity toEntity(Paciente model) {
        return new PacienteEntity(model.getId(), model.getNombre(), model.getIdentificacion());
    }

    public static Paciente toModel(PacienteEntity entity) {
        return new Paciente(entity.getId(), entity.getNombre(), entity.getIdentificacion());
    }
}
