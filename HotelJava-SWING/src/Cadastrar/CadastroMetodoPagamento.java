package Cadastrar;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import Hotel.MetodoPagamento;
import dao.DaoSupplier;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;

public class CadastroMetodoPagamento extends JInternalFrame {
	private JTextField tipo;


	
	public CadastroMetodoPagamento() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblCadastroDeMtodo = new JLabel("CADASTRO DE M\u00C9TODO DE PAGAMENTO");
		lblCadastroDeMtodo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCadastroDeMtodo.setBounds(40, 11, 414, 35);
		getContentPane().add(lblCadastroDeMtodo);
		
		tipo = new JTextField();
		tipo.setBounds(107, 86, 211, 25);
		getContentPane().add(tipo);
		tipo.setColumns(10);
		
		JLabel lblTipoPagamento = new JLabel("Tipo Pagamento");
		lblTipoPagamento.setBounds(10, 91, 110, 14);
		getContentPane().add(lblTipoPagamento);
		
		
		//BOTÃO ADICIONAR
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setBackground(new Color(0, 128, 0));
		btnAdicionar.setForeground(new Color(240, 255, 240));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirDados();
			}
		});
		btnAdicionar.setBounds(228, 122, 90, 23);
		getContentPane().add(btnAdicionar);
		
		
		//BOTÃO CANCELAR
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sair();
			}
		});
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setForeground(new Color(240, 255, 255));
		btnCancelar.setBounds(107, 122, 90, 23);
		getContentPane().add(btnCancelar);
		
		
		Object[] tipoQuarto = DaoSupplier.getDaoMetodoPagamento().findAll().toArray() ;
		JComboBox comboBox = new JComboBox(tipoQuarto);
		comboBox.setBounds(90, 217, 247, 25);
		getContentPane().add(comboBox);
		
		JLabel lblJCadastrados = new JLabel("J\u00E1 cadastrados");
		lblJCadastrados.setBounds(166, 192, 110, 14);
		getContentPane().add(lblJCadastrados);
		
	

	}
	public void inserirDados() {
		MetodoPagamento mPagamento = new MetodoPagamento();
		mPagamento.setNome(tipo.getText());
		JOptionPane.showMessageDialog(null, "Cadastrado");
		DaoSupplier.getDaoMetodoPagamento().insert(mPagamento);
	}
	public void sair() {
		this.doDefaultCloseAction();

	}
}

