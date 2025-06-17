package com.fcv.gestioncitas.application.service;

import com.fcv.gestioncitas.domain.model.Cita;
import com.fcv.gestioncitas.domain.model.Doctor;
import com.fcv.gestioncitas.domain.model.Paciente;
import com.fcv.gestioncitas.domain.port.in.AgendarCitaUseCase;
import com.fcv.gestioncitas.domain.port.out.BuscarDoctorPort;
import com.fcv.gestioncitas.domain.port.out.BuscarPacientePort;
import com.fcv.gestioncitas.domain.port.out.GuardarCitaPort;
import com.fcv.gestioncitas.exception.AgendaOcupadaException;
import com.fcv.gestioncitas.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.time.LocalDateTime;

@Service
public class AgendarCitaServiceImpl implements AgendarCitaUseCase {



    private final BuscarDoctorPort buscarDoctorPort;
    private final BuscarPacientePort buscarPacientePort;
    private final GuardarCitaPort guardarCitaPort;

    @Autowired
    public AgendarCitaServiceImpl(BuscarDoctorPort buscarDoctorPort,
                                  BuscarPacientePort buscarPacientePort,
                                  GuardarCitaPort guardarCitaPort) {
        this.buscarDoctorPort = buscarDoctorPort;
        this.buscarPacientePort = buscarPacientePort;
        this.guardarCitaPort = guardarCitaPort;
    }

    @Override
    public Cita agendarCita(Cita cita) {
        Doctor doctor = buscarDoctorPort.buscarDoctorPorId(cita.getDoctor().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Doctor no encontrado"));

        Paciente paciente = buscarPacientePort.buscarPacientePorId(cita.getPaciente().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente no encontrado"));

        validarDisponibilidad(cita, doctor);

        // Asociar las entidades completas
        cita = new Cita(doctor, paciente, cita.getFechaHora(), cita.getDuracionMinutos());

        return guardarCitaPort.guardar(cita);
    }

    private void validarDisponibilidad(Cita cita, Doctor doctor) {
        LocalDateTime inicio = cita.getFechaHora();
        LocalDateTime fin = inicio.plusMinutes(cita.getDuracionMinutos());

        LocalDateTime doctorInicio = inicio.with(doctor.getHoraInicio());
        LocalDateTime doctorFin = inicio.with(doctor.getHoraFin());

        if (inicio.isBefore(doctorInicio) || fin.isAfter(doctorFin)) {
            throw new AgendaOcupadaException("La cita está fuera del horario del doctor");
        }
    }
}
