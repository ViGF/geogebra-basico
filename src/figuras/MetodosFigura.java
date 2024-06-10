package figuras;

public interface MetodosFigura {
	// A classe abstrata Figura exige esta interface para
	// especificar que o metodo calcular esta presente em
	// todas as classes que a implementam e por isso pode
	// ser usado diretamente da classe abstrata mesmo que
	// nao seja implementada nela
	public void calcularPerimetro();

	public void calcularArea();
}
