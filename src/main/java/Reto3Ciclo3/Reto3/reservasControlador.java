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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class reservasControlador {
    @Autowired  
    private reservasServicio servicio;
    
    @GetMapping("/all")
    public List<reservas> getReservas(){
        return servicio.getAll();
    }
     @GetMapping("{id}")
    public Optional<reservas> getReserva(@PathVariable("id") int reservasId){
        return servicio.getReservas(reservasId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)    
    public reservas save(@RequestBody reservas Reservation){
        return servicio.save(Reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public reservas update(@RequestBody reservas Reservation) {
        return servicio.update(Reservation);       
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservasId){
        return servicio.deleteReservas(reservasId);
    }
    
}
