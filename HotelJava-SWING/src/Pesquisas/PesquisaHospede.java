package Pesquisas;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;

import Hotel.Hospede;
import Hotel.Servicos;
import dao.DaoSupplier;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;
import javax.swing.JComboBox;

public class PesquisaHospede extends JInternalFrame {
private JList list;

	public PesquisaHospede() {
		setBounds(100, 100, 839, 336);
		getContentPane().setLayout(null);
		
		
		
		JLabel lblHospedesCadastrados = new JLabel("HOSPEDES CADASTRADOS");
		lblHospedesCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHospedesCadastrados.setBounds(96, 11, 265, 26);
		getContentPane().add(lblHospedesCadastrados);
		
		
		//BOTÃO SAIR
		JLabel lblSAIR = new JLabel("SAIR");
		lblSAIR.setForeground(new Color(128, 0, 0));
		lblSAIR.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSAIR.setBounds(517, 0, 43, 37);
		lblSAIR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sair();
			}
		});
		getContentPane().add(lblSAIR);
		
		Object[] hosp = DaoSupplier.getDaoHospede().findAll().toArray() ;
		JComboBox comboBox = new JComboBox(hosp);
		comboBox.setBounds(10, 71, 743, 26);
		getContentPane().add(comboBox);

	}
	
	
	//===================== CANTO DAS FUNÇÕES =================
	
	//FUNÇÃO VARRER REGISTROS
	
	//FUNÇÃO SAIR
	public void sair() {
		this.doDefaultCloseAction();

	}
}
