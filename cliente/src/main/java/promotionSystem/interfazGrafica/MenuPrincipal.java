package promotionSystem.interfazGrafica;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import promotionSystem.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private Cliente cliente;

	public MenuPrincipal(Cliente cliente) throws IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JFrame marco=this;
		setTitle("Menu Principal");
		this.cliente=cliente;
		cliente.enviarAccion("MenuPrincipal");
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU PRINCIPAL");
		lblMenu.setBounds(181, 11, 126, 14);
		contentPane.add(lblMenu);
		
		JButton btnSeleccionarMapa = new JButton("Seleccionar Mapa");
		btnSeleccionarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					abrirSeleccionDeMapa(marco);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}

		});
		btnSeleccionarMapa.setBounds(163, 50, 115, 23);
		contentPane.add(btnSeleccionarMapa);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(170, 228, 89, 23);
		contentPane.add(btnSalir);
	}
	

	private void abrirSeleccionDeMapa(JFrame marco) throws IOException {
		SeleccionMapa mapa=new SeleccionMapa(cliente);
		mapa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mapa.setVisible(true);
		
		mapa.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
			
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
		
				marco.setEnabled(true);
				
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
			
				marco.setEnabled(false);
			}
			
		});
	}
}