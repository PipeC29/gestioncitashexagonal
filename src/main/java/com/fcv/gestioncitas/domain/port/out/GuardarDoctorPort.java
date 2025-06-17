package com.fcv.gestioncitas.domain.port.out;

import com.fcv.gestioncitas.domain.model.Doctor;

public interface GuardarDoctorPort {
    Doctor guardar(Doctor doctor);
}
