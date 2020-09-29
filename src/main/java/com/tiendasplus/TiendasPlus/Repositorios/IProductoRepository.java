package com.tiendasplus.TiendasPlus.Repositorios;

import com.tiendasplus.TiendasPlus.Entidades.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends CrudRepository<Producto, Integer> {
}
