package gm.rh;

import gm.rh.modelo.Empleado;
import gm.rh.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RhApplication {

	@Autowired
	EmpleadoServicio empleadoServicio;

	public static void main(String[] args) {
		SpringApplication.run(RhApplication.class, args);

	}

}
