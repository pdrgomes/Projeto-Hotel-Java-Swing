package Checkout;


import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;

import Hotel.Camareira;
import Hotel.Hospede;
import Hotel.Servicos;
import dao.DaoSupplier;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;
import javax.swing.JComboBox;

public class CamareiraDisponivel extends JInternalFrame {

		public CamareiraDisponivel() {
			setBounds(100, 100, 530, 300);
			getContentPane().setLayout(null);
			
			JLabel lblServiosCadastrados = new JLabel("Camareiras Disponíveis");
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
			
			
			Object[] serv = DaoSupplier.getDaoCamareira().findAllDisponiveis().toArray() ;
			JComboBox comboBox = new JComboBox(serv);
			comboBox.setBounds(24, 75, 446, 20);
			getContentPane().add(comboBox);

		}
		
		//===================== CANTO DAS FUNÇÕES =================
		
		//FUNÇÃO VARRER REGISTROS
		private DefaultListModel<Camareira> loadList() { 
			List<Camareira> cam = DaoSupplier.getDaoCamareira().findAllDisponiveis();
			DefaultListModel<Camareira> modelo = new DefaultListModel<Camareira>();
			
			for (Camareira camareira : cam) {
				modelo.addElement(camareira);
			}
			
			return modelo;
		}
		//FUNÇÃO SAIR
		public void sair() {
			this.doDefaultCloseAction();

		}

	}


