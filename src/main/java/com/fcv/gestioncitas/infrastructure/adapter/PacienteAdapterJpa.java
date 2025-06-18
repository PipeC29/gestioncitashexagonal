package com.fcv.gestioncitas.infrastructure.adapter;

import com.fcv.gestioncitas.domain.model.Paciente;
import com.fcv.gestioncitas.domain.port.out.BuscarPacientePort;
import com.fcv.gestioncitas.domain.port.out.GuardarPacientePort;
import com.fcv.gestioncitas.infrastructure.mapper.PacienteMapper;
import com.fcv.gestioncitas.infrastructure.repository.jpa.PacienteRepositoryJpa;
import com.fcv.gestioncitas.infrastructure.repository.jpa.PacienteEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PacienteAdapterJpa implements GuardarPacientePort, BuscarPacientePort {

    private final PacienteRepositoryJpa repository;

    public PacienteAdapterJpa(PacienteRepositoryJpa repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Paciente> buscarPacientePorId(Long id) {
        return repository.findById(id).map(PacienteMapper::toModel);
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        PacienteEntity entity = PacienteMapper.toEntity(paciente);
        PacienteEntity guardado = repository.save(entity);
        return PacienteMapper.toModel(guardado);
    }
}
