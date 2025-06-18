package com.fcv.gestioncitas.infrastructure.repository.jpa;



import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas")
public class CitaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DoctorEntity doctor;

    @ManyToOne
    private PacienteEntity paciente;

    private LocalDateTime fechaHora;
    private int duracionMinutos;

    public CitaEntity() {}

    public CitaEntity(DoctorEntity doctor, PacienteEntity paciente, LocalDateTime fechaHora, int duracionMinutos) {
        this.doctor = doctor;
        this.paciente = paciente;
        this.fechaHora = fechaHora;
        this.duracionMinutos = duracionMinutos;
    }

    public Long getId() { return id; }
    public DoctorEntity getDoctor() { return doctor; }
    public PacienteEntity getPaciente() { return paciente; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public int getDuracionMinutos() { return duracionMinutos; }

    public void setId(Long id) { this.id = id; }
}
