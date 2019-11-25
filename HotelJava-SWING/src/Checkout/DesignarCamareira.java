package Checkout;


import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Hotel.Camareira;
import Hotel.CamareiraQuarto;
import Hotel.Hospede;
import Hotel.Quarto;
import Hotel.QuartoDados;
import Hotel.Servicos;
import dao.DaoSupplier;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DesignarCamareira extends JInternalFrame {

	JComboBox comboCamareira;
	JComboBox comboQuarto;
	
		public DesignarCamareira() {
			setBounds(100, 100, 633, 368);
			getContentPane().setLayout(null);
			
			JLabel lblServiosCadastrados = new JLabel("Designar Camareira");
			lblServiosCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblServiosCadastrados.setBounds(24, 10, 238, 35);
			getContentPane().add(lblServiosCadastrados);
			
			JLabel lblSAIR = new JLabel("SAIR");
			lblSAIR.setForeground(new Color(128, 0, 0));
			lblSAIR.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblSAIR.setBounds(565, 11, 46, 14);
			lblSAIR.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					sair();
				}
			});
			getContentPane().add(lblSAIR);
			
			
			Object[] cam = DaoSupplier.getDaoCamareira().findAll().toArray();
			comboCamareira = new JComboBox(cam);
			comboCamareira.setBounds(24, 184, 333, 20);
			getContentPane().add(comboCamareira);
			
			Object[] quarto = DaoSupplier.getDaoQuarto().findAllOcupados().toArray();
			comboQuarto = new JComboBox(quarto);
			comboQuarto.setBounds(24, 102, 546, 20);
			getContentPane().add(comboQuarto);
			
			JLabel label = new JLabel("Quarto");
			label.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
			label.setBounds(24, 76, 150, 16);
			getContentPane().add(label);
			
			JLabel label_1 = new JLabel("Camareira");
			label_1.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
			label_1.setBounds(24, 148, 150, 28);
			getContentPane().add(label_1);
			
			JButton button = new JButton("Cancelar");
			button.setForeground(Color.WHITE);
			button.setBackground(new Color(128, 0, 0));
			button.setBounds(109, 248, 103, 38);
			getContentPane().add(button);
			
			JButton button_1 = new JButton("Incluir");
			button_1.setForeground(Color.WHITE);
			button_1.setBackground(new Color(0, 128, 0));
			button_1.setBounds(242, 248, 103, 38);
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						sair();	
						inserirDados();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			});
			getContentPane().add(button_1);

		}
		
		//===================== CANTO DAS FUNÇÕES =================
		
		
		public void inserirDados() throws InterruptedException {
			CamareiraQuarto CamareiraQrt = new CamareiraQuarto();
			

			CamareiraQrt.setCamareira((Camareira) comboCamareira.getSelectedItem());
			CamareiraQrt.setQuarto((Quarto) comboQuarto.getSelectedItem());
			Thread.sleep(10000);
			CamareiraQrt.setQuartoLimpo(true);
				
			JOptionPane.showMessageDialog(null, "Quarto Nº "+ CamareiraQrt.getQuarto().getNumQuarto() +" está limpo!");
			DaoSupplier.getDaoQuarto().checkout(CamareiraQrt.getQuarto());
			Thread.sleep(10000);
			JOptionPane.showMessageDialog(null, "Quarto Nº "+ CamareiraQrt.getQuarto().getNumQuarto() +" liberado!");
			
			
		}

		//FUNÇÃO SAIR
		public void sair() {
			this.doDefaultCloseAction();

		}
	}


