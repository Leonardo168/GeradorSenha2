import java.util.Random;

/**
 * @author Leonardo Gomes da Silva
 */

public class GeradorSenha {

	public static final String maiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String minusculas = "abcdefghijklmnopqrstuvwxyz";
	public static final String numeros = "0123456789";
	public static final String especiais = "!@#$%¨&*()-_=+/*[]{}<>.,";
	private final Random r;

	public GeradorSenha() {
		this.r = new Random();
	}

	public String gerarSenha(int tamanho, boolean includeMaiusculas, boolean includeMinusculas, boolean includeNumeros,
			boolean includeEspeciais) {

		String caracteresIncluidos = "";
		if (includeMaiusculas)
			caracteresIncluidos += maiusculas;
		if (includeMinusculas)
			caracteresIncluidos += minusculas;
		if (includeNumeros)
			caracteresIncluidos += numeros;
		if (includeEspeciais)
			caracteresIncluidos += especiais;
		
		StringBuilder senhaBuilder = new StringBuilder();
		for (int i = 0; i < tamanho; i++) {
			senhaBuilder.append(caracteresIncluidos.charAt(r.nextInt(caracteresIncluidos.length())));
		}
		
		return senhaBuilder.toString();
	}
}
