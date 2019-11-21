package Cadastrar;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Hotel.Evento;
import Hotel.Servicos;
import dao.DaoSupplier;

import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class CadastrarServico extends JInternalFrame {
	private JTextField nomeServico;
	private JTextField preco;
	private Evento onClose;

	public Evento getOnClose() {
		return onClose;
	}

	public void setOnClose(Evento onClose) {
		this.onClose = onClose;
	}

	
	public CadastrarServico() {
		setBounds(100, 100, 452, 356);
		getContentPane().setLayout(null);
		
		JLabel lblCadastrarServio = new JLabel("Cadastrar Servi\u00E7o");
		lblCadastrarServio.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 25));
		lblCadastrarServio.setBounds(97, 13, 294, 36);
		getContentPane().add(lblCadastrarServio);
		
		nomeServico = new JTextField();
		nomeServico.setBounds(138, 88, 197, 23);
		getContentPane().add(nomeServico);
		nomeServico.setColumns(10);
		
		preco = new JTextField();
		preco.setBounds(138, 132, 197, 24);
		getContentPane().add(preco);
		preco.setColumns(10);
		

		
		JLabel lblNomeServio = new JLabel("Nome Servi\u00E7o");
		lblNomeServio.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNomeServio.setBounds(32, 88, 116, 21);
		getContentPane().add(lblNomeServio);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblPreo.setBounds(60, 129, 56, 24);
		getContentPane().add(lblPreo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setBounds(131, 177, 97, 25);
		btnCancelar.addActionListener(item ->{
			sair();
		});
		getContentPane().add(btnCancelar);
		
		
		//BOTÃO INCLUIR
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirDados();
			}
		});
		btnIncluir.setForeground(Color.WHITE);
		btnIncluir.setBackground(new Color(0, 128, 0));
		btnIncluir.setBounds(238, 177, 97, 25);

		getContentPane().add(btnIncluir);
		
		Object[] servicos = DaoSupplier.getDaoServico().findAll().toArray() ;
		JComboBox comboBox = new JComboBox(servicos);
		comboBox.setBounds(32, 266, 359, 20);
		getContentPane().add(comboBox);
		
		JLabel lblServiosJCadastrados = new JLabel("Servi\u00E7os j\u00E1 cadastrados");
		lblServiosJCadastrados.setBounds(32, 241, 152, 14);
		getContentPane().add(lblServiosJCadastrados);
		

	}

	private DefaultListModel<Servicos> loadList() { 
		List<Servicos> servicos = DaoSupplier.getDaoServico().findAll();
		DefaultListModel<Servicos> modelo = new DefaultListModel<Servicos>();
		
		for (Servicos servico : servicos) {
			modelo.addElement(servico);
		}
		
		return modelo;
	}
	public void inserirDados() {
		Servicos serv = new Servicos();
		serv.setNomeServico(nomeServico.getText());
		serv.setPrecoServico(Double.parseDouble(preco.getText()));
		JOptionPane.showMessageDialog(null, "Cadastrado");
		DaoSupplier.getDaoServico().insert(serv);
	}
	public void sair() {
		this.doDefaultCloseAction();

	}

}
