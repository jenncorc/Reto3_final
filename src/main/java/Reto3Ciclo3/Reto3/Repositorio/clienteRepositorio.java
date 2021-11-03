package Reto3Ciclo3.Reto3.Repositorio;

import Reto3Ciclo3.Reto3.Interface.clienteInterface;
import Reto3Ciclo3.Reto3.Modelo.cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jennc
 */
@Repository
public class clienteRepositorio {
    @Autowired
    private clienteInterface crud1;
    
    public List<cliente> getAll() {
        return (List<cliente>) crud1.findAll();
    }
    
    public Optional<cliente> getCliente(int id) {
        return crud1.findById(id);    
    }
    
    public cliente  save(cliente cliente) {
        return crud1.save(cliente);
    } 
    
    public void delete(cliente cliente) {
        crud1.delete(cliente);
    }
    
}
