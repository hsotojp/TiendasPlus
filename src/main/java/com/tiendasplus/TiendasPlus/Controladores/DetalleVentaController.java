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
import com.tiendasplus.TiendasPlus.Entidades.DetalleVenta;
import com.tiendasplus.TiendasPlus.Repositorios.IDetalleVentaRepository;

@RestController
@RequestMapping("/detalle-venta")
public class DetalleVentaController {
	@Autowired
	IDetalleVentaRepository idVenta;
	
	@GetMapping("/all")
	public List<DetalleVenta> getdVenta(){
		return (List<DetalleVenta>) idVenta.findAll();
	}

	@PostMapping("/add")
	public String addDVenta(@RequestBody DetalleVenta dventa) {
		idVenta.save(dventa);
		return "Guardado correctamente";
	}
	
	@GetMapping("/{id}")
	public DetalleVenta getDVentaId(@PathVariable int id) {
		return idVenta.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontraron registros."));
	}
	
	@DeleteMapping("/{id}")
	public String deleteDVentaId(@PathVariable int id) {
		idVenta.deleteById(id);
		return "Eliminado";
	}
	
	@PostMapping("/{id}")
	public DetalleVenta updateDVenta(@PathVariable int id, @RequestBody DetalleVenta newdVenta) {
		DetalleVenta dv = idVenta.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontraron registros."));
		
		dv.setIdventa(newdVenta.getIdventa());
		dv.setPosicion(newdVenta.getPosicion());
		dv.setCantidad(newdVenta.getCantidad());
		dv.setIdproducto(newdVenta.getIdproducto());
		dv.setIdreceta(newdVenta.getIdreceta());
		dv.setTotal(newdVenta.getTotal());
		
		idVenta.save(dv);
		return dv;
	}
}
