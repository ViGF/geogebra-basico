package controladores;

import figuras.Poligono;
import figuras.Vertice;

public class PoligonoControlador extends ControladorFigura {
  private Poligono p;

  // Construtor:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public PoligonoControlador() {
    super("poligono");
  }

  // Criador do objeto:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  public void criarPoligono() {
    p = new Poligono(definirQuantidadeVertices());

    // Forca o usuario a inserir ao menos 3 vertices, antes de conseguir acessar
    // novamente o menu
    System.out.println("Para inicializar o Poligono e necessario inserir ao menos 3 vertices.");
    //System.out.println("Ensira-os no sentido anti-horario.");
    while (p.getQtdPossuiVertices() < 3) {
      int qtdeVerticesPossui = p.getQtdPossuiVertices();

      // Forca o usuario a inserir um vertice que ainda nao existe
      boolean adicionouVertice = false;
      while (!adicionouVertice) {
        Vertice novoVertice = Vertice.pedirVertice(qtdeVerticesPossui + 1, scDouble);
        adicionouVertice = p.addVertice(novoVertice);

        if (adicionouVertice) {
          System.out.println("Adicionado com sucesso!");
        } else {
          System.out.print("O vertice adicionado ja existe! Tente novamente.\n");
        }
      }
    }

    this.figuraCriada = true;
    System.out.print("\033[H\033[2J");
    separador();
    System.out.println("Poligono criado com sucesso!");
  }

  // Metodos de poligono:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  int definirQuantidadeVertices() {
    int quantidade = 0;

    // Forca o usuario a inserir uma quantidade valida
    banner("Criando Poligono");
    while (quantidade < 3 || quantidade > 10) {
      System.out.print("Quantidade de vertices (min. 3, max. 10): ");
      quantidade = scInt.nextInt();

      if (quantidade < 3) {
        System.out.println("Erro - O poligono deve ter ao menos 3 vertices");
      } else if (quantidade > 10) {
        System.out.println("Erro - O poligono deve ter no maximo 10 vertices");
      }
    }

    // System.out.println("Checkpoint: qtd - " + quantidade);
    return quantidade;
  }

  public void addVertice() {
    separador();
    if (figuraCriada) {
      if (p.getQtdMaxVertices() == p.getQtdPossuiVertices()) {
        System.out.println("Erro - O poligono ja possui a quantidade maxima de vertices");
      } else {
        Vertice novoVertice = Vertice.pedirVertice(p.getQtdPossuiVertices() + 1, scDouble);
        boolean adicionouVertice = p.addVertice(novoVertice);

        if (adicionouVertice) {
          System.out.println("Adicionado com sucesso!");
          return;
        } else {
          System.out.print("Erro - O vertice adicionado ja existe.\n");
        }
      }
    } else {
      msgFiguraInexistente();
    }
  }

  public void alterarVertice() {
    separador();
    if (figuraCriada) {
      System.out.print("Numero do vertice que deseja alterar: ");
      int numeroVertice = scInt.nextInt();
      Vertice novoVertice = Vertice.pedirVertice(numeroVertice, scDouble);

      boolean alterarVerticeResultado = p.alterarVertice(numeroVertice, novoVertice.getX(), novoVertice.getY());
      if (alterarVerticeResultado) {
        System.out.println("Vertice alterado com sucesso!");
      } else {
        System.out.println("Erro - O vertice informado ainda nao existe.");
      }
    } else {
      msgFiguraInexistente();
    }
  }

  public void qtdeVertices() {
    separador();
    if (figuraCriada) {
      System.out.print("Qtd. de vertices definida: ");
      System.out.println(this.p.getQtdMaxVertices());

      System.out.print("Qtd. de vertices que o poligono possui: ");
      System.out.println(this.p.getQtdPossuiVertices());
    } else {
      msgFiguraInexistente();
    }
  }

  public void estaNoPoligono() {
    separador();
    if (figuraCriada) {
      System.out.println("Insira os vertices do ponto:");
      Vertice ponto = Vertice.pedirVertice(1, scDouble);
      System.out.print("\033[H\033[2J");
      separador();
      if (p.pontoEstaNoPoligono(ponto)) {
        System.out.println("O ponto esta dentro do poligono.");
      } else {
        System.out.println("O ponto nao esta dentro do poligono.");
      }
    } else {
      msgFiguraInexistente();
    }
  }

  // Comum:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

  @Override
  public void area() {
    separador();
    if (figuraCriada) {
      System.out.format("Area: %.2f\n", p.getArea());
    } else {
      msgFiguraInexistente();
    }
  }

  @Override
  public void perimetro() {
    separador();
    if (figuraCriada) {
      System.out.format("Perimetro: %.2f\n", p.getPerimetro());
    } else {
      msgFiguraInexistente();
    }
  }
}
