package Pesquisas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JList;

import Hotel.Quarto;
import Hotel.QuartoDados;
import dao.DaoSupplier;
import javax.swing.JComboBox;


public class QuartosDisponiveis extends JInternalFrame {
	
	private JComboBox comboBox;
	
	public QuartosDisponiveis() {
		setBounds(100, 100, 592, 409);
		getContentPane().setLayout(null);
		
		JLabel lblQuartosOcupados = new JLabel("QUARTOS DISPONÍVEIS");
		lblQuartosOcupados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuartosOcupados.setBounds(174, 11, 245, 39);
		getContentPane().add(lblQuartosOcupados);
		
		JLabel lblSAIR = new JLabel("SAIR");
		lblSAIR.setForeground(new Color(128, 0, 0));
		lblSAIR.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSAIR.setBounds(458, 11, 46, 14);
		lblSAIR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sair();
			}
		});
		getContentPane().add(lblSAIR);
		
		Object[] serv = DaoSupplier.getDaoQuarto().findAllDisponiveis().toArray();
		JComboBox comboBox = new JComboBox(serv);
		comboBox.setBounds(37, 96, 481, 20);
		getContentPane().add(comboBox);
	}
	private DefaultListModel<QuartoDados> loadList() { 
		List<QuartoDados> qrt = DaoSupplier.getDaoRegistrarQuarto().findAll();
		DefaultListModel<QuartoDados> modelo = new DefaultListModel<QuartoDados>();
		
		for (QuartoDados quarto : qrt) {
			modelo.addElement(quarto);
		}
		
		return modelo;
	}
	
	public void sair() {
		this.doDefaultCloseAction();

	}
	
}

