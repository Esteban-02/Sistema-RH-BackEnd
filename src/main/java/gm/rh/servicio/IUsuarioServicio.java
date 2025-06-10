package gm.rh.servicio;

import gm.rh.modelo.Usuarios;

import java.util.List;

public interface IUsuarioServicio{

    List<Usuarios> listarUsuarios();

    Usuarios guardarUsuario(Usuarios usuarios);

    Usuarios buscarUsuario(Integer id);

    void eliminarUsuario(Integer id);


}
