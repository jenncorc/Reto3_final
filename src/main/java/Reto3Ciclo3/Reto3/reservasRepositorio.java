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
public class reservasRepositorio {
    @Autowired
    private reservasInterface crud4;
    
    public List<reservas> getAll() {
        return (List<reservas>) crud4.findAll();
    }
    
    public Optional<reservas> getReservas(int id) {
        return crud4.findById(id);    
    }
    
    public reservas save(reservas reservas) {
        return crud4.save(reservas);
    } 
    
    public void delete(reservas reservas) {
        crud4.delete(reservas);
    }
    
}
