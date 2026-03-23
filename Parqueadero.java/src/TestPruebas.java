public class TestPruebas {
    public static void main(String[] args) {
        System.out.println("   EJECUCIÓN TÉCNICA PARA PLAN DE PRUEBAS ");

        // --- PRUEBA 01: GESTIÓN DE USUARIOS ---
        // Tu clase Usuario usa toString() con 'S' mayúscula (según tu imagen)
        System.out.println("\n[Caso 01: Registro de Usuario]");
        Usuario userTest = new Usuario(50, "Prueba Sistema");
        
        System.out.println("Datos generados: " + userTest.toString());
        if (userTest.getId() == 50) {
            System.out.println("RESULTADO: EXITOSO ");
        }

        // --- PRUEBA 02: GESTIÓN DE PLAZAS (DISPONIBILIDAD) ---
        // Tu clase Plaza usa tostring() con 's' minúscula (según tu imagen)
        System.out.println("\n[Caso 02: Estado Inicial de Plaza]");
        Plaza plazaTest = new Plaza(10, "Nivel 1 - A1");
        
        // Llamamos al método exactamente como lo escribiste: tostring()
        System.out.println("Estado inicial: " + plazaTest.toString());
        if (plazaTest.isDisponible()) {
            System.out.println("RESULTADO: EXITOSO ");
        }

        // --- PRUEBA 03: GESTIÓN DE PLAZAS (OCUPACIÓN) ---
        System.out.println("\n[Caso 03: Cambiar Plaza a Ocupada]");
        plazaTest.setDisponible(false); 
        
        System.out.println("Estado final: " + plazaTest.toString());
        if (!plazaTest.isDisponible()) {
            System.out.println("RESULTADO: EXITOSO ");
        }

        
    }
}

