package Cadastrar;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

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

public class CadastroHospede extends JInternalFrame {
	private JTextField nomeHospede;
	private JTextField idadeHospede;
	private JTextField telefoneHospede;
	private JTextField emailHospede;
	private JComboBox comboBox;

	/**
	 * Create the frame.
	 */
	public CadastroHospede() {
		
		
		//NOME
		setBounds(100, 100, 857, 573);
		getContentPane().setLayout(null);
		nomeHospede = new JTextField();
		nomeHospede.setBounds(126, 78, 267, 35);
		getContentPane().add(nomeHospede);
		nomeHospede.setColumns(10);

		//IDADE
		idadeHospede = new JTextField();
		idadeHospede.setBounds(126, 126, 267, 35);
		getContentPane().add(idadeHospede);
		idadeHospede.setColumns(10);
		
		//TELEFONE
		telefoneHospede = new JTextField();
		telefoneHospede.setBounds(126, 174, 267, 35);
		getContentPane().add(telefoneHospede);
		telefoneHospede.setColumns(10);
		
		//EMAIL
		emailHospede = new JTextField();
		emailHospede.setBounds(126, 222, 267, 35);
		getContentPane().add(emailHospede);
		emailHospede.setColumns(10);
		
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblNome.setBounds(46, 85, 56, 16);
		getContentPane().add(lblNome);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblIdade.setBounds(46, 133, 56, 16);
		getContentPane().add(lblIdade);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblTelefone.setBounds(42, 181, 72, 16);
		getContentPane().add(lblTelefone);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblEmail.setBounds(46, 229, 56, 16);
		getContentPane().add(lblEmail);
		
		JLabel lblCadastrarHspede = new JLabel("Cadastrar H\u00F3spede");
		lblCadastrarHspede.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 25));
		lblCadastrarHspede.setBounds(105, 13, 268, 35);
		getContentPane().add(lblCadastrarHspede);
		
		JLabel lblMtodo = new JLabel("M\u00E9todo");
		lblMtodo.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblMtodo.setBounds(34, 270, 68, 16);
		getContentPane().add(lblMtodo);
		
		JLabel lblPagamento = new JLabel("Pagamento");
		lblPagamento.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		lblPagamento.setBounds(22, 288, 92, 26);
		getContentPane().add(lblPagamento);
		
		
		//BOTÃO INCLUIR
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 inserirDados();
			}
		});
		btnIncluir.setBackground(new Color(0, 128, 0));
		btnIncluir.setForeground(Color.WHITE);
		btnIncluir.setBounds(267, 329, 103, 38);
		getContentPane().add(btnIncluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.addActionListener(event -> {
			sair();
		});
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setBounds(136, 329, 103, 38);
		getContentPane().add(btnCancelar);
		
		
		//COMBOBOX DE TIPO PAGAMENTO
		Object[] tipoPagamento = DaoSupplier.getDaoMetodoPagamento().findAll().toArray() ;
		comboBox = new JComboBox(tipoPagamento);		
		comboBox.setBounds(126, 270, 113, 31);
		getContentPane().add(comboBox);
		
		Object[] hospedes = DaoSupplier.getDaoHospede().findAll().toArray() ;
		JComboBox comboBox_1 = new JComboBox(hospedes);
		comboBox_1.setBounds(22, 422, 809, 26);
		getContentPane().add(comboBox_1);
		
		JLabel lblHospedesJCadastrados = new JLabel("Hospedes j\u00E1 cadastrados:");
		lblHospedesJCadastrados.setBounds(22, 404, 158, 14);
		getContentPane().add(lblHospedesJCadastrados);
		
		
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
	
	public void inserirDados() {
		Hospede hosp = new Hospede();
		hosp.setNome(nomeHospede.getText());
		hosp.setIdade(Integer.parseInt(idadeHospede.getText()));
		hosp.setTelefone(telefoneHospede.getText());
		hosp.setEmail(emailHospede.getText());
		hosp.setMetPagamento((MetodoPagamento) comboBox.getSelectedItem());
		JOptionPane.showMessageDialog(null, "Cadastrado");
		DaoSupplier.getDaoHospede().insert(hosp);


	}
}
