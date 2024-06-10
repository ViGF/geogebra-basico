package outros;

public class Calculadora {
	private String numeros = "";
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

	private void resetar() {
		numeros = "";
		operadores = "";
		operadoresNaoUsados = null;
	}

	private String[] formarCalculo(String expressao) {
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
		return numeros.split(" ");
	}

	// O laco comeca a partir do indice para saber se nao ha mais fatores
	// validos, se tiver ele vai colocar o proximo fator no lugar do que
	// acabou de ser usado, e vai fazer isso com os proximos, como se fosse
	// uma fila. Depois o ultimo indice e substituido por null.

	private void removerFator(String[] fatores, int indice) {
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

	private double calcular(String expressao) {
		resetar();
		String fatores[] = formarCalculo(expressao);
		operadoresNaoUsados = operadores.toCharArray();
		int operacoesRestando = operadores.length();

		while (operacoesRestando > 0) {
			int indicePotenciacao = indice(operadoresNaoUsados, '^');
			int indiceRadiciacao = indice(operadoresNaoUsados, 'V');
			int indiceMultiplicacao = indice(operadoresNaoUsados, '*');
			int indiceDivisao = indice(operadoresNaoUsados, '/');
			int indiceSoma = indice(operadoresNaoUsados, '+');
			int indiceSubtracao = indice(operadoresNaoUsados, '-');

			// Se houver uma potenciacao e o indice dela for menor do que o indice
			// da radiciacao, caso ela exista, significa dizer que a potenciacao vem
			// antes da radiacao, portanto tem prioridade.
			// O fator que esta no indice da potencia e ponteciado pelo proximo
			// fator, que depois e substituido pelo proximo fator na fila.
			// O contador de operacoes restantes decresce e a operacao e substituida
			// pela proxima na fila, pois ela foi feita.

			if (indicePotenciacao != -1 && (indicePotenciacao < indiceRadiciacao || indiceRadiciacao == -1)) {
				fatores[indicePotenciacao] = "" + (Math.pow(Double.parseDouble(fatores[indicePotenciacao]),
						Double.parseDouble(fatores[indicePotenciacao + 1])));
				removerFator(fatores, indicePotenciacao + 1);
				operacoesRestando--;
				removerOperador(indicePotenciacao);

				// Caso contrario, ou seja, se nao houver potenciacao ou o indice dele
				// for maior, e houver uma radiciacao, o fator no indice da radiciacao
				// sera radiciado por 2 e o contador decresce e a operacao e substituida
				// pela proxima na fila, pois ela foi feita.

			} else if (indiceRadiciacao != -1) {
				fatores[indiceRadiciacao] = "" + (Math.sqrt(Double.parseDouble(fatores[indiceRadiciacao])));
				operacoesRestando--;
				removerOperador(indiceRadiciacao);

				// O padrao se repete para os proximos operadores, sendo multiplicacao
				// divisao acima de soma e subtracao na lista de prioridade e abaixo de
				// potenciacao e radiciacao.

			} else if (indiceMultiplicacao != -1 && (indiceMultiplicacao < indiceDivisao || indiceDivisao == -1)) {
				fatores[indiceMultiplicacao] = "" + (Double.parseDouble(fatores[indiceMultiplicacao])
						* Double.parseDouble(fatores[indiceMultiplicacao + 1]));
				removerFator(fatores, indiceMultiplicacao + 1);
				operacoesRestando--;
				removerOperador(indiceMultiplicacao);
			} else if (indiceDivisao != -1) {
				if (Double.parseDouble(fatores[indiceDivisao + 1]) == 0) {
					System.out.println("Nao e possivel dividir por 0");
				} else {
					fatores[indiceDivisao] = "" + (Double.parseDouble(fatores[indiceDivisao])
							/ Double.parseDouble(fatores[indiceDivisao + 1]));
				}
				removerFator(fatores, indiceDivisao + 1);
				operacoesRestando--;
				removerOperador(indiceDivisao);

				// Soma e subtracao

			} else if (indiceSoma != -1 && (indiceSoma < indiceSubtracao || indiceSubtracao == -1)) {
				fatores[indiceSoma] = ""
						+ (Double.parseDouble(fatores[indiceSoma]) + Double.parseDouble(fatores[indiceSoma + 1]));
				removerFator(fatores, indiceSoma + 1);
				operacoesRestando--;
				removerOperador(indiceSoma);
			} else if (indiceSubtracao != -1) {
				fatores[indiceSubtracao] = "" + (Double.parseDouble(fatores[indiceSubtracao])
						- Double.parseDouble(fatores[indiceSubtracao + 1]));
				removerFator(fatores, indiceSubtracao + 1);
				operacoesRestando--;
				removerOperador(indiceSubtracao);
			}
		}

		// No final deve restar apenas um fator valido que contem o resultado
		// de todas as outras operacoes

		return Double.parseDouble(fatores[0]);
	}

	// O metodo replaceAll percorre a String e substitui ( por (f
	// pois o f sera usado para marcar quais fatores possuiam parenteses
	// O metodo Split corta a String onde houver (conteudo), removendo os
	// parenteses no processo, por isso a importancia de marcar quais fatores
	// possuiam parenteses para que sejam dados prioridade

	// As contrabarras duplas \\ se dao pelo fato do replaceAll usar o regex para
	// Java, onde o ( e contado como um operador, sendo \\ o escape

	// O split tambem usa regex e o ([]) e usado para criar padroes, nesse caso ().

	public double calcularExpressao(String expressao) {
		String fatores[] = expressao.replaceAll("\\(", "\\(f").split("([()])");
		expressao = "";

		for (int i = 0; i < fatores.length; i++) {

			// Se houver um parenteses no comeco da String o .split() pode causar
			// uma String vazia, que pode ser identificada com .isEmpty() (e vazia).

			if (!fatores[i].isEmpty()) {
				if (fatores[i].charAt(0) == 'f') {
					// Se houver um f no comeco significa que esse fator estava entre
					// parenteses, entao ele deve ser calculado primeiro
					fatores[i] = "" + calcular(fatores[i]) / 10;
				}
			
				expressao += fatores[i];
			}
		}

		return calcular(expressao);
	}

	public double calcularComResultado(String expressao, double resultado) {
		return calcularExpressao(expressao.replaceAll("r", "" + resultado/10));
	}
}
