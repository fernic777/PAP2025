package pap2025;

/**
 * Tipo de dato para representar fechas
 */
public class DTFecha {
    private int dia;
    private int mes;
    private int anio;
    
    public DTFecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    // Getters
    public int getDia() {
        return dia;
    }
    
    public int getMes() {
        return mes;
    }
    
    public int getAnio() {
        return anio;
    }
    
    // Setters
    public void setDia(int dia) {
        this.dia = dia;
    }
    
    public void setMes(int mes) {
        this.mes = mes;
    }
    
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}
