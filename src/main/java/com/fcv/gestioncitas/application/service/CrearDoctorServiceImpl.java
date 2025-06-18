package com.fcv.gestioncitas.application.service;

import com.fcv.gestioncitas.domain.model.Doctor;
import com.fcv.gestioncitas.domain.port.in.CrearDoctorUseCase;
import com.fcv.gestioncitas.domain.port.out.GuardarDoctorPort;
import org.springframework.stereotype.Service;

@Service
public class CrearDoctorServiceImpl implements CrearDoctorUseCase {

    private final GuardarDoctorPort guardarDoctorPort;

    public CrearDoctorServiceImpl(GuardarDoctorPort guardarDoctorPort) {
        this.guardarDoctorPort = guardarDoctorPort;
    }

    public Doctor crear(Doctor doctor) {
        if (doctor.getNombre() == null || doctor.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (doctor.getApellido() == null || doctor.getApellido().trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido es obligatorio");
        }
        if (doctor.getEspecialidad() == null || doctor.getEspecialidad().trim().isEmpty()) {
            throw new IllegalArgumentException("La especialidad es obligatoria");
        }
        if (doctor.getHoraInicio() == null || doctor.getHoraFin() == null ||
                !doctor.getHoraInicio().isBefore(doctor.getHoraFin())) {
            throw new IllegalArgumentException("El horario no es válido");
        }

        return guardarDoctorPort.guardar(doctor);
    }
}
