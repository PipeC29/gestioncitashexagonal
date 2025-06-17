package com.fcv.gestioncitas.infrastructure.mapper;

import com.fcv.gestioncitas.domain.model.Paciente;
import com.fcv.gestioncitas.infrastructure.repository.jpa.PacienteEntity;

public class PacienteMapper {

    public static PacienteEntity toEntity(Paciente model) {
        PacienteEntity entity = new PacienteEntity(
                model.getNombre(),
                model.getApellido(),
                model.getFechaNacimiento(),
                model.getGenero()
        );
        entity.setId(model.getId());
        return entity;
    }

    public static Paciente toModel(PacienteEntity entity) {
        Paciente model = new Paciente(
                entity.getNombre(),
                entity.getApellido(),
                entity.getFechaNacimiento(),
                entity.getGenero()
        );
        model.setId(entity.getId());
        return model;
    }
}
