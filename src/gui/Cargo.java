package gui;

import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.EventQueue;
import clase.*;
import arreglo.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class Cargo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JComboBox cboCargo;
	private JLabel lblCargo;
	private JLabel lblSueldo;
	private JButton btnAdicionar;
	private JButton btnModificar;
	private JTable tblTabla;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cargo frame = new Cargo();
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
	ArregloCargos ac = new ArregloCargos();
	ArregloEmpleados ar = new ArregloEmpleados();
	private JTextField txtSueldo;
	public Cargo() {
		setTitle("Cargos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 663, 214);
		contentPane.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 60, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(69, 8, 86, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		cboCargo = new JComboBox();
		cboCargo.addActionListener(this);
		cboCargo.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Limpieza", "Seguridad", "Ventas"}));
		cboCargo.setBounds(273, 8, 109, 20);
		contentPane.add(cboCargo);
		
		lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(226, 11, 60, 14);
		contentPane.add(lblCargo);
		
		lblSueldo = new JLabel("Sueldo");
		lblSueldo.setBounds(428, 11, 67, 14);
		contentPane.add(lblSueldo);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(695, 7, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(695, 36, 89, 23);
		contentPane.add(btnModificar);
		
		modelo = new DefaultTableModel();
		 modelo.addColumn("código");
		 modelo.addColumn("nombre");
		 modelo.addColumn("apellido");
		 modelo.addColumn("DNI");
		 modelo.addColumn("edad");
		 modelo.addColumn("telefono");
		 modelo.addColumn("cargo");
		 modelo.addColumn("sueldo");
		 tblTabla.setModel(modelo);
		 
		 txtSueldo = new JTextField();
		 txtSueldo.setEditable(false);
		 txtSueldo.setBounds(472, 5, 86, 20);
		 contentPane.add(txtSueldo);
		 txtSueldo.setColumns(10);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboCargo) {
			actionPerformedCboCargo(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		
		
		
	}
	void listar(){
		
		modelo.setRowCount(0);
		for(int i = 0;i<ac.tamaño();i++){
			Object[] fila = { ar.obtener(i).getCodigo(),
							  ar.obtener(i).getNombre(),
							  ar.obtener(i).getApellido(),
							  ar.obtener(i).getDni(),
							  ar.obtener(i).getEdad(),
	                  		  ar.obtener(i).getTelefono(),
							  ac.obtener(i).getCargo(),
			                  ac.obtener(i).getSueldo()};
			modelo.addRow(fila);
		}
	}
	String leerCargo(){
		String nombre;
		int posnombre;
		posnombre = cboCargo.getSelectedIndex();
		
		switch (posnombre) {
		case 0:
			return nombre = "";
		case 1:
			return nombre = "Limpieza";
		case 2:
			return nombre = "Seguridad";
		
		default:
			return nombre = "Ventas";
		}
	}
	protected void actionPerformedCboCargo(ActionEvent arg0) {
		int posCombo;
		double sueldo;
		posCombo = cboCargo.getSelectedIndex();
		switch (posCombo) {
		case 0:
		 sueldo = 0.0;
		 break;
		case 1:
			sueldo = 1200;
			break;
		case 2:
			sueldo = 1500;
			break;
		default:
			sueldo = 2000;
			break;
		}
		txtSueldo.setText("" + sueldo);
	}
}
