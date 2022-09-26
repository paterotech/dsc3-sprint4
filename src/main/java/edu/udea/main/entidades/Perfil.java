package edu.udea.main.entidades;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    private String id;
    private String imagen;
    private String telefono;

    private LocalDate fechaCreacion;

    @OneToOne(cascade={CascadeType.REMOVE}, orphanRemoval=true)
    @JoinColumn(name = "id_empleado", insertable = false, updatable = false)
    private Empleado empleado;


    public Perfil() {
    }


    public Perfil(String id, String imagen, String telefono, LocalDate fechaCreacion, Empleado empleado) {
        this.id = id;
        this.imagen = imagen;
        this.telefono = telefono;
        this.fechaCreacion = fechaCreacion;
        this.empleado = empleado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
