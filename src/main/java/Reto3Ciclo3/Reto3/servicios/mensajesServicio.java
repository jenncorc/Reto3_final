package Reto3Ciclo3.Reto3.servicios;

import Reto3Ciclo3.Reto3.Modelo.mensajes;
import Reto3Ciclo3.Reto3.Repositorio.mensajesRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jennc
 */
@Service
public class mensajesServicio {
    @Autowired
    private mensajesRepositorio metodosCrud;
    
    public List<mensajes> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<mensajes> getMensaje(int messageId){
        return metodosCrud.getMensajes(messageId);
    }
    public mensajes save(mensajes mensaje){
        if (mensaje.getIdMessage() == null) {
            return metodosCrud.save(mensaje);            
        }else{
            Optional<mensajes> e= metodosCrud.getMensajes(mensaje.getIdMessage());
            if (e.isEmpty()) {
                return metodosCrud.save(mensaje);                
            }else{
                return mensaje;                
            }
        }
    }
    public mensajes update(mensajes mensaje){
        if (mensaje.getIdMessage() != null) {
            Optional<mensajes> e= metodosCrud.getMensajes(mensaje.getIdMessage());
            if (!e.isEmpty()) {
                if (mensaje.getMessageText() != null) {
                    e.get().setMessageText(mensaje.getMessageText());                    
                }
                metodosCrud.save(e.get());
                return e.get();               
            }else{
                return mensaje;
            }            
        }else{
            return mensaje;
        }
    }
    public boolean deleteMensajes( int messageId){
        Boolean eBoolean = getMensaje(messageId).map(mensajes -> {
            metodosCrud.delete(mensajes);
            return true;                   
        }).orElse(false);
        return eBoolean;
    }
    
}
