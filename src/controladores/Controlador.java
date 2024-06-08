package controladores;

import java.util.Scanner;

public abstract class Controlador implements Comum {
	// Para previnir erro de buffer e para deixar o
	// código mais organizado os Scanners foram divididos
	// de acordo com o tipo de retorno
	protected Scanner scInt;
	protected Scanner scDouble;
	protected boolean figuraCriada = false;
	// O tipo de figura armazena apenas o nome da figura
	// e é especificado pelo construtor da classe filha
	protected String tipoFigura;

	Controlador(String tipoFigura) {
		// Inicia os Scanners na criação
		scInt = new Scanner(System.in);
		scDouble = new Scanner(System.in);
		this.tipoFigura = tipoFigura;
	}

	protected void msgFiguraInexistente() {
		if (!figuraCriada) {
			System.out.println("Erro - Você ainda não criou um " + tipoFigura);
		}
	}

	protected void bannerFigura(String titulo) {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("                                     " + titulo);
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	}

	protected void separador() {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	}
}
