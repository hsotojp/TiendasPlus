package com.tiendasplus.TiendasPlus.Controladores;

import com.tiendasplus.TiendasPlus.Entidades.Producto;
import com.tiendasplus.TiendasPlus.Repositorios.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    IProductoRepository iproducto;

    @GetMapping("/all")
    public List<Producto> getProductos(){
        return (List<Producto>) iproducto.findAll();

    }

    @PostMapping("/add")
    public String addProducto(@RequestBody Producto producto){
        iproducto.save(producto);

        return "Guardado correctamente";
    }

    @GetMapping("/{id}")
    public Producto getProductoId(@PathVariable int id){

        return  iproducto.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));
    }

    @DeleteMapping("/{id}")
    public String deleteProductoId(@PathVariable int id){

        //Producto t = producto.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));

        iproducto.deleteById(id);

        return "Eliminado";

    }

    @PostMapping("/{id}")
    public Producto updateProducto(@PathVariable int id, @RequestBody Producto newTienda){
        Producto t = iproducto.findById(id).orElseThrow(()-> new IllegalArgumentException( "No se encontraron registros."));

        t.setNombre(newTienda.getNombre());
        t.setDescripcion(newTienda.getDescripcion());
        t.setPrecio(newTienda.getPrecio());

        iproducto.save(t);

        return t;

    }
}
