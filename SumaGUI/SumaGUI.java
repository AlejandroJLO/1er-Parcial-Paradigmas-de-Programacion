import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;

public class SumaGUI {
    private Frame f;
    private Panel pan1, pan2, pan3, pan4;
    private JLabel lblInstruccion1, lblInstruccion2, lblNum1, lblNum2, lblResultado;
    private TextField tfNum1, tfNum2, tfResultado;
    private Button btCalcular, btSalir;

    // Checkboxes con grupo, solo para agrupar visualmente
    private CheckboxGroup operaciones;
    private Checkbox chkSuma, chkResta, chkMulti, chkDiv;

    public SumaGUI() {
        f = new Frame("Operaciones con dos números");

        pan1 = new Panel();
        pan2 = new Panel();
        pan3 = new Panel();
        pan4 = new Panel(); // Panel para las nuevas operaciones

        lblInstruccion1 = new JLabel("Instrucciones:");
        lblInstruccion1.setFont(new Font("Arial", Font.BOLD, 16));
        lblInstruccion2 = new JLabel(
            "<html><div align='center'>Ingrese los números y seleccione la operación.<br>" +
            "Después haga clic en CALCULAR.</div></html>"
        );

        lblNum1 = new JLabel("Primer Número:");
        lblNum2 = new JLabel("Segundo Número:");
        lblResultado = new JLabel("Resultado:");

        tfNum1 = new TextField(7);
        tfNum2 = new TextField(7);
        tfResultado = new TextField(10);
        tfResultado.setEditable(false);

        btCalcular = new Button("Calcular");
        btSalir = new Button("Salir");

        // Agrupamos los CheckBox solo apariencia
        operaciones = new CheckboxGroup();
        chkSuma = new Checkbox("Sumar", operaciones, true);
        chkResta = new Checkbox("Restar", operaciones, false);
        chkMulti = new Checkbox("Multiplicar", operaciones, false);
        chkDiv   = new Checkbox("Dividir", operaciones, false);
    }

    public void acomodarEnFrame() {
        btCalcular.addActionListener(new MnjBotonCalcular());
        btSalir.addActionListener(e -> System.exit(0));

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Panel con instrucciones y campos
        pan1.setLayout(new GridLayout(3,2,10,10)); // Más espacio entre celdas
        pan1.add(lblInstruccion1);
        pan1.add(lblInstruccion2);
        pan1.add(lblNum1);
        pan1.add(tfNum1);
        pan1.add(lblNum2);
        pan1.add(tfNum2);
        f.add(pan1, BorderLayout.NORTH);

        // Panel de operaciones
        pan4.setLayout(new GridLayout(1,4,15,15));
        pan4.add(chkSuma);
        pan4.add(chkResta);
        pan4.add(chkMulti);
        pan4.add(chkDiv);
        pan4.setBackground(new Color(230,230,250));
        f.add(pan4, BorderLayout.WEST);

        // Panel del resultado
        pan2.add(lblResultado);
        pan2.add(tfResultado);
        f.add(pan2, BorderLayout.CENTER);

        // Panel de los botones
        pan3.setLayout(new GridLayout(1,2,15,15));
        pan3.add(btCalcular);
        pan3.add(btSalir);
        f.add(pan3, BorderLayout.SOUTH);

        f.setSize(550, 320);  
        f.setVisible(true);
    }


    class MnjBotonCalcular implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                double n1 = Double.parseDouble(tfNum1.getText());
                double n2 = Double.parseDouble(tfNum2.getText());
                double res = 0;

                if (chkSuma.getState()) {
                    res = n1 + n2;
                } else if (chkResta.getState()) {
                    res = n1 - n2;
                } else if (chkMulti.getState()) {
                    res = n1 * n2;
                } else if (chkDiv.getState()) {
                    if (n2 != 0) {
                        res = n1 / n2;
                    } else {
                        tfResultado.setText("División por 0");
                        return;
                    }
                }

                tfResultado.setText(Double.toString(res));
            } catch (NumberFormatException e) {
                tfResultado.setText("Entrada inválida");
            }
        }
    }


    public static void main(String[] args) {
        SumaGUI ventana = new SumaGUI();
        ventana.acomodarEnFrame();
    }
}
