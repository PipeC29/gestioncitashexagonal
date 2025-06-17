package com.fcv.gestioncitas.domain.port.in;

import com.fcv.gestioncitas.domain.model.Cita;
import java.util.List;

public interface BuscarCitasUseCase {
    List<Cita> obtenerCitasPorDoctor(Long idDoctor);
}
