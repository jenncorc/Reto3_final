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
public class categoriasRepositorio {
    @Autowired
    private categoriasInterface crud;
    
    public List<categorias> getAll() {
        return (List<categorias>) crud.findAll();
    }
    
    public Optional<categorias> getCategorias(int id) {
        return crud.findById(id);    
    }
    
    public categorias save(categorias categorias) {
        return crud.save(categorias);
    } 
    
    public void delete(categorias categorias) {
        crud.delete(categorias);
    }
}
