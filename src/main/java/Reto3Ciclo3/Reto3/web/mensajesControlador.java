package Reto3Ciclo3.Reto3.web;

import Reto3Ciclo3.Reto3.Modelo.mensajes;
import Reto3Ciclo3.Reto3.servicios.mensajesServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jennc
 */
@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class mensajesControlador {
    @Autowired  
    private mensajesServicio servicio;
    
    @GetMapping("/all")
    public List<mensajes> getMensajes(){
        return servicio.getAll();
    }
     @GetMapping("{id}")
    public Optional<mensajes> getMensaje(@PathVariable("id") int mensajesId){
        return servicio.getMensaje(mensajesId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)    
    public mensajes save(@RequestBody mensajes Message){
        return servicio.save(Message);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public mensajes update(@RequestBody mensajes Message) {
        return servicio.update(Message);       
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int mensajesId){
        return servicio.deleteMensajes(mensajesId);
    }
    
}
