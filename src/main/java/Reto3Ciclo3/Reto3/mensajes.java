package Reto3Ciclo3.Reto3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
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
@Table(name = "message")
public class mensajes implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;
    
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnoreProperties({"messages","client","reservations"})
    private computer computer;
    
    @ManyToOne  
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages","reservations","client"})
    private cliente client;

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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
    
    
    
    
}
