package com.fcv.gestioncitas.application.dto;

import java.time.LocalDateTime;

public class CitaDTO {
    private Long idDoctor;
    private Long idPaciente;
    private LocalDateTime fechaHora;
    private int duracionMinutos;

    public CitaDTO() {}

    public CitaDTO(Long idDoctor, Long idPaciente, LocalDateTime fechaHora, int duracionMinutos) {
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
        this.fechaHora = fechaHora;
        this.duracionMinutos = duracionMinutos;
    }

    public Long getIdDoctor() { return idDoctor; }
    public void setIdDoctor(Long idDoctor) { this.idDoctor = idDoctor; }

    public Long getIdPaciente() { return idPaciente; }
    public void setIdPaciente(Long idPaciente) { this.idPaciente = idPaciente; }

    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public int getDuracionMinutos() { return duracionMinutos; }
    public void setDuracionMinutos(int duracionMinutos) { this.duracionMinutos = duracionMinutos; }
}
