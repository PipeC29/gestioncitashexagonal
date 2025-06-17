package com.fcv.gestioncitas.domain.port.out;

import com.fcv.gestioncitas.domain.model.Cita;
import java.util.List;

public interface CitaConsultaPort {
    List<Cita> obtenerCitasPorDoctorOrdenadas(Long idDoctor);
}
