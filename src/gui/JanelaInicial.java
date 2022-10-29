package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.TitledBorder;
import formulas.AmplitudeTotal;
import formulas.DesvioPadrao;
import formulas.MediaAritmetica;
import formulas.MediaGeometrica;
import formulas.MediaHarmonica;
import formulas.MediaPonderada;
import formulas.Mediana;
import utilitarios.ColorirObjeto;
import utilitarios.Ordenador;
import java.awt.Color;

public class JanelaInicial extends JFrame{ //Declaração da classe e herança da classe JFrame

	
	//declaração de todos os componentes gráficos e dos arrays para serem utilizados para realizar os cálculos
	private JPanel cartoes,pnMediaAritmetica, pnMediaPonderada, pnMediaGeometrica, pnMediaHarmonica, pnMediana, pnDesvioPadrao,pnAmplitudeTotal,pnBotoes,pnEntradaMediaAritmetica, pnEntradaMediaPonderada, pnEntradaMediana, pnEntradaDesvioPadrao, pnEntradaAmplitudeTotal;
	private CardLayout cl;
	private JButton btMediaPonderada, btMediaAritmetica,btMediana,btDesvioPadrao,btMediaHarmonica, btMediaGeometrica,btAmplitudeTotal,btSair, btnIncluirVetorB,
	btnLimparMediaPonderada,btnLimparMediaGeometrica,btnLimparMediaHarmonica,btnLimparMediana,btnLimparDesvioPadrao,btnLimparAmplitudeTotal;
	private JTextField tfValorMediaAritmetica, tfValorMediana, tfValorDesvioPadrao, tfValorAmplitude,tfResultadoMediaAritmetica, tfResultadoMediana,tfResultadoDesvioPadrao,tfResultadoAmplitude,tfValorVetorA,tfValorVetorB,tfResultadoMediaPonderada,tfValorVetorMediaGeometrica,tfResultadoMediaGeometrica,tfValorMediaHarmonica,tfResultadoMediaHarmonica,tfMediaArit,tfCoeficiente,tfClassificacao;
	private JTextArea taDadosMediaAritmetica, taDadosVetorA, taDadosVetorB, taDadosMediaGeometrica, taDadosMediaHarmonica, taDadosMediana, taDadosDesvioPadrao, taDadosAmplitude;
	private JScrollPane scDadosMediaAritmetica, scDadosVetorA, scDadosVetorB, scDadosVetorMediaGeometrica, scDadosMediaHarmonica, scDadosMediana, scDadosDesvioPadrao, scDadosAmplitude;
	private List<Double> vetorMediaAritmetica, vetorA, vetorB, vetorMediaGeometrica, vetorMediaHarmonica, vetorMediana, vetorDesvioPadrao, vetorAmplitudeTotal;

