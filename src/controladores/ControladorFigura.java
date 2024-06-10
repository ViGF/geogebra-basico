package controladores;

public abstract class ControladorFigura extends Controlador implements MetodosControladorFigura {
	protected boolean figuraCriada = false;
	// O tipo de figura armazena apenas o nome da figura
	// e e especificado pelo construtor da classe filha
	protected String tipoFigura;

	protected ControladorFigura(String tipoFigura) {
		this.tipoFigura = tipoFigura;
	}

	protected void msgFiguraInexistente() {
		if (!figuraCriada) {
			System.out.println("Erro - Voce ainda nao criou um " + tipoFigura);
		}
	}
}
