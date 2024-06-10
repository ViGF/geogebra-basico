package outros;

public class Calculadora {
	private String numeros = "";
	private String fatores[];
	private String operadores = "";
	private char[] operadoresNaoUsados;

	// itera a lista de operadores e retorna o indice do operador
	// buscado.

	private int indice(char caracteres[], char buscado) {
		int contador = 0;
		for (char caractere : caracteres) {
			if (buscado == caractere) {
				return contador;
			}
			contador++;
		}
		return -1;
	}

	// No java um ponto flutuante e no padrao EUA, em que e usado o ponto
	// A expressao e adicionada a string dividida por espacos a partir
	// dos operadores, e depois o metodo split cria uma lista a partir dessa
	// reparticao.
	// Por exemplo 123 + 123 e adicionado a uma string como "123 123".
	// Depois ela e repartida pelo metodo .split(" ") onde contiver " ".
	// Resultando em [123,123], o que elimina o uso de ArrayList para listas
	// dinamicas.

	private void formarCalculo(String expressao) {
		for (int i = 0; i < expressao.length(); i++) {
			char caractere = expressao.charAt(i);
			if (caractere == ',') {
				numeros += '.';
			} else if (indice("+-*/^".toCharArray(), caractere) != -1) {
				numeros += ' ';
				operadores += caractere;
			}
			// O unico operador que nao reparte numeros e a raiz quadrada, pois ela atua
			// apenas
			// com o um numero, por exemplo V25
			else if (caractere == 'V') {
				operadores += caractere;
			} else if (indice("0123456789".toCharArray(), caractere) != -1) {
				numeros += caractere;
			}
		}
		fatores = numeros.split(" ");
	}

	// O laco comeca a partir do indice para saber se nao ha mais fatores
	// validos, se tiver ele vai colocar o proximo fator no lugar do que
	// acabou de ser usado, e vai fazer isso com os proximos, como se fosse
	// uma fila. Depois o ultimo indice e substituido por null.

	private void removerFator(int indice) {
		int contador = indice;
		for (int i = indice; i < fatores.length - 1; i++) {
			if (fatores[i + 1] != null) {
				fatores[i] = fatores[i + 1];
				contador++;
			}
		}
		fatores[contador] = null;
	}

	// Mesma logica anterior, exceto que por se tratar de um array de
	// caracteres nao e possivel usar null, entao usa-se ' '.

	private void removerOperador(int indice) {
		int contador = indice;
		for (int i = indice; i < operadoresNaoUsados.length - 1; i++) {
			if (operadoresNaoUsados[i + 1] != ' ') {
				operadoresNaoUsados[i] = operadoresNaoUsados[i + 1];
				contador++;
			}
		}
		operadoresNaoUsados[contador] = ' ';
	}

	// O metodo vai formar o calculo e criar uma lista de operadores
	// que ainda nao foram usados e um inteiro para saber quantas
	// operacoes ainda faltam.
	// depois ele ira buscar o indice de cada operador para ver qual
	// vem primeiro.
	// Por regra multiplicacoes e divisoes vem primeiro que

	public double calcular(String expressao) {
		formarCalculo(expressao);
		operadoresNaoUsados = operadores.toCharArray();
		int operacoesRestando = operadores.length();

		while (operacoesRestando > 0) {
			int indicePotenciacao = indice(operadoresNaoUsados, '^');
			int indiceRadiciacao = indice(operadoresNaoUsados, 'V');
			int indiceMultiplicacao = indice(operadoresNaoUsados, '*');
			int indiceDivisao = indice(operadoresNaoUsados, '/');
			int indiceSoma = indice(operadoresNaoUsados, '+');
			int indiceSubtracao = indice(operadoresNaoUsados, '-');

			// System.out.println("Checkpoint: M" + indiceMultiplicacao + " D" +
			// indiceDivisao + " S" + indiceSoma + " S" + indiceSubtracao);

			if (indicePotenciacao != -1 && (indicePotenciacao < indiceRadiciacao || indiceRadiciacao == -1)) {
				fatores[indicePotenciacao] = "" + (Math.pow(Double.parseDouble(fatores[indicePotenciacao]),
						Double.parseDouble(fatores[indicePotenciacao + 1])));
				removerFator(indicePotenciacao + 1);
				operacoesRestando--;
				removerOperador(indicePotenciacao);
			} else if (indiceRadiciacao != -1) {
				fatores[indiceRadiciacao] = "" + (Math.sqrt(Double.parseDouble(fatores[indiceRadiciacao])));
				operacoesRestando--;
				removerOperador(indiceRadiciacao);
			} else if (indiceMultiplicacao != -1 && (indiceMultiplicacao < indiceDivisao || indiceDivisao == -1)) {
				fatores[indiceMultiplicacao] = "" + (Double.parseDouble(fatores[indiceMultiplicacao])
						* Double.parseDouble(fatores[indiceMultiplicacao + 1]));
				removerFator(indiceMultiplicacao + 1);
				operacoesRestando--;
				removerOperador(indiceMultiplicacao);
			} else if (indiceDivisao != -1) {
				if (Double.parseDouble(fatores[indiceDivisao + 1]) == 0) {
					System.out.println("Nao e possivel dividir por 0");
				} else {
					fatores[indiceDivisao] = "" + (Double.parseDouble(fatores[indiceDivisao])
							/ Double.parseDouble(fatores[indiceDivisao + 1]));
				}
				removerFator(indiceDivisao + 1);
				operacoesRestando--;
				removerOperador(indiceDivisao);
			} else if (indiceSoma != -1 && (indiceSoma < indiceSubtracao || indiceSubtracao == -1)) {
				fatores[indiceSoma] = ""
						+ (Double.parseDouble(fatores[indiceSoma]) + Double.parseDouble(fatores[indiceSoma + 1]));
				removerFator(indiceSoma + 1);
				operacoesRestando--;
				removerOperador(indiceSoma);
			} else if (indiceSubtracao != -1) {
				fatores[indiceSubtracao] = "" + (Double.parseDouble(fatores[indiceSubtracao])
						- Double.parseDouble(fatores[indiceSubtracao + 1]));
				removerFator(indiceSubtracao + 1);
				operacoesRestando--;
				removerOperador(indiceSubtracao);
			}
		}

		return Double.parseDouble(fatores[0]);
	}

	public double calcularComResultado(String expressao, double resultado) {
		return calcular(resultado / 10 + expressao);
	}
}
