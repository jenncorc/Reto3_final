package Reto3Ciclo3.Reto3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jennc
 */
@Service
public class clienteServicio {
    @Autowired
    private clienteRepositorio metodosCrud;
    
    public List<cliente> getAll() {
        return metodosCrud.getAll();        
    }
    public Optional<cliente> getCliente(int  clienteId){
        return metodosCrud.getCliente(clienteId);    
    }
    public cliente save(cliente cliente){
        if (cliente.getIdClient() == null) {
            return metodosCrud.save(cliente);            
        }else{
            Optional<cliente> e= metodosCrud.getCliente(cliente.getIdClient());
            if (e.isEmpty()) {
                return metodosCrud.save(cliente);                
            }else{
                return cliente;                
            }
        }
    }
    public cliente update(cliente cliente){
        if (cliente.getIdClient() != null) {
            Optional<cliente> e= metodosCrud.getCliente(cliente.getIdClient());
            if ( !e.isEmpty()) {
                if (cliente.getName() != null) {
                    e.get().setName(cliente.getName());                    
                }
                if (cliente.getAge() != null) {
                    e.get().setAge(cliente.getAge());                    
                }
                if (cliente.getPassword() != null) {
                    e.get().setPassword(cliente.getPassword());                    
                }
                metodosCrud.save(e.get());
                return e.get();                
            }else{
                return cliente;
            }
            
        }else{
            return cliente;
        }
    }
    public boolean deleteCliente(int clienteId){
        Boolean aBoolean=getCliente(clienteId).map(cliente -> {
            metodosCrud.delete(cliente);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
