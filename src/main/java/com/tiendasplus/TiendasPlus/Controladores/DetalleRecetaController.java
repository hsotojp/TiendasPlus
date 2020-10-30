package com.tiendasplus.TiendasPlus.Controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tiendasplus.TiendasPlus.Entidades.DetalleReceta;
import com.tiendasplus.TiendasPlus.Repositorios.IDetalleRecetaRepository;

@RestController
@RequestMapping("/detalle-receta")
public class DetalleRecetaController {
	@Autowired
	IDetalleRecetaRepository idetalle;
	
	@GetMapping("/all")
	public List<DetalleReceta> getDReceta(){
		return (List<DetalleReceta>) idetalle.findAll();
	}
	
	@PostMapping("/add")
	public String addDReceta(@RequestBody DetalleReceta dreceta) {
		idetalle.save(dreceta);
		return "Guardado correctamente";
	}
	
	@GetMapping("/{id}")
	public DetalleReceta getDRecetaId(@PathVariable int id) {
		return idetalle.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontraron registros."));
	}
	
	@DeleteMapping("/{id}")
	public String deleteDetalle(@PathVariable int id) {
		idetalle.deleteById(id);
		return "Eliminado";
	}
	
	@PostMapping("/{id}")
	public DetalleReceta updateDReceta(@PathVariable int id, @RequestBody DetalleReceta newdReceta) {
		DetalleReceta dt = idetalle.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontraron registros."));
		
		dt.setIdreceta(dt.getIdreceta());
		dt.setIdproducto(dt.getIdproducto());
		dt.setCantidad(newdReceta.getCantidad());
		
		idetalle.save(dt);
		return dt;
	}
}
