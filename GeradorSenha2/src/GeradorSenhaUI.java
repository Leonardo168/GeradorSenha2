
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
		tituloLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		// Coordenadas x e y, largura e altura
		tituloLabel.setBounds(0, 10, 540, 40);

		add(tituloLabel);
		
		JTextArea output = new JTextArea();
		output.setEditable(false);
		output.setFont(new Font("Dialog", Font.PLAIN, 12));

		JScrollPane outputPane = new JScrollPane(output);
		outputPane.setBounds(25, 90, 480, 50);
		outputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		add(outputPane);
		
		JLabel tamahoLabel = new JLabel("Tamanho da Senha:");
		tamahoLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
		tamahoLabel.setBounds(25, 150, 272, 39);
		
		add(tamahoLabel);
	}
}
