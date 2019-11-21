package Designar;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class ComprarServico extends JInternalFrame {
	private JTextField idHospede;
	private JTextField idQuarto;
	private JTextField quarto;
	private JTextField valorServico;

	
	public ComprarServico() {
		setBounds(100, 100, 451, 434);
		getContentPane().setLayout(null);
		
		JLabel lblComprarServio = new JLabel("COMPRAR SERVI\u00C7O");
		lblComprarServio.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblComprarServio.setBounds(114, 13, 249, 50);
		getContentPane().add(lblComprarServio);
		
		JLabel lblIdHospede = new JLabel("ID Hospede");
		lblIdHospede.setBounds(23, 76, 76, 40);
		getContentPane().add(lblIdHospede);
		
		idHospede = new JTextField();
		idHospede.setBounds(12, 113, 116, 22);
		getContentPane().add(idHospede);
		idHospede.setColumns(10);
		
		JLabel lblIdQuarto = new JLabel("ID Quarto");
		lblIdQuarto.setBounds(150, 88, 56, 16);
		getContentPane().add(lblIdQuarto);
		
		idQuarto = new JTextField();
		idQuarto.setBounds(150, 113, 116, 22);
		getContentPane().add(idQuarto);
		idQuarto.setColumns(10);
		
		JLabel lblQuarto = new JLabel("Quarto");
		lblQuarto.setBounds(291, 88, 56, 16);
		getContentPane().add(lblQuarto);
		
		quarto = new JTextField();
		quarto.setBounds(291, 113, 116, 22);
		getContentPane().add(quarto);
		quarto.setColumns(10);
		
		JLabel lblTipoServio = new JLabel("Tipo Servi\u00E7o");
		lblTipoServio.setBounds(114, 198, 114, 16);
		getContentPane().add(lblTipoServio);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBackground(new Color(0, 128, 0));
		btnComprar.setForeground(new Color(255, 255, 255));
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnComprar.setBounds(242, 360, 97, 25);
		getContentPane().add(btnComprar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(128, 0, 0));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sair();
			}
		});
		btnCancelar.setBounds(103, 360, 97, 25);
		getContentPane().add(btnCancelar);
		
		JLabel lblValorServio = new JLabel("Valor Servi\u00E7o");
		lblValorServio.setBounds(150, 259, 109, 16);
		getContentPane().add(lblValorServio);
		
		valorServico = new JTextField();
		valorServico.setBounds(150, 278, 116, 22);
		getContentPane().add(valorServico);
		valorServico.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(203, 195, 90, 22);
		getContentPane().add(comboBox);

	}
	public void sair() {
		this.doDefaultCloseAction();

	}
}
