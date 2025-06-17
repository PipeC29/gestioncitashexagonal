package com.fcv.gestioncitas.infrastructure.controller;

import com.fcv.gestioncitas.domain.model.Cita;
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
    public ResponseEntity<Cita> agendar(@RequestBody Cita cita) {
        Cita result = agendarCitaUseCase.agendarCita(cita);
        return ResponseEntity.ok(result);
    }
}
