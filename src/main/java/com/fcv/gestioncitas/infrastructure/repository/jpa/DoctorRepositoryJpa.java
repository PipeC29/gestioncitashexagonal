package com.fcv.gestioncitas.infrastructure.repository.jpa;

import com.fcv.gestioncitas.infrastructure.repository.jpa.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepositoryJpa extends JpaRepository<DoctorEntity, Long> {
}
