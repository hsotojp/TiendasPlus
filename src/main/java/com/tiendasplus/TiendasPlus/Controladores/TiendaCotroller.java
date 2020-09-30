package com.tiendasplus.TiendasPlus.Controladores;

import com.tiendasplus.TiendasPlus.Entidades.Tienda;
import com.tiendasplus.TiendasPlus.Repositorios.ITiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(path = "tienda", produces = MediaType.APPLICATION_JSON_VALUE)
public class TiendaCotroller {
    @Autowired
    ITiendaRepository tienda;

    @GetMapping("/all")
    public List<Tienda> getTiendas(){
        return (List<Tienda>) tienda.findAll();

    }

    @PostMapping("/add")
    public String addTienda(@RequestBody Tienda newTienda){
        tienda.save(newTienda);

        return "Guardado correctamente";
    }

    @GetMapping("/{id}")
    public Tienda getTiendById(@PathVariable int id){

        return  tienda.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));
    }

    @DeleteMapping("/{id}")
    public String deleteTiendaId(@PathVariable int id){

        //Tienda t = tienda.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));

        tienda.deleteById(id);

        return "Eliminado";

    }

    @PostMapping("/{id}")
    public Tienda updateTienda(@PathVariable int id, @RequestBody Tienda newTienda){
        Tienda t = tienda.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));

        t.setNombre(newTienda.getNombre());
        t.setDireccion(newTienda.getDireccion());
        t.setTelefono(newTienda.getTelefono());

        tienda.save(t);

        return t;

    }

}
