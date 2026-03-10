public class Vehiculo {
    private int id;
    private String placa;
    private String marca;
    private int idUsuario;
    
    public Vehiculo(int id, String placa, String marca, int idUsuario) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.idUsuario = idUsuario;
    }
    
    public int getId() { return id; }
    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public int getIdUsuario() { return idUsuario; }
    
    @Override
    public String toString() {
        return id + " - " + placa + " (" + marca + ")";
    }
}
