package com.tiendasplus.TiendasPlus.Repositorios;

import com.tiendasplus.TiendasPlus.Entidades.Inventario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInventarioRepository extends CrudRepository<Inventario, Integer> {
}
