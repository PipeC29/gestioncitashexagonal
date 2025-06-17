package com.fcv.gestioncitas.domain.model;

public class Paciente {

    private Long id;
    private String nombre;
    private String identificacion;

    public Paciente(Long id, String nombre, String identificacion) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getIdentificacion() { return identificacion; }
}
