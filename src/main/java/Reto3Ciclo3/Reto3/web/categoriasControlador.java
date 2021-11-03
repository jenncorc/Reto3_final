package Reto3Ciclo3.Reto3.web;

import Reto3Ciclo3.Reto3.Modelo.categorias;
import Reto3Ciclo3.Reto3.servicios.categoriasServicio;
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
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class categoriasControlador {
    @Autowired  
    private categoriasServicio servicio;
    
    @GetMapping("/all")
    public List<categorias> getCategorias(){
        return servicio.getAll();
    }
    @GetMapping("{id}")
    public Optional<categorias> getCategoria(@PathVariable("id") int categoriasId){
        return servicio.getCategorias(categoriasId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)    
    public categorias save(@RequestBody categorias Category){
        return servicio.save(Category);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public categorias update(@RequestBody categorias Category) {
        return servicio.update(Category);       
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriasId){
        return servicio.deleteCategorias(categoriasId);
    }        
    
}
