package Hotel;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Alterar.AlterarHospede;
import Cadastrar.CadastrarCamareira;
import Cadastrar.CadastrarServico;
import Cadastrar.CadastroHospede;
import Cadastrar.CadastroMetodoPagamento;
import Cadastrar.CadastroQuarto;
import Cadastrar.CadastroTipoQuarto;
import Checkout.CamareiraDisponivel;
import Checkout.CamareiraOcupada;
import Checkout.DesignarCamareira;
import Designar.ComprarServico;
import Designar.RegistrarQuarto;
import Pesquisas.PesquisaHospede;
import Pesquisas.PesquisaServicos;
import Pesquisas.PesquisarQuarto;
import Pesquisas.QuartosDisponiveis;
import Pesquisas.QuartosOcupados;
import Relatorio.ExportCsv;
import dao.DaoSupplier;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Event;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hotel extends JFrame {

	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel frame = new Hotel();
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
	public Hotel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 709);
		
		//------------------------------
		//--------BARRA DE MENU-------------
		//------------------------------
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//------------------------------------------------------------------------------
		//--------CADASTROS-------------------------------------------------------------
		//------------------------------------------------------------------------------
		JMenu mnCadastros = new JMenu("Cadastros");
		mnCadastros.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		mnCadastros.setForeground(Color.BLACK);
		menuBar.add(mnCadastros);
		mnCadastros.addSeparator();
		
		
		
		//CADASTRAR METODO DE PAGAMENTO
		JMenuItem mntmCadastrarMtodosDe = new JMenuItem("Cadastrar M\u00E9todos de Pagamento");
		mntmCadastrarMtodosDe.addActionListener(event -> {
			CadastroMetodoPagamento mPagamento = new CadastroMetodoPagamento();
			contentPane.add(mPagamento);
			mPagamento.setVisible(true);
		});
		mnCadastros.add(mntmCadastrarMtodosDe);
		
		//CADASTRAR TIPO DE PAGAMENTO
		JMenuItem mntmCadastrarTipoDe = new JMenuItem("Cadastrar Tipo de Quarto");
		mntmCadastrarTipoDe.addActionListener(event -> {
			CadastroTipoQuarto tQuarto = new CadastroTipoQuarto();
			contentPane.add(tQuarto);
			tQuarto.setVisible(true);
		});
		mnCadastros.add(mntmCadastrarTipoDe);
		
		//CADASTRAR HOSPEDE
				JMenuItem mntmCadastrarHspede = new JMenuItem("Cadastrar H\u00F3spede");
				mntmCadastrarHspede.addActionListener(event -> {
					CadastroHospede cadHospede = new CadastroHospede();
					contentPane.add(cadHospede);
					cadHospede.setVisible(true);
				});
				
				JMenuItem menuItem_1 = new JMenuItem("");
				mnCadastros.add(menuItem_1);
				mnCadastros.add(mntmCadastrarHspede);
		
		//CADASTRAR QUARTO
		JMenuItem mntmCadastrarQuarto = new JMenuItem("Cadastrar Quarto");
		mntmCadastrarQuarto.addActionListener(event -> {
			CadastroQuarto cadQuarto = new CadastroQuarto();
			cadQuarto.setOnClose((item) -> {
				closeInstance(item);
			});
			contentPane.add(cadQuarto);
			cadQuarto.setVisible(true);
			
			
		});;
		mnCadastros.add(mntmCadastrarQuarto);
		
		
		JMenuItem mntmCadastrarCamareira = new JMenuItem("Cadastrar Camareira");
		mntmCadastrarCamareira.addActionListener(event -> {
			CadastrarCamareira cadHospede = new CadastrarCamareira();
			contentPane.add(cadHospede);
			cadHospede.setVisible(true);
		});
		mnCadastros.add(mntmCadastrarCamareira);
		
		
		//CADASTRAR SERVI�OS
		JMenuItem mntmCadastrarServios = new JMenuItem("Cadastrar Servi\u00E7os");
		mntmCadastrarServios.addActionListener(event -> {
			CadastrarServico cadServico = new CadastrarServico();
			cadServico.setOnClose((item) ->{
				closeInstance(item);
			});
			contentPane.add(cadServico);
			cadServico.setVisible(true);
		});
		mnCadastros.add(mntmCadastrarServios);
		
		
		JMenu mAlterar = new JMenu("Alterar");
		mAlterar.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		mAlterar.setForeground(Color.BLACK);
		menuBar.add(mAlterar);
		
		JMenuItem mntmAlterarHospede = new JMenuItem("Alterar Status Hospede");
			mntmAlterarHospede.addActionListener(event -> {
				AlterarHospede altHospede = new AlterarHospede();
				contentPane.add(altHospede);
				altHospede.setVisible(true);
			});
			mAlterar.add(mntmAlterarHospede);
		
		//-------------------------------------------------------------
		//--------DESIGNAR QUARTO--------------------------------------
		//-------------------------------------------------------------
		
		JMenu mnDesignarQuarto = new JMenu("Designar quarto");
		mnDesignarQuarto.setBackground(Color.WHITE);
		mnDesignarQuarto.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		mnDesignarQuarto.setForeground(Color.DARK_GRAY);
		menuBar.add(mnDesignarQuarto);
		
		JMenuItem mntmRegistrarQuarto = new JMenuItem("Registrar quarto");
		mntmRegistrarQuarto.addActionListener(event -> {
			RegistrarQuarto register = new RegistrarQuarto();
			contentPane.add(register);
			register.setVisible(true);
		});
		mnDesignarQuarto.add(mntmRegistrarQuarto);
		
		JMenuItem mntmComprarServios = new JMenuItem("Comprar servi\u00E7os");
		mntmComprarServios.addActionListener(event -> {
			ComprarServico serv = new ComprarServico();
			contentPane.add(serv);
			serv.setVisible(true);
		});
		mnDesignarQuarto.add(mntmComprarServios);
		
		
		//---------------------------------------------------------------------
		//--------PESQUISAR----------------------------------------------------
		//---------------------------------------------------------------------
		
		JMenu mnPesquisar = new JMenu("Pesquisar");
		mnPesquisar.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		mnPesquisar.setForeground(Color.BLACK);
		menuBar.add(mnPesquisar);
		mnPesquisar.addSeparator();
		
		
		//PESQUISAR HOSPEDES CADASTRADOS
		JMenuItem mntmHospedesCadastrados = new JMenuItem("Hospedes Cadastrados");
		mntmHospedesCadastrados.addActionListener(event -> {
			PesquisaHospede register = new PesquisaHospede();
			contentPane.add(register);
			register.setVisible(true);
		});
		mnPesquisar.add(mntmHospedesCadastrados);
		
		
		//PESQUISAR QUARTOS CADASTRADOS
		JMenuItem mntmQuartosCadastrados = new JMenuItem("Quartos Cadastrados");
		mntmQuartosCadastrados.addActionListener(event -> {
			PesquisarQuarto quarto = new PesquisarQuarto();
			contentPane.add(quarto);
			quarto.setVisible(true);
		});
		mnPesquisar.add(mntmQuartosCadastrados);
		
		
		//PESQUISAR SERVI�OS CADASTRADOS
		JMenuItem mntmServiosCadastrados = new JMenuItem("Servi\u00E7os Cadastrados");
		mntmServiosCadastrados.addActionListener(event -> {
			PesquisaServicos serv = new PesquisaServicos();
			contentPane.add(serv);
			serv.setVisible(true);
		});
		mnPesquisar.add(mntmServiosCadastrados);
		
		JMenuItem menuItem = new JMenuItem("");
		mnPesquisar.add(menuItem);
		
		JMenuItem mntmQuartosDisponveis = new JMenuItem("Quartos dispon\u00EDveis");
		mntmQuartosDisponveis.addActionListener(event -> {
			QuartosDisponiveis qrt = new QuartosDisponiveis();
			contentPane.add(qrt);
			qrt.setVisible(true);
		});
		mnPesquisar.add(mntmQuartosDisponveis);
		
		

		//QUARTOS OCUPADOS
		JMenuItem mntmQuartosOcupados = new JMenuItem("Quartos ocupados");
		mntmQuartosOcupados.addActionListener(event -> {
			QuartosOcupados qrt = new QuartosOcupados();
			contentPane.add(qrt);
			qrt.setVisible(true);
		});
		mnPesquisar.add(mntmQuartosOcupados);
		
		
		JMenu mnRelatrio = new JMenu("Relat\u00F3rio");
		mnRelatrio.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		mnRelatrio.setForeground(Color.DARK_GRAY);
		menuBar.add(mnRelatrio);
		
		JMenuItem mntmRelatorioReservas = new JMenuItem("Relatorio de Reservas");
		mntmRelatorioReservas.addActionListener(event -> {
			ExportCsv exp = new ExportCsv();
			contentPane.add(exp);
			exp.setVisible(true);
		});
		mnRelatrio.add(mntmRelatorioReservas);
		
		
		//CHECKOUT
		JMenu mCheckout = new JMenu("Checkout");
		mCheckout.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		mCheckout.setForeground(Color.BLACK);
		menuBar.add(mCheckout);
		
		JMenuItem mntmCamareirasDisponiveis = new JMenuItem("Camareiras Dispon�veis");
		mntmCamareirasDisponiveis.addActionListener(event -> {
			CamareiraDisponivel serv = new CamareiraDisponivel();
			contentPane.add(serv);
			serv.setVisible(true);
		});
		mCheckout.add(mntmCamareirasDisponiveis);
		
		JMenuItem mntmCamareirasOcupadas = new JMenuItem("Camareiras Ocupadas");
		mntmCamareirasOcupadas.addActionListener(event -> {
			CamareiraOcupada serv = new CamareiraOcupada();
			contentPane.add(serv);
			serv.setVisible(true);
		});
		mCheckout.add(mntmCamareirasOcupadas);
		
	
		
		JMenuItem mntmDesignarQuartoCamareira = new JMenuItem("Designar Quarto Camareira");
		mntmDesignarQuartoCamareira.addActionListener(event -> {
			DesignarCamareira DesigCam = new DesignarCamareira();
			contentPane.add(DesigCam);
			DesigCam.setVisible(true);
		});
		mCheckout.add(mntmDesignarQuartoCamareira);
		
		
		
		JMenu mnFinalizar = new JMenu("Finalizar");
		mnFinalizar.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		mnFinalizar.setForeground(Color.BLACK);
		menuBar.add(mnFinalizar);
		
		JMenuItem mntmFecharConta = new JMenuItem("Fechar Conta");
		mnFinalizar.add(mntmFecharConta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

	}

	public void closeInstance(JInternalFrame janela) {
		janela.dispose();
	}
}
