package com.fcv.gestioncitas.infrastructure.mapper;

import com.fcv.gestioncitas.domain.model.Cita;
import com.fcv.gestioncitas.infrastructure.repository.jpa.CitaEntity;
import com.fcv.gestioncitas.infrastructure.repository.jpa.DoctorEntity;
import com.fcv.gestioncitas.infrastructure.repository.jpa.PacienteEntity;

public class CitaMapper {

    public static CitaEntity toEntity(Cita model, DoctorEntity doctorEntity, PacienteEntity pacienteEntity) {
        CitaEntity entity = new CitaEntity(doctorEntity, pacienteEntity, model.getFechaHora(), model.getDuracionMinutos());
        entity.setId(model.getId());
        return entity;
    }

    public static Cita toModel(CitaEntity entity) {
        return new Cita(
                DoctorMapper.toModel(entity.getDoctor()),
                PacienteMapper.toModel(entity.getPaciente()),
                entity.getFechaHora(),
                entity.getDuracionMinutos()
        );
    }
}
