public class Agente {
    String id, nombre, mision;
    int peligrosidad;
    double pagoMensual;

    public Agente(String id, String nombre, String mision, int peligrosidad, double pagoMensual) {
        this.id = id;
        this.nombre = nombre;
        this.mision = mision;
        this.peligrosidad = peligrosidad;
        this.pagoMensual = pagoMensual;
    }

    public double calcularAporte() {
        return pagoMensual * 0.08;
    }

    public double calcularImpuestoAnual() {
        double anual = pagoMensual * 12;
        if (anual <= 5000) return 0;
        else if (anual <= 10000) return (anual - 5000) * 0.10;
        else if (anual <= 20000) return 500 + (anual - 10000) * 0.20;
        else return 2500 + (anual - 20000) * 0.30;
    }

    public double calcularPagoNeto() {
        return pagoMensual - calcularAporte() - (calcularImpuestoAnual() / 12);
    }

    public String getResumen() {
        return "Agente: " + nombre +
                "\nPago: $" + pagoMensual +
                "\nAporte: $" + calcularAporte() +
                "\nImpuesto: $" + calcularImpuestoAnual() +
                "\nNeto: $" + calcularPagoNeto();
    }
}
