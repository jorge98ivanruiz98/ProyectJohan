package gui;

import java.awt.BorderLayout;
import clase.*;
import arreglo.*;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class RegistroVenta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistroVenta dialog = new RegistroVenta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public RegistroVenta() {
		setTitle("Registro de ventas");
		setBounds(100, 100, 510, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 474, 304);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(txtS);
		listar();
	}
	

	void listar(){
		ArregloVentas ar = new ArregloVentas();
		Ventas v;
		txtS.setText("");
		for(int i = 0;i<ar.tamanio();i++) {
			v = ar.obtener(i);
			imprimir("Codigo    : " + v.getCodigo());
			imprimir("Cantidad  : " + v.getCantidad());
			imprimir("Modelo    : " + v.getModelo());
			imprimir("Precio    : " + v.getPrecio());
			imprimir("Descuento : " + v.descuento());
			imprimir("Total     : " + v.importepagar());
			imprimir("");
			imprimir("-----------------------------------");
		}
	}
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
	
}
