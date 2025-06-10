package gm.rh.servicio;

import gm.rh.modelo.Usuarios;
import gm.rh.repositorio.RepositorioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio implements IUsuarioServicio{

    @Autowired
    private RepositorioUsuarios repo;

    @Override
    public List<Usuarios> listarUsuarios() {
        return repo.findAll();
    }

    @Override
    public Usuarios guardarUsuario(Usuarios usuarios) {
        return repo.save(usuarios);
    }

    @Override
    public Usuarios buscarUsuario(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void eliminarUsuario(Integer id) {
        if (id != null){
            System.out.println("Usuario con ID: "+id+" Eliminado");
            repo.deleteById(id);
        }else {
            System.out.println("Id no encontrado");
        }
    }
}
