
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

/**
 * @author Leonardo Gomes da Silva
 */

public class GeradorSenhaUI extends JFrame {

	private GeradorSenha geradorSenha;

	public GeradorSenhaUI() {
		super("Gerador de Senhas 2.0");

		setSize(540, 570);
		setResizable(false);
		setLayout(null);

		// Encerra o programa quando a interface é fechada
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Centraliza a interface
		setLocationRelativeTo(null);

		geradorSenha = new GeradorSenha();

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

		// Botões
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

		JToggleButton especiaisToggle = new JToggleButton("Especiais ");
		especiaisToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		especiaisToggle.setBounds(277, 373, 230, 56);
		add(especiaisToggle);

		JButton gerarButton = new JButton("Gerar");
		gerarButton.setFont(new Font("Dialog", Font.PLAIN, 32));
		gerarButton.setBounds(155, 462, 240, 56);
		gerarButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean algumaOpcaoAtivada = maiusculasToggle.isSelected() || minusculasToggle.isSelected()
						|| numerosToggle.isSelected() || especiaisToggle.isSelected();

				if (!algumaOpcaoAtivada || (Integer.parseInt(tamanhoInput.getText()) <= 0)) {
					senhaOutput.setText("");
				}

				int tamanhoSenha = Integer.parseInt(tamanhoInput.getText());
				String senhaGerada = geradorSenha.gerarSenha(tamanhoSenha, 
						maiusculasToggle.isSelected(),
						minusculasToggle.isSelected(), 
						numerosToggle.isSelected(), 
						especiaisToggle.isSelected());
				senhaOutput.setText(senhaGerada);
			}
		});
		add(gerarButton);
	}
}
