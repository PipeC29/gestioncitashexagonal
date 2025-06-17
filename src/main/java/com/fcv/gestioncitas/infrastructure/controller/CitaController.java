package com.fcv.gestioncitas.infrastructure.controller;

import com.fcv.gestioncitas.application.dto.CitaDTO;
import com.fcv.gestioncitas.domain.model.Cita;
import com.fcv.gestioncitas.domain.model.Doctor;
import com.fcv.gestioncitas.domain.model.Paciente;
import com.fcv.gestioncitas.domain.port.in.AgendarCitaUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final AgendarCitaUseCase agendarCitaUseCase;

    public CitaController(AgendarCitaUseCase agendarCitaUseCase) {
        this.agendarCitaUseCase = agendarCitaUseCase;
    }

    @PostMapping
    public ResponseEntity<Cita> agendar(@RequestBody CitaDTO dto) {
        Cita cita = new Cita(
                new Doctor(null, null, null, null, null), // Placeholder
                new Paciente(null, null, null, null),     // Placeholder
                dto.getFechaHora(),
                dto.getDuracionMinutos()
        );
        cita.getDoctor().setId(dto.getIdDoctor());
        cita.getPaciente().setId(dto.getIdPaciente());

        Cita agendada = agendarCitaUseCase.agendarCita(cita);
        return ResponseEntity.ok(agendada);
    }
}
