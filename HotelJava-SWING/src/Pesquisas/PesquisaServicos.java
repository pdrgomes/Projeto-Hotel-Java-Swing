package Pesquisas;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import Hotel.Hospede;
import Hotel.Servicos;
import dao.DaoSupplier;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;
import javax.swing.JComboBox;

public class PesquisaServicos extends JInternalFrame {
	
	public PesquisaServicos() {
		setBounds(100, 100, 530, 300);
		getContentPane().setLayout(null);
		
		JLabel lblServiosCadastrados = new JLabel("SERVI\u00C7OS CADASTRADOS");
		lblServiosCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblServiosCadastrados.setBounds(46, 11, 238, 35);
		getContentPane().add(lblServiosCadastrados);
		
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
		
		
		Object[] serv = DaoSupplier.getDaoServico().findAll().toArray() ;
		JComboBox comboBox = new JComboBox(serv);
		comboBox.setBounds(24, 75, 446, 20);
		getContentPane().add(comboBox);

	}
	
	//===================== CANTO DAS FUNÇÕES =================
	
	//FUNÇÃO VARRER REGISTROS
	private DefaultListModel<Servicos> loadList() { 
		List<Servicos> serv = DaoSupplier.getDaoServico().findAll();
		DefaultListModel<Servicos> modelo = new DefaultListModel<Servicos>();
		
		for (Servicos servico : serv) {
			modelo.addElement(servico);
		}
		
		return modelo;
	}
	//FUNÇÃO SAIR
	public void sair() {
		this.doDefaultCloseAction();

	}

}
