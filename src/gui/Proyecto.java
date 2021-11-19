package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Proyecto extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar mnProyecto;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenuItem mntmConsultar;
	private JMenuItem mntmModificar;
	private JMenuItem mntmListar;
	private JMenu mnVentas;
	private JMenuItem mntmRealizarVenta;

	/**
	 * Launch the application.
	 */
	
	
	public static String modelo0 = "iPhone 12 Pro Max";
	public static String ram0 = "6 GB";
	public static String almacenamiento0 = "128GB";
	public static String camara0 = "12MP ultra";
	public static String tamaño0 = "5.4'";
	public static String so0 = "iOS 15";
	public static double precio0 = 3500;
	
	public static String modelo1 = "Samsung Galaxy S10";
	public static String ram1 = "6 GB";
	public static String almacenamiento1 = "512GB";
	public static String camara1 = "13MP ultra HD";
	public static String tamaño1 = "6.1'";
	public static String so1 = "Android 9";
	public static double precio1 = 2500;
	
	public static String modelo2 = "Motorola One Plus";
	public static String ram2 = "6 GB";
	public static String almacenamiento2 = "128GB";
	public static String camara2 = "12MP ultra";
	public static String tamaño2 = "6.5'";
	public static String so2 = "android 9";
	public static double precio2 = 1700;
	
	public static String modelo3 = "Xiaomi Redmi Note 10";
	public static String ram3 = "6 GB";
	public static String almacenamiento3 = "128GB";
	public static String camara3 = "48MP ultra";
	public static String tamaño3 = "5.4'";
	public static String so3 = "android 9";
	public static double precio3 = 1100;
	private JMenuItem mntmClientes;
	private JMenuItem mntmEmpleados;
	private JMenu mnRegistros;
	private JMenuItem mntmRegistroDeVentas;
	private JMenuItem mntmEmpleado;
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto frame = new Proyecto();
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
	public Proyecto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		mnProyecto = new JMenuBar();
		setJMenuBar(mnProyecto);
		
		mnArchivo = new JMenu("Archivo");
		mnProyecto.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		mnProyecto.add(mnMantenimiento);
		
		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.addActionListener(this);
		mnMantenimiento.add(mntmConsultar);
		
		mntmModificar = new JMenuItem("Modificar");
		mntmModificar.addActionListener(this);
		mnMantenimiento.add(mntmModificar);
		
		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(this);
		mnMantenimiento.add(mntmListar);
		
		mntmEmpleado = new JMenuItem("Empleado");
		mnMantenimiento.add(mntmEmpleado);
		
		mnVentas = new JMenu("Ventas");
		mnProyecto.add(mnVentas);
		
		mntmRealizarVenta = new JMenuItem("Realizar Venta");
		mntmRealizarVenta.addActionListener(this);
		mnVentas.add(mntmRealizarVenta);
		
		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mnVentas.add(mntmClientes);
		
		mntmEmpleados = new JMenuItem("Empleados");
		mntmEmpleados.addActionListener(this);
		mnVentas.add(mntmEmpleados);
		
		mnRegistros = new JMenu("Registros");
		mnProyecto.add(mnRegistros);
		
		mntmRegistroDeVentas = new JMenuItem("Registro de ventas");
		mntmRegistroDeVentas.addActionListener(this);
		mnRegistros.add(mntmRegistroDeVentas);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmRegistroDeVentas) {
			actionPerformedMntmRegistroDeVentas(arg0);
		}
		if (arg0.getSource() == mntmEmpleados) {
			actionPerformedMntmEmpleados(arg0);
		}
		if (arg0.getSource() == mntmClientes) {
			actionPerformedMntmClientes(arg0);
		}
		if (arg0.getSource() == mntmListar) {
			actionPerformedMntmListar(arg0);
		}
		if (arg0.getSource() == mntmModificar) {
			actionPerformedMntmModificar(arg0);
		}
		if (arg0.getSource() == mntmRealizarVenta) {
			actionPerformedMntmRealizarVenta(arg0);
		}
		if (arg0.getSource() == mntmConsultar) {
			actionPerformedMntmConsultar(arg0);
		}
		
	}
	protected void actionPerformedMntmConsultar(ActionEvent arg0) {
		Consulta v = new Consulta();
		v.setVisible(true);
	}
	protected void actionPerformedMntmRealizarVenta(ActionEvent arg0) {
		Venta a = new Venta();
		a.setVisible(true);
	}
	protected void actionPerformedMntmModificar(ActionEvent arg0) {
		modificar m = new modificar();
		m.setVisible(true);
	}
	protected void actionPerformedMntmListar(ActionEvent arg0) {
		Listar l = new Listar();
		l.setVisible(true);
	}
	protected void actionPerformedMntmClientes(ActionEvent arg0) {
		Clientes c = new Clientes();
		c.setVisible(true);
	}
	protected void actionPerformedMntmEmpleados(ActionEvent arg0) {
		Empleado e = new Empleado();
		e.setVisible(true);
	}
	protected void actionPerformedMntmRegistroDeVentas(ActionEvent arg0) {
		
	}
}
