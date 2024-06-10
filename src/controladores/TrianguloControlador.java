package controladores;

import figuras.Triangulo;
import figuras.Vertice;

public class TrianguloControlador extends ControladorFigura {
  private Triangulo t;

  // Construtor:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public TrianguloControlador() {
    super("triangulo");
  }

  // Criador do objeto:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public void criarTriangulo() {
    Vertice[] vertices = new Vertice[3];

    // Forca o usuario a criar um triangulo valido
    banner("Criando Triangulo");
    for (;;) {
      for (int i = 0; i < vertices.length; i++) {
        Vertice novoVertice = Vertice.pedirVertice(i + 1, scDouble);
        vertices[i] = novoVertice;
        System.out.println("Vertice criado com sucesso!");
      }

      t = new Triangulo(vertices[0], vertices[1], vertices[2]);
      if (t.formaTriangulo()) {
        figuraCriada = true;
        System.out.print("\033[H\033[2J");
        separador();
        System.out.println("Triangulo criado com sucesso!");
        return; // Encerra o laco
      } else {
        System.out.println("Erro - Os vertices nao formam um triangulo!");
        System.out.println("Adicione novamente!");
      }
    }
  }

  // Metodos de triangulo:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public void tipo() {
    if (figuraCriada) {
      System.out.println(t.tipo());
    } else {
      msgFiguraInexistente();
    }
  }

  // Comum:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  @Override
  public void area() {
    if (figuraCriada) {
      System.out.format("Area: %.2f\n", t.getArea());
    } else {
      msgFiguraInexistente();
    }
  }

  @Override
  public void perimetro() {
    if (figuraCriada) {
      System.out.format("Perimetro: %.2f\n", t.getPerimetro());
    } else {
      msgFiguraInexistente();
    }
  }
}
