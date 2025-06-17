package com.fcv.gestioncitas.infrastructure.mapper;

import com.fcv.gestioncitas.domain.model.Doctor;
import com.fcv.gestioncitas.infrastructure.repository.jpa.DoctorEntity;

public class DoctorMapper {

    public static DoctorEntity toEntity(Doctor model) {
        DoctorEntity entity = new DoctorEntity(
                model.getNombre(),
                model.getApellido(),
                model.getEspecialidad(),
                model.getHoraInicio(),
                model.getHoraFin()
        );
        entity.setId(model.getId());
        return entity;
    }

    public static Doctor toModel(DoctorEntity entity) {
        Doctor model = new Doctor(
                entity.getNombre(),
                entity.getApellido(),
                entity.getEspecialidad(),
                entity.getHoraInicio(),
                entity.getHoraFin()
        );
        model.setId(entity.getId());
        return model;
    }
}
