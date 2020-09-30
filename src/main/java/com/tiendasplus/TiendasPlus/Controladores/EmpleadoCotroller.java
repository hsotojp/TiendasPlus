package com.tiendasplus.TiendasPlus.Controladores;

import com.tiendasplus.TiendasPlus.Entidades.Empleado;
import com.tiendasplus.TiendasPlus.Repositorios.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoCotroller {
    @Autowired
    IEmpleadoRepository empleado;

    @GetMapping("/all")
    public List<Empleado> getEmpleados(){
        return (List<Empleado>) empleado.findAll();

    }

    @PostMapping("/add")
    public String addEmpleado(@RequestBody Empleado newEmpleado){
        empleado.save(newEmpleado);

        return "Guardado correctamente";
    }

    @GetMapping("/{id}")
    public Empleado getEmpleadoById(@PathVariable int id){

        return  empleado.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));
    }

    @DeleteMapping("/{id}")
    public String deleteEmpleadoId(@PathVariable int id){

        //Tienda t = empleado.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));

        empleado.deleteById(id);

        return "Eliminado";

    }

    @PostMapping("/{id}")
    public Empleado updateEmpleado(@PathVariable int id, @RequestBody Empleado newEmpleado){
        Empleado t = empleado.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));

        t.setNombre(newTienda.getNombre());
		t.setApellido(newTienda.getApellido());
		t.setUsuario(newTienda.getUsuario());
        t.setContrasenia(newTienda.getContrasenia());


        empleado.save(t);

        return t;

    }

}
