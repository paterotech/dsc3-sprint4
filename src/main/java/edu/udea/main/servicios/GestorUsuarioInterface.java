package edu.udea.main.servicios;

import edu.udea.main.entidades.Usuario;

import java.util.List;

public interface GestorUsuarioInterface {

    public List<Usuario> getUsuarios();
    public Usuario getUsuario(String id) throws Exception;
    public String setUsuario(Usuario usuario_parametro) throws Exception;
    public Usuario updateUsuarioAll(Usuario usuario_update, String id) throws Exception;
    public Usuario updateUsuario(Usuario usuario_update, String id) throws Exception;
    public String deleteUsuario(String id) throws Exception;


}
