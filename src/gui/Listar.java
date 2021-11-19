package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Listar extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JScrollPane scrollPane;
	private JTextArea txtS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Listar dialog = new Listar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Listar() {
		setBounds(100, 100, 454, 416);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(339, 13, 89, 23);
		contentPanel.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 12, 319, 354);
		contentPanel.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.BOLD, 12));
		scrollPane.setViewportView(txtS);
		listar();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		dispose();
	}
	void listar(){
		txtS.setText("");
		imprimir("Modelo            : " + Proyecto.modelo0);
		imprimir("Ram               : " + Proyecto.ram0);
		imprimir("Almacenamiento    : " + Proyecto.almacenamiento0);
		imprimir("Camara            : " + Proyecto.camara0);
		imprimir("Sistema Operativo : " + Proyecto.so0);
		imprimir("Tamaño            : " + Proyecto.tamaño0);
		imprimir("Precio            : S/. " + Proyecto.precio0);
		imprimir("------------------------------------");
		imprimir("");
		imprimir("Modelo            : " + Proyecto.modelo1);
		imprimir("Ram               : " + Proyecto.ram1);
		imprimir("Almacenamiento    : " + Proyecto.almacenamiento1);
		imprimir("Camara            : " + Proyecto.camara1);
		imprimir("Sistema Operativo : " + Proyecto.so1);
		imprimir("Tamaño            : " + Proyecto.tamaño1);
		imprimir("Precio            : S/. " + Proyecto.precio1);
		imprimir("------------------------------------");
		imprimir("");
		imprimir("Modelo            : " + Proyecto.modelo2);
		imprimir("Ram               : " + Proyecto.ram2);
		imprimir("Almacenamiento    : " + Proyecto.almacenamiento2);
		imprimir("Camara            : " + Proyecto.camara2);
		imprimir("Sistema Operativo : " + Proyecto.so2);
		imprimir("Tamaño            : " + Proyecto.tamaño2);
		imprimir("Precio            : S/. " + Proyecto.precio2);
		imprimir("------------------------------------");
		imprimir("");
		imprimir("Modelo            : " + Proyecto.modelo3);
		imprimir("Ram               : " + Proyecto.ram3);
		imprimir("Almacenamiento    : " + Proyecto.almacenamiento3);
		imprimir("Camara            : " + Proyecto.camara3);
		imprimir("Sistema Operativo : " + Proyecto.so3);
		imprimir("Tamaño            : " + Proyecto.tamaño3);
		imprimir("Precio            : S/. " + Proyecto.precio3);
		imprimir("------------------------------------");
		imprimir("");
	}
	void imprimir(String s){
		txtS.append(s + "\n");
	}
}
