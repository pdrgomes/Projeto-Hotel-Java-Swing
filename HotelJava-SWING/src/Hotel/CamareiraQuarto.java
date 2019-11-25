package Hotel;

public class CamareiraQuarto {
	private int id;
	private Camareira camareira;
	private Quarto quarto;
	private boolean QuartoLimpo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Camareira getCamareira() {
		return camareira;
	}
	public void setCamareira(Camareira camareira) {
		this.camareira = camareira;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	public boolean isQuartoLimpo() {
		return QuartoLimpo;
	}
	public void setQuartoLimpo(boolean quartoLimpo) {
		QuartoLimpo = quartoLimpo;
	}
	@Override
	public String toString() {
		return "ID: " + id + "| Camareira: " + camareira + "| Quarto: " + quarto + "| QuartoLimpo: "
				+ QuartoLimpo + "]";
	}
	
	
	
	
	
}
