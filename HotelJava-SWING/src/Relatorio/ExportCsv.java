package Relatorio;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap; 

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


import Hotel.Comprar;
import Hotel.QuartoDados;
import Hotel.Servicos;
import dao.DaoSupplier;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExportCsv extends JInternalFrame{

	private File arquivo;
	
	public ExportCsv() {
		setBounds(100, 100, 1520, 414);
		getContentPane().setLayout(null);
		
		JLabel lblServiosCadastrados = new JLabel("Relatório");
		lblServiosCadastrados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblServiosCadastrados.setBounds(24, 10, 238, 35);
		getContentPane().add(lblServiosCadastrados);
		
		JLabel lblSAIR = new JLabel("SAIR");
		lblSAIR.setForeground(new Color(128, 0, 0));
		lblSAIR.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSAIR.setBounds(1452, 10, 46, 14);
		lblSAIR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sair();
			}
		});
		getContentPane().add(lblSAIR);
		
		
		Object[] RegQrt = DaoSupplier.getDaoRegistrarQuarto().findAll().toArray() ;
		JComboBox comboBox = new JComboBox(RegQrt);
		comboBox.setBounds(24, 75, 1436, 20);
		getContentPane().add(comboBox);
		
		JButton btnImportCsv = new JButton("Import CSV");
		btnImportCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnImportCsv.setBounds(24, 135, 121, 21);
		getContentPane().add(btnImportCsv);
		
		JButton btnExportCsv = new JButton("Export CSV");
		btnExportCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				arquivo = new File("C:\\Users\\pedro.gomes\\downloads\\");
				arquivo.mkdir();

				String conteudo = "TESTANDO 1231231312312"; //essa string aqui voce ja tem! eh o q vai ser gravado
				FileWriter fw;
				
				if (arquivo.isDirectory()){
					try {
						fw = new FileWriter("Relatorio.xlsx", false);
						fw.write(conteudo);
						fw.flush();
						fw.close();
						JOptionPane.showMessageDialog(null, "Export efetuado com sucesso!");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
			
				
			}
		});
		btnExportCsv.setBounds(154, 135, 127, 21);
		getContentPane().add(btnExportCsv);

	}
	
	//===================== CANTO DAS FUNÇÕES =================
	public void export() {
		Object[] quartoDados = DaoSupplier.getDaoRegistrarQuarto().findAll().toArray() ;
		List<String> dados = new ArrayList<String>();
		dados.add(quartoDados.toString());

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet ws = wb.createSheet();
		

	}

	//FUNÇÃO SAIR
	public void sair() {
		this.doDefaultCloseAction();

	}
}
