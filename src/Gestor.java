import java.util.ArrayList;

public class Gestor {
    ArrayList<Agente> lista = new ArrayList<>();

    public void agregarAgente(Agente a) {
        lista.add(a);
    }

    public Agente buscarAgente(String id) {
        for (Agente a : lista) {
            if (a.id.equals(id)) return a;
        }
        return null;
    }

    public ArrayList<Agente> getTodos() {
        return lista;
    }
}
