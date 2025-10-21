import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventosMouseClick extends JFrame {

    private JLabel lblSaludo;

    public EventosMouseClick() {
        lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 10, 350, 30);

        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);

        JTextField campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);

        JButton boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // Listener que detecta clics con teclas modificadoras (Alt, Ctrl, Shift)

        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // Diferentes combinaciones de clic + tecla
                if (e.isAltDown()) {
                    lblSaludo.setText("clic + alt");
                } else if (e.isControlDown()) {
                    lblSaludo.setText("clic + Control");
                } else if (e.isShiftDown()) {
                    lblSaludo.setText("clic + Shift");
                } else if (e.isMetaDown()) {
                    lblSaludo.setText("clic derecho");
                } else {
                    lblSaludo.setText("clic izquierdo");
                }

                // Detectar el doble clic
                if (e.getClickCount() == 2) {
                    lblSaludo.setText("doble clic");
                }
            }

            // Métodos vacíos para otros eventos no usados
            @Override public void mousePressed(MouseEvent e) {}
            @Override public void mouseReleased(MouseEvent e) {}
            @Override public void mouseEntered(MouseEvent e) {}
            @Override public void mouseExited(MouseEvent e) {}
        };

        // Se agregan los listeners
        boton.addMouseListener(listener);
        campoSaludo.addMouseListener(listener);

        add(lblSaludo);
        add(lblInstruccion);
        add(campoSaludo);
        add(boton);

        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new EventosMouseClick();
    }
}
