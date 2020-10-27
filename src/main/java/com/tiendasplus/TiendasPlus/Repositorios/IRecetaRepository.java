package com.tiendasplus.TiendasPlus.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendasplus.TiendasPlus.Entidades.Receta;

@Repository
public interface IRecetaRepository extends CrudRepository<Receta, Integer>{

}
