package com.fcv.gestioncitas.infrastructure.adapter;

import com.fcv.gestioncitas.domain.model.Doctor;
import com.fcv.gestioncitas.domain.port.out.BuscarDoctorPort;
import com.fcv.gestioncitas.domain.port.out.GuardarDoctorPort;
import com.fcv.gestioncitas.infrastructure.repository.jpa.DoctorRepositoryJpa;
import com.fcv.gestioncitas.infrastructure.repository.jpa.DoctorEntity;
import com.fcv.gestioncitas.infrastructure.mapper.DoctorMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DoctorAdapterJpa implements GuardarDoctorPort, BuscarDoctorPort {

    private final DoctorRepositoryJpa repository;


    public DoctorAdapterJpa(DoctorRepositoryJpa repository) {
        this.repository = repository;
    }

    public Doctor guardar(Doctor doctor) {
        DoctorEntity entity = DoctorMapper.toEntity(doctor);
        DoctorEntity saved = repository.save(entity);
        return DoctorMapper.toModel(saved);
    }

    @Override
    public Optional<Doctor> buscarDoctorPorId(Long id) {
        return repository.findById(id).map(DoctorMapper::toModel);
    }

}
