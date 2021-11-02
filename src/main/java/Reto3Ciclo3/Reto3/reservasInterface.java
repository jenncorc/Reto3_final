/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reto3Ciclo3.Reto3;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author jennc
 */
public interface reservasInterface extends CrudRepository<reservas, Integer>{
    
    public List<reservas> findAllByStatus (String status); 
    
    public List<reservas> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
    // SELECT clientid, COUNT(*) AS total FROM reservacion group by clientid order by desc;
    @Query ("SELECT c.client, COUNT(c.client) from reservas AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByclient();
    
}
