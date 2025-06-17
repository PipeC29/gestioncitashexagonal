package com.fcv.gestioncitas.infrastructure.mapper;

import com.fcv.gestioncitas.domain.model.Cita;
import com.fcv.gestioncitas.domain.model.Doctor;
import com.fcv.gestioncitas.domain.model.Paciente;
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
        Doctor doctor = DoctorMapper.toModel(entity.getDoctor());
        Paciente paciente = PacienteMapper.toModel(entity.getPaciente());
        Cita model = new Cita(doctor, paciente, entity.getFechaHora(), entity.getDuracionMinutos());
        model.setId(entity.getId());
        return model;
    }
}
