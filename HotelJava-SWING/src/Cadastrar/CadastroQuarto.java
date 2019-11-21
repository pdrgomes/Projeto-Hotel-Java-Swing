package Cadastrar;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Hotel.Evento;
import Hotel.Quarto;
import Hotel.TipoQuarto;
import dao.DaoSupplier;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CadastroQuarto extends JInternalFrame {
	private JTextField numQuarto;
	private JTextField precoQuarto;
	private JList list;
	private JList list_1;
	private JLabel lblNQuarto;
	private JLabel lblPreo;
	private JLabel lblTipo;
	private JButton btnIncluir;
	private JButton btnCancelar;
	private Evento onClose;
	private Evento onOpen;
	private Evento onFinish;	
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JLabel lblQuartosCadastrados;


	public Evento getOnClose() {
		return onClose;
	}

	public void setOnClose(Evento onClose) {
		this.onClose = onClose;
	}

	public Evento getOnOpen() {
		return onOpen;
	}

	public void setOnOpen(Evento onOpen) {
		this.onOpen = onOpen;
	}

	public Evento getOnFinish() {
		return onFinish;
	}

	public void setOnFinish(Evento onFinish) {
		this.onFinish = onFinish;
	}


	public CadastroQuarto() {
		setBounds(100, 100, 442, 331);
		getContentPane().setLayout(null);
		
		JLabel lblCadastrarQuarto = new JLabel("Cadastrar Quarto");
		lblCadastrarQuarto.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 25));
		lblCadastrarQuarto.setBounds(81, 13, 282, 35);
		getContentPane().add(lblCadastrarQuarto);
		
		numQuarto = new JTextField();
		numQuarto.setBounds(17, 97, 78, 20);
		getContentPane().add(numQuarto);
		numQuarto.setColumns(10);	
		
		precoQuarto = new JTextField();
		precoQuarto.setBounds(126, 97, 78, 20);
		getContentPane().add(precoQuarto);
		precoQuarto.setColumns(10);
		
		list = new JList();
		list.setBounds(97, 150, 1, 1);
		getContentPane().add(list);
		
		list_1 = new JList();
		list_1.setBounds(110, 150, 1, 1);
		getContentPane().add(list_1);
		
		lblNQuarto = new JLabel("N\u00BA Quarto");
		lblNQuarto.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblNQuarto.setBounds(17, 70, 94, 27);
		getContentPane().add(lblNQuarto);
		
		lblPreo = new JLabel("Pre\u00E7o");
		lblPreo.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblPreo.setBounds(126, 64, 56, 34);
		getContentPane().add(lblPreo);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		lblTipo.setBounds(224, 67, 56, 28);
		getContentPane().add(lblTipo);
		
		
		//BOTÃO INCLUIR
		btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirDados();
			}
		});
		btnIncluir.setForeground(Color.WHITE);
		btnIncluir.setBackground(new Color(0, 128, 0));
		btnIncluir.setBounds(261, 146, 78, 25);
		getContentPane().add(btnIncluir);
		
		
		//BOTÃO SAIR
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setBounds(151, 146, 100, 25);
		btnCancelar.addActionListener(event -> {
			sair();
		});
		getContentPane().add(btnCancelar);
		
		//COMBOBOX DE TIPO DE QUARTO
		Object[] tipoQuarto = DaoSupplier.getDaoTipoQuarto().findAll().toArray() ;
		comboBox = new JComboBox(tipoQuarto);
		comboBox.setBounds(224, 94, 115, 27);
		getContentPane().add(comboBox);
		
		Object[] quarto = DaoSupplier.getDaoQuarto().findAll().toArray() ;
		comboBox_1 = new JComboBox(quarto);
		comboBox_1.setBounds(17, 221, 369, 27);
		getContentPane().add(comboBox_1);
		
		lblQuartosCadastrados = new JLabel("Quartos cadastrados");
		lblQuartosCadastrados.setBounds(17, 205, 123, 14);
		getContentPane().add(lblQuartosCadastrados);

	}
	private DefaultListModel<Quarto> loadList() { 
		List<Quarto> quartos = DaoSupplier.getDaoQuarto().findAll();
		DefaultListModel<Quarto> modelo = new DefaultListModel<Quarto>();
		
		for (Quarto quarto : quartos) {
			modelo.addElement(quarto);
		}
		
		return modelo;
	}
	
	public void inserirDados() {
		Quarto qrt = new Quarto();
		qrt.setNumQuarto(Integer.parseInt(numQuarto.getText()));
		qrt.setPrecoQuarto(Double.parseDouble(precoQuarto.getText()));
		qrt.setTipoQuarto((TipoQuarto) comboBox.getSelectedItem());
		JOptionPane.showMessageDialog(null, "Cadastrado");
		DaoSupplier.getDaoQuarto().insert(qrt);
	}
	public void sair() {
		this.doDefaultCloseAction();

	}
}
