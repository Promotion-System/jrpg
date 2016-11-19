package promotionSystem.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import promotionSystem.Cliente;

public class Login extends JFrame {
	Cliente cliente;

	public Login() throws Exception {

		cliente = new Cliente();
		crearInterfaz();

		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {

			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {

				try {
					enviarAccionDeCerrar();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowOpened(WindowEvent e) {

			}

		});
	}

	private void crearInterfaz() {
		LaminaLogin lamina = new LaminaLogin(cliente, this);
		setTitle("LOGIN");
		setResizable(false);
		setBounds(0, 0, 450, 400);
		add(lamina);
	}

	public Login(Cliente cliente) {
		this.cliente = cliente;
		crearInterfaz();
	}

	private void enviarAccionDeCerrar() throws IOException {
		cliente.enviarAccion("cerrar");
	}

}

class LaminaLogin extends JPanel {

	public LaminaLogin(Cliente cliente, JFrame marco) {
		setLayout(new BorderLayout());
		LaminaLoginCentral lamina = new LaminaLoginCentral(cliente, marco);
		LaminaLoginNorte laminaN = new LaminaLoginNorte();
		LaminaLoginSur laminaS = new LaminaLoginSur(cliente, marco);
		add(lamina, BorderLayout.CENTER);
		add(laminaN, BorderLayout.NORTH);
		add(laminaS, BorderLayout.SOUTH);

	}
}

class LaminaLoginCentral extends JPanel implements KeyListener {

	private Cliente cliente;
	private JPasswordField contraseña;
	private JTextField nick;
	private JLabel error;
	private JFrame frame;
	private JButton registrarse;

	public LaminaLoginCentral(Cliente cliente, JFrame frame) {
		this.cliente = cliente;
		setLayout(new GridLayout(5, 1));
		JLabel nicklabel = new JLabel("NickName:");
		nick = new JTextField(20);
		this.frame = frame;
		registrarse = new JButton("REGISTRATE");
		JLabel contraseñalabel = new JLabel("contraseña: ");
		contraseña = new JPasswordField(20);
		contraseña.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					aceptar();
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {

			}

			@Override
			public void keyTyped(KeyEvent arg0) {

			}

		});

		JButton ingresar = new JButton("Ingresar");
		ingresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				aceptar();
			}
		});

		JLabel label = new JLabel("Aun no te has registrado?");

		registrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrirRegistrar(cliente, frame);
			}

		});

		error = new JLabel(" ");

		nicklabel.setBounds(0, 10, 100, 20);
		nick.setBounds(110, 10, 100, 20);
		contraseñalabel.setBounds(0, 30, 100, 20);
		contraseña.setBounds(110, 30, 100, 20);
		ingresar.setBounds(220, 20, 100, 30);
		label.setBounds(0, 60, 200, 20);
		registrarse.setBounds(0, 90, 120, 20);

		LaminaAuxiliarFlowLog nickName = new LaminaAuxiliarFlowLog(FlowLayout.LEFT);
		LaminaAuxiliarFlowLog password = new LaminaAuxiliarFlowLog(FlowLayout.LEFT);
		LaminaAuxiliarFlowLog registro = new LaminaAuxiliarFlowLog(FlowLayout.LEFT);
		LaminaAuxiliarFlowLog ingresarBoton = new LaminaAuxiliarFlowLog(FlowLayout.CENTER);
		LaminaAuxiliarFlowLog informe = new LaminaAuxiliarFlowLog(FlowLayout.LEFT);

		nickName.add(nicklabel);
		nickName.add(nick);
		password.add(contraseñalabel);
		password.add(contraseña);
		ingresarBoton.add(ingresar);
		registro.add(label);
		registro.add(registrarse);
		informe.add(error);

		add(nickName);
		add(password);
		add(ingresarBoton);
		add(registro);
		add(informe);
	}

	private void aceptar() {
		try {
			if (camposNoVacios()) {
				registrarse.setEnabled(false);
				enviarAccion();
				iniciarSesion();
				if (resultado()) {
					cargarNombre();
					cargarPersonaje();
					menuPrincipal(frame);
				} else {
					error.setText("Usuario y/o Contraseña incorrecta");
					vaciarCampos();
				}
			} else {
				error.setText("Los Campos no deben estar vacios");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cargarPersonaje() throws Exception {
		if (!cliente.tienePersonaje()) {
			cliente.enviarAccion("cargarPersonaje");
			cliente.recibirPersonaje();
		}
	}

	private void abrirRegistrar(Cliente cliente, JFrame frame) {
		Registrarse marco = new Registrarse(cliente);
		marco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		marco.setVisible(true);

		marco.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				frame.setEnabled(true);
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				frame.setEnabled(false);
			}

		});
	}

	private void vaciarCampos() {
		nick.setText("");
		contraseña.setText("");
	}

	private void cargarNombre() {
		cliente.setNombre(nick.getText());

	}

	private boolean camposNoVacios() {
		return !nick.getText().equals("") && !contraseña.getText().equals("");
	}

	private void iniciarSesion() throws IOException {

		cliente.enviarUsuarioYContraseña(nick.getText(), contraseña.getText());
	}

	private void enviarAccion() throws IOException {
		cliente.enviarAccion("login");
	}

	private boolean resultado() throws IOException {
		return cliente.resultado().equals("true");
	}

	private void menuPrincipal(JFrame marco) throws Exception {

		MenuPrincipal ventana = new MenuPrincipal(cliente);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {

			}

			@Override
			public void windowClosed(WindowEvent arg0) {

			}

			@Override
			public void windowClosing(WindowEvent arg0) {

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {

			}

			@Override
			public void windowIconified(WindowEvent arg0) {

			}

			@Override
			public void windowOpened(WindowEvent arg0) {

				marco.dispose();
			}

		});

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}

class LaminaLoginNorte extends JPanel {

	public LaminaLoginNorte() {

		JLabel Titulo = new JLabel("KINGS OF THE MULTIVERSE");

		Titulo.setFont(new Font("titulo", Font.BOLD, 33));

		add(Titulo);

	}
}

class LaminaLoginSur extends JPanel {

	public LaminaLoginSur(Cliente cliente, JFrame marco) {

		JButton salir = new JButton("SALIR");

		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					enviarAccionDeCerrar(cliente);
				} catch (IOException e) {

					e.printStackTrace();
				}
				marco.dispose();
			}

		});

		salir.setSize(50, 50);

		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(salir);

	}

	private void enviarAccionDeCerrar(Cliente cliente) throws IOException {
		cliente.enviarAccion("cerrar");
	}
}

class LaminaAuxiliarFlowLog extends JPanel {

	public LaminaAuxiliarFlowLog(int f) {
		setLayout(new FlowLayout(f));

	}
}
