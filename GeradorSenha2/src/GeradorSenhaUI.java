
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

		addUiComponents();

	}

	private void addUiComponents() {
		JLabel tituloLabel = new JLabel("Gerador de Senhas");
		tituloLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//Coordenadas x e y, largura e altura
		tituloLabel.setBounds(0, 10, 540, 39);
		add(tituloLabel);
	}

}
