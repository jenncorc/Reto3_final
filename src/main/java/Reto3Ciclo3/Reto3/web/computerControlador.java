package Reto3Ciclo3.Reto3.web;

import Reto3Ciclo3.Reto3.Modelo.computer;
import Reto3Ciclo3.Reto3.servicios.computerServicio;
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
@RequestMapping("/api/Computer")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class computerControlador {
    @Autowired
    private computerServicio servicio;
    
    @GetMapping("/all")
    public List<computer> getComputers(){
        return servicio.getAll();        
    }
    @GetMapping("/{id}")
    public Optional<computer> getComputer(@PathVariable("id") int computerId){
        return servicio.getComputer(computerId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public computer save(@RequestBody computer Computer){
        return servicio.save(Computer);        
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public computer update(@RequestBody computer Computer){
        return servicio.update(Computer);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int computerId){
        return servicio.deleteComputer(computerId);
    }
    
    
}
