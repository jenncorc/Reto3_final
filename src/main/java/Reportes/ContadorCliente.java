package Reportes;

import Reto3Ciclo3.Reto3.cliente;

/**
 *
 * @author jennc
 */
public class ContadorCliente {    
    
    
    private Long total;
    private cliente client;

    public ContadorCliente(Long total, cliente client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public cliente getClient() {
        return client;
    }

    public void setClient(cliente client) {
        this.client = client;
    } 
    
    
}

    

