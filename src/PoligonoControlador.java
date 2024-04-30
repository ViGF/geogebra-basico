import java.util.Scanner;

public class PoligonoControlador {
  private Poligono p;
  private Scanner sc;
  private boolean poligonoCriado = false;
  // É solicitado ao usuário antes de instanciar o polígono
  private int qtdeVerticesDefinida;

  PoligonoControlador() {
    this.sc = new Scanner(System.in);
  }

  private void mensagemPoligonoInexistente() {
    if (!poligonoCriado) {
      System.out.println("Erro - Você ainda não criou o poligono!");
    }
  }

  void definirQuantidadeVertices() {
    int quantidade = 0;

    // Força o usuário a inserir uma quantidade válida
    while (quantidade < 3 || quantidade > 10) {
      System.out.print("Quantidade de vertices (min. 3, max. 10): ");
      quantidade = sc.nextInt();

      if (quantidade < 3) {
        System.out.println("Erro - O poligono deve ter ao menos 3 vertices");
      } else if (quantidade > 10) {
        System.out.println("Erro - O poligono deve ter no máximo 10 vertices");
      }
    }

    this.qtdeVerticesDefinida = quantidade;
  }

  void criarPoligono() {
    definirQuantidadeVertices();
    p = new Poligono(this.qtdeVerticesDefinida);

    // Força o usuário a inserir ao menos 3 vértices, antes de conseguir acessar
    // novamente o menu
    System.out.println("Para inicializar o Poligono é necessario inserir ao menos 3 vertices.");
    while (p.getQtdVerticesPossui() < 3) {
      int qtdeVerticesPossui = p.getQtdVerticesPossui();

      // Força o usuário a inserir um vértice que ainda não existe
      boolean adicionarVerticeResultado = false;
      while (!adicionarVerticeResultado) {
        Vertice novoVertice = Vertice.pedirVertice(qtdeVerticesPossui + 1, sc);
        adicionarVerticeResultado = p.addVertice(novoVertice);

        if (adicionarVerticeResultado) {
          System.out.println("Adicionado com sucesso!");
        } else {
          System.out.print("O vertice adicionado ja existe! Tente novamente.\n");
        }
      }
    }

    this.poligonoCriado = true;
    System.out.println("Poligono criado com sucesso!");
  }

  void adicionarVertice() {
    if (poligonoCriado) {
      if (p.getMaxQtdVertices() == p.getQtdVerticesPossui()) {
        System.out.println("Erro - O poligono ja possui a quantidade maxima de vertices");
      } else {  
        Vertice novoVertice = Vertice.pedirVertice(p.getQtdVerticesPossui() + 1, sc);
        boolean adicionarVerticeResultado = p.addVertice(novoVertice);
  
        if (adicionarVerticeResultado) {
          System.out.println("Adicionado com sucesso!");
          return;
        } else {
          System.out.print("Erro - O vertice adicionado ja existe.\n");
        }
      }
    } else {
      this.mensagemPoligonoInexistente();
    }
  }

  void alterarVertice() {
    if (poligonoCriado) {
      System.out.print("Número do vértice que deseja alterar: ");
      int numeroVertice = sc.nextInt();
      Vertice novoVertice = Vertice.pedirVertice(numeroVertice, sc);

      boolean alterarVerticeResultado = p.alterarVertice(numeroVertice, novoVertice.getX(), novoVertice.getY());
      if (alterarVerticeResultado) {
        System.out.println("Vértice alterado com sucesso!");
      } else {
        System.out.println("Erro - O vértice informado ainda não existe.");
      }
    } else {
      this.mensagemPoligonoInexistente();
    }
  }

  void perimetro() {
    if (poligonoCriado) {
      int qtdeVerticesPossui = p.getQtdVerticesPossui();
      p.calcularPerimetro(qtdeVerticesPossui);
      System.out.format("Perimetro: %.2f\n", p.getPerimetro());

    } else {
      this.mensagemPoligonoInexistente();
    }
  }

  void qtdeVertices() {
    if (poligonoCriado) {
      System.out.print("Qtd. de vertices definida: ");
      System.out.println(this.p.getMaxQtdVertices());

      System.out.print("Qtd. de vertices que o poligono possui: ");
      System.out.println(this.p.getQtdVerticesPossui());
    } else {
      this.mensagemPoligonoInexistente();
    }
  }
}
