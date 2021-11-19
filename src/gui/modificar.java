package gui;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class modificar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblRam;
	private JLabel lblAlmacenamiento;
	private JLabel lblCamara;
	private JLabel lblSistemaOperativo;
	private JLabel lblTamao;
	private JLabel lblPrecio;
	private JTextField txtRam;
	private JTextField txtAlmacenamiento;
	private JTextField txtCamara;
	private JTextField txtSo;
	private JTextField txttamao;
	private JTextField txtprecio;
	private JComboBox cboModelo;
	private JButton btnGrabar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			modificar dialog = new modificar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public modificar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblModelo = new JLabel("Modelo");
			lblModelo.setBounds(10, 11, 80, 14);
			contentPanel.add(lblModelo);
		}
		
		lblRam = new JLabel("Ram");
		lblRam.setBounds(10, 46, 46, 14);
		contentPanel.add(lblRam);
		
		lblAlmacenamiento = new JLabel("Almacenamiento");
		lblAlmacenamiento.setBounds(10, 78, 125, 14);
		contentPanel.add(lblAlmacenamiento);
		
		lblCamara = new JLabel("Camara");
		lblCamara.setBounds(10, 114, 46, 14);
		contentPanel.add(lblCamara);
		
		lblSistemaOperativo = new JLabel("Sistema Operativo");
		lblSistemaOperativo.setBounds(10, 152, 125, 14);
		contentPanel.add(lblSistemaOperativo);
		
		lblTamao = new JLabel("Tama\u00F1o");
		lblTamao.setBounds(10, 179, 46, 14);
		contentPanel.add(lblTamao);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 217, 46, 14);
		contentPanel.add(lblPrecio);
		
		txtRam = new JTextField();
		txtRam.setBounds(145, 43, 86, 20);
		contentPanel.add(txtRam);
		txtRam.setColumns(10);
		
		txtAlmacenamiento = new JTextField();
		txtAlmacenamiento.setBounds(145, 75, 86, 20);
		contentPanel.add(txtAlmacenamiento);
		txtAlmacenamiento.setColumns(10);
		
		txtCamara = new JTextField();
		txtCamara.setBounds(145, 111, 86, 20);
		contentPanel.add(txtCamara);
		txtCamara.setColumns(10);
		
		txtSo = new JTextField();
		txtSo.setBounds(145, 149, 86, 20);
		contentPanel.add(txtSo);
		txtSo.setColumns(10);
		
		txttamao = new JTextField();
		txttamao.setBounds(145, 176, 86, 20);
		contentPanel.add(txttamao);
		txttamao.setColumns(10);
		
		txtprecio = new JTextField();
		txtprecio.setBounds(145, 214, 86, 20);
		contentPanel.add(txtprecio);
		txtprecio.setColumns(10);
		
		cboModelo = new JComboBox();
		cboModelo.addActionListener(this);
		cboModelo.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "iPhone 12 Pro Max", "Samsung Galaxy S10", "Motorola One Plus", "Xiomi Redmi Note 10"}));
		cboModelo.setBounds(100, 8, 131, 20);
		contentPanel.add(cboModelo);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(322, 11, 89, 23);
		contentPanel.add(btnGrabar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(322, 46, 89, 23);
		contentPanel.add(btnCerrar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == cboModelo) {
			actionPerformedComboBox(arg0);
		}
	}
	protected void actionPerformedComboBox(ActionEvent arg0) {
		switch (cboModelo.getSelectedIndex()) {
		case 0:
			txtRam.setText("");
			txtAlmacenamiento.setText("");
			txtCamara.setText("");
			txtSo.setText("");
			txttamao.setText("");
			txtprecio.setText("");
			
			break;
        case 1:
        	txtRam.setText(Proyecto.ram0);
			txtAlmacenamiento.setText(Proyecto.almacenamiento0);
			txtCamara.setText(Proyecto.camara0);
			txtSo.setText(Proyecto.so0);
			txttamao.setText(Proyecto.tamaño0);
			txtprecio.setText(""+Proyecto.precio0);
			
			break;
        case 2:
        	txtRam.setText(Proyecto.ram1);
			txtAlmacenamiento.setText(Proyecto.almacenamiento1);
			txtCamara.setText(Proyecto.camara1);
			txtSo.setText(Proyecto.so1);
			txttamao.setText(Proyecto.tamaño1);
			txtprecio.setText(""+Proyecto.precio1);
	
	        break;
        case 3:
        	txtRam.setText(Proyecto.ram2);
			txtAlmacenamiento.setText(Proyecto.almacenamiento2);
			txtCamara.setText(Proyecto.camara2);
			txtSo.setText(Proyecto.so2);
			txttamao.setText(Proyecto.tamaño2);
			txtprecio.setText(""+Proyecto.precio2);
	        break;

		default:
			txtRam.setText(Proyecto.ram3);
			txtAlmacenamiento.setText(Proyecto.almacenamiento3);
			txtCamara.setText(Proyecto.camara3);
			txtSo.setText(Proyecto.so3);
			txttamao.setText(Proyecto.tamaño3);
			txtprecio.setText(""+Proyecto.precio3);
		}
		
	}
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		String ram = leerRam();
		
			
				String almacenamiento = leerAlmacenamiento();
				String camara = leerCamara();
				String so = leerSo();
				String tamaño = leerTamaño();
				
					
				
						double precio = leerPrecio();
						switch (cboModelo.getSelectedIndex()) { 
							case 0: 
								
								break;
							case 1: 
								Proyecto.ram0 = ram;
								Proyecto.almacenamiento0 = almacenamiento;
								Proyecto.camara0 = camara;
								Proyecto.so0 = so;
								Proyecto.tamaño0 = tamaño;
								Proyecto.precio0 = precio;
								break;
							case 2: 
								Proyecto.ram1 = ram;
								Proyecto.almacenamiento1 = almacenamiento;
								Proyecto.camara1 = camara;
								Proyecto.so1 = so;
								Proyecto.tamaño1 = tamaño;
								Proyecto.precio1 = precio;
								break;
							case 3: 
								Proyecto.ram2 = ram;
								Proyecto.almacenamiento2 = almacenamiento;
								Proyecto.camara2 = camara;
								Proyecto.so2 = so;
								Proyecto.tamaño2 = tamaño;
								Proyecto.precio2 = precio;
								break;
							default:
								Proyecto.ram3 = ram;
								Proyecto.almacenamiento3 = almacenamiento;
								Proyecto.camara3 = camara;
								Proyecto.so3 = so;
								Proyecto.tamaño3 = tamaño;
								Proyecto.precio3 = precio;
						} 
						dispose();
					}
				
		
		
		
	
		
	
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s, "PrimaTaxi ® >>> MN-Global ®", 2);
	}
	String leerRam(){
		return txtRam.getText().trim();
	}
	String leerAlmacenamiento(){
		return txtAlmacenamiento.getText().trim();
	}
	String leerCamara(){
		return txtCamara.getText().trim();
	}
	String leerSo(){
		return txtSo.getText().trim();
	}
	String leerTamaño(){
		return txttamao.getText().trim();
	}
	double leerPrecio(){
		return Double.parseDouble(txtprecio.getText().trim());
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
}
