package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consulta extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblModelo;
	private JComboBox cboModelo;
	private JLabel lblRam;
	private JLabel lblAlmacenamiento;
	private JLabel lblCamara;
	private JLabel lblSistemaOperativo;
	private JLabel lblTamao;
	private JTextField txtRAM;
	private JTextField txtAlmacenamiento;
	private JTextField txtCamara;
	private JTextField txtSO;
	private JTextField txtTamaño;
	private JLabel lblPrecio;
	private JTextField txtPrecio;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta frame = new Consulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Consulta() {
		setTitle("Consultar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(12, 13, 72, 14);
		contentPane.add(lblModelo);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "iPhone 12 Pro Max", "Samsung Galaxy S10", "Motorola One Plus", "Xiomi Redmi Note 10"}));
		cboModelo.setBounds(106, 8, 154, 20);
		contentPane.add(cboModelo);
		
		lblRam = new JLabel("RAM");
		lblRam.setBounds(12, 49, 46, 14);
		contentPane.add(lblRam);
		
		lblAlmacenamiento = new JLabel("Almacenamiento");
		lblAlmacenamiento.setBounds(8, 89, 109, 14);
		contentPane.add(lblAlmacenamiento);
		
		lblCamara = new JLabel("Camara");
		lblCamara.setBounds(12, 124, 63, 14);
		contentPane.add(lblCamara);
		
		lblSistemaOperativo = new JLabel("Sistema Operativo");
		lblSistemaOperativo.setBounds(10, 156, 118, 14);
		contentPane.add(lblSistemaOperativo);
		
		lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setBounds(10, 193, 60, 14);
		contentPane.add(lblTamao);
		
		txtRAM = new JTextField();
		txtRAM.setEditable(false);
		txtRAM.setBounds(138, 46, 86, 20);
		contentPane.add(txtRAM);
		txtRAM.setColumns(10);
		
		txtAlmacenamiento = new JTextField();
		txtAlmacenamiento.setEditable(false);
		txtAlmacenamiento.setBounds(138, 86, 86, 20);
		contentPane.add(txtAlmacenamiento);
		txtAlmacenamiento.setColumns(10);
		
		txtCamara = new JTextField();
		txtCamara.setEditable(false);
		txtCamara.setBounds(138, 121, 86, 20);
		contentPane.add(txtCamara);
		txtCamara.setColumns(10);
		
		txtSO = new JTextField();
		txtSO.setEditable(false);
		txtSO.setBounds(138, 153, 134, 20);
		contentPane.add(txtSO);
		txtSO.setColumns(10);
		
		txtTamaño = new JTextField();
		txtTamaño.setEditable(false);
		txtTamaño.setBounds(138, 190, 136, 20);
		contentPane.add(txtTamaño);
		txtTamaño.setColumns(10);
		
		lblPrecio = new JLabel("Precio S/.");
		lblPrecio.setBounds(9, 226, 75, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(138, 221, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(335, 9, 89, 23);
		contentPane.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == cboModelo) {
			actionPerformedCboModelo(e);
		}
	}
	protected void actionPerformedCboModelo(ActionEvent e) {
		int posModelo;
		String modelo,ram,almacenamiento,camara,tamaño,so;
		double precio;
		
		posModelo = cboModelo.getSelectedIndex();
		
		switch (posModelo) {
		case 0:
			modelo = "";
			ram = "";
			almacenamiento ="";
			camara = "";
			tamaño = "";
			so = "";
			precio = 0;
			break;
		case 1:
			modelo = Proyecto.modelo0;
			ram = Proyecto.ram0;
			almacenamiento = Proyecto.almacenamiento0;
			camara = Proyecto.camara0;
			tamaño = Proyecto.tamaño0;
			so = Proyecto.so0;
			precio = Proyecto.precio0;
			break;
        case 2:
        	modelo = Proyecto.modelo1;
			ram = Proyecto.ram1;
			almacenamiento = Proyecto.almacenamiento1;
			camara = Proyecto.camara1;
			tamaño = Proyecto.tamaño1;
			so = Proyecto.so1;
			precio = Proyecto.precio1;
			break;
        case 3:
        	modelo = Proyecto.modelo2;
			ram = Proyecto.ram2;
			almacenamiento = Proyecto.almacenamiento2;
			camara = Proyecto.camara2;
			tamaño = Proyecto.tamaño2;
			so = Proyecto.so2;
			precio = Proyecto.precio2;
	        break;

		default:
			modelo = Proyecto.modelo3;
			ram = Proyecto.ram3;
			almacenamiento = Proyecto.almacenamiento3;
			camara = Proyecto.camara3;
			tamaño = Proyecto.tamaño3;
			so = Proyecto.so3;
			precio = Proyecto.precio3;
		}
		txtRAM.setText(ram);
		txtTamaño.setText(tamaño);
		txtAlmacenamiento.setText(almacenamiento);
		txtCamara.setText(camara);
		txtSO.setText(so);
		txtPrecio.setText("" + precio);
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
}
