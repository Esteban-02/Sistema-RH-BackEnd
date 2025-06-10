package gm.rh.repositorio;

import gm.rh.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioEmpleado extends JpaRepository<Empleado, Integer> {
}
