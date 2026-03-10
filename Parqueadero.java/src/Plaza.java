public class Plaza {
    private int id;
    private String ubicacion;
    private boolean disponible;
    
    public Plaza(int id, String ubicacion) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.disponible = true;
    }
    
    public int getId() { return id; }
    public String getUbicacion() { return ubicacion; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    
    @Override
    public String toString() {
        return id + " - " + ubicacion + " - " + (disponible ? "LIBRE" : "OCUPADA");
    }
}
