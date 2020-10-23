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

import com.tiendasplus.TiendasPlus.Entidades.Cliente;
import com.tiendasplus.TiendasPlus.Repositorios.IClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
	IClienteRepository icliente;
	
	@GetMapping("/all")
	public List<Cliente> getCliente(){
		return (List<Cliente>) icliente.findAll();
	}
	
	@PostMapping("/add")
	public String addCliente(@RequestBody Cliente cliente) {
		icliente.save(cliente);
		
		return "Guardado correctamente";
	}
	
	@GetMapping("/{id}")
	public Cliente getClienteId(@PathVariable int id) {
		return icliente.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontraron registros."));
	}
	
	@DeleteMapping("/{id}")
	public String deleteClienteId(@PathVariable int id) {
		icliente.deleteById(id);
		return "Eliminado";
	}
	
	@PostMapping("/{id}")
	public Cliente updateCliente(@PathVariable int id, @RequestBody Cliente newCliente) {
		Cliente c = icliente.findById(id).orElseThrow(()-> new IllegalArgumentException("No se encontraron registros."));
		
		c.setNit(newCliente.getNit());
		c.setNombre(newCliente.getNombre());
		
		icliente.save(c);
		return c;
	}

}
