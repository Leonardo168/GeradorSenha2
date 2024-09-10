
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class GeradorSenhaUI extends JFrame {

	public GeradorSenhaUI() {
		super("Gerador de Senhas 2.0");

		setSize(540, 570);
		setResizable(false);
		setLayout(null);

		// Encerra o programa quando a interface é fechada
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Centraliza a interface
		setLocationRelativeTo(null);

		addElementosUi();
	}

	private void addElementosUi() {
		JLabel tituloLabel = new JLabel("Gerador de Senhas");
		tituloLabel.setFont(new Font("Dialog", Font.BOLD, 32));
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		// Coordenadas x e y, largura e altura
		tituloLabel.setBounds(0, 10, 540, 39);
		add(tituloLabel);
		
		
		JTextArea senhaOutput = new JTextArea();
		senhaOutput.setEditable(false);
		senhaOutput.setFont(new Font("Dialog", Font.PLAIN, 22));
		
		JScrollPane outputPane = new JScrollPane(senhaOutput);
		outputPane.setBounds(25, 77, 479, 120);
		outputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(outputPane);
		
		JLabel tamanhoLabel = new JLabel("Tamanho da Senha:");
		tamanhoLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
		tamanhoLabel.setBounds(25, 245, 302, 39);
		add(tamanhoLabel);
		
		JTextArea tamanhoInput = new JTextArea();
		tamanhoInput.setFont(new Font("Dialog", Font.PLAIN, 32));
		tamanhoInput.setBounds(310, 245, 197, 39);
		tamanhoInput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(tamanhoInput);
		
		//Botões
		JToggleButton maiusculasToggle = new JToggleButton("Maiúsculas");
		maiusculasToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		maiusculasToggle.setBounds(25, 302, 230, 56);
		add(maiusculasToggle);
		
		JToggleButton minusculasToggle = new JToggleButton("Minúsculas");
		minusculasToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		minusculasToggle.setBounds(277, 302, 230, 56);
		add(minusculasToggle);
		
		JToggleButton numerosToggle = new JToggleButton("Números");
		numerosToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		numerosToggle.setBounds(25, 373, 230, 56);
		add(numerosToggle);
		
		JToggleButton simbolosToggle = new JToggleButton("Símbolos");
		simbolosToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		simbolosToggle.setBounds(277, 373, 230, 56);
		add(simbolosToggle);
		
		JButton gerarButton = new JButton("Gerar");
		gerarButton.setFont(new Font("Dialog", Font.PLAIN, 32));
		gerarButton.setBounds(155, 462, 240, 56);
		add(gerarButton);
	}
}
