package com.fcv.gestioncitas.infrastructure.controller;

import com.fcv.gestioncitas.domain.model.Cita;
import com.fcv.gestioncitas.domain.port.in.BuscarCitasUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaConsultaController {

    private final BuscarCitasUseCase buscarCitasUseCase;

    public CitaConsultaController(BuscarCitasUseCase buscarCitasUseCase) {
        this.buscarCitasUseCase = buscarCitasUseCase;
    }

    @GetMapping("/doctor/{idDoctor}")
    public ResponseEntity<List<Cita>> obtenerCitasPorDoctor(@PathVariable Long idDoctor) {
        List<Cita> citas = buscarCitasUseCase.obtenerCitasPorDoctor(idDoctor);
        return ResponseEntity.ok(citas);
    }
}
