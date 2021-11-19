package gui;

import java.awt.BorderLayout;

import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import clase.Empleados;
import arreglo.ArregloEmpleados;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Empleado extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblEdad;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDni;
	private JTextField txtEdad;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JTextField txtTelefono;
	private JLabel lblTlf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Empleado dialog = new Empleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	ArregloEmpleados ae = new ArregloEmpleados();
	public Empleado() {
		setTitle("Empleados");
		setBounds(100, 100, 661, 438);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 508, 287);
		contentPanel.add(scrollPane);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTabla);
		
		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 66, 14);
		contentPanel.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 51, 66, 14);
		contentPanel.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(154, 51, 74, 14);
		contentPanel.add(lblApellido);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(290, 51, 46, 14);
		contentPanel.add(lblDni);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(408, 51, 46, 14);
		contentPanel.add(lblEdad);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(55, 8, 86, 20);
		contentPanel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(55, 48, 86, 20);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(198, 48, 86, 20);
		contentPanel.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(311, 48, 86, 20);
		contentPanel.add(txtDni);
		txtDni.setColumns(10);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(442, 48, 39, 20);
		contentPanel.add(txtEdad);
		txtEdad.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(549, 11, 89, 23);
		contentPanel.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(549, 47, 89, 23);
		contentPanel.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(549, 81, 89, 23);
		contentPanel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(549, 115, 89, 23);
		contentPanel.add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(549, 149, 89, 23);
		contentPanel.add(btnCerrar);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(198, 8, 86, 20);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		lblTlf = new JLabel("Tlf");
		lblTlf.setBounds(162, 11, 46, 14);
		contentPanel.add(lblTlf);
		
		modelo = new DefaultTableModel();
		 modelo.addColumn("código");
		 modelo.addColumn("nombre");
		 modelo.addColumn("apellido");
		 modelo.addColumn("DNI");
		 modelo.addColumn("edad");
		 modelo.addColumn("telefono");
		 tblTabla.setModel(modelo);
		 listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		int codigo = leerCodigo();
		if(ae.buscar(codigo) == null){
			String nombre = leerNombre();
			String apellido = leerApellido();
			int edad = leerEdad();
			String dni = leerDNI();
			String telefono = leerTelefono();
		Empleados nuevo = new Empleados(codigo,nombre,apellido,dni,edad,telefono);	
		ae.adicionar(nuevo);
		listar();
		}
		else 
			mensaje("El codigo ya existe");
		limpieza();
		
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}	
	void listar(){
		modelo.setRowCount(0);
		for(int i = 0;i<ae.tamaño();i++){
			Object[] fila = { ae.obtener(i).getCodigo(),
					          ae.obtener(i).getNombre(),
			                  ae.obtener(i).getApellido(),
			                  ae.obtener(i).getDni(),
			                  ae.obtener(i).getEdad(),
			                  ae.obtener(i).getTelefono()};
			modelo.addRow(fila);
		}
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
	String leerDNI(){
		return txtDni.getText().trim();
	}
	String leerTelefono(){
		return txtTelefono.getText().trim();
	}
	int leerEdad(){
		return Integer.parseInt(txtEdad.getText().trim());
	}
	void limpieza(){
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtEdad.setText("");
		txtDni.setText("");
		txtTelefono.setText("");
	}
}
