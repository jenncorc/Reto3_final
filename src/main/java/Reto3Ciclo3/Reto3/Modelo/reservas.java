package Reto3Ciclo3.Reto3.Modelo;

import Reto3Ciclo3.Reto3.Modelo.computer;
import Reto3Ciclo3.Reto3.Modelo.cliente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author jennc
 */
@Entity
@Table(name = "reservation")
public class reservas implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status="created";
    
    @ManyToOne
    @JoinColumn(name =  "id")
    @JsonIgnoreProperties("reservations")
    private computer computer;
    
     @ManyToOne
    @JoinColumn(name =  "idClient")
    @JsonIgnoreProperties({"reservations", "messages"})
    private cliente client;
     
     private String score;

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public computer getComputer() {
        return computer;
    }

    public void setComputer(computer computer) {
        this.computer = computer;
    }

    public cliente getClient() {
        return client;
    }

    public void setClient(cliente client) {
        this.client = client;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
     
        
    
    
    
}
