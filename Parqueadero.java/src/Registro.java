import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Registro {
    private int id;
    private int idVehiculo;
    private int idPlaza;
    private String entrada;
    private String salida;
    
    public Registro(int id, int idVehiculo, int idPlaza) {
        this.id = id;
        this.idVehiculo = idVehiculo;
        this.idPlaza = idPlaza;
        this.entrada = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM HH:mm"));
        this.salida = null;
    }
    
    public int getId() { return id; }
    public int getIdVehiculo() { return idVehiculo; }
    public int getIdPlaza() { return idPlaza; }
    public String getEntrada() { return entrada; }
    public String getSalida() { return salida; }
    public void setSalida(String salida) { this.salida = salida; }
}