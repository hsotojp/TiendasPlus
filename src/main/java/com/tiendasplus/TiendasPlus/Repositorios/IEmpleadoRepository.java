package com.tiendasplus.TiendasPlus.Repositorios;

import com.tiendasplus.TiendasPlus.Entidades.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends CrudRepository<Empleado, Integer> {

    Empleado findByUsuarioAndContrasenia(String user, String pass);
}
