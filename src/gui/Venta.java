package gui;

import clase.Cliente;

import clase.Ventas;
import arreglo.ArregloCliente;
import arreglo.ArregloVentas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Venta extends JFrame implements ActionListener {
	//Aqui estoy soy ivan
	private static final long serialVersionUID = 1L;
	//soy johan
	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblPrecio;
	private JLabel lblCantidad;
	private JTextField txtCodigo;
	private JTextField txtPrecio;	
	private JTextField txtCantidad;
	private JButton btnAdicionar;	
	private JButton btnReportar;
	private JScrollPane scrollPaneA;
	private JScrollPane scrollPaneB;
	private JTextArea txtS;
	private JTable tblTabla;
	private DefaultTableModel modelo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venta frame = new Venta();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
     String nombre = "";
	/**
	 * Create the frame.
	 */
	public Venta() {
		setTitle("Area Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 11, 40, 28);
		contentPane.add(lblCodigo);
		
		lblPrecio = new JLabel("precio");
		lblPrecio.setBounds(543, 11, 40, 28);
		contentPane.add(lblPrecio);	
		
		lblCantidad = new JLabel("cantidad");
		lblCantidad.setBounds(132, 11, 78, 28);
		contentPane.add(lblCantidad);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(54, 11, 40, 28);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(593, 14, 64, 23);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(192, 11, 40, 28);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(653, 47, 155, 23);
		contentPane.add(btnAdicionar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.setBounds(653, 77, 155, 23);
		btnReportar.addActionListener(this);
		contentPane.add(btnReportar);
		
		scrollPaneA = new JScrollPane();
		scrollPaneA.setBounds(10, 50, 633, 200);
		contentPane.add(scrollPaneA);
		
		tblTabla = new JTable();
		tblTabla.setFillsViewportHeight(true);
		scrollPaneA.setViewportView(tblTabla);

		modelo = new DefaultTableModel();
		modelo.addColumn("N°");
		modelo.addColumn("código");
		modelo.addColumn("nombre");
		modelo.addColumn("apellido");
		modelo.addColumn("Modelo");
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Descuento");
		modelo.addColumn("Subtotal");
		tblTabla.setModel(modelo);
		listar();

		scrollPaneB = new JScrollPane();
		scrollPaneB.setBounds(10, 250, 633, 100);
		contentPane.add(scrollPaneB);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPaneB.setViewportView(txtS);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(274, 18, 46, 14);
		contentPane.add(lblModelo);
		
		cboModelo1 = new JComboBox();
		cboModelo1.addActionListener(this);
		cboModelo1.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "iPhone 12 Pro Max", "Samsung Galaxy S10", "Motorola One Plus", "Xiomi Redmi Note 10"}));
		cboModelo1.setBounds(344, 15, 155, 20);
		contentPane.add(cboModelo1);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(653, 114, 155, 23);
		contentPane.add(btnCerrar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(653, 148, 155, 23);
		contentPane.add(btnEliminar);
		
		listar();		
	}
	
	//  Declaración global
	ArregloVentas aa = new ArregloVentas();
	ArregloCliente ac = new ArregloCliente();
	
	
	
	private JLabel lblModelo;
	private JComboBox cboModelo1;
	private JButton btnCerrar;
	private JButton btnEliminar;

	/** 
	 *           .-------.
     *  .-------.| 456   |
     *  |  123  || Juan  |.-------.
     *  |  Ana  || 15    || 789   |.-------.
     *  |  19   || 14    || Pedro || 302   |
     *  |  15   |'-------'| 17    || David |
     *  '-------'   |     | 19    || 13    |
     *      |        \    '-------'| 18    |
     *      \         |      /     '-------'
     *       \        |     /          /
     *        \ _     |    /    _ _ _ /
     *            \   |   |   / 
     *          .---.---.---.---.---.---.---.---.---.---.
     *     ==>  | @ | @ | @ | @ |   |   |   |   |   |   |
     *          '---'---'---'---'---'---'---'---'---'---'
     *            0   1   2   3   4   5   6   7   8   9
     * 							  ^                 
	 */
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnNewButton(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if (arg0.getSource() == cboModelo1) {
			actionPerformedCboModelo1(arg0);
		}
		if (arg0.getSource() == btnReportar) {
			actionPerformedBtnReportar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
	}

	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
		/**
		 * Envía al método adicionar un nuevo alumno creado
		 */
		
			
		try {
			int codigo = leerCodigo();
			Cliente x = ac.buscar(codigo);
			if(x.getCodigo() != 0){
				String nombre = x.getNombre();
				String apellido = x.getApellido();
				String modelo = leerModelo1();
				if (cboModelo1.getSelectedIndex() >= 1) {
					try {
						int cantidad = leerCantidad();
						double precio = leerPrecio();
						Ventas nuevo = new Ventas(codigo,nombre,apellido, cantidad, modelo, precio);
						aa.adicionar(nuevo);
						listar();
						limpieza();
					} catch (Exception e) {
						error("Ingrese cantidad", txtCantidad);
					}
				} else
					error1("Seleccione un modelo ", cboModelo1);
			} else
				error("el Codigo no existe", txtCodigo);
		} catch (Exception e) {
			error("Ingrese el codigo", txtCodigo);
		}
	}
	protected void actionPerformedBtnReportar(ActionEvent arg0) {
		/**
		 * Muestra la cantidad de alumnos, promedio general
		 * de todos los alumnos y nombre del alumno con el
		 * mayor promedio
		 */
		txtS.setText("");
		imprimir("cantidad de ventas efectuadas :  " + aa.tamanio());
		imprimir("Ganancias Totales : " +  aa.Ganancias());
		imprimir("Nombre " + codigo());
  	}
	//  Métodos tipo void (sin parámetros)
	void imprimir() {
		imprimir("");
	}
	void limpieza() {
		txtCodigo.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
		txtS.setText("");
		txtCodigo.requestFocus();
	}
   	void listar() {
		modelo.setRowCount(0);
		for (int i=0; i<aa.tamanio(); i++) {
			Object[] fila = { i + 1,
							  aa.obtener(i).getCodigo(),
					          aa.obtener(i).getNombre(),
					          aa.obtener(i).getApellido(),
					          aa.obtener(i).getModelo(),
					          aa.obtener(i).getPrecio(),
					          aa.obtener(i).getCantidad(),
					          aa.obtener(i).descuento(),
					          aa.obtener(i).importepagar()};
			
			modelo.addRow(fila);
		}
		}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}		
	//  Métodos que retornan valor (sin parámetros)
	int leerCodigo() {
		return Integer.parseInt(txtCodigo.getText().trim());
	}
	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}
	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText().trim());
	}
	protected void actionPerformedCboModelo1(ActionEvent arg0) {
		int posModelo;
		double precio;
		String nombre;
		posModelo = cboModelo1.getSelectedIndex();
		
		switch (posModelo) {
		case 0:
		       nombre = "";
		       precio = 0;
		    break;
		case 1:
			nombre = "Samsung Galaxy S10";
			precio = Proyecto.precio0;
			break;
		case 2:
			nombre = "iPhone 12 Pro Max";
			precio = Proyecto.precio1;
			break;
        case 3:
        	nombre = "Motorola One Plus";
			precio = Proyecto.precio2;
			break;
        default:
        	nombre = "Xiaomi Redmi Note 10";
			precio = Proyecto.precio3;
	       

	
		}
		txtPrecio.setText("" + precio);
	}
	String leerModelo1(){
		int posModelo;
		double precio;
		String nombre;
		posModelo = cboModelo1.getSelectedIndex();
		
		switch (posModelo) {
		case 1:
			return nombre = "Samsung Galaxy S10";
		case 2:
			return nombre = "iPhone 12 Pro Max";
        case 3:
        	return nombre = "Motorola One Plus";
			
        default:
        	return nombre = "Xiaomi Redmi Note 10";

		
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	void error(String s, JTextField txt) {
		mensaje(s);
		txt.setText("");
		txt.requestFocus();
	}
	void error1(String s, JComboBox cboModelo12) {
		mensaje(s);
		cboModelo12.requestFocus();
	}
	protected void actionPerformedBtnNewButton(ActionEvent arg0) {
		try {
			int codigo = leerCodigo();
			Ventas a = aa.buscar(codigo);
			if (a == null)
				mensaje("el CÓDIGO no existe");
			else {
				aa.Eliminar(a);
				listar();
			}
			limpieza();
		}
		catch (Exception e) {
			error("ingrese CÓDIGO", txtCodigo);
		}
	
	}
	public String codigo(){
		int codigo = leerCodigo();
		String nombre = "";
		Cliente x = ac.buscar(codigo);
		if(x.getCodigo() != 0){
			nombre=x.getNombre();
		}
		return nombre;	
	}
	
}