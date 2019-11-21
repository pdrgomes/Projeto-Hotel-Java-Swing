package Pesquisas;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JList;

import Hotel.Quarto;
import Hotel.QuartoDados;
import dao.DaoSupplier;
import javax.swing.JComboBox;


public class QuartosOcupados extends JInternalFrame {
	
	private JComboBox comboBox;
	
	public QuartosOcupados() {
		setBounds(100, 100, 592, 409);
		getContentPane().setLayout(null);
		
		JLabel lblQuartosOcupados = new JLabel("QUARTOS OCUPADOS");
		lblQuartosOcupados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuartosOcupados.setBounds(174, 11, 245, 39);
		getContentPane().add(lblQuartosOcupados);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(107, 98, 312, 20);
		getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(107, 169, 312, 20);
		getContentPane().add(comboBox_1);
	}
	private DefaultListModel<QuartoDados> loadList() { 
		List<QuartoDados> qrt = DaoSupplier.getDaoRegistrarQuarto().findAll();
		DefaultListModel<QuartoDados> modelo = new DefaultListModel<QuartoDados>();
		
		for (QuartoDados quarto : qrt) {
			modelo.addElement(quarto);
		}
		
		return modelo;
	}
	
}

