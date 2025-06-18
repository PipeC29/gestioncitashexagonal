package com.fcv.gestioncitas.infrastructure.controller;

import com.fcv.gestioncitas.domain.model.Paciente;
import com.fcv.gestioncitas.domain.port.in.CrearPacienteUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final CrearPacienteUseCase crearPacienteUseCase;

    public PacienteController(CrearPacienteUseCase crearPacienteUseCase) {
        this.crearPacienteUseCase = crearPacienteUseCase;
    }

    @PostMapping
    public ResponseEntity<Paciente> registrar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(crearPacienteUseCase.crear(paciente));
    }
}
