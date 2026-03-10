import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private List<Usuario> usuarios;
    private List<Vehiculo> vehiculos;
    private List<Plaza> plazas;
    private List<Registro> registros;
    
    private int contadorUsuarios = 1;
    private int contadorVehiculos = 1;
    private int contadorRegistros = 1;
    
    public Parqueadero() {
        usuarios = new ArrayList<>();
        vehiculos = new ArrayList<>();
        plazas = new ArrayList<>();
        registros = new ArrayList<>();
        
        // Crear plazas iniciales
        plazas.add(new Plaza(1, "Piso 1 - A1"));
        plazas.add(new Plaza(2, "Piso 1 - A2"));
        plazas.add(new Plaza(3, "Piso 1 - A3"));
        plazas.add(new Plaza(4, "Piso 2 - B1"));
        plazas.add(new Plaza(5, "Piso 2 - B2"));
    }
    
    // Usuarios
    public void agregarUsuario(String nombre) {
        usuarios.add(new Usuario(contadorUsuarios++, nombre));
    }
    
    public List<Usuario> getUsuarios() {
        return usuarios;
    }
    
    public Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }
    
    // Vehículos
    public void agregarVehiculo(String placa, String marca, int idUsuario) {
        vehiculos.add(new Vehiculo(contadorVehiculos++, placa, marca, idUsuario));
    }
    
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public Vehiculo buscarVehiculo(int id) {
        for (Vehiculo v : vehiculos) {
            if (v.getId() == id) return v;
        }
        return null;
    }
    
    // Plazas
    public List<Plaza> getPlazas() {
        return plazas;
    }
    
    public Plaza buscarPlazaLibre() {
        for (Plaza p : plazas) {
            if (p.isDisponible()) return p;
        }
        return null;
    }
    
    public Plaza buscarPlaza(int id) {
        for (Plaza p : plazas) {
            if (p.getId() == id) return p;
        }
        return null;
    }
    
    // Registros
    public void registrarEntrada(int idVehiculo, int idPlaza) {
        registros.add(new Registro(contadorRegistros++, idVehiculo, idPlaza));
        buscarPlaza(idPlaza).setDisponible(false);
    }
    
    public void registrarSalida(int idRegistro) {
        for (Registro r : registros) {
            if (r.getId() == idRegistro && r.getSalida() == null) {
                r.setSalida(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM HH:mm")));
                buscarPlaza(r.getIdPlaza()).setDisponible(true);
                break;
            }
        }
    }
    
    public List<Registro> getRegistros() {
        return registros;
    }
    
    public List<Registro> getRegistrosActivos() {
        List<Registro> activos = new ArrayList<>();
        for (Registro r : registros) {
            if (r.getSalida() == null) activos.add(r);
        }
        return activos;
    }
    
    // Verificaciones
    public boolean vehiculoDentro(int idVehiculo) {
        for (Registro r : registros) {
            if (r.getIdVehiculo() == idVehiculo && r.getSalida() == null) {
                return true;
            }
        }
        return false;
    }
}

