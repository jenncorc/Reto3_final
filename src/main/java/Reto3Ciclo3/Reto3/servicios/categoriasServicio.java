package Reto3Ciclo3.Reto3.servicios;

import Reto3Ciclo3.Reto3.Modelo.categorias;
import Reto3Ciclo3.Reto3.Repositorio.categoriasRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jennc
 */
@Service
public class categoriasServicio {
    @Autowired
    private categoriasRepositorio metodosCrud;
    
    public List <categorias> getAll() {
        return metodosCrud.getAll();
    }
    public Optional<categorias> getCategorias(int categoriasId){
        return metodosCrud.getCategorias(categoriasId);
    }
    public categorias save(categorias categorias){
        if (categorias.getId() == null) {
            return metodosCrud.save(categorias);            
        }else{
            Optional<categorias> categorias1 =metodosCrud.getCategorias(categorias.getId());
            if (categorias1.isEmpty()) {
                return metodosCrud.save(categorias);                
            }else   {
                return categorias;
            }
        }
    }
    public categorias update(categorias categorias){
        if (categorias.getId() != null) {
            Optional<categorias> g= metodosCrud.getCategorias( categorias.getId());
            if (! g.isEmpty()) {
                if (categorias.getDescription() != null ) {
                    g.get().setDescription(categorias.getDescription());                   
                }
                if (categorias.getName() != null) {
                    g.get().setName(categorias.getName());                    
                }
                return metodosCrud.save(g.get());                
            }
            
        }
        return categorias;
    }
    public boolean deleteCategorias(int categoriasId){
        Boolean d= getCategorias(categoriasId).map(categorias -> {
            metodosCrud.delete(categorias);
            return true;
        } ).orElse(false);
        return d;        
    }  
            
    
}
