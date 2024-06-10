package controladores;

import outros.Calculadora;

public class CalculadoraControlador extends Controlador {
	private Calculadora calculadora = new Calculadora();

	public void calcularExpressao() {
		separador();
		System.out.println(calculadora.getResultado());
		separador();
		System.out.println("Digite uma expressao:\nExemplo: 2^3 + V16/2 (resultado 10)");
		double resultado = calculadora.calcularExpressao(scStr.nextLine());
		System.out.print("\033[H\033[2J");
		separador();
		System.out.println(resultado);
	}

	public void calcularComResultado() {
		separador();
		System.out.println(calculadora.getResultado());
		separador();
		System.out.println("Digite uma expressao:\nExemplo: 2^3 + V16/2 (resultado 10)");
		System.out.print("Resultado ");
		double resultado = calculadora.calcularExpressao(scStr.nextLine());
		System.out.print("\033[H\033[2J");
		separador();
		System.out.println(resultado);
	}

	public void zerarResultado() {
		calculadora.zerarResultado();
		System.out.print("\033[H\033[2J");
		separador();
		System.out.println(calculadora.getResultado());
	}
}
