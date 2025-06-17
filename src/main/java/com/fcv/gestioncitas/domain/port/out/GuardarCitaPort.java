package com.fcv.gestioncitas.domain.port.out;

import com.fcv.gestioncitas.domain.model.Cita;

import java.time.LocalDateTime;

public interface GuardarCitaPort {
    Cita guardar(Cita cita);
    boolean haySolapamiento(Long doctorId, LocalDateTime inicio, LocalDateTime fin);
}
