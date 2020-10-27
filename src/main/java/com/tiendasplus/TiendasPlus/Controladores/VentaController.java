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
import com.tiendasplus.TiendasPlus.Entidades.Venta;
import com.tiendasplus.TiendasPlus.Repositorios.IVentaRepository;

@RestController
@RequestMapping("/venta")
public class VentaController {
	@Autowired
	IVentaRepository iventa;
	
	@GetMapping("/all")
	public List<Venta> getVenta(){
		return (List<Venta>) iventa.findAll();
	}
	
	@PostMapping("/add")
	public String addVenta(@RequestBody Venta venta) {
		iventa.save(venta);
		return "Guardado correctamente";
	}
	
	@GetMapping("/{id}")
	public Venta getVentaId(@PathVariable int id) {
		return iventa.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontraron registros."));
	}
	
	@DeleteMapping("/{id}")
	public String deleteVenta(@PathVariable int id) {
		iventa.deleteById(id);
		return "Eliminado";
	}
	
	@PostMapping("/{id}")
	public Venta updateVenta(@PathVariable int id, @RequestBody Venta newVenta) {
		Venta v = iventa.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontraron registros."));
		
		v.setFecha(newVenta.getFecha());
		v.setTotal(newVenta.getTotal());
		v.setIdcliente(newVenta.getIdcliente());
		v.setIdtienda(newVenta.getIdtienda());
		
		iventa.save(v);
		return v;
	}
}
