package Cadastrar;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import Hotel.Camareira;
import Hotel.Hospede;
import Hotel.MetodoPagamento;
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

public class CadastrarCamareira extends JInternalFrame {
	private JTextField nomeHospede;

	/**
	 * Create the frame.
	 */
	public CadastrarCamareira() {
		
		
		//NOME
		setBounds(100, 100, 857, 573);
		getContentPane().setLayout(null);
		nomeHospede = new JTextField();
		nomeHospede.setBounds(129, 108, 267, 35);
		getContentPane().add(nomeHospede);
		nomeHospede.setColumns(10);
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblNome.setBounds(50, 114, 56, 16);
		getContentPane().add(lblNome);
		
		JLabel lblCadastrarHspede = new JLabel("Cadastrar Camareira");
		lblCadastrarHspede.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 25));
		lblCadastrarHspede.setBounds(105, 13, 268, 35);
		getContentPane().add(lblCadastrarHspede);
		
		
		//BOTÃO INCLUIR
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 inserirDados();
			}
		});
		btnIncluir.setBackground(new Color(0, 128, 0));
		btnIncluir.setForeground(Color.WHITE);
		btnIncluir.setBounds(283, 191, 103, 38);
		getContentPane().add(btnIncluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.addActionListener(event -> {
			sair();
		});
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setBounds(123, 191, 103, 38);
		getContentPane().add(btnCancelar);
		
		

		
		Object[] camareiras = DaoSupplier.getDaoCamareira().findAll().toArray() ;
		JComboBox comboBox_1 = new JComboBox(camareiras);
		comboBox_1.setBounds(10, 313, 809, 26);
		getContentPane().add(comboBox_1);
		
		JLabel lblHospedesJCadastrados = new JLabel("Camareiras já cadastradas");
		lblHospedesJCadastrados.setBounds(10, 281, 158, 14);
		getContentPane().add(lblHospedesJCadastrados);
		
		
	}
	
	private DefaultListModel<Camareira> loadList() { 
		List<Camareira> camareiras = DaoSupplier.getDaoCamareira().findAll();
		DefaultListModel<Camareira> modelo = new DefaultListModel<Camareira>();
		
		for (Camareira camareira : camareiras) {
			modelo.addElement(camareira);
		}
		
		return modelo;
	}
	
	public void sair() {
		//this.dispose();
		this.doDefaultCloseAction();

	}
	
	public void inserirDados() {
		Camareira cam = new Camareira();
		cam.setNome(nomeHospede.getText());
		cam.setDispCamareira(true);
		
		JOptionPane.showMessageDialog(null, "Cadastrado");
		DaoSupplier.getDaoCamareira().insert(cam);


	}
}
