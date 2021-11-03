package Reto3Ciclo3.Reto3.servicios;

import Reto3Ciclo3.Reto3.Modelo.computer;
import Reto3Ciclo3.Reto3.Repositorio.computerRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jennc
 */
@Service
public class computerServicio {
    @Autowired
    private computerRepositorio metodosCrud;

    public List<computer> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<computer> getComputer(int computerId) {
        return metodosCrud.getComputer(computerId);
    }
    
     public computer save(computer computer){
        if(computer.getId()==null){
            return metodosCrud.save(computer);
        }else{
            Optional<computer> e=metodosCrud.getComputer(computer.getId());
            if (e.isEmpty()) {
                return metodosCrud.save(computer);                
            }else{
                return computer;
            }
               
            }
                
            }
     public computer  update(computer computer) {
         if (computer.getId() !=null) {
             Optional<computer> e=metodosCrud.getComputer(computer.getId());
             if (e.isEmpty()) {
                 if (computer.getName() !=null) {
                     e.get().setName(computer.getName());                     
                 }
                 if (computer.getBrand() !=null) {
                     e.get().setBrand(computer.getBrand());                     
                 }
                 if (computer.getYear() !=null) {
                     e.get().setYear(computer.getYear());                     
                 }
                 if (computer.getDescription() !=null) {
                     e.get().setDescription(computer.getDescription());                    
                 }
                 if (computer.getCategory() !=null) {
                     e.get().setCategory(computer.getCategory());                    
                 }
                 metodosCrud.save(e.get());
                 return e.get();                 
             }else{
                 return computer;
             }
             
         }else{
             return computer;
         }
     }
     
     public boolean deleteComputer(int computerId) {
         Boolean aBoolean = getComputer(computerId).map(computer -> {
             metodosCrud.delete(computer);
             return true;             
         }).orElse(false);
         return aBoolean;
     }
    
}
