package gui;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import arreglo.ArregloCliente;
import clase.Cliente;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Clientes extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable tbltable;
	private DefaultTableModel modelo;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblEdad;
	private JTextField txtEdad;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Clientes dialog = new Clientes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	ArregloCliente ac = new ArregloCliente();
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblTlf;
	private JTextField txttlf;
	public Clientes() {
		setTitle("Cliente");
		setBounds(100, 100, 802, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 79, 565, 171);
		contentPanel.add(scrollPane);
		
		tbltable = new JTable();
		tbltable.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbltable);
		
		modelo = new DefaultTableModel();
		modelo.addColumn("codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Edad");
		modelo.addColumn("DNI");
		modelo.addColumn("Telefono");
		tbltable.setModel(modelo);
		
		listar();
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 66, 14);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(68, 8, 86, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 42, 97, 14);
		contentPanel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(68, 39, 86, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(173, 42, 72, 14);
		contentPanel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(232, 39, 86, 20);
		contentPanel.add(txtApellido);
		txtApellido.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(345, 42, 46, 14);
		contentPanel.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(381, 39, 86, 20);
		contentPanel.add(txtEdad);
		txtEdad.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(663, 7, 89, 23);
		contentPanel.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(663, 38, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(663, 72, 89, 23);
		contentPanel.add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(663, 106, 89, 23);
		contentPanel.add(btnCerrar);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(171, 11, 46, 14);
		contentPanel.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setBounds(232, 8, 86, 20);
		contentPanel.add(txtDni);
		txtDni.setColumns(10);
		
		lblTlf = new JLabel("tlf");
		lblTlf.setBounds(345, 11, 46, 14);
		contentPanel.add(lblTlf);
		
		txttlf = new JTextField();
		txttlf.setBounds(381, 8, 86, 20);
		contentPanel.add(txttlf);
		txttlf.setColumns(10);
		
		
}
	int leerCodigo(){
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	String leerNombre(){
		return txtNombre.getText().trim();
	}
	String leerApellido(){
		return txtApellido.getText().trim();
	}
	
	int leerEdad(){
	    return Integer.parseInt(txtEdad.getText().trim());
	}
	int leerDni(){
		return Integer.parseInt(txtDni.getText().trim());
	}
	int leerTlf(){
		return Integer.parseInt(txttlf.getText().trim());
	}
	
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}		
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		int codigo = leerCodigo();
		if(ac.buscar(codigo) == null){
			
		
		String nombre = leerNombre();
		String apellido = leerApellido();
		int edad = leerEdad();
		int dni = leerDni();
		int tlf = leerTlf();
		Cliente nuevo = new Cliente(codigo,nombre,apellido,edad, dni ,tlf);
		ac.adicionar(nuevo);
		listar();
		}
		else 
			mensaje("El codigo ya existe");
		limpieza();
	}
	
	void listar(){
		modelo.setRowCount(0);
		for(int i = 0;i<ac.tamaño();i++){
			Object[] fila = { ac.obtener(i).getCodigo(),
					          ac.obtener(i).getNombre(),
			                  ac.obtener(i).getApellido(),
			                  ac.obtener(i).getEdad(),
			                  ac.obtener(i).getDni(),
			                  ac.obtener(i).getTlf()};
			modelo.addRow(fila);
		}
	}
	void limpieza(){
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtEdad.setText("");
		txtDni.setText("");
		txttlf.setText("");
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
		try {
			int codigo = leerCodigo();
			Cliente a = ac.buscar(codigo);
			if (a == null)
				mensaje("el CÓDIGO no existe");
			else {
				ac.eliminar(a);
				listar();
			}
			limpieza();
		}
		catch (Exception e) {
			error("ingrese CÓDIGO", txtCodigo);
		}
	
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
}