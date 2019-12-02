package Alterar;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import Hotel.Hospede;
import Hotel.MetodoPagamento;
import Hotel.Quarto;
import Hotel.QuartoDados;
import dao.DaoSupplier;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class AlterarHospede extends JInternalFrame {
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public AlterarHospede() {
		
		
		//NOME
		setBounds(100, 100, 857, 573);
		getContentPane().setLayout(null);
		
		
		JLabel lblNome = new JLabel("Hospede");
		lblNome.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblNome.setBounds(22, 140, 104, 27);
		getContentPane().add(lblNome);
		
		JLabel lblCadastrarHspede = new JLabel("Alterar H\u00F3spede");
		lblCadastrarHspede.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 25));
		lblCadastrarHspede.setBounds(105, 13, 268, 35);
		getContentPane().add(lblCadastrarHspede);
		
		
		//BOTÃO INCLUIR
		JButton btnIncluir = new JButton("ATIVO");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				alterarStatusFalse();
			}
		});
		btnIncluir.setBackground(new Color(0, 128, 0));
		btnIncluir.setForeground(Color.WHITE);
		btnIncluir.setBounds(410, 239, 158, 38);
		getContentPane().add(btnIncluir);
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.addActionListener(event -> {
			sair();
		});
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setBounds(105, 239, 103, 38);
		getContentPane().add(btnCancelar);
		
		
		//COMBOBOX DE TIPO PAGAMENTO
		Object[] hospedeCombo = DaoSupplier.getDaoHospede().findAll().toArray() ;
		comboBox = new JComboBox(hospedeCombo);		
		comboBox.setBounds(136, 141, 699, 31);
		getContentPane().add(comboBox);
		
		JButton button = new JButton("INATIVO");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarStatusTrue();
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 128, 0));
		button.setBounds(608, 239, 158, 38);
		getContentPane().add(button);
		
		
	}
	
	private DefaultListModel<Hospede> loadList() { 
		List<Hospede> hospedes = DaoSupplier.getDaoHospede().findAll();
		DefaultListModel<Hospede> modelo = new DefaultListModel<Hospede>();
		
		for (Hospede hospede : hospedes) {
			modelo.addElement(hospede);
		}
		
		return modelo;
	}
	
	public void sair() {
		//this.dispose();
		this.doDefaultCloseAction();

	}

	
	public void alterarStatusTrue() {
	
		Hospede hosp =  (Hospede) comboBox.getSelectedItem();
		if(hosp.isStatusHospede() == true) {
		DaoSupplier.getDaoHospede().updateFalse(hosp);
		}else {
			JOptionPane.showMessageDialog(null, "Hospede já está inativo");
		}
			
	}
	
	public void alterarStatusFalse() {
		
		Hospede hosp =  (Hospede) comboBox.getSelectedItem();
		if(hosp.isStatusHospede() == false) {
		DaoSupplier.getDaoHospede().update(hosp);
		}else {
			JOptionPane.showMessageDialog(null, "Hospede já está ativo");
		}
			
	}
	
	public void setOnClose(Object object) {
		// TODO Auto-generated method stub
		
	}
}
