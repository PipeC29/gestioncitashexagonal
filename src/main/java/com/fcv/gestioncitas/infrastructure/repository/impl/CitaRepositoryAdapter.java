package com.fcv.gestioncitas.infrastructure.repository.impl;

import com.fcv.gestioncitas.domain.model.Cita;
import com.fcv.gestioncitas.domain.model.Doctor;
import com.fcv.gestioncitas.domain.model.Paciente;
import com.fcv.gestioncitas.domain.port.out.BuscarDoctorPort;
import com.fcv.gestioncitas.domain.port.out.BuscarPacientePort;
import com.fcv.gestioncitas.domain.port.out.GuardarCitaPort;
import com.fcv.gestioncitas.infrastructure.mapper.CitaMapper;
import com.fcv.gestioncitas.infrastructure.mapper.DoctorMapper;
import com.fcv.gestioncitas.infrastructure.mapper.PacienteMapper;
import com.fcv.gestioncitas.infrastructure.repository.jpa.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CitaRepositoryAdapter implements GuardarCitaPort, BuscarDoctorPort, BuscarPacientePort {

    private final CitaRepositoryJpa citaRepo;
    private final DoctorRepositoryJpa doctorRepo;
    private final PacienteRepositoryJpa pacienteRepo;

    public CitaRepositoryAdapter(CitaRepositoryJpa citaRepo, DoctorRepositoryJpa doctorRepo, PacienteRepositoryJpa pacienteRepo) {
        this.citaRepo = citaRepo;
        this.doctorRepo = doctorRepo;
        this.pacienteRepo = pacienteRepo;
    }

    @Override
    public Cita guardar(Cita cita) {
        DoctorEntity doctorEntity = DoctorMapper.toEntity(cita.getDoctor());
        PacienteEntity pacienteEntity = PacienteMapper.toEntity(cita.getPaciente());
        CitaEntity entity = CitaMapper.toEntity(cita, doctorEntity, pacienteEntity);
        return CitaMapper.toModel(citaRepo.save(entity));
    }

    public Optional<Doctor> buscarDoctorPorId(Long id) {
        return doctorRepo.findById(id).map(DoctorMapper::toModel);
    }

    @Override
    public Optional<Paciente> buscarPacientePorId(Long id) {
        return pacienteRepo.findById(id).map(PacienteMapper::toModel);
    }
}
