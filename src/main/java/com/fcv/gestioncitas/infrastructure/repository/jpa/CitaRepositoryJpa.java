package com.fcv.gestioncitas.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaRepositoryJpa extends JpaRepository<CitaEntity, Long> {

    @Query("SELECT COUNT(c) > 0 FROM CitaEntity c WHERE c.doctor.id = :doctorId " +
            "AND c.fechaHora < :fin AND FUNCTION('ADDTIME', c.fechaHora, FUNCTION('SEC_TO_TIME', c.duracionMinutos * 60)) > :inicio")
    boolean existeSolapamiento(@Param("doctorId") Long doctorId,
                               @Param("inicio") LocalDateTime inicio,
                               @Param("fin") LocalDateTime fin);

    @Query("SELECT c FROM CitaEntity c WHERE c.doctor.id = :doctorId ORDER BY c.fechaHora ASC")
    List<CitaEntity> findByDoctorIdOrderByFechaHoraAsc(@Param("doctorId") Long doctorId);

}
