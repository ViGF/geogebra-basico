public class App {
  public static void main(String[] args) {
    Menu menu = new Menu();
    MenuOptions menuOptions = new MenuOptions();

    TrianguloControlador trianguloControlador = new TrianguloControlador();
    PoligonoControlador poligonoControlador = new PoligonoControlador();

    // Limpa o terminal utilizando códigos ANSI
    System.out.print("\033[H\033[2J");

    for (;;) {
      int opcao = menu.getOption();

      if (opcao == menuOptions.CRIAR_TRIANGULO) {
        trianguloControlador.criarTriangulo();
      } else if (opcao == menuOptions.PERIMETRO_TRIANGULO) {
        trianguloControlador.perimetro();
      } else if (opcao == menuOptions.AREA_TRIANGULO) {
        trianguloControlador.area();
      } else if (opcao == menuOptions.TIPO_TRIANGULO) {
        trianguloControlador.tipo();
      } else if (opcao == menuOptions.CRIAR_POLIGONO) {
        poligonoControlador.criarPoligono();
      } else if (opcao == menuOptions.ADICIONAR_VERTICE_POLIGONO) {
        poligonoControlador.adicionarVertice();
      } else if (opcao == menuOptions.ALTERAR_VERTICE_POLIGONO) {
        poligonoControlador.alterarVertice();
      } else if (opcao == menuOptions.PERIMETRO_POLIGONO) {
        poligonoControlador.perimetro();
      } else if (opcao == menuOptions.QUANTIDADE_VERTICES_POLIGONO) {
        poligonoControlador.qtdeVertices();
      } else {
        System.out.println("Encerrando...");
        return;
      }
    }
  }
}
