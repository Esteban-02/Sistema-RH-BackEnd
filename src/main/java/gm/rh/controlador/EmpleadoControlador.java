package gm.rh.controlador;


import gm.rh.excepcion.RecursoNoEncontradoExcepcion;
import gm.rh.modelo.Empleado;
import gm.rh.servicio.EmpleadoServicio;
import gm.rh.servicio.IEmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rh-app")
//URL base de la aplicacio =>http://localhost:8080/rh-app
@CrossOrigin(value = "http://localhost:3000")   // URL para hacer conectar el Backend con el FrontEnd a traves del puerto 3000 para hacer las peticiones

public class EmpleadoControlador {
    private final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private IEmpleadoServicio empleadoServicio;

    //http://localhost:8081/rh-app/empleados
    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados(){
        var empleado = empleadoServicio.listarEmpleados();
        empleado.forEach((empleado1 -> logger.info(empleado1.toString())));
        return empleado;
    }

    @PostMapping("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        logger.info("El empleado a guardar: \n"+ empleado);
        return empleadoServicio.guardarEmpleado(empleado);
    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> obtenerEmpleadoPorId (@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        if (empleado == null){
            throw new RecursoNoEncontradoExcepcion("No se encontro el id: " + id);
        }
        return ResponseEntity.ok(empleado);
    }

    //Actualizar empleado
    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleadoRecibido){

        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        if (empleado == null){
            throw new RecursoNoEncontradoExcepcion("El id no existe: "+id);
        }
        empleado.setNombre(empleadoRecibido.getNombre());
        empleado.setDepartamento(empleado.getDepartamento());
        empleado.setSueldo(empleadoRecibido.getSueldo());
        empleadoServicio.guardarEmpleado(empleado);

        return ResponseEntity.ok(empleado);
    }

    //Eliminar empleado
    @DeleteMapping("/empleados/{id} ")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpleado (@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        if (empleado == null){
            throw new RecursoNoEncontradoExcepcion("El id recibido no existe: "+id);
        }
        empleadoServicio.eliminarEmpleado(id);
        //Json {"eliminado": true}
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("Eliminado", Boolean.TRUE);
        return  ResponseEntity.ok(respuesta);
    }


}
