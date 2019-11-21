package Cadastrar;



import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;

import Hotel.TipoQuarto;
import dao.DaoSupplier;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JComboBox;

public class CadastroTipoQuarto extends JInternalFrame {
	private JTextField tipo;


	public CadastroTipoQuarto() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblCadastrarTipoDe = new JLabel("CADASTRAR TIPO DE QUARTO");
		lblCadastrarTipoDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadastrarTipoDe.setBounds(68, 11, 295, 33);
		getContentPane().add(lblCadastrarTipoDe);
		
		tipo = new JTextField();
		tipo.setBounds(150, 87, 190, 23);
		getContentPane().add(tipo);
		tipo.setColumns(10);
		
		JLabel lblTipoDeQuarto = new JLabel("Tipo de quarto");
		lblTipoDeQuarto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoDeQuarto.setBounds(10, 80, 130, 33);
		getContentPane().add(lblTipoDeQuarto);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setBackground(new Color(0, 128, 0));
		btnIncluir.setForeground(new Color(245, 255, 250));
		btnIncluir.setBounds(251, 121, 89, 23);
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirDados();
			}
		});
		getContentPane().add(btnIncluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sair();
			}
		});
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setForeground(new Color(245, 245, 245));
		btnCancelar.setBounds(150, 121, 89, 23);
		getContentPane().add(btnCancelar);
		
		
		Object[] tipoQuarto = DaoSupplier.getDaoTipoQuarto().findAll().toArray() ;
		JComboBox comboBox = new JComboBox(tipoQuarto);
		comboBox.setBounds(28, 186, 306, 20);
		getContentPane().add(comboBox);
		
		JLabel lblTiposDeQuartos = new JLabel("Tipos de Quartos cadastrados:");
		lblTiposDeQuartos.setBounds(29, 171, 210, 14);
		getContentPane().add(lblTiposDeQuartos);

	}
	private DefaultListModel<TipoQuarto> loadList() { 
		List<TipoQuarto> quartos = DaoSupplier.getDaoTipoQuarto().findAll();
		DefaultListModel<TipoQuarto> modelo = new DefaultListModel<TipoQuarto>();
		
		for (TipoQuarto quarto : quartos) {
			modelo.addElement(quarto);
		}
		
		return modelo;
	}
	public void inserirDados() {
		TipoQuarto mPagamento = new TipoQuarto();
		mPagamento.setNome(tipo.getText());
		JOptionPane.showMessageDialog(null, "Cadastrado");
		DaoSupplier.getDaoTipoQuarto().insert(mPagamento);

	}
	public void sair() {
		this.doDefaultCloseAction();

	}

}
