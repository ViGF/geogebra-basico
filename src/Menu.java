import java.util.Scanner;

//Classe responsável por apresentar os menus e ler a opção selecionada pelo usuário.
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
    // Variável que indica a última opção do menu
    // Está associada ao retorno para o menu anterior
    int ultimaOpcaoMenu = 0;

    // Loop até que a opcao do nosso menu seja retornado
    for (;;) {
      switch (menuId) {
        case 0:
          this.mostrarMainMenu();
          ultimaOpcaoMenu = 3;
          break;
        case 1:
          this.mostrarTrianguloMenu();
          ultimaOpcaoMenu = 5;
          break;
        case 2:
          this.mostrarPoligonoMenu();
          ultimaOpcaoMenu = 6;
          break;
        default:
          break;
      }

      // Pede opção do menu ao usuário
      int opcao = sc.nextInt();
      
      //Limpa o terminal utilizando códigos ANSI
      System.out.print("\033[H\033[2J");

      if (opcao == ultimaOpcaoMenu) {
        // Escolheu a última opção do menu...
        if (this.menuId == 0) {
          // Estava no menu principal
          return 3;
        } else {
          // Estava em algum menu, então volta para o menu principal
          this.menuId = 0;
        }
      } else {
        // Selecionou outra opção que não é a última
        if (this.menuId == 0) {
          // Navega para o outro menu, pois no menu principal só tem submenus
          this.menuId = opcao;
        } else {
          // Selecionou alguma funcionalidade
          // Retorna a opção selecionada
          return this.menuId * 10 + opcao;
        }
      }
    }
  }

  private void mostrarMainMenu() {
    System.out.println("---------------------------");
    System.out.println("       Menu Principal      ");
    System.out.println("---------------------------");
    System.out.println("1 - Triângulo");
    System.out.println("2 - Poligono");
    System.out.println("3 - Fim");
    System.out.print("Opcao: ");
  }

  private void mostrarTrianguloMenu() {
    System.out.println("---------------------------");
    System.out.println("      Menu do Triangulo    ");
    System.out.println("---------------------------");
    System.out.println("1 - Adicionar Vértices");
    System.out.println("2 - Perimetro");
    System.out.println("3 - Area");
    System.out.println("4 - Tipo");
    System.out.println("5 - Voltar p/ menu principal");
    System.out.print("Opcao: ");
  }

  private void mostrarPoligonoMenu() {
    System.out.println("---------------------------");
    System.out.println("      Menu do Poligono     ");
    System.out.println("---------------------------");
    System.out.println("1 - Criar Poligono");
    System.out.println("2 - Adicionar Vertice");
    System.out.println("3 - Alterar Vertice");
    System.out.println("4 - Perimetro");
    System.out.println("5 - Quantidade de Vertices");
    System.out.println("6 - Voltar p/ menu principal");
    System.out.print("Opcao: ");
  }
}
