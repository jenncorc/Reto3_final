package Reto3Ciclo3.Reto3.Repositorio;

import Reto3Ciclo3.Reto3.Interface.reservasInterface;
import Reto3Ciclo3.Reto3.Reportes.ContadorCliente;
import Reto3Ciclo3.Reto3.Modelo.cliente;
import Reto3Ciclo3.Reto3.Modelo.reservas;
import java.util.ArrayList;
import java.util.Date;
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
    
    public List<reservas> ReservacionStatusRepositorio (String status){
         return crud4.findAllByStatus(status);
     }
     
     public List<reservas> ReservacionTiempoRepositorio (Date a, Date b){
         return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
     
     }
     
     public List<ContadorCliente> getClientesRepositorio(){
         List<ContadorCliente> res = new ArrayList<>();
         List<Object[]> report = crud4.countTotalReservationsByclient();
         for(int i=0; i<report.size(); i++){
             res.add(new ContadorCliente((Long)report.get(i)[1],(cliente) report.get(i)[0]));
         }
         return res;
     }
    
}
