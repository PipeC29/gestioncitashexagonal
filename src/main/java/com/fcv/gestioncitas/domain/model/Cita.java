package com.fcv.gestioncitas.domain.model;

import java.time.LocalDateTime;

public class Cita {
    private Long id;
    private Doctor doctor;
    private Paciente paciente;
    private LocalDateTime fechaHora;
    private int duracionMinutos;

    public Cita(Doctor doctor, Paciente paciente, LocalDateTime fechaHora, int duracionMinutos) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.fechaHora = fechaHora;
        this.duracionMinutos = duracionMinutos;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Doctor getDoctor() { return doctor; }
    public Paciente getPaciente() { return paciente; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public int getDuracionMinutos() { return duracionMinutos; }

    public LocalDateTime getHoraFin() {
        return fechaHora.plusMinutes(duracionMinutos);
    }
}
