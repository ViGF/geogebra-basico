import controladores.PoligonoControlador;
import controladores.TrianguloControlador;
import controladores.CirculoControlador;
import controladores.CalculadoraControlador;

public class App {
  public static void geogebraLogo() {
    System.out.print("\033[H\033[2J");
    System.out.println(
        ":::::::::::::::::::::::::::::::::::: ######### :::::::::::::::::::::::::::::::::::::::\n" + //
            ":::::::::::::::::::::::::::::::::: ############   *********** ::::::::::::::::::::::::\n" + //
            ":::::::::::::::::::::::::::: ****  ############   **************** :::::::::::::::::::\n" + //
            ":::::::::::::::::::::::: ********   ##########         ************* :::::::::::::::::\n" + //
            ":::::::::::::::::::: ***********                 ..          ********** ::::::::::::::\n" + //
            ":::::::::::::::::: ********** ::.        ..:::::::::::::.          *     :::::::::::::\n" + //
            "::::::::::::::'  ********** ::::::::::::::::::::::::::::::.         ########## :::::::\n" + //
            ":::::::::''           ** :::::::::::::::::::::::::::::::::::      ############# ::::::\n" + //
            "::::::'' ########## ::::::::::::::::::::::::::::::::::::::::      ############# ::::::\n" + //
            "::::::  ############ ::::::::::::::::::::::::::::::::::::::::       ########## :::::::\n" + //
            "::::::  ############ :::::::::::::::::::::::::::::::::::::::::.                .::::::\n" + //
            "::::::   #########  ::::::::::::::::::::::::::::::::::::::::::::..     ******* :::::::\n" + //
            ":::::             ::::::::::::::::::::::::::::::::::::::::::::::::     ******* :::::::\n" + //
            ":::::    ****** ::::::::::::::::::::::::::::::::::::::::::::::::::    ******* .:::::::\n" + //
            ":::::   ******* :::::::::::::::::::::::::::::::::::::::::::::::::    ******* .::::::::\n" + //
            ":::::   ******* ::::::::::::::::::::::::::::::::::::::::::::::::    ******* .:::::::::\n" + //
            ":::::    ******  :::::::::::::::::::::::::::::::::::::::::::::'   ******** .::::::::::\n" + //
            ":::::    *******  ::::::::::::::::::::::::::::::::::::::::''''    ******** .::::::::::\n" + //
            ":::::     *******  :::::::::::::::::::::::::::::::::::::'  ######   **** .::::::::::::\n" + //
            "::::::      *******  ::::::::::::::::::::::::::::::::::  ########## .....:::::::::::::\n" + //
            ":::::::      ****    ######  :::::::::::::::::::::::::  ############ :::::::::::::::::\n" + //
            "::::::::.      *   ##########  ::::::::::::::::::' ***  ############ :::::::::::::::::\n" + //
            "::::::::::.       ############   *********************   ########   .:::::::::::::::::\n" + //
            "::::::::::::.     ############  ***********************         ...:::::::::::::::::::\n" + //
            ":::::::::::::       ########   *****************      ...:::::::::::::::::::::::::::::\n" + //
            ":::::::::::::::                              .....::::::::::::::::::::::::::::::::::::\n" + //
            ":'######:::'########   #######:::'######:::'########:'########::'########:::::'###::::\n" + //
            "'##... ##:: ##.....::'##.... ##:'##... ##:: ##.....:: ##.... ##: ##.... ##:::'## ##:::\n" + //
            " ##:::..::: ##::::::: ##:::: ##: ##:::..::: ##::::::: ##:::: ##: ##:::: ##::'##:. ##::\n" + //
            " ##::'####: ######::: ##:::: ##: ##::'####: ######::: ########:: ########::'##:::. ##:\n" + //
            " ##::: ##:: ##...:::: ##:::: ##: ##::: ##:: ##...:::: ##.... ##: ##.. ##::: #########:\n" + //
            " ##::: ##:: ##::::::: ##:::: ##: ##::: ##:: ##::::::: ##:::: ##: ##::. ##:: ##.... ##:\n" + //
            ". ######::: ########:. #######::. ######::: ########: ########:: ##:::. ##: ##:::: ##:\n" + //
            ":......::::........:::.......::::......::::........::........:::..:::::..::..:::::..::\n\n");
  }

  public static void main(String[] args) {
    Menu menu = new Menu();

    TrianguloControlador trianguloControlador = new TrianguloControlador();
    PoligonoControlador poligonoControlador = new PoligonoControlador();
    CirculoControlador circuloControlador = new CirculoControlador();
    CalculadoraControlador calculadoraControlador = new CalculadoraControlador();

    // Limpa o terminal utilizando codigos ANSI
    System.out.print("\033[H\033[2J");
    geogebraLogo();

    for (;;) {
      int opcao = menu.getOption();

      switch (opcao) {
        // Triangulo
        case Opcoes.CRIAR_TRIANGULO:
          trianguloControlador.criarTriangulo();
          break;
        case Opcoes.PERIMETRO_TRIANGULO:
          trianguloControlador.perimetro();
          break;
        case Opcoes.AREA_TRIANGULO:
          trianguloControlador.area();
          break;
        case Opcoes.TIPO_TRIANGULO:
          trianguloControlador.tipo();
          break;

        // Poligono
        case Opcoes.CRIAR_POLIGONO:
          poligonoControlador.criarPoligono();
          break;
        case Opcoes.ADICIONAR_VERTICE_POLIGONO:
          poligonoControlador.addVertice();
          break;
        case Opcoes.ALTERAR_VERTICE_POLIGONO:
          poligonoControlador.alterarVertice();
          break;
        case Opcoes.PERIMETRO_POLIGONO:
          poligonoControlador.perimetro();
          break;
        case Opcoes.AREA_POLIGONO:
          poligonoControlador.area();
          break;
        case Opcoes.QUANTIDADE_VERTICES_POLIGONO:
          poligonoControlador.qtdeVertices();
          break;
        case Opcoes.PONTO_ESTA_NO_POLIGONO:
          poligonoControlador.estaNoPoligono();
          break;

        // Circulo
        case Opcoes.CRIAR_CIRCULO:
          circuloControlador.criarCirculo();
          break;
        case Opcoes.PERIMETRO_CIRCULO:
          circuloControlador.perimetro();
          break;
        case Opcoes.AREA_CIRCULO:
          circuloControlador.area();
          break;
        case Opcoes.RAIO_CIRCULO:
          circuloControlador.raio();
          break;
        case Opcoes.DIAMETRO_CIRCULO:
          circuloControlador.diametro();
          break;

        // Calculadora
        case Opcoes.CALCULAR_EXPRESSAO:
          calculadoraControlador.calcularExpressao();
          break;
        case Opcoes.CALCULAR_COM_RESULTADO:
          calculadoraControlador.calcularComResultado();
          break;
        case Opcoes.ZERAR_RESULTADO:
          calculadoraControlador.zerarResultado();
          break;

        default:
          System.out.println("Encerrando...");
          return;
      }
    }
  }
}
