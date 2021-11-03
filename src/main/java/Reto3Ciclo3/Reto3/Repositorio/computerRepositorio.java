package Reto3Ciclo3.Reto3.Repositorio;

import Reto3Ciclo3.Reto3.Interface.computerInterface;
import Reto3Ciclo3.Reto3.Modelo.computer;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jennc
 */
@Repository
public class computerRepositorio {
    
    @Autowired
    private computerInterface crud;
    
    public List<computer> getAll() {
        return (List<computer>) crud.findAll();
    }
    
    public Optional<computer> getComputer(int id) {
        return crud.findById(id);    
    }
    
    public computer save(computer computer) {
        return crud.save(computer);
    } 
    
    public void delete(computer computer) {
        crud.delete(computer);
    }
    
}
