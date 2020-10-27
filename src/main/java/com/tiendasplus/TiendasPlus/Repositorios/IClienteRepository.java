package com.tiendasplus.TiendasPlus.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tiendasplus.TiendasPlus.Entidades.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Integer>{

}
