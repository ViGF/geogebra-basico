package controladores;

import outros.Calculadora;

public class CalculadoraControlador extends Controlador {
	private Calculadora calculadora;
	private double resultado = 0;

	public void calcularExpressao() {
		calculadora = new Calculadora();
		separador();
		System.out.println(resultado);
		separador();
		System.out.println("Digite uma expressao, por exemplo: '2^3 + (V16-2)/2 + 1'\n| ^: potencicacao, V: raiz quadrada, /: Divisao, *: Multiplicacao, +: Soma, -: Subtracao");
		System.out.print("Expressao: ");
		String entrada = scStr.nextLine();
		System.out.print("\033[H\033[2J");
		resultado = calculadora.calcularExpressao(entrada);
		separador();
		System.out.println(resultado);
	}

	public void calcularComResultado() {
		calculadora = new Calculadora();
		separador();
		System.out.println(resultado);
		separador();
		System.out.println("Digite uma expressao, por exemplo: '(r + 2) + 3/2'\n| r: resposta anterior");
		System.out.print("Expressao: ");
		String entrada = scStr.nextLine();
		System.out.print("\033[H\033[2J");
		resultado = calculadora.calcularComResultado(entrada, resultado);
		separador();
		System.out.println(resultado);
	}

	public void zerarResultado() {
		resultado = 0;
		System.out.print("\033[H\033[2J");
		separador();
		System.out.println(resultado);
	}
}
