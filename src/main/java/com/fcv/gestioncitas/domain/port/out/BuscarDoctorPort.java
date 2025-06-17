package com.fcv.gestioncitas.domain.port.out;

import com.fcv.gestioncitas.domain.model.Doctor;

import java.util.Optional;

public interface BuscarDoctorPort {
    Optional<Doctor> buscarDoctorPorId(Long id);
}
