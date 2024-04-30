import java.util.Scanner;

public class TrianguloControlador {
  private Triangulo t;
  private Scanner sc;
  private boolean trianguloCriado = false;

  TrianguloControlador() {
    this.sc = new Scanner(System.in);
  }

  private void mensagemTrianguloInexistente() {
    if (!trianguloCriado) {
      System.out.println("Erro - Você ainda não criou o triângulo!");
    }
  }

  void criarTriangulo() {
    Vertice[] vertices = new Vertice[3];

    //Força o usuário a criar um triângulo válido
    for(;;) {
      for (int i = 0; i < vertices.length; i++) {
        Vertice novoVertice = Vertice.pedirVertice(i + 1, sc);
        vertices[i] = novoVertice;
        System.out.println("Vertice criado com sucesso!");
      }
  
      t = new Triangulo(vertices[0], vertices[1], vertices[2]);
      if (t.formaTriangulo()) {
        trianguloCriado = true;
        System.out.println("Triangulo criado com sucesso!");
        return; //Encerra o laço
      } else {
        System.out.println("Erro - Os vertices não formam um triangulo!");
        System.out.println("Adicione novamente!");
      }
    }
  }

  void perimetro() {
    if (trianguloCriado) {
      t.calcularPerimetro(3);
      System.out.format("Perimetro: %.2f\n", t.getPerimetro());
    } else {
      this.mensagemTrianguloInexistente();
    }
  }

  void area() {
    if (trianguloCriado) {
      System.out.format("Area: %.2f\n", t.getArea());
    } else {
      this.mensagemTrianguloInexistente();
    }
  }

  void tipo() {
    if (trianguloCriado) {
      System.out.println(t.tipo());
    } else {
      this.mensagemTrianguloInexistente();
    }
  }
}
