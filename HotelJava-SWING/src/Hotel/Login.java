package Hotel;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ControllerUsuario;

import java.awt.Color;
import java.awt.Button;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Login() {
		List<Usuario> loginUsuario = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 527);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(416, 161, 192, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		Button button = new Button("Login");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Goudy Stout", Font.PLAIN, 14));
		button.setBackground(SystemColor.textHighlight);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hotel menu = new Hotel();
				if(textField.getText().equals("admin") && textField_1.getText().equals("admin")){
				menu.setVisible(true);
				JOptionPane.showMessageDialog(null, "Bem-vindo ao Hotel");
				dispose();
				}
			}
		});
		button.setBounds(489, 301, 119, 47);
		contentPane.add(button);
		
		textField_1 = new JTextField();
		textField_1.setBounds(416, 245, 192, 40);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setForeground(new Color(184, 134, 11));
		lblUsurio.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 22));
		lblUsurio.setBounds(416, 114, 83, 43);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(new Color(184, 134, 11));
		lblSenha.setFont(new Font("Imprint MT Shadow", Font.PLAIN, 22));
		lblSenha.setBounds(416, 209, 78, 43);
		contentPane.add(lblSenha);
		
		JLabel lblSair = new JLabel("SAIR");
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lblSair.setForeground(new Color(204, 0, 0));
		lblSair.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblSair.setBounds(587, 13, 50, 24);
		contentPane.add(lblSair);
		
		JLabel label = new JLabel("");
		label.setBounds(235, 19, 56, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(290, 32, 56, 16);
		contentPane.add(label_1);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(489, 368, 119, 25);
		contentPane.add(btnCadastrar);

		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\pedro.gomes\\Downloads\\Hotelaria\\Hotelaria\\burjarab.jpg"));
		label_2.setBounds(-29, 13, 495, 475);
		contentPane.add(label_2);
		
		


	}

}
