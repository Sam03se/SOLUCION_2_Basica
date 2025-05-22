import javax.swing.*;
import java.awt.event.*;

public class Formulario extends JFrame {
    private JPanel panelMain;
    private JTextField SCJBtxtId;
    private JTextField SCJBtxtNombre;
    private JTextField SCJBtxtMision;
    private JTextField SCJBtxtPeligrosidad;
    private JTextField SCJBtxtPago;
    private JButton SCJBbtnGuardar;
    private JButton SCJBbtnModificar;
    private JButton SCJBbtnListar;
    private JTextArea SCJBtxtResultado;

    Gestor gestor = new Gestor();

    public Formulario() {
        setTitle("Gestión de Agentes SCJB");
        setContentPane(panelMain);
        setSize(400, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        SCJBbtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = SCJBtxtId.getText();
                String nombre = SCJBtxtNombre.getText();
                String mision = SCJBtxtMision.getText();
                int peligro = Integer.parseInt(SCJBtxtPeligrosidad.getText());
                double pago = Double.parseDouble(SCJBtxtPago.getText());

                Agente a = new Agente(id, nombre, mision, peligro, pago);
                gestor.agregarAgente(a);
                SCJBtxtResultado.setText("Agente guardado.\n\n" + a.getResumen());
            }
        });

        SCJBbtnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Agente a = gestor.buscarAgente(SCJBtxtId.getText());
                if (a != null) {
                    a.nombre = SCJBtxtNombre.getText();
                    a.mision = SCJBtxtMision.getText();
                    a.peligrosidad = Integer.parseInt(SCJBtxtPeligrosidad.getText());
                    a.pagoMensual = Double.parseDouble(SCJBtxtPago.getText());
                    SCJBtxtResultado.setText("Agente modificado.\n\n" + a.getResumen());
                } else {
                    SCJBtxtResultado.setText("Agente no encontrado.");
                }
            }
        });

        SCJBbtnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                for (Agente a : gestor.getTodos()) {
                    sb.append(a.getResumen()).append("\n\n");
                }
                SCJBtxtResultado.setText(sb.toString());
            }
        });
    }

    public static void main(String[] args) {
        new Formulario();
    }
}
