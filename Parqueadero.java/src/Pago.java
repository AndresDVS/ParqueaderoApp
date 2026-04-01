import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pago {
    private int id;
    private int idVehiculo;
    private int idUsuario;
    private double monto;
    private String fecha;
    private String concepto;
    private String estado;
    
    public Pago(int id, int idVehiculo, int idUsuario, double monto, String concepto) {
        this.id = id;
        this.idVehiculo = idVehiculo;
        this.idUsuario = idUsuario;
        this.monto = monto;
        this.concepto = concepto;
        this.fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.estado = "PAGADO";
    }
    
    public int getId() { 
        return id; 
    }
    
    public int getIdVehiculo() { 
        return idVehiculo; 
    }
    
    public int getIdUsuario() { 
        return idUsuario; 
    }
    
    public double getMonto() { 
        return monto; 
    }
    
    public String getFecha() { 
        return fecha; 
    }
    
    public String getConcepto() { 
        return concepto; 
    }
    
    public String getEstado() { 
        return estado; 
    }
    
    public void setEstado(String estado) { 
        this.estado = estado; 
    }
    
    @Override
    public String toString() {
        return id + " | Vehículo ID: " + idVehiculo + 
               " | $" + monto + " | " + concepto + 
               " | " + fecha + " | " + estado;
    }
}
