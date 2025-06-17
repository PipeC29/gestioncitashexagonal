package com.fcv.gestioncitas.infrastructure.repository.jpa;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "doctores")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String especialidad;

    private LocalTime horaInicio;
    private LocalTime horaFin;

    public DoctorEntity() {}

    public DoctorEntity(Long id, String nombre, String apellido, String especialidad, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEspecialidad() { return especialidad; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public LocalTime getHoraFin() { return horaFin; }
}
