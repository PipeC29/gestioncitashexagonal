package com.fcv.gestioncitas.infrastructure.controller;

import com.fcv.gestioncitas.domain.model.Doctor;
import com.fcv.gestioncitas.domain.port.in.CrearDoctorUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctores")
public class DoctorController {

    private final CrearDoctorUseCase crearDoctorUseCase;

    public DoctorController(CrearDoctorUseCase crearDoctorUseCase) {
        this.crearDoctorUseCase = crearDoctorUseCase;
    }

    @PostMapping
    public ResponseEntity<Doctor> crear(@RequestBody Doctor doctor) {
        Doctor creado = crearDoctorUseCase.crear(doctor);
        return ResponseEntity.ok(creado);
    }
}
