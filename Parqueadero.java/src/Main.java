import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Parqueadero parqueadero = new Parqueadero();
    
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());
            
            switch(opcion) {
                case 1: registrarUsuario(); break;
                case 2: registrarVehiculo(); break;
                case 3: listarUsuarios(); break;
                case 4: listarVehiculos(); break;
                case 5: verPlazas(); break;
                case 6: registrarEntrada(); break;
                case 7: registrarSalida(); break;
                case 8: verHistorial(); break;
                case 9: System.out.println("¡Hasta luego!"); break;
                default: System.out.println("Opción inválida");
            }
        } while(opcion != 9);
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=== PARQUEADERO ===");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Registrar vehículo");
        System.out.println("3. Listar usuarios");
        System.out.println("4. Listar vehículos");
        System.out.println("5. Ver plazas");
        System.out.println("6. Registrar entrada");
        System.out.println("7. Registrar salida");
        System.out.println("8. Ver historial");
        System.out.println("9. Salir");
        System.out.print("Opción: ");
    }
    
    private static void registrarUsuario() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        parqueadero.agregarUsuario(nombre);
        System.out.println(" Usuario registrado");
    }
    
    private static void registrarVehiculo() {
        if (parqueadero.getUsuarios().isEmpty()) {
            System.out.println("Primero registre un usuario");
            return;
        }
        
        System.out.println("\n--- Usuarios ---");
        for (Usuario u : parqueadero.getUsuarios()) {
            System.out.println(u.getId() + ". " + u.getNombre());
        }
        
        System.out.print("ID del dueño: ");
        int idU = Integer.parseInt(sc.nextLine());
        
        if (parqueadero.buscarUsuario(idU) == null) {
            System.out.println(" Usuario no existe");
            return;
        }
        
        System.out.print("Placa: ");
        String placa = sc.nextLine();
        System.out.print("Marca: ");
        String marca = sc.nextLine();
        
        parqueadero.agregarVehiculo(placa, marca, idU);
        System.out.println("✅ Vehículo registrado");
    }
    
    private static void listarUsuarios() {
        if (parqueadero.getUsuarios().isEmpty()) {
            System.out.println("📭 No hay usuarios");
            return;
        }
        
        System.out.println("\n--- USUARIOS ---");
        for (Usuario u : parqueadero.getUsuarios()) {
            System.out.println(u);
        }
    }
    
    private static void listarVehiculos() {
        if (parqueadero.getVehiculos().isEmpty()) {
            System.out.println("📭 No hay vehículos");
            return;
        }
        
        System.out.println("\n--- VEHÍCULOS ---");
        for (Vehiculo v : parqueadero.getVehiculos()) {
            Usuario u = parqueadero.buscarUsuario(v.getIdUsuario());
            System.out.println(v.getId() + ". " + v.getPlaca() + " (" + v.getMarca() + 
                             ") - Dueño: " + (u != null ? u.getNombre() : "?"));
        }
    }
    
    private static void verPlazas() {
        System.out.println("\n--- PLAZAS ---");
        int libres = 0;
        for (Plaza p : parqueadero.getPlazas()) {
            System.out.println(p);
            if (p.isDisponible()) libres++;
        }
        System.out.println("\n📊 Libres: " + libres + "/" + parqueadero.getPlazas().size());
    }
    
    private static void registrarEntrada() {
        Plaza libre = parqueadero.buscarPlazaLibre();
        if (libre == null) {
            System.out.println("❌ No hay plazas disponibles");
            return;
        }
        
        if (parqueadero.getVehiculos().isEmpty()) {
            System.out.println("❌ No hay vehículos");
            return;
        }
        
        System.out.println("\n--- Vehículos disponibles ---");
        for (Vehiculo v : parqueadero.getVehiculos()) {
            if (!parqueadero.vehiculoDentro(v.getId())) {
                System.out.println(v.getId() + ". " + v.getPlaca());
            }
        }
        
        System.out.print("ID del vehículo: ");
        int idV = Integer.parseInt(sc.nextLine());
        
        if (parqueadero.buscarVehiculo(idV) == null) {
            System.out.println("❌ Vehículo no existe");
            return;
        }
        
        if (parqueadero.vehiculoDentro(idV)) {
            System.out.println("❌ El vehículo ya está dentro");
            return;
        }
        
        parqueadero.registrarEntrada(idV, libre.getId());
        System.out.println("✅ Entrada registrada en plaza " + libre.getId());
    }
    
    private static void registrarSalida() {
        List<Registro> activos = parqueadero.getRegistrosActivos();
        if (activos.isEmpty()) {
            System.out.println("❌ No hay vehículos dentro");
            return;
        }
        
        System.out.println("\n--- Vehículos dentro ---");
        for (Registro r : activos) {
            Vehiculo v = parqueadero.buscarVehiculo(r.getIdVehiculo());
            System.out.println(r.getId() + ". " + v.getPlaca() + 
                             " - Plaza " + r.getIdPlaza() + 
                             " (" + r.getEntrada() + ")");
        }
        
        System.out.print("ID del registro: ");
        int idR = Integer.parseInt(sc.nextLine());
        
        parqueadero.registrarSalida(idR);
        System.out.println(" Salida registrada");
    }
    
    private static void verHistorial() {
        if (parqueadero.getRegistros().isEmpty()) {
            System.out.println(" No hay movimientos");
            return;
        }
        
        System.out.println("\n--- HISTORIAL ---");
        for (Registro r : parqueadero.getRegistros()) {
            Vehiculo v = parqueadero.buscarVehiculo(r.getIdVehiculo());
            System.out.println("Registro " + r.getId() + 
                             " | Vehículo: " + (v != null ? v.getPlaca() : "?") +
                             " | Plaza: " + r.getIdPlaza() +
                             " | Entrada: " + r.getEntrada() +
                             " | Salida: " + (r.getSalida() == null ? "---" : r.getSalida()));
        }
    }
}

