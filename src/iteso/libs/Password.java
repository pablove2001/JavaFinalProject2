package iteso.libs;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
@SuppressWarnings("serial")
public class Password extends JFrame {
 
    public Password() {
        add(ingresarUsuario());
        add(ingresarContrasenia());
        add(jtaUsuario());
        add(jpfContrasenia());
        inicializador();
    }
 
    // Inicializador de la Ventana
    private void inicializador() {
        setSize(400, 200);
        setLayout(null);
        setTitle("Login");
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
 
    // Texto que indica donde va el nombre de Usuario
    private JLabel ingresarUsuario() {
        JLabel usuario = new JLabel("Nombre de Usuario: ");
        usuario.setBounds(30, 30, 200, 20);
        return usuario;
    }
 
    // Texto que indica donde va la contraña
    private JLabel ingresarContrasenia() {
        JLabel contrasenia = new JLabel("Contrasenia: ");
        contrasenia.setBounds(30, 80, 200, 20);
        return contrasenia;
    }
 
    // Espacio para ingresar el nombre de usuario
    private JTextField jtaUsuario() {
        JTextField usuario = new JTextField();
        usuario.setBounds(200, 30, 150, 20);
        usuario.setToolTipText("Ingrese Nombre de Usuario");
        return usuario;
    }
 
    // Espacio para ingresar la contraseña
    private JPasswordField jpfContrasenia() {
        // Se inicializa el Objeto
        JPasswordField contrasenia = new JPasswordField();
        // Asignamos posición y tamaño
        contrasenia.setBounds(200, 80, 150, 20);
        // Colocamos un símbolo personalizado(opcional)
        contrasenia.setEchoChar('*');
        // Le asignamos un texto emergente cuando nos posamos encima del objeto
        contrasenia.setToolTipText("Ingrese Contraseña");
        return contrasenia;
    }
 
    public static void main(String[] args) {
        new Password();
    }
 
}
