package com.tiendasplus.TiendasPlus.Controladores;

import com.tiendasplus.TiendasPlus.Entidades.Empleado;
import com.tiendasplus.TiendasPlus.Entidades.Inventario;
import com.tiendasplus.TiendasPlus.Repositorios.IInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inventario")
public class InventarioController {
    @Autowired
    IInventarioRepository iiventario;


    @GetMapping("/all")
    public List<Inventario> getInventarios(){
        return (List<Inventario>) iiventario.findAll();

    }

    @PostMapping("/add")
    public String addInventario(@RequestBody Inventario inventario){
        iiventario.save(inventario);

        return "Guardado correctamente";
    }

    @GetMapping("/{id}")
    public Inventario getInventarioId(@PathVariable int id){

        return  iiventario.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));
    }

    @DeleteMapping("/{id}")
    public String deleteInventarioId(@PathVariable int id){
        iiventario.deleteById(id);

        return "Eliminado";

    }

    @PostMapping("/{id}")
    public Inventario updateInventario(@PathVariable int id, @RequestBody Inventario inventario){
        Inventario t = iiventario.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));

        t.setCantidad(inventario.getCantidad());
        t.setIdproducto(t.getIdproducto());
        t.setIdtienda(t.getIdtienda());
        iiventario.save(t);

        return t;

    }

}
