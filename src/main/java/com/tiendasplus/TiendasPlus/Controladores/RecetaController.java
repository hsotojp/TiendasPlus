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
import com.tiendasplus.TiendasPlus.Entidades.Receta;
import com.tiendasplus.TiendasPlus.Repositorios.IRecetaRepository;

@RestController
@RequestMapping("/receta")
public class RecetaController {
	@Autowired
	IRecetaRepository ireceta;
	
	@GetMapping("/all")
	public List<Receta> getReceta(){
		return (List<Receta>) ireceta.findAll();
	}
	
	@PostMapping("/add")
	public String addReceta(@RequestBody Receta receta) {
		ireceta.save(receta);
		return "Guardado correctamente";
	}
	
	@GetMapping("/{id}")
	public Receta getRecetaId(@PathVariable int id) {
		return ireceta.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontraron registros."));
	}
	
	@DeleteMapping("/{id}")
	public String deleteRecetaId(@PathVariable int id) {
		ireceta.deleteById(id);
		return "Eliminado";
	}
	
	@PostMapping("/{id}")
	public Receta updateReceta(@PathVariable int id, @RequestBody Receta newReceta) {
		Receta r = ireceta.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontraron registros."));
		
		r.setNombre(newReceta.getNombre());
		r.setDescripcion(newReceta.getDescripcion());
		r.setPrecio(newReceta.getPrecio());
		
		ireceta.save(r);
		return r;
	}
}
