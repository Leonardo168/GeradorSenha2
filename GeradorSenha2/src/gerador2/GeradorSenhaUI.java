package gerador2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;

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
		
		getContentPane().setBackground(Color.BLACK);
		

		geradorSenha = new GeradorSenha();

		Color cor1 = Color.decode("#000000");
		Color cor2 = Color.decode("#33ff00");
		
		addElementosUi(cor1, cor2);
	}

	private void addElementosUi(Color cor1, Color cor2) {
		
		JLabel tituloLabel = new JLabel("Gerador de Senhas");
		tituloLabel.setFont(new Font("Dialog", Font.BOLD, 32));
		tituloLabel.setForeground(cor2);
		tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
		// Coordenadas x e y, largura e altura
		tituloLabel.setBounds(0, 10, 540, 39);
		add(tituloLabel);

		JTextArea senhaOutput = new JTextArea();
		senhaOutput.setEditable(false);
		senhaOutput.setFont(new Font("Dialog", Font.PLAIN, 22));
		senhaOutput.setBackground(cor1);
		senhaOutput.setForeground(cor2);

		JScrollPane outputPane = new JScrollPane(senhaOutput);
		outputPane.setBounds(25, 77, 479, 59);
		outputPane.setBorder(BorderFactory.createLineBorder(cor2));
		add(outputPane);

		JLabel tamanhoLabel = new JLabel("Tamanho da Senha:");
		tamanhoLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
		tamanhoLabel.setForeground(cor2);
		tamanhoLabel.setBounds(25, 245, 302, 39);
		add(tamanhoLabel);

		JTextArea tamanhoInput = new JTextArea();
		tamanhoInput.setFont(new Font("Dialog", Font.PLAIN, 32));
		tamanhoInput.setBackground(cor1);
		tamanhoInput.setForeground(cor2);
		tamanhoInput.setBounds(310, 245, 197, 39);
		tamanhoInput.setBorder(BorderFactory.createLineBorder(cor2));
		add(tamanhoInput);

		// Botões
		JToggleButton maiusculasToggle = new JToggleButton("Maiúsculas");
		maiusculasToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		maiusculasToggle.setBackground(cor1);
		maiusculasToggle.setForeground(cor2);
		maiusculasToggle.setBorder(BorderFactory.createLineBorder(cor2));
		addToggleButtonListener(maiusculasToggle, cor1, cor2);
		maiusculasToggle.setBounds(25, 302, 230, 56);
		add(maiusculasToggle);

		JToggleButton minusculasToggle = new JToggleButton("Minúsculas");
		minusculasToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		minusculasToggle.setBackground(cor1);
		minusculasToggle.setForeground(cor2);
		minusculasToggle.setBorder(BorderFactory.createLineBorder(cor2));
		addToggleButtonListener(minusculasToggle, cor1, cor2);
		minusculasToggle.setBounds(277, 302, 230, 56);
		add(minusculasToggle);

		JToggleButton numerosToggle = new JToggleButton("Números");
		numerosToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		numerosToggle.setBackground(cor1);
		numerosToggle.setForeground(cor2);
		numerosToggle.setBorder(BorderFactory.createLineBorder(cor2));
		addToggleButtonListener(numerosToggle, cor1, cor2);
		numerosToggle.setBounds(25, 373, 230, 56);
		add(numerosToggle);

		JToggleButton especiaisToggle = new JToggleButton("Especiais ");
		especiaisToggle.setFont(new Font("Dialog", Font.PLAIN, 26));
		especiaisToggle.setBackground(cor1);
		especiaisToggle.setForeground(cor2);
		especiaisToggle.setBorder(BorderFactory.createLineBorder(cor2));
		addToggleButtonListener(especiaisToggle, cor1, cor2);
		especiaisToggle.setBounds(277, 373, 230, 56);
		add(especiaisToggle);

		JButton gerarButton = new JButton("Gerar");
		gerarButton.setFont(new Font("Dialog", Font.PLAIN, 32));
		gerarButton.setBackground(cor1);
		gerarButton.setForeground(cor2);
		gerarButton.setBorder(BorderFactory.createLineBorder(cor2));
		gerarButton.setBounds(155, 462, 240, 56);
		gerarButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				boolean algumaOpcaoAtivada = maiusculasToggle.isSelected() || minusculasToggle.isSelected()
						|| numerosToggle.isSelected() || especiaisToggle.isSelected();

				gerarButton.addMouseListener(new java.awt.event.MouseAdapter() {
				    @Override
				    public void mousePressed(MouseEvent e) {
				    	gerarButton.setContentAreaFilled(false);
				    	gerarButton.setOpaque(true);
				        gerarButton.setBackground(cor2);
				        gerarButton.setForeground(cor1);
				    }

				    @Override
				    public void mouseReleased(MouseEvent e) {
				    	gerarButton.setContentAreaFilled(false);
				    	gerarButton.setOpaque(true);
				        gerarButton.setBackground(cor1);
				        gerarButton.setForeground(cor2);
				    }
				});
				
				if (!algumaOpcaoAtivada || (tamanhoInput.getText().length() <= 0)) {
					senhaOutput.setText("");
					return;
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

	private void addToggleButtonListener(JToggleButton toggleButton, Color cor1, Color cor2) {
	    toggleButton.setContentAreaFilled(false);  // Remove a área padrão do botão
	    toggleButton.setOpaque(true);              // Garante que a cor de fundo será visível

	    toggleButton.addItemListener(new ItemListener() {
	        @Override
	        public void itemStateChanged(ItemEvent e) {
	            if (toggleButton.isSelected()) {
	                toggleButton.setBackground(cor2);
	                toggleButton.setForeground(cor1);
	            } else {
	                toggleButton.setBackground(cor1);
	                toggleButton.setForeground(cor2);
	            }
	        }
	    });
	}

}
