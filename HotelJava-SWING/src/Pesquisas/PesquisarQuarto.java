package Pesquisas;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;

import Hotel.Hospede;
import Hotel.Quarto;
import dao.DaoSupplier;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;
import javax.swing.JComboBox;


public class PesquisarQuarto extends JInternalFrame {
	
	public PesquisarQuarto() {
		setBounds(100, 100, 765, 305);
		getContentPane().setLayout(null);
		
		JLabel lblQuartosCadastrados = new JLabel("QUARTOS CADASTRADOS");
		lblQuartosCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuartosCadastrados.setBounds(56, 11, 240, 30);
		getContentPane().add(lblQuartosCadastrados);
		
		JLabel lblSAIR = new JLabel("SAIR");
		lblSAIR.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSAIR.setForeground(new Color(128, 0, 0));
		lblSAIR.setBounds(697, 11, 46, 14);
		lblSAIR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sair();
			}
		});
		getContentPane().add(lblSAIR);
		
		Object[] quarto = DaoSupplier.getDaoQuarto().findAll().toArray() ;
		JComboBox comboBox = new JComboBox(quarto);
		comboBox.setBounds(31, 76, 619, 20);
		getContentPane().add(comboBox);

	}
	//===================== CANTO DAS FUNÇÕES =================
	
	
	//FUNÇÃO SAIR
	public void sair() {
		this.doDefaultCloseAction();

	}

}
