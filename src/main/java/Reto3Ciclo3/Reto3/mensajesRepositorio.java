package Reto3Ciclo3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jennc
 */
@Repository
public class mensajesRepositorio {
    @Autowired
    private mensajesInterface crud3;
    
    public List<mensajes> getAll() {
        return (List<mensajes>) crud3.findAll();
    }
    
    public Optional<mensajes> getMensajes(int id) {
        return crud3.findById(id);    
    }
    
    public mensajes save(mensajes mensajes) {
        return crud3.save(mensajes);
    } 
    
    public void delete(mensajes mensajes) {
        crud3.delete(mensajes);
    }
    
}
