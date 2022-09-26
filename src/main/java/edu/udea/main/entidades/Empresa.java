package edu.udea.main.entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    private String nombre;

    private String direccion;

    private String telefono;

    private String nit;

    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "empresa", cascade={CascadeType.REMOVE}, orphanRemoval=true)
    private List<Empleado> empleados = new ArrayList<>();


    @OneToMany(mappedBy = "empresa", cascade={CascadeType.REMOVE}, orphanRemoval=true)
    private List<Movimiento> movimientos = new ArrayList<>();

    public Empresa() {
    }

    public Empresa(long id, String nombre, String direccion, String telefono, String nit, LocalDate fechaCreacion, List<Empleado> empleados, List<Movimiento> movimientos) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;
        this.fechaCreacion = fechaCreacion;
        this.empleados = empleados;
        this.movimientos = movimientos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

}
