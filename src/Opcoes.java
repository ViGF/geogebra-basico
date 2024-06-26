/**
 * Codigos retornados de acordo com a opcao selecionada:
 * - Primeiro digito indica o menu:
 * 0 - menu principal
 * 1 - menu do triangulo
 * 2 - menu do poligono
 * - Segundo digito indica a opcao
 */
class Opcoes {
  // Triangulo
  static final int CRIAR_TRIANGULO = 11;
  static final int PERIMETRO_TRIANGULO = 12;
  static final int AREA_TRIANGULO = 13;
  static final int TIPO_TRIANGULO = 14;

  // Poligono
  static final int CRIAR_POLIGONO = 21;
  static final int ADICIONAR_VERTICE_POLIGONO = 22;
  static final int ALTERAR_VERTICE_POLIGONO = 23;
  static final int PERIMETRO_POLIGONO = 24;
  static final int AREA_POLIGONO = 25;
  static final int QUANTIDADE_VERTICES_POLIGONO = 26;
  static final int PONTO_ESTA_NO_POLIGONO = 27;

  // Circulo
  static final int CRIAR_CIRCULO = 31;
  static final int PERIMETRO_CIRCULO = 32;
  static final int AREA_CIRCULO = 33;
  static final int RAIO_CIRCULO = 34;
  static final int DIAMETRO_CIRCULO = 35;

  // Calculadora
  static final int CALCULAR_EXPRESSAO = 41;
  static final int CALCULAR_COM_RESULTADO = 42;
  static final int ZERAR_RESULTADO = 43;

  static final int FIM = 5;
}