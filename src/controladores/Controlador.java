package controladores;

import java.util.Scanner;

public abstract class Controlador {
	// Para previnir erro de buffer e para deixar o
	// codigo mais organizado os Scanners foram divididos
	// de acordo com o tipo de retorno
	protected Scanner scInt;
	protected Scanner scDouble;
	protected Scanner scStr;

	protected Controlador() {
		scInt = new Scanner(System.in);
		scDouble = new Scanner(System.in);
		scStr = new Scanner(System.in);
	}

	protected void banner(String titulo) {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		System.out.println("                                     " + titulo);
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	}

	protected void separador() {
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	}
}
