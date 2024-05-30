public class App {
  public static void main(String[] args) {
    Menu menu = new Menu();

    TrianguloControlador trianguloControlador = new TrianguloControlador();
    PoligonoControlador poligonoControlador = new PoligonoControlador();

    // Limpa o terminal utilizando códigos ANSI
    System.out.print("\033[H\033[2J");

    for (;;) {
      int opcao = menu.getOption();

      switch (opcao) {
        case MenuOptions.CRIAR_TRIANGULO:
          trianguloControlador.criarTriangulo();
        case MenuOptions.PERIMETRO_TRIANGULO:
          trianguloControlador.perimetro();
        case MenuOptions.AREA_TRIANGULO:
          trianguloControlador.area();
        case MenuOptions.TIPO_TRIANGULO:
          trianguloControlador.tipo();
        case MenuOptions.CRIAR_POLIGONO:
          poligonoControlador.criarPoligono();
        case MenuOptions.ADICIONAR_VERTICE_POLIGONO:
          poligonoControlador.adicionarVertice();
        case MenuOptions.ALTERAR_VERTICE_POLIGONO:
          poligonoControlador.alterarVertice();
        case MenuOptions.PERIMETRO_POLIGONO:
          poligonoControlador.perimetro();
        case MenuOptions.QUANTIDADE_VERTICES_POLIGONO:
          poligonoControlador.qtdeVertices();
        default:
          System.out.println("Encerrando...");
          return;
      }
    }
  }
}
