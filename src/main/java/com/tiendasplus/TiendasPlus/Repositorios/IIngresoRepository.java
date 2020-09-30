package com.tiendasplus.TiendasPlus.Repositorios;

import com.tiendasplus.TiendasPlus.Entidades.Ingreso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIngresoRepository extends CrudRepository<Ingreso, Integer> {

}
