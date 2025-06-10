package gm.rh.repositorio;

import gm.rh.modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuarios extends JpaRepository<Usuarios, Integer> {
}
