package Reto3Ciclo3.Reto3;

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
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class clienteControlador {
    @Autowired
    private clienteServicio servicio;
    
     @GetMapping("/all")
    public List<cliente> getClientes(){
        return servicio.getAll();        
    }    
    @GetMapping("/{id}")
    public Optional<cliente> getCliente(@PathVariable("id") int clienteId){
        return servicio.getCliente(clienteId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public cliente save(@RequestBody cliente Client){
        return servicio.save(Client);        
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public cliente update(@RequestBody cliente Client){
        return servicio.update(Client);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clienteId){
        return servicio.deleteCliente(clienteId);
    }
    
    
}
