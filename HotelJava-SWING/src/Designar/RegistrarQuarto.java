package Designar;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Hotel.Evento;
import Hotel.Hospede;
import Hotel.Quarto;
import Hotel.QuartoDados;
import Hotel.TipoQuarto;
import dao.DaoSupplier;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class RegistrarQuarto extends JInternalFrame {
	private JTextField diaria;
	private JTextField valorTotal;
	private Evento onClose;
	private JComboBox comboBox;

	
	public RegistrarQuarto() {
		setBounds(100, 100, 457, 448);
		getContentPane().setLayout(null);
		
		JLabel lblQuarto = new JLabel("Quarto");
		lblQuarto.setBounds(39, 168, 56, 16);
		getContentPane().add(lblQuarto);
		
		
		//DI�RIAS
		JLabel lblDirias = new JLabel("Di\u00E1rias");
		lblDirias.setBounds(204, 245, 56, 16);
		getContentPane().add(lblDirias);
		
		diaria = new JTextField();
		diaria.setBounds(204, 272, 69, 22);
		getContentPane().add(diaria);
		diaria.setColumns(10);
		
		
		//VALOR TOTAL
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setBounds(39, 251, 128, 16);
		getContentPane().add(lblValorTotal);
		
		valorTotal = new JTextField();
		valorTotal.setBounds(39, 272, 116, 22);
		getContentPane().add(valorTotal);
		valorTotal.setColumns(10);
		
		JLabel lblRegistrarQuarto = new JLabel("REGISTRAR QUARTO");
		lblRegistrarQuarto.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblRegistrarQuarto.setBounds(99, 13, 252, 48);
		getContentPane().add(lblRegistrarQuarto);
		
		JButton btnDesignar = new JButton("Designar");
		btnDesignar.setBackground(new Color(0, 128, 0));
		btnDesignar.setForeground(new Color(248, 248, 255));
		btnDesignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirDados();
			}
		});
		btnDesignar.setBounds(223, 357, 97, 25);
		getContentPane().add(btnDesignar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setForeground(new Color(245, 255, 250));
		btnCancelar.setBounds(114, 357, 97, 25);
		getContentPane().add(btnCancelar);
		
		
		//COMBOBOX 
		Object[] tipoQuarto = DaoSupplier.getDaoTipoQuarto().findAll().toArray() ;
		comboBox = new JComboBox(tipoQuarto);
		comboBox.setBounds(39, 186, 328, 22);
		getContentPane().add(comboBox);
		
		Object[] hosp = DaoSupplier.getDaoHospede().findAll().toArray() ;
		JComboBox comboBox_1 = new JComboBox(hosp);
		comboBox_1.setBounds(39, 116, 328, 25);
		getContentPane().add(comboBox_1);
		
		JLabel lblHospede = new JLabel("Hospede");
		lblHospede.setBounds(39, 97, 46, 14);
		getContentPane().add(lblHospede);
		
		

	}
	//FUN��ES

	public Evento getOnClose() {
		return onClose;
	}

	public void setOnClose(Evento onClose) {
		this.onClose = onClose;
	}
	public void sair() {
		//this.dispose();
		this.doDefaultCloseAction();

	}
	private DefaultListModel<Quarto> loadList() { 
		List<Quarto> quartos = DaoSupplier.getDaoQuarto().findAll();
		DefaultListModel<Quarto> modelo = new DefaultListModel<Quarto>();
		
		for (Quarto quarto : quartos) {
			modelo.addElement(quarto);
		}
		
		return modelo;
	}
	public void inserirDados() {
		QuartoDados qrt = new QuartoDados();
		qrt.setTipoQuarto((TipoQuarto) comboBox.getSelectedItem());
		qrt.setDiaria(Integer.parseInt(diaria.getText()));
		qrt.setValor(Double.parseDouble(valorTotal.getText()));
		
		DaoSupplier.getDaoRegistrarQuarto().insert(qrt);
	}
}