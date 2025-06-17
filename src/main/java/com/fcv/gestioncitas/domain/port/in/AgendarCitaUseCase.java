package com.fcv.gestioncitas.domain.port.in;

import com.fcv.gestioncitas.domain.model.Cita;

public interface AgendarCitaUseCase {
    Cita agendarCita(Cita cita);
}