	public JanelaInicial(){ //Declaração do método construtor
		super("Mega Média"); //Declaração do nome da classe
		setResizable(false); //Desabilitando a opção de maxmizar a janela
		setSize(600,500); //Definindo o tamanho da janela 
		setLocationRelativeTo(null); //Definindo que a janela irá iniciar no centro da tela
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource("img/icon.png")));//Trocando a imagem da Barra de título da janela
		

		/*try {
			javax.swing.UIManager.
			setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); //Alterando o tema da janela
		}catch(Exception e) {
		}*/
		{
			//Alaranjado:
			UIManager.put( "nimbusBase", new Color( 140, 103, 59 ) ); 
			UIManager.put( "nimbusBlueGrey", new Color( 190, 189, 170 ) ); 
			UIManager.put( "control", new Color( 221, 223, 212 ) );

			try {
				for ( LookAndFeelInfo info : UIManager.getInstalledLookAndFeels() ) {
					if ( "Nimbus".equals( info.getName() ) ) {
						UIManager.setLookAndFeel( info.getClassName() );
						break;
					}
				}
			} catch ( UnsupportedLookAndFeelException exc ) {
				exc.printStackTrace();
			} catch ( ClassNotFoundException exc ) {
				exc.printStackTrace();
			} catch ( InstantiationException exc ) {
				exc.printStackTrace();
			} catch ( IllegalAccessException exc ) {
				exc.printStackTrace();
			}

			//		Verde esmeralda: UIManager.put( "nimbusBase", new Color( 59, 140, 47 ) ); UIManager.put( "nimbusBlueGrey", new Color( 170, 190, 184 ) ); UIManager.put( "control", new Color( 214, 223, 220 ) );
			//		Avermelhado:UIManager.put( "nimbusBase", new Color( 140, 42, 42 ) ); UIManager.put( "nimbusBlueGrey", new Color( 190, 167, 167 ) ); UIManager.put( "control", new Color( 223, 215, 214 ) );
			//
			//		Tons de cinza:UIManager.put( "nimbusBase", new Color( 81, 81, 81 ) ); UIManager.put( "nimbusBlueGrey", new Color( 190, 190, 190 ) ); UIManager.put( "control", new Color( 223, 223, 223 ) );
		}

		Container contentPane = getContentPane(); //Componente utilizado para dar suporte aos paineis
		cl = new CardLayout(); //Componente utilizado para poder tabalhar com vários paineis em um mesmo espaço
		cartoes = new JPanel(cl); /*Intanciação de um painel que recebe o componente cardLayout, para ele ser capaz de
		trabalhar com mais de um painel em um mesmo espaço, como um efeito de cartas, com uma sobrepondo a outra*/
		
		pnMediaAritmetica = new JPanel(); //Instanciação do painel que será montado os componentes para fazer a média aritmética
		pnMediaAritmetica.setBorder(new TitledBorder(null, "M\u00E9dia Aritm\u00E9tica", 
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59))); //Definição de borda com título
		pnMediaPonderada = new JPanel();
		pnMediaPonderada.setBorder(new TitledBorder(null, "M\u00E9dia Ponderada", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnMediaGeometrica = new JPanel();
		pnMediaGeometrica.setBorder(new TitledBorder(null, "M\u00E9dia Geom\u00E9trica", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnMediaHarmonica = new JPanel();
		pnMediaHarmonica.setBorder(new TitledBorder(null, "M\u00E9dia Harmônica", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnMediana = new JPanel();
		pnMediana.setBorder(new TitledBorder(null, "Mediana", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnDesvioPadrao = new JPanel();
		pnDesvioPadrao.setBorder(new TitledBorder(null, "Desvio Padrão", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnAmplitudeTotal = new JPanel();
		pnAmplitudeTotal.setBorder(new TitledBorder(null, "Amplitude Total", TitledBorder.CENTER, TitledBorder.TOP, null, null));

		pnBotoes = new JPanel(new GridLayout(19,1)); /*Instanciação do painel que recebe os botões de opções
		utilizando o GridLayout que é utilizado para posicionar automaticamente um abaixo do outro*/

		//// adicionando os paineis no painel card
		cartoes.add(pnMediaAritmetica, "mediaAritmetica");
		cartoes.add(pnMediaPonderada, "mediaPonderada");
		cartoes.add(pnMediaGeometrica, "mediaGeometrica");
		cartoes.add(pnMediaHarmonica, "mediaHarmonica");
		cartoes.add(pnMediana, "mediana");
		cartoes.add(pnDesvioPadrao, "desvioPadrao");
		cartoes.add(pnAmplitudeTotal, "amplitudeTotal");

		/////////////////////////////////////////////////////////////////////////////
		////////// Média Aritmética /////////////////////////////////////////////////
		pnMediaAritmetica.setLayout(null);

		pnEntradaMediaAritmetica = new JPanel();
		pnEntradaMediaAritmetica.setBorder(BorderFactory.createTitledBorder(null, "Entrada de dados", TitledBorder.LEFT, TitledBorder.CENTER));
		pnEntradaMediaAritmetica.setBounds(6, 20, 250, 70);
		pnEntradaMediaAritmetica.setLayout(null);
		pnMediaAritmetica.add(pnEntradaMediaAritmetica);

		JLabel lblInformeValor = new JLabel("Informe Valor");
		lblInformeValor.setBounds(10, 15, 74, 14);
		pnEntradaMediaAritmetica.add(lblInformeValor);

		tfValorMediaAritmetica = new JTextField();
		tfValorMediaAritmetica.setBounds(10, 28, 110, 25);
		pnEntradaMediaAritmetica.add(tfValorMediaAritmetica);
		tfValorMediaAritmetica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularMediaAritmetica();
			}
		});

		JButton btnIncluirMedAritmetica = new JButton("Incluir");
		btnIncluirMedAritmetica.setMnemonic('n');
		btnIncluirMedAritmetica.setBounds(120, 28, 89, 25);
		pnEntradaMediaAritmetica.add(btnIncluirMedAritmetica);
		btnIncluirMedAritmetica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularMediaAritmetica();
			}
		});

		taDadosMediaAritmetica = new JTextArea();
		taDadosMediaAritmetica.setLineWrap(true);
		taDadosMediaAritmetica.setWrapStyleWord(true);
		taDadosMediaAritmetica.setEditable(false);
		taDadosMediaAritmetica.setBackground( ColorirObjeto.corAmarelo() );
		scDadosMediaAritmetica = new JScrollPane(taDadosMediaAritmetica);
		pnMediaAritmetica.add(scDadosMediaAritmetica);
		scDadosMediaAritmetica.setBounds(6, 109, 150, 350);

		JLabel lblValores = new JLabel("Valores");
		lblValores.setBounds(9, 95, 46, 14);
		pnMediaAritmetica.add(lblValores);

		JLabel lblMediaAritmtica = new JLabel("M\u00E9dia Aritm\u00E9tica");
		lblMediaAritmtica.setBounds(177, 95, 92, 14);
		pnMediaAritmetica.add(lblMediaAritmtica);

		tfResultadoMediaAritmetica = new JTextField();
		tfResultadoMediaAritmetica.setBounds(174, 109, 100, 25);
		tfResultadoMediaAritmetica.setBackground( ColorirObjeto.corAmarelo() );
		pnMediaAritmetica.add(tfResultadoMediaAritmetica);
		tfResultadoMediaAritmetica.setEditable(false);

		JButton btnLimparMediaAritmetica = new JButton("Limpar");
		btnLimparMediaAritmetica.setMnemonic('m');
		btnLimparMediaAritmetica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparDados("mediaAritmetica");
			}
		});
		btnLimparMediaAritmetica.setBounds(268, 48, 100, 25);
		pnMediaAritmetica.add(btnLimparMediaAritmetica);

		/////////////////////////////////////////////////////////////////////////////////////////////////
		///////////// Média Ponderada////////////////////////////////////////////////////////////////////
		pnMediaPonderada.setLayout(null);

		pnEntradaMediaPonderada = new JPanel();
		pnEntradaMediaPonderada.setBorder(new TitledBorder(null, "Entrada de dados", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(59, 59, 59)));
		pnEntradaMediaPonderada.setBounds(6, 20, 251, 70);
		pnMediaPonderada.add(pnEntradaMediaPonderada);
		pnEntradaMediaPonderada.setLayout(null);

		JLabel lblValorVetor = new JLabel("Valor Vetor A");
		lblValorVetor.setBounds(9, 15, 76, 16);
		pnEntradaMediaPonderada.add(lblValorVetor);

		JLabel lblValorVetorB = new JLabel("Valor Vetor B");
		lblValorVetorB.setBounds(103, 15, 81, 16);
		pnEntradaMediaPonderada.add(lblValorVetorB);

		tfValorVetorA = new JTextField();
		tfValorVetorA.setBounds(6, 28, 76, 25);
		pnEntradaMediaPonderada.add(tfValorVetorA);
		tfValorVetorA.setColumns(10);
		tfValorVetorA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfValorVetorB.requestFocus();
			}
		});

		tfValorVetorB = new JTextField();
		tfValorVetorB.setBounds(101, 28, 76, 25);
		pnEntradaMediaPonderada.add(tfValorVetorB);
		tfValorVetorB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularMediaPonderada();
			}
		});

		btnIncluirVetorB = new JButton("Incluir");
		btnIncluirVetorB.setBounds(175, 28, 65, 25);
		btnIncluirVetorB.setMnemonic('n');
		pnEntradaMediaPonderada.add(btnIncluirVetorB);
		btnIncluirVetorB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularMediaPonderada();
			}
		});


		taDadosVetorA = new JTextArea();
		taDadosVetorA.setLineWrap(true);
		taDadosVetorA.setWrapStyleWord(true);
		taDadosVetorA.setEditable(false);
		taDadosVetorA.setBackground( ColorirObjeto.corAmarelo() );
		scDadosVetorA = new JScrollPane(taDadosVetorA);
		pnMediaPonderada.add(scDadosVetorA);
		scDadosVetorA.setBounds(6, 109, 150, 350);


		taDadosVetorB = new JTextArea();
		taDadosVetorB.setLocation(0, 103);
		taDadosVetorB.setLineWrap(true);
		taDadosVetorB.setWrapStyleWord(true);
		taDadosVetorB.setEditable(false);
		taDadosVetorB.setBackground( ColorirObjeto.corAmarelo() );
		scDadosVetorB = new JScrollPane(taDadosVetorB);
		pnMediaPonderada.add(scDadosVetorB);
		scDadosVetorB.setBounds(160, 109, 150, 350);

		JLabel lblVetorA = new JLabel("Vetor A (Valor)");
		lblVetorA.setBounds(9, 95, 79, 16);
		pnMediaPonderada.add(lblVetorA);

		JLabel lblVetorB = new JLabel("Vetor B (Peso)");
		lblVetorB.setBounds(163, 95, 79, 16);
		pnMediaPonderada.add(lblVetorB);

		JLabel lblMdiaPonderada = new JLabel("Média Ponderada");
		lblMdiaPonderada.setBounds(316, 95, 105, 16);
		pnMediaPonderada.add(lblMdiaPonderada);

		tfResultadoMediaPonderada = new JTextField();
		tfResultadoMediaPonderada.setEditable(false);
		tfResultadoMediaPonderada.setBackground( ColorirObjeto.corAmarelo() );
		tfResultadoMediaPonderada.setBounds(313, 109, 105, 28);
		pnMediaPonderada.add(tfResultadoMediaPonderada);
		tfResultadoMediaPonderada.setColumns(10);

		btnLimparMediaPonderada = new JButton("Limpar");
		btnLimparMediaPonderada.setMnemonic('m');
		btnLimparMediaPonderada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparDados("mediaPonderada");
			}
		});
		btnLimparMediaPonderada.setBounds(268, 48, 100, 25);
		pnMediaPonderada.add(btnLimparMediaPonderada);

		///////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////// MEDIA GEOMETRICA ///////////////////////////////////////////////////////////

		pnMediaGeometrica.setLayout(null);

		JPanel pnEntradaMediaGeometrica = new JPanel();
		pnEntradaMediaGeometrica.setBorder(new TitledBorder(null, "Entrada de dados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		pnEntradaMediaGeometrica.setBounds(6, 20, 251, 70);
		pnEntradaMediaGeometrica.setLayout(null);
		pnMediaGeometrica.add(pnEntradaMediaGeometrica);

		JLabel lblInformeValor_1 = new JLabel("Informe Valor");
		lblInformeValor_1.setBounds(10, 15, 74, 14);
		pnEntradaMediaGeometrica.add(lblInformeValor_1);

		tfValorVetorMediaGeometrica = new JTextField();
		tfValorVetorMediaGeometrica.setBounds(10, 28, 110, 25);
		pnEntradaMediaGeometrica.add(tfValorVetorMediaGeometrica);
		tfValorVetorMediaGeometrica.setColumns(10);
		tfValorVetorMediaGeometrica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularMediaGeometrica();
			}
		});

		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setMnemonic('n');
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularMediaGeometrica();
			}
		});
		btnIncluir.setBounds(120, 28, 89, 25);
		pnEntradaMediaGeometrica.add(btnIncluir);

		JLabel lblValoresVetorGeometrico = new JLabel("Valores");
		lblValoresVetorGeometrico.setBounds(9, 95, 55, 14);
		pnMediaGeometrica.add(lblValoresVetorGeometrico);

		JLabel lblMdiaGeomtrica = new JLabel("M\u00E9dia Geom\u00E9trica");
		lblMdiaGeomtrica.setBounds(177, 95, 107, 14);
		pnMediaGeometrica.add(lblMdiaGeomtrica);

		taDadosMediaGeometrica = new JTextArea();
		taDadosMediaGeometrica.setLineWrap(true);
		taDadosMediaGeometrica.setWrapStyleWord(true);
		taDadosMediaGeometrica.setEditable(false);
		taDadosMediaGeometrica.setBackground( ColorirObjeto.corAmarelo() );
		scDadosVetorMediaGeometrica = new JScrollPane(taDadosMediaGeometrica);
		pnMediaGeometrica.add(scDadosVetorMediaGeometrica);
		scDadosVetorMediaGeometrica.setBounds(6, 109, 150, 350);

		tfResultadoMediaGeometrica = new JTextField();
		tfResultadoMediaGeometrica.setEditable(false);
		tfResultadoMediaGeometrica.setBackground( ColorirObjeto.corAmarelo() );
		tfResultadoMediaGeometrica.setBounds(174, 109, 122, 25);
		pnMediaGeometrica.add(tfResultadoMediaGeometrica);
		tfResultadoMediaGeometrica.setColumns(10);

		btnLimparMediaGeometrica = new JButton("Limpar");
		btnLimparMediaGeometrica.setMnemonic('m');
		btnLimparMediaGeometrica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparDados("mediaGeometrica");
			}
		});
		btnLimparMediaGeometrica.setBounds(268, 48, 100, 25);
		pnMediaGeometrica.add(btnLimparMediaGeometrica);

		///////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////// MEDIA HARMÔNICA ////////////////////////////////////////////////////////////
		pnMediaHarmonica.setLayout(null);

		JPanel pnEntradaMediaHarmonica = new JPanel();
		pnEntradaMediaHarmonica.setBorder(new TitledBorder(null, "Entrada de dados", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		pnEntradaMediaHarmonica.setBounds(6, 20, 250, 70);
		pnMediaHarmonica.add(pnEntradaMediaHarmonica);
		pnEntradaMediaHarmonica.setLayout(null);

		tfValorMediaHarmonica = new JTextField();
		tfValorMediaHarmonica.setBounds(10, 28, 110, 25);
		pnEntradaMediaHarmonica.add(tfValorMediaHarmonica);
		tfValorMediaHarmonica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularMediaHarmonica();
			}
		});

		JButton btIncluirMediaHarmonica = new JButton("Incluir");
		btIncluirMediaHarmonica.setMnemonic('n');
		btIncluirMediaHarmonica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularMediaHarmonica();
			}
		});
		btIncluirMediaHarmonica.setBounds(120, 28, 89, 25);
		pnEntradaMediaHarmonica.add(btIncluirMediaHarmonica);

		JLabel lblInformeValorMediaHarmonica = new JLabel("Informe Valor");
		lblInformeValorMediaHarmonica.setBounds(10, 15, 74, 14);
		pnEntradaMediaHarmonica.add(lblInformeValorMediaHarmonica);

		JLabel lblValoresVetorMediaHarmonica = new JLabel("Valores");
		lblValoresVetorMediaHarmonica.setBounds(9, 95, 55, 14);
		pnMediaHarmonica.add(lblValoresVetorMediaHarmonica);

		taDadosMediaHarmonica = new JTextArea();
		taDadosMediaHarmonica.setLineWrap(true);
		taDadosMediaHarmonica.setWrapStyleWord(true);
		taDadosMediaHarmonica.setEditable(false);
		taDadosMediaHarmonica.setBackground( ColorirObjeto.corAmarelo() );
		scDadosMediaHarmonica = new JScrollPane(taDadosMediaHarmonica);
		pnMediaHarmonica.add(scDadosMediaHarmonica);
		scDadosMediaHarmonica.setBounds(6, 109, 150, 350);

		JLabel lblMdiaHarmonica = new JLabel("M\u00E9dia Harm\u00F4nica");
		lblMdiaHarmonica.setBounds(177, 95, 97, 14);
		pnMediaHarmonica.add(lblMdiaHarmonica);

		tfResultadoMediaHarmonica = new JTextField();
		tfResultadoMediaHarmonica.setEditable(false);
		tfResultadoMediaHarmonica.setBackground( ColorirObjeto.corAmarelo() );
		tfResultadoMediaHarmonica.setBounds(176, 109, 100, 25);
		pnMediaHarmonica.add(tfResultadoMediaHarmonica);
		tfResultadoMediaHarmonica.setColumns(10);

		btnLimparMediaHarmonica = new JButton("Limpar");
		btnLimparMediaHarmonica.setMnemonic('m');
		btnLimparMediaHarmonica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparDados("mediaHarmonica");
			}
		});
		btnLimparMediaHarmonica.setBounds(268, 48, 100, 25);
		pnMediaHarmonica.add(btnLimparMediaHarmonica);

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////// MEDIANA //////////////////////////////////////////////////////////////////////////////
		pnMediana.setLayout(null);

		pnEntradaMediana = new JPanel();
		pnEntradaMediana.setBorder(BorderFactory.createTitledBorder(null, "Entrada de dados", TitledBorder.LEFT, TitledBorder.CENTER));
		pnEntradaMediana.setBounds(6, 20, 250, 70);
		pnEntradaMediana.setLayout(null);
		pnMediana.add(pnEntradaMediana);

		JLabel lblInformeValorMediana = new JLabel("Informe Valor");
		lblInformeValorMediana.setBounds(10, 15, 74, 14);
		pnEntradaMediana.add(lblInformeValorMediana);

		tfValorMediana = new JTextField();
		tfValorMediana.setBounds(10, 28, 110, 25);
		pnEntradaMediana.add(tfValorMediana);
		tfValorMediana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularMediana();
			}
		});

		JButton btnIncluirMediana = new JButton("Incluir");
		btnIncluirMediana.setMnemonic('n');
		btnIncluirMediana.setBounds(120, 28, 89, 25);
		pnEntradaMediana.add(btnIncluirMediana);
		btnIncluirMediana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularMediana();
			}
		});

		taDadosMediana = new JTextArea();
		taDadosMediana.setLineWrap(true);
		taDadosMediana.setWrapStyleWord(true);
		taDadosMediana.setEditable(false);
		taDadosMediana.setBackground( ColorirObjeto.corAmarelo() );
		scDadosMediana = new JScrollPane(taDadosMediana);
		pnMediana.add(scDadosMediana);
		scDadosMediana.setBounds(6, 109, 150, 350);

		JLabel lblValoresMediana = new JLabel("Valores");
		lblValoresMediana.setBounds(9, 95, 46, 14);
		pnMediana.add(lblValoresMediana);

		JLabel lblMediana = new JLabel("Mediana");
		lblMediana.setBounds(177, 95, 92, 14);
		pnMediana.add(lblMediana);

		tfResultadoMediana = new JTextField();
		tfResultadoMediana.setEditable(false);
		tfResultadoMediana.setBackground( ColorirObjeto.corAmarelo() );
		tfResultadoMediana.setBounds(174, 109, 100, 25);
		pnMediana.add(tfResultadoMediana);

		btnLimparMediana = new JButton("Limpar");
		btnLimparMediana.setMnemonic('m');
		btnLimparMediana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparDados("mediana");
			}
		});
		btnLimparMediana.setBounds(268, 48, 100, 25);
		pnMediana.add(btnLimparMediana);

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////// DESVIO PADRAO /////////////////////////////////////////////////////////////////////////////////
		pnDesvioPadrao.setLayout(null);

		pnEntradaDesvioPadrao = new JPanel();
		pnEntradaDesvioPadrao.setBorder(BorderFactory.createTitledBorder(null, "Entrada de dados", TitledBorder.LEFT, TitledBorder.CENTER));
		pnEntradaDesvioPadrao.setBounds(6, 20, 250, 70);
		pnEntradaDesvioPadrao.setLayout(null);
		pnDesvioPadrao.add(pnEntradaDesvioPadrao);

		JLabel lblValorDesvioPadrao = new JLabel("Informe Valor");
		lblValorDesvioPadrao.setBounds(10, 15, 74, 14);
		pnEntradaDesvioPadrao.add(lblValorDesvioPadrao);

		tfValorDesvioPadrao = new JTextField();
		tfValorDesvioPadrao.setBounds(10, 28, 110, 25);
		pnEntradaDesvioPadrao.add(tfValorDesvioPadrao);
		tfValorDesvioPadrao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularDesvioPadrao();
			}
		});

		JButton btnIncluirDesvioPadrao = new JButton("Incluir");
		btnIncluirDesvioPadrao.setMnemonic('n');
		btnIncluirDesvioPadrao.setBounds(120, 28, 89, 25);
		pnEntradaDesvioPadrao.add(btnIncluirDesvioPadrao);
		btnIncluirDesvioPadrao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularDesvioPadrao();
			}
		});

		taDadosDesvioPadrao = new JTextArea();
		taDadosDesvioPadrao.setLineWrap(true);
		taDadosDesvioPadrao.setWrapStyleWord(true);
		taDadosDesvioPadrao.setEditable(false);
		taDadosDesvioPadrao.setBackground( ColorirObjeto.corAmarelo() );
		scDadosDesvioPadrao = new JScrollPane(taDadosDesvioPadrao);
		pnDesvioPadrao.add(scDadosDesvioPadrao);
		scDadosDesvioPadrao.setBounds(6, 109, 150, 350);

		JLabel lblValoresDesvioPadrao = new JLabel("Valores");
		lblValoresDesvioPadrao.setBounds(9, 95, 46, 14);
		pnDesvioPadrao.add(lblValoresDesvioPadrao);

		JLabel lblDesvioPadrao = new JLabel("Desvio Padrão");
		lblDesvioPadrao.setBounds(171, 146, 92, 14);
		pnDesvioPadrao.add(lblDesvioPadrao);

		tfResultadoDesvioPadrao = new JTextField();
		tfResultadoDesvioPadrao.setEditable(false);
		tfResultadoDesvioPadrao.setBackground( ColorirObjeto.corAmarelo() );
		tfResultadoDesvioPadrao.setBounds(168, 160, 100, 25);
		pnDesvioPadrao.add(tfResultadoDesvioPadrao);

		JLabel lblMediaArit = new JLabel("M\u00E9dia Aritm\u00E9tica");
		lblMediaArit.setBounds(177, 95, 92, 14);
		pnDesvioPadrao.add(lblMediaArit);

		tfMediaArit = new JTextField();
		tfMediaArit.setBounds(174, 109, 100, 25);
		pnDesvioPadrao.add(tfMediaArit);
		tfMediaArit.setColumns(10);

		JButton btnRecuperarMedia = new JButton("Resgatar");
		btnRecuperarMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tfMediaArit.setText(  tfResultadoMediaAritmetica.getText() );
			}
		});
		btnRecuperarMedia.setBounds(280, 109, 100, 25);
		pnDesvioPadrao.add(btnRecuperarMedia);

		JLabel lblCoeficienteDeVariao = new JLabel("Coeficiente de Varia\u00E7\u00E3o");
		lblCoeficienteDeVariao.setBounds(171, 220, 130, 16);
		pnDesvioPadrao.add(lblCoeficienteDeVariao);

		tfCoeficiente = new JTextField();
		tfCoeficiente.setEditable(false);
		tfCoeficiente.setBackground( ColorirObjeto.corAmarelo() );
		tfCoeficiente.setBounds(168, 233, 137, 25);
		pnDesvioPadrao.add(tfCoeficiente);
		tfCoeficiente.setColumns(10);

		JLabel lblClassificacao = new JLabel("Classifica\u00E7\u00E3o");
		lblClassificacao.setBounds(171, 270, 92, 16);
		pnDesvioPadrao.add(lblClassificacao);

		tfClassificacao = new JTextField();
		tfClassificacao.setEditable(false);
		tfClassificacao.setBackground( ColorirObjeto.corAmarelo() );
		tfClassificacao.setBounds(168, 285, 137, 25);
		pnDesvioPadrao.add(tfClassificacao);
		tfClassificacao.setColumns(10);

		btnLimparDesvioPadrao = new JButton("Limpar");
		btnLimparDesvioPadrao.setMnemonic('m');
		btnLimparDesvioPadrao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparDados("desvioPadrao");
			}
		});
		btnLimparDesvioPadrao.setBounds(268, 48, 100, 25);
		pnDesvioPadrao.add(btnLimparDesvioPadrao);

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////// AMPLITUDE TOTAL /////////////////////////////////////////////////////////////////////////
		pnAmplitudeTotal.setLayout(null);

		pnEntradaAmplitudeTotal = new JPanel();
		pnEntradaAmplitudeTotal.setBorder(BorderFactory.createTitledBorder(null, "Entrada de dados", TitledBorder.LEFT, TitledBorder.CENTER));
		pnEntradaAmplitudeTotal.setBounds(6, 20, 250, 70);
		pnEntradaAmplitudeTotal.setLayout(null);
		pnAmplitudeTotal.add(pnEntradaAmplitudeTotal);

		JLabel lblInformeAmplitude = new JLabel("Informe Valor");
		lblInformeAmplitude.setBounds(10, 15, 74, 14);
		pnEntradaAmplitudeTotal.add(lblInformeAmplitude);

		tfValorAmplitude = new JTextField();
		tfValorAmplitude.setBounds(10, 28, 110, 25);
		pnEntradaAmplitudeTotal.add(tfValorAmplitude);
		tfValorAmplitude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularAmplitudeTotal();
			}
		});

		JButton btnIncluirAmplitude = new JButton("Incluir");
		btnIncluirAmplitude.setMnemonic('n');
		btnIncluirAmplitude.setBounds(120, 28, 89, 25);
		pnEntradaAmplitudeTotal.add(btnIncluirAmplitude);
		btnIncluirAmplitude.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calcularAmplitudeTotal();
			}
		});

		taDadosAmplitude = new JTextArea();
		taDadosAmplitude.setLineWrap(true);
		taDadosAmplitude.setWrapStyleWord(true);
		taDadosAmplitude.setEditable(false);
		taDadosAmplitude.setBackground( ColorirObjeto.corAmarelo() );
		scDadosAmplitude = new JScrollPane(taDadosAmplitude);
		pnAmplitudeTotal.add(scDadosAmplitude);
		scDadosAmplitude.setBounds(6, 109, 150, 350);

		JLabel lblValoresAmplitude = new JLabel("Valores");
		lblValoresAmplitude.setBounds(9, 95, 46, 14);
		pnAmplitudeTotal.add(lblValoresAmplitude);

		JLabel lblAmplitudeTotal = new JLabel("Amplitude Total");
		lblAmplitudeTotal.setBounds(177, 95, 92, 14);
		pnAmplitudeTotal.add(lblAmplitudeTotal);

		tfResultadoAmplitude = new JTextField();
		tfResultadoAmplitude.setEditable(false);
		tfResultadoAmplitude.setBackground( ColorirObjeto.corAmarelo() );
		tfResultadoAmplitude.setBounds(174, 109, 100, 25);
		pnAmplitudeTotal.add(tfResultadoAmplitude);

		btnLimparAmplitudeTotal = new JButton("Limpar");
		btnLimparAmplitudeTotal.setMnemonic('m');
		btnLimparAmplitudeTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limparDados("aplitudeTotal");
			}
		});
		btnLimparAmplitudeTotal.setBounds(268, 48, 100, 25);
		pnAmplitudeTotal.add(btnLimparAmplitudeTotal);

		//////////////////////////////////////////////////////////////////////////////////////////		
		////////////MENU LATERAL////////////////////////////////////////////////////////////////////////////////

		pnBotoes.setBorder(BorderFactory.createTitledBorder(null, "Opções", TitledBorder.CENTER, TitledBorder.CENTER));

		btMediaAritmetica = new JButton("Média Aritmética");
		pnBotoes.add(btMediaAritmetica);
		btMediaAritmetica.setMnemonic('i');

		btMediaPonderada = new JButton("Média Ponderada");
		btMediaPonderada.setMnemonic('o');
		pnBotoes.add(btMediaPonderada);

		btMediaGeometrica = new JButton("Média Geométrica");
		btMediaGeometrica.setMnemonic('t');
		pnBotoes.add(btMediaGeometrica);

		btMediaHarmonica = new JButton("Média Harmônica");
		btMediaHarmonica.setMnemonic('r');
		pnBotoes.add(btMediaHarmonica);

		btMediana = new JButton("Mediana");
		btMediana.setMnemonic('d');
		pnBotoes.add(btMediana);

		btDesvioPadrao = new JButton("Desvio Padrão");
		btDesvioPadrao.setMnemonic('v');
		pnBotoes.add(btDesvioPadrao);

		btAmplitudeTotal = new JButton("Amplitude Total");
		btAmplitudeTotal.setMnemonic('u');
		pnBotoes.add(btAmplitudeTotal);

		btSair = new JButton("Sair");
		btSair.setMnemonic('a');
		pnBotoes.add(btSair);

		///////////////////////////////////////////////////////////////////////////////
		///// Adicionando paineis no container
		contentPane.add(pnBotoes, BorderLayout.WEST);
		contentPane.add(cartoes, BorderLayout.CENTER);

		////////////////////////////////////////////////////////////////////////////////
		/////////////// Eventos dos botões/////////////////////////////////////////////
		btMediaAritmetica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(cartoes,"mediaAritmetica");
			}
		});

		btMediaPonderada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(cartoes,"mediaPonderada");
			}
		});

		btMediaGeometrica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(cartoes, "mediaGeometrica");
			}
		});

		btMediaHarmonica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(cartoes, "mediaHarmonica");
			}
		});

		btMediana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(cartoes,"mediana");
			}
		});

		btDesvioPadrao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(cartoes,"desvioPadrao");
			}
		});

		btAmplitudeTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(cartoes,"amplitudeTotal");
			}
		});

		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] opcoes = new String[] {"Sim", "Não"}; 

				int result = JOptionPane.showOptionDialog(null,"Deseja sair do Mega Média?","Atenção!",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,null,opcoes,opcoes[0]);

				if (result == 0) {
					System.exit(0);
				}
			}
		});

		cl.show(cartoes, "mediaAritmetica"); //Define qual o painel que irá iniciar primeiro

		setVisible(true); //Definindo a janela visível
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Definindo que o processo será encerrado ao fechar a aplicação
	}

	/*
	 * Método para zerar o vetor e os campos de resultados
	 * para poder fazer novos calculos
	 */
	private void limparDados(String media){
		if(media.equals("mediaAritmetica")){
			tfResultadoMediaAritmetica.setText("");
			taDadosMediaAritmetica.setText("");
			vetorMediaAritmetica.clear();
		}else if(media.equals("mediaPonderada")){
			tfResultadoMediaPonderada.setText("");
			taDadosVetorA.setText("");
			taDadosVetorB.setText("");
			vetorA.clear();
			vetorB.clear();
		}else if(media.equals("mediaGeometrica")){
			tfResultadoMediaGeometrica.setText("");
			taDadosMediaGeometrica.setText("");
			vetorMediaGeometrica.clear();
		}else if(media.equals("mediaHarmonica")){
			tfResultadoMediaHarmonica.setText("");
			taDadosMediaHarmonica.setText("");
			vetorMediaHarmonica.clear();
		}else if(media.equals("mediana")){
			tfResultadoMediana.setText("");
			taDadosMediana.setText("");
			vetorMediana.clear();
		}else if(media.equals("desvioPadrao")){
			tfResultadoDesvioPadrao.setText("");
			taDadosDesvioPadrao.setText("");
			tfCoeficiente.setText("");
			tfClassificacao.setText("");
			tfMediaArit.setText("");
			vetorDesvioPadrao.clear();
		}else if(media.equals("amplitudeTotal")){
			tfResultadoAmplitude.setText("");
			taDadosAmplitude.setText("");
			vetorAmplitudeTotal.clear();
		}
	}

	private void calcularAmplitudeTotal(){
		if(tfValorAmplitude.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Informe um valor!","Atenção!", JOptionPane.WARNING_MESSAGE);
		}else{
			AmplitudeTotal.setValor( Double.parseDouble( tfValorAmplitude.getText().replace(',', '.')  ));
			apresentarDadosAmplitudeTotal();
			tfValorAmplitude.setText("");
		}
	}

	private void apresentarDadosAmplitudeTotal(){
		vetorAmplitudeTotal = AmplitudeTotal.getValores();
		StringBuilder valores = new StringBuilder();

		for(int i=0;i<vetorAmplitudeTotal.size();i++){
			valores.append("Valor  " + (i + 1) + ": " + vetorAmplitudeTotal.get(i).toString() + "\n" );
		}

		taDadosAmplitude.setText( valores.toString() );
		tfResultadoAmplitude.setText( AmplitudeTotal.getAmplitudeTotal().toString() );
	}

	private void calcularDesvioPadrao(){
		if(tfValorDesvioPadrao.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Informe um valor!","Atenção!", JOptionPane.WARNING_MESSAGE);
		}else if(tfMediaArit.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Informe a média aritmética!","Atenção!", JOptionPane.WARNING_MESSAGE);
		}else{
			DesvioPadrao.setValor( Double.parseDouble( tfValorDesvioPadrao.getText().replace(',', '.')  ) );
			apresentarDadosDesvioPadrao();
			tfValorDesvioPadrao.setText("");
		}
	}

	private void apresentarDadosDesvioPadrao(){
		vetorDesvioPadrao = DesvioPadrao.getValores();
		StringBuilder valores = new StringBuilder();

		for(int i=0;i<vetorDesvioPadrao.size();i++){
			valores.append("Valor  " + (i + 1) + ": " + vetorDesvioPadrao.get(i).toString() + "\n" );
		}
		taDadosDesvioPadrao.setText(valores.toString());
		tfResultadoDesvioPadrao.setText( DesvioPadrao.getDesvioPadrao(Double.parseDouble(tfMediaArit.getText())).toString() );

		calcularCoeficienteDeVariacao();
	}

	private void calcularCoeficienteDeVariacao(){
		Double coeficiente = ( Double.parseDouble( tfResultadoDesvioPadrao.getText() )  / Double.parseDouble(tfMediaArit.getText()) ) * 100;
		coeficiente = Ordenador.arredondar(coeficiente);

		tfCoeficiente.setText(coeficiente + " %");

		if(coeficiente < 16){
			tfClassificacao.setText("Baixa Dispersão");
		}else if(coeficiente > 15 || coeficiente < 31){
			tfClassificacao.setText("Média Dispersão");
		}else if(coeficiente > 30){
			tfClassificacao.setText("Alta Dispersão");
		}
	}

	private void calcularMediana(){
		if(tfValorMediana.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Informe um valor!","Atenção!", JOptionPane.WARNING_MESSAGE);
		}else{
			Mediana.setValor( Double.parseDouble(tfValorMediana.getText().replace(',', '.') ));
			apresentarDadosMediana();
			tfValorMediana.setText("");
		}
	}

	private void apresentarDadosMediana(){
		vetorMediana = Mediana.getValores();
		StringBuilder valores = new StringBuilder();

		for(int i=0;i<vetorMediana.size();i++){
			valores.append("Valor  " + (i + 1) + ": " + vetorMediana.get(i).toString() + "\n" );
		}
		taDadosMediana.setText(valores.toString());
		tfResultadoMediana.setText( Mediana.getMediana().toString() );
	}

	private void calcularMediaHarmonica(){
		if(tfValorMediaHarmonica.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Informe um valor!","Atenção!", JOptionPane.WARNING_MESSAGE);
		}else{
			MediaHarmonica.setValor( Double.parseDouble(tfValorMediaHarmonica.getText().replace(',', '.') ));
			apresentarDadosMediaHarmonica();
			tfValorMediaHarmonica.setText("");
		}
	}

	private void apresentarDadosMediaHarmonica(){
		vetorMediaHarmonica = MediaHarmonica.getValores();
		StringBuilder valores = new StringBuilder();

		for(int i=0;i<vetorMediaHarmonica.size();i++){
			valores.append("Valor  " + (i + 1) + ": " + vetorMediaHarmonica.get(i).toString() + "\n" );
		}
		taDadosMediaHarmonica.setText(valores.toString());
		tfResultadoMediaHarmonica.setText( MediaHarmonica.getMediaHarmonica().toString() );
	}

	private void calcularMediaGeometrica(){
		if(tfValorVetorMediaGeometrica.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Informe um valor!","Atenção!", JOptionPane.WARNING_MESSAGE);
		}else{
			MediaGeometrica.setValor( Double.parseDouble( tfValorVetorMediaGeometrica.getText().replace(',', '.') ));
			apresentarDadosMediaGeometrica();
			tfValorVetorMediaGeometrica.setText("");
		}
	}

	private void apresentarDadosMediaGeometrica(){
		vetorMediaGeometrica = MediaGeometrica.getValores();
		StringBuilder valores = new StringBuilder();

		for(int i=0;i<vetorMediaGeometrica.size();i++){
			valores.append("Valor  " + (i + 1) + ": " + vetorMediaGeometrica.get(i).toString() + "\n" );
		}
		taDadosMediaGeometrica.setText(valores.toString());
		tfResultadoMediaGeometrica.setText( MediaGeometrica.getMediaGeometrica().toString() );
	}

	private void apresentarDadosMediaAritmetica(){
		vetorMediaAritmetica = MediaAritmetica.getValores();
		StringBuilder valores = new StringBuilder();

		for(int i=0;i<vetorMediaAritmetica.size();i++){
			valores.append( "Valor  " + (i + 1) + ": " + vetorMediaAritmetica.get(i).toString() + "\n" );
		}

		taDadosMediaAritmetica.setText( valores.toString() );
		tfResultadoMediaAritmetica.setText( MediaAritmetica.getMediaAritmetica().toString() );
	}

	private void calcularMediaAritmetica(){
		if(tfValorMediaAritmetica.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Informe um valor!","Atenção!", JOptionPane.WARNING_MESSAGE);
		}else{
			MediaAritmetica.setValor( Double.parseDouble(tfValorMediaAritmetica.getText().replace(',', '.')));
			apresentarDadosMediaAritmetica();
			tfValorMediaAritmetica.setText("");
		}
	}

	private void calcularMediaPonderada(){

		if(tfValorVetorA.getText().isEmpty() || tfValorVetorB.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Informe os 2 valores!","Atenção!", JOptionPane.WARNING_MESSAGE);
		}else{
			MediaPonderada.setValor( Double.parseDouble(tfValorVetorA.getText().replace(',', '.')), "A");
			MediaPonderada.setValor( Double.parseDouble(tfValorVetorB.getText().replace(',', '.')), "B");
			apresentarDadosMediaPonderada();
		}
	}

	private void apresentarDadosMediaPonderada(){
		vetorA= MediaPonderada.getVetor("A");
		vetorB= MediaPonderada.getVetor("B");

		StringBuilder valoresVetorA = new StringBuilder();
		StringBuilder valoresVetorB = new StringBuilder();

		for(int i=0;i<vetorA.size();i++){
			valoresVetorA.append( "Valor  " + (i + 1) + ": " + vetorA.get(i).toString() + "\n" );
		}

		for(int i=0;i<vetorB.size();i++){
			valoresVetorB.append( "Valor  " + (i + 1) + ": " + vetorB.get(i).toString() + "\n" );
		}

		taDadosVetorA.setText( valoresVetorA.toString() );
		tfValorVetorA.setText("");

		taDadosVetorB.setText( valoresVetorB.toString() );
		tfValorVetorB.setText("");

		tfResultadoMediaPonderada.setText( MediaPonderada.calculaMediaPonderada().toString() );
		tfValorVetorA.requestFocus();
	}
}