import java.util.Scanner;

public class CirculoControlador {
  private Circulo c;
  private Scanner sc;
  private boolean circuloCriado = false;

  CirculoControlador() {
    this.sc = new Scanner(System.in);
  }

  private void mensagemCirculoInexistente() {
    if (!circuloCriado) {
      System.out.println("Erro - Você ainda não criou o circulo!");
    }
  }

  void criarCirculo() {}
  void area() {}
  void circunferencia() {}
  void raio() {}
  void diametro() {}
}
