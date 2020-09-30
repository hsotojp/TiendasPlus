package com.tiendasplus.TiendasPlus.Repositorios;

import com.tiendasplus.TiendasPlus.Entidades.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITiendaRepository extends CrudRepository<Empleado, Integer> {

}
