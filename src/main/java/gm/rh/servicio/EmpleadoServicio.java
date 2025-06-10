package gm.rh.servicio;

import gm.rh.modelo.Empleado;
import gm.rh.repositorio.RepositorioEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio {

    @Autowired
    private RepositorioEmpleado repositorioEmpleado;

    @Override
    public List<Empleado> listarEmpleados() {
        return repositorioEmpleado.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Integer id) {
        return repositorioEmpleado.findById(id).orElse(null);
    }

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return repositorioEmpleado.save(empleado);
    }


    @Override
    public void eliminarEmpleado(Integer id) {
        if (id != null){
            System.out.println("Usuario con ID: "+id+" Eliminado");
            repositorioEmpleado.deleteById(id);
        }else {
            System.out.println("Id no encontrado");
        }
    }
}
