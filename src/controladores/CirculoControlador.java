package controladores;

import figuras.Circulo;
import figuras.Vertice;

public class CirculoControlador extends ControladorFigura {
  private Circulo c;

  // Construtor:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public CirculoControlador() {
    super("circulo");
  }

  // Criador do objeto:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public void criarCirculo() {
    Vertice centro;
    Vertice ponto;
    double raio;

    // Forca o usuario a criar circulo valido
    banner("Criando Circulo");
    System.out
        .println("Para inicializar o circulo e necessario indicar o centro e o raio, ou o centro e outro vertice.");
    System.out.println("Escolha uma opcao:\n 1: Ponto\n 2: Raio");
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
          System.out.println("Circulo criado com sucesso!");
          return; // Encerra o laco

        case 2:
          centro = Vertice.pedirVertice(1, scDouble);
          System.out.println("Vertice criado com sucesso!");
          System.out.println("Digite o raio do circulo: ");
          raio = scDouble.nextDouble();

          c = new Circulo(centro, raio);
          figuraCriada = true;
          System.out.print("\033[H\033[2J");
          separador();
          System.out.println("Circulo criado com sucesso! ");
          return; // Encerra o laco

        default:
          System.out.println("Opcao invalida. Tente novamente.");
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
      System.out.format("Diametro: %.2f\n", c.getDiametro());
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
