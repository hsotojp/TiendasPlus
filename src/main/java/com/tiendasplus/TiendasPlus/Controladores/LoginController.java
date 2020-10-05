package com.tiendasplus.TiendasPlus.Controladores;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.tiendasplus.TiendasPlus.Entidades.Empleado;
import com.tiendasplus.TiendasPlus.Repositorios.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;

@RestController
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    IEmpleadoRepository empleado;

    @PostMapping("/login")
    public String validateCredentials(@RequestBody Empleado credenciales) throws UnirestException {
        System.out.println("Hola desde el metodo validateCredentials"+credenciales.getUsuario()+" - "+credenciales.getContrasenia());
        Empleado emp = empleado.findByUsuarioAndContrasenia(credenciales.getUsuario(), credenciales.getContrasenia());
        HttpResponse<String> response = null;
        String token = "ERROR";
        if(emp != null) {
            System.out.println(emp.getNombre());


            response = Unirest.post("https://dev-h5l34moo.us.auth0.com/oauth/token")
                    .header("content-type", "application/json")
                    .body("{\"client_id\":\"av6l8thofTKPsInT2gcMyeoephjcmYxg\",\"client_secret\":\"xFAe1FF9uSqpInMa2wqFI2wzVlDcYyC5bc-5eEiD-7dTamHH13m_04GQJWJgFK01\",\"audience\":\"https://tiendasplus/api\",\"grant_type\":\"client_credentials\"}")
                    .asString();
            String[] split = response.getBody().split(":");
            split= split[1].split("\"");
            token = split[1];
        }

        return token;
    }




}
