import java.util.Scanner;

//Classe responsavel por apresentar os menus e ler a opcao selecionada pelo usuario.
public class Menu {
  // Menu ID:
  // 0 (menu principal)
  // 1 (menu de triangulo)
  // 2 (menu da poligono)
  private int menuId;
  private Scanner sc;

  Menu() {
    this.menuId = 0;
    this.sc = new Scanner(System.in);
  }

  int getOption() {
    // Variavel que indica a ultima opcao do menu
    // Esta associada ao retorno para o menu anterior
    int ultimaOpcaoMenu = 0;

    // Loop ate que a opcao do nosso menu seja retornado
    for (;;) {
      switch (menuId) {
        case 0:
          this.mostrarMainMenu();
          ultimaOpcaoMenu = 5;
          break;
        case 1:
          this.mostrarTrianguloMenu();
          ultimaOpcaoMenu = 5;
          break;
        case 2:
          this.mostrarPoligonoMenu();
          ultimaOpcaoMenu = 8;
          break;
        case 3:
          this.mostrarCirculoMenu();
          ultimaOpcaoMenu = 6;
          break;
        case 4:
          this.mostrarCalculadoraMenu();
          ;
          ultimaOpcaoMenu = 4;
        default:
          break;
      }

      // Pede opcao do menu ao usuario
      int opcao = sc.nextInt();

      // Limpa o terminal utilizando codigos ANSI
      System.out.print("\033[H\033[2J");
      System.out.println(opcao);

      if (opcao == ultimaOpcaoMenu) {
        // Escolheu a ultima opcao do menu...
        if (this.menuId == 0) {
          // Estava no menu principal
          return 4;
        } else {
          // Estava em algum menu, entao volta para o menu principal
          this.menuId = 0;
        }
      } else {
        // Selecionou outra opcao que nao e a ultima
        if (this.menuId == 0) {
          // Navega para o outro menu, pois no menu principal so tem submenus
          this.menuId = opcao;
        } else {
          // Selecionou alguma funcionalidade
          // Retorna a opcao selecionada
          return this.menuId * 10 + opcao;
        }
      }
    }
  }

  private void mostrarMainMenu() {
    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    System.out.println("                                         Inicio");
    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    System.out.println("1 - Triangulo");
    System.out.println("2 - Poligono");
    System.out.println("3 - Circulo");
    System.out.println("4 - Calculadora");
    System.out.println("5 - Sair");
    System.out.print("Opcao: ");
  }

  private void mostrarTrianguloMenu() {
    System.out.println("::::::::::::::::::::::::::::::::::::::::Triangulo::::::::::::::::::::::::::::::::::::");
    System.out.println("1 - Adicionar vertices");
    System.out.println("2 - Perimetro");
    System.out.println("3 - Area");
    System.out.println("4 - Tipo");
    System.out.println("5 - Voltar p/ inicio");
    System.out.print("Opcao: ");
  }

  private void mostrarPoligonoMenu() {
    System.out.println("::::::::::::::::::::::::::::::::::::::::Poligono:::::::::::::::::::::::::::::::::::::::");
    System.out.println("1 - Criar poligono");
    System.out.println("2 - Adicionar vertice");
    System.out.println("3 - Alterar vertice");
    System.out.println("4 - Perimetro");
    System.out.println("5 - Area");
    System.out.println("6 - Quantidade de vertices");
    System.out.println("7 - Checar se um ponto esta dentro do poligono");
    System.out.println("8 - Voltar p/ inicio");
    System.out.print("Opcao: ");
  }

  private void mostrarCirculoMenu() {
    System.out.println("::::::::::::::::::::::::::::::::::::::::Circulo::::::::::::::::::::::::::::::::::::::::");
    System.out.println("1 - Criar circulo");
    System.out.println("2 - Perimetro");
    System.out.println("3 - Area");
    System.out.println("4 - Raio");
    System.out.println("5 - Diametro");
    System.out.println("6 - Voltar p/ inicio");
    System.out.print("Opcao: ");
  }

  private void mostrarCalculadoraMenu() {
    System.out.println("::::::::::::::::::::::::::::::::::::::Calculadora::::::::::::::::::::::::::::::::::::::");
    System.out.println("1 - Calcular expressao");
    System.out.println("2 - Calcular com resultado anterior");
    System.out.println("3 - Zerar resultado");
    System.out.println("4 - Voltar p/ inicio");
    System.out.print("Opcao: ");
  }
}
