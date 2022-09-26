package edu.udea.main.entidades;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @Column(unique = true)
    private String correo;
    @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Role role;
    private LocalDate fechaCreacion;

    @OneToOne(cascade={CascadeType.REMOVE}, orphanRemoval=true)
    @JoinColumn(name = "id_perfil", insertable = false, updatable = false)
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_empresa", insertable = false, updatable = false)
    private Empresa empresa;

    @OneToMany(mappedBy = "empleado", cascade={CascadeType.REMOVE}, orphanRemoval=true)
    private List<Movimiento> movimientos = new ArrayList<>();



    public Empleado() {
    }

    public Empleado(long id, String nombre, String correo, Perfil perfil, Role role, LocalDate fechaCreacion, Empresa empresa, List<Movimiento> movimientos) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.perfil = perfil;
        this.role = role;
        this.fechaCreacion = fechaCreacion;
        this.empresa = empresa;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
