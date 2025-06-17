package com.fcv.gestioncitas.infrastructure.adapter;

import com.fcv.gestioncitas.domain.model.Doctor;
import com.fcv.gestioncitas.domain.port.out.GuardarDoctorPort;
import com.fcv.gestioncitas.infrastructure.repository.jpa.DoctorJpaRepository;
import com.fcv.gestioncitas.infrastructure.repository.jpa.DoctorEntity;
import com.fcv.gestioncitas.infrastructure.mapper.DoctorMapper;
import org.springframework.stereotype.Component;

@Component
public class DoctorAdapterJpa implements GuardarDoctorPort {

    private final DoctorJpaRepository repository;

    public DoctorJpaAdapter(DoctorJpaRepository repository) {
        this.repository = repository;
    }

    public Doctor guardar(Doctor doctor) {
        DoctorEntity entity = DoctorMapper.toEntity(doctor);
        DoctorEntity saved = repository.save(entity);
        return DoctorMapper.toModel(saved);
    }
}
