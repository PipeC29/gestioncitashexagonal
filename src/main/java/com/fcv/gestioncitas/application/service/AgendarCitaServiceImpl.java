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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class AgendarCitaServiceImpl implements AgendarCitaUseCase {

    private final BuscarDoctorPort buscarDoctorPort;
    private final BuscarPacientePort buscarPacientePort;
    private final GuardarCitaPort guardarCitaPort;

    public AgendarCitaServiceImpl(BuscarDoctorPort buscarDoctorPort,
                                  BuscarPacientePort buscarPacientePort,
                                  GuardarCitaPort guardarCitaPort) {
        this.buscarDoctorPort = buscarDoctorPort;
        this.buscarPacientePort = buscarPacientePort;
        this.guardarCitaPort = guardarCitaPort;
    }

    public Cita agendarCita(Cita cita) {
        Doctor doctor = buscarDoctorPort.buscarDoctorPorId(cita.getDoctor().getId())
                .orElseThrow(new ResourceNotFoundException("Doctor no encontrado"));
        Paciente paciente = buscarPacientePort.buscarPacientePorId(cita.getPaciente().getId())
                .orElseThrow(new ResourceNotFoundException("Paciente no encontrado"));

        validarDisponibilidad(cita, doctor);

        return guardarCitaPort.guardar(new Cita(doctor, paciente, cita.getFechaHora(), cita.getDuracionMinutos()));
    }

    private void validarDisponibilidad(Cita cita, Doctor doctor) {
        LocalDateTime inicio = cita.getFechaHora();
        LocalDateTime fin = inicio.plusMinutes(cita.getDuracionMinutos());

        LocalDateTime horarioInicio = inicio.with(doctor.getHoraInicio());
        LocalDateTime horarioFin = inicio.with(doctor.getHoraFin());

        if (inicio.isBefore(horarioInicio) || fin.isAfter(horarioFin)) {
            throw new AgendaOcupadaException("La cita está fuera del horario del doctor");
        }

        if (inicio.isBefore(LocalDateTime.now().plusMinutes(30))) {
            throw new AgendaOcupadaException("La cita debe agendarse con al menos 30 minutos de anticipación");
        }

        boolean solapada = guardarCitaPort.haySolapamiento(doctor.getId(), inicio, fin);
        if (solapada) {
            throw new AgendaOcupadaException("El doctor ya tiene una cita en ese horario");
        }
    }
}
