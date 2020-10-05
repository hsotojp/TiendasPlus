package com.tiendasplus.TiendasPlus.Controladores;

import com.tiendasplus.TiendasPlus.Entidades.Ingreso;
import com.tiendasplus.TiendasPlus.Repositorios.IIngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/ingreso")
public class IngresoCotroller {
    @Autowired
    IIngresoRepository ingreso;

    @GetMapping("/all")
    public List<Ingreso> getIngresos(){
        return (List<Ingreso>) ingreso.findAll();

    }

    @PostMapping("/add")
    public String addIngreso(@RequestBody Ingreso newIngreso){
        newIngreso.setFecha(new Date() );
        ingreso.save(newIngreso);
       
        return "Guardado correctamente";
    }

    @GetMapping("/{id}")
    public Ingreso getIngresoById(@PathVariable int id){

        return  ingreso.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));
    }

    @DeleteMapping("/{id}")
    public String deleteIngresoId(@PathVariable int id){

        ingreso.deleteById(id);

        return "Eliminado";

    }

    @PostMapping("/{id}")
    public Ingreso updateIngreso(@PathVariable int id, @RequestBody Ingreso newIngreso){
        Ingreso t = ingreso.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));

        t.setFecha(newIngreso.getFecha());
        t.setCantidad(newIngreso.getCantidad());
        t.setIdproducto(newIngreso.getIdproducto());
        t.setIdempleado(newIngreso.getIdempleado());

        ingreso.save(t);

        return t;

    }

}
