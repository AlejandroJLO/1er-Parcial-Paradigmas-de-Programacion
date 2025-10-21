import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EventosMouse extends JFrame {

    // Etiqueta para mostrar mensajes
    private JLabel lblSaludo;

    // Campo de texto donde el usuario puede escribir
    private JTextField campoSaludo;

    // Botón para interactuar
    private JButton boton;

    public EventosMouse() {

        // Etiqueta vacía para mostrar mensajes según la acción del mouse
        lblSaludo = new JLabel();
        lblSaludo.setBounds(25, 10, 350, 30);

        // Etiqueta de la instrucción
        JLabel lblInstruccion = new JLabel("Ingresa tu nombre: ");
        lblInstruccion.setBounds(25, 165, 200, 30);

        // Campo de texto para que el usuario escriba su nombre
        campoSaludo = new JTextField(200);
        campoSaludo.setBounds(25, 200, 200, 30);

        // Botón que servirá para saludar
        boton = new JButton("¡Saludar!");
        boton.setBounds(25, 235, 150, 30);

        // Listener que detecta los distintos eventos del mouse
        MouseListener listener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // Detecta si se hace clic en el campo de texto o el botón
                if (e.getSource() == campoSaludo) {
                    lblSaludo.setText("MouseClicked dentro de campo saludo");
                }
                if (e.getSource() == boton) {
                    lblSaludo.setText("MouseClicked dentro de boton");
                }
            }
            @Override public void mousePressed(MouseEvent e) { lblSaludo.setText("mousePressed"); }
            @Override public void mouseReleased(MouseEvent e) { lblSaludo.setText("mouseReleased"); }
            @Override public void mouseEntered(MouseEvent e) { lblSaludo.setText("mouseEntered"); }
            @Override public void mouseExited(MouseEvent e)  { lblSaludo.setText("mouseExited"); }
        };

        // Se agregan los listeners al botón y al campo de texto
        boton.addMouseListener(listener);
        campoSaludo.addMouseListener(listener);

        // Se añaden los componentes a la ventana
        add(lblSaludo);
        add(lblInstruccion);
        add(campoSaludo);
        add(boton);

        // Configuración de la ventana
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Método principal del programa
    public static void main(String[] args) {
        new EventosMouse();
    }
}
