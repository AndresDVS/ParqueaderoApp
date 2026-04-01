public class Tarifa {
    private double valorHora;
    private double valorMensual;
    
    public Tarifa() {
        this.valorHora = 2000;
        this.valorMensual = 80000;
    }
    
    public double getValorHora() { return valorHora; }
    public double getValorMensual() { return valorMensual; }
    
    public void setValorHora(double valorHora) { this.valorHora = valorHora; }
    public void setValorMensual(double valorMensual) { this.valorMensual = valorMensual; }
    
    public double calcularPorHoras(int horas) {
        return horas * valorHora;
    }
    
    public double calcularPorMensualidad() {
        return valorMensual;
    }
}