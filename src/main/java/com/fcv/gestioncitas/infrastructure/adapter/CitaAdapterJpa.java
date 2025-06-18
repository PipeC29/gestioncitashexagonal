package com.fcv.gestioncitas.infrastructure.adapter;

import com.fcv.gestioncitas.domain.model.Cita;
import com.fcv.gestioncitas.domain.model.Doctor;
import com.fcv.gestioncitas.domain.model.Paciente;
import com.fcv.gestioncitas.domain.port.out.GuardarCitaPort;
import com.fcv.gestioncitas.domain.port.out.CitaConsultaPort;
import com.fcv.gestioncitas.infrastructure.mapper.CitaMapper;
import com.fcv.gestioncitas.infrastructure.mapper.DoctorMapper;
import com.fcv.gestioncitas.infrastructure.mapper.PacienteMapper;
import com.fcv.gestioncitas.infrastructure.repository.jpa.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CitaAdapterJpa implements GuardarCitaPort, CitaConsultaPort {

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

    @Override
    public Cita guardar(Cita cita) {
        DoctorEntity doctorEntity = doctorRepository.getReferenceById(cita.getDoctor().getId());
        PacienteEntity pacienteEntity = pacienteRepository.getReferenceById(cita.getPaciente().getId());

        CitaEntity entity = CitaMapper.toEntity(cita, doctorEntity, pacienteEntity);
        CitaEntity guardada = citaRepository.save(entity);

        return CitaMapper.toModel(guardada);
    }

    @Override
    public boolean haySolapamiento(Long doctorId, LocalDateTime inicio, LocalDateTime fin) {
        return citaRepository.existeSolapamiento(doctorId, inicio, fin);
    }

    @Override
    public List<Cita> obtenerCitasPorDoctorOrdenadas(Long idDoctor) {
        return citaRepository.findByDoctorIdOrderByFechaHoraAsc(idDoctor)
                .stream()
                .map(CitaMapper::toModel)
                .collect(Collectors.toList());
    }
}
