package com.fcv.gestioncitas.domain.model;

import java.time.LocalTime;

public class Doctor {
    private Long id;
    private String nombre;
    private String apellido;
    private String especialidad;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public Doctor(String nombre, String apellido, String especialidad, LocalTime horaInicio, LocalTime horaFin) {
        if (horaInicio.isAfter(horaFin)) {
            throw new IllegalArgumentException("La hora de inicio debe ser menor que la hora de fin");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEspecialidad() { return especialidad; }
    public LocalTime getHoraInicio() { return horaInicio; }
    public LocalTime getHoraFin() { return horaFin; }
}
