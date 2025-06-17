package com.fcv.gestioncitas.infrastructure.mapper;

import com.fcv.gestioncitas.domain.model.Doctor;
import com.fcv.gestioncitas.infrastructure.repository.jpa.DoctorEntity;

public class DoctorMapper {

    public static DoctorEntity toEntity(Doctor model) {
        return new DoctorEntity(
                model.getId(),
                model.getNombre(),
                model.getApellido(),
                model.getEspecialidad(),
                model.getHoraInicio(),
                model.getHoraFin()
        );
    }

    public static Doctor toModel(DoctorEntity entity) {
        return new Doctor(
                entity.getId(),
                entity.getNombre(),
                entity.getApellido(),
                entity.getEspecialidad(),
                entity.getHoraInicio(),
                entity.getHoraFin()
        );
    }
}
