package figuras;

import java.lang.Math;
import java.util.Scanner;

public class Vertice {
  private double x;
  private double y;

  public Vertice(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  // Metodo para calcular a distancia euclidiana entre dois vertices
  public double distancia(Vertice outroVertice) {
    double deltaX = this.x - outroVertice.getX();
    double deltaY = this.y - outroVertice.getY();
    return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
  }

  // Metodo para alterar a posicao de um vertice
  public void move(double novoX, double novoY) {
    this.x = novoX;
    this.y = novoY;
  }

  // Metodo para verificar se dois vertices sao iguais
  public boolean equals(Vertice outroVertice) {
    return this.x == outroVertice.getX() && this.y == outroVertice.getY();
  }

  public static Vertice pedirVertice(int numeroVertice, Scanner sc) {
    System.out.println("Vertice " + numeroVertice + ": ");
    System.out.print("[x]: ");
    double x = sc.nextDouble();
    System.out.print("[y]: ");
    double y = sc.nextDouble();

    Vertice novoVertice = new Vertice(x, y);
    return novoVertice;
  }
}