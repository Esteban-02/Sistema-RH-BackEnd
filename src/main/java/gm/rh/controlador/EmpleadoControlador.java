package gm.rh.controlador;

import gm.rh.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rh-app")
//URL base de la aplicacio =>http://localhost:8080/rh-app
@CrossOrigin(value = "http://localhost:3000")   // URL para hacer conectar el Backend con el FrontEnd a traves del puerto 3000 para hacer las peticiones

public class EmpleadoControlador {
    private final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private IEmpleadoServicio usuarioServicio;

}
