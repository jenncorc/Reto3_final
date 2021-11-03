package Reto3Ciclo3.Reto3.servicios;

import Reto3Ciclo3.Reto3.Repositorio.reservasRepositorio;
import Reto3Ciclo3.Reto3.Reportes.ContadorCliente;
import Reto3Ciclo3.Reto3.Reportes.StatusReservas;
import Reto3Ciclo3.Reto3.Modelo.reservas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jennc
 */
@Service
public class reservasServicio {
    @Autowired
    private reservasRepositorio metodosCrud;
    
    public List<reservas> getAll(){
        return metodosCrud.getAll();
    }
    public Optional<reservas> getReservas(int reservasId){
        return metodosCrud.getReservas(reservasId);
    }
    public reservas save(reservas reservation){
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);            
        }else{
            Optional<reservas> e= metodosCrud.getReservas(reservation.getIdReservation());
            if (e.isEmpty()) {
                return metodosCrud.save(reservation);                
            }else{
                return reservation;
            }
        }
    }
    public reservas update(reservas reservation){
        if (reservation.getIdReservation() != null) {
            Optional<reservas> e= metodosCrud.getReservas(reservation.getIdReservation());
            if (!e.isEmpty()) {
                if (reservation.getStartDate() != null) {
                    e.get().setStartDate(reservation.getStartDate());                    
                }
                if (reservation.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(reservation.getDevolutionDate());                   
                }
                if (reservation.getStatus() != null) {
                    e.get().setStatus(reservation.getStatus());                    
                }
                metodosCrud.save(e.get());
                return e.get();
                
            }else{
                return reservation;
            }
            
        }else{
            return reservation;
        }
        
    }
    
    public boolean deleteReservas(int reservasId){
        Boolean eBoolean = getReservas(reservasId).map(reservas -> {
            metodosCrud.delete(reservas);
            return true;
        }).orElse(false);
        return eBoolean;
    }
    
    public StatusReservas reporteStatusServicio (){
        List<reservas>completed= metodosCrud.ReservacionStatusRepositorio("completed");
        List<reservas>cancelled= metodosCrud.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size() );
    }
    
    public List<reservas> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    } 
     public List<ContadorCliente> reporteClientesServicio(){
            return metodosCrud.getClientesRepositorio();
        } 
    
}
