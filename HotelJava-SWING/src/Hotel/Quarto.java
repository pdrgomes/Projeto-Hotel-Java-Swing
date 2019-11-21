package Hotel;

public class Quarto {
	private int id;
	private int numQuarto;
	private double precoQuarto;
	private TipoQuarto tipoQuarto;
	private int  diarias;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}
	public double getPrecoQuarto() {
		return precoQuarto;
	}
	public void setPrecoQuarto(double precoQuarto) {
		this.precoQuarto = precoQuarto;
	}
	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}
	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
	public int getDiarias() {
		return diarias;
	}
	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}
	@Override
	public String toString() {
		return "Numero Quarto: " + numQuarto + "  |   Valor:" + precoQuarto + "  |   Tipo de Quarto:" + tipoQuarto ;
	}
	
	
}
