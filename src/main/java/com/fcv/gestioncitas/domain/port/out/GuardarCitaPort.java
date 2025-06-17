package com.fcv.gestioncitas.domain.port.out;

import com.fcv.gestioncitas.domain.model.Cita;

public interface GuardarCitaPort {
    Cita guardar(Cita cita);
}
