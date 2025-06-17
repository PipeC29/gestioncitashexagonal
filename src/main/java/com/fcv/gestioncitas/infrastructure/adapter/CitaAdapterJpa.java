package com.fcv.gestioncitas.infrastructure.adapter;

import com.fcv.gestioncitas.domain.model.Cita;
import com.fcv.gestioncitas.domain.port.out.GuardarCitaPort;
import com.fcv.gestioncitas.infrastructure.mapper.CitaMapper;
import com.fcv.gestioncitas.infrastructure.repository.jpa.CitaRepositoryJpa;
import com.fcv.gestioncitas.infrastructure.repository.jpa.DoctorEntity;
import com.fcv.gestioncitas.infrastructure.repository.jpa.DoctorRepositoryJpa;
import com.fcv.gestioncitas.infrastructure.repository.jpa.PacienteEntity;
import com.fcv.gestioncitas.infrastructure.repository.jpa.PacienteRepositoryJpa;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CitaAdapterJpa implements GuardarCitaPort {

    private final CitaRepositoryJpa citaRepository;
    private final DoctorRepositoryJpa doctorRepository;
    private final PacienteRepositoryJpa pacienteRepository;

    public CitaAdapterJpa(CitaRepositoryJpa citaRepository,
                          DoctorRepositoryJpa doctorRepository,
                          PacienteRepositoryJpa pacienteRepository) {
        this.citaRepository = citaRepository;
        this.doctorRepository = doctorRepository;
        this.pacienteRepository = pacienteRepository;
    }

    public Cita guardar(Cita cita) {
        DoctorEntity doctorEntity = doctorRepository.getReferenceById(cita.getDoctor().getId());
        PacienteEntity pacienteEntity = pacienteRepository.getReferenceById(cita.getPaciente().getId());
        return CitaMapper.toModel(citaRepository.save(CitaMapper.toEntity(cita, doctorEntity, pacienteEntity)));
    }

    public boolean haySolapamiento(Long doctorId, LocalDateTime inicio, LocalDateTime fin) {
        return citaRepository.existeSolapamiento(doctorId, inicio, fin);
    }
}
