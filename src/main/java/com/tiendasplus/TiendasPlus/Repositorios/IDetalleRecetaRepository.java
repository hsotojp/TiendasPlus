package com.tiendasplus.TiendasPlus.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tiendasplus.TiendasPlus.Entidades.DetalleReceta;

@Repository
public interface IDetalleRecetaRepository extends CrudRepository<DetalleReceta, Integer>{

}
