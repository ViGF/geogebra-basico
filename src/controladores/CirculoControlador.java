package controladores;

import figuras.Circulo;
import figuras.Vertice;

public class CirculoControlador extends Controlador {
  private Circulo c;

  // Construtor:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public CirculoControlador() {
    super("círculo");
  }

  // Criador do objeto:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public void criarCirculo() {
    Vertice centro;
    Vertice ponto;
    double raio;

    // Força o usuário a criar circulo válido
    bannerFigura("Criando Círculo");
    System.out
        .println("Para inicializar o círculo é necessário indicar o centro e o raio, ou o centro e outro vértice.");
    System.out.println("Escolha uma opção:\n 1: Ponto\n 2: Raio");
    for (;;) {
      switch (scInt.nextInt()) {
        case 1:
          centro = Vertice.pedirVertice(1, scDouble);
          System.out.println("Vertice criado com sucesso!");
          ponto = Vertice.pedirVertice(2, scDouble);
          System.out.println("Vertice criado com sucesso!");

          c = new Circulo(centro, ponto);
          figuraCriada = true;
          System.out.print("\033[H\033[2J");
          separador();
          System.out.println("Círculo criado com sucesso!");
          return; // Encerra o laço

        case 2:
          centro = Vertice.pedirVertice(1, scDouble);
          System.out.println("Vertice criado com sucesso!");
          System.out.println("Digite o raio do círculo: ");
          raio = scDouble.nextDouble();

          c = new Circulo(centro, raio);
          figuraCriada = true;
          return; // Encerra o laço

        default:
          System.out.println("Opção inválida. Tente novamente.");
          break;
      }
    }
  }

  // Metodos de Circulo:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public void raio() {
    separador();
    if (figuraCriada) {
      System.out.format("Raio: %.2f\n", c.getRaio());
    } else {
      msgFiguraInexistente();
    }
  }

  public void diametro() {
    separador();
    if (figuraCriada) {
      System.out.format("Diâmetro: %.2f\n", c.getDiametro());
    } else {
      msgFiguraInexistente();
    }
  }

  // Comum:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  @Override
  public void area() {
    separador();
    if (figuraCriada) {
      System.out.format("Area: %.2f\n", c.getArea());
    } else {
      msgFiguraInexistente();
    }
  }

  @Override
  public void perimetro() {
    separador();
    if (figuraCriada) {
      System.out.format("Perimetro: %.2f\n", c.getPerimetro());
    } else {
      msgFiguraInexistente();
    }
  }
}
