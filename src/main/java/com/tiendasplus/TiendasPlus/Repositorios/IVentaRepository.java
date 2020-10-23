package com.tiendasplus.TiendasPlus.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tiendasplus.TiendasPlus.Entidades.Venta;

@Repository
public interface IVentaRepository extends CrudRepository<Venta, Integer>{

}
