package Hotel;

public class QuartoDados {

	private int id;
	private Hospede idHospede;
	private Quarto idQuarto;
	private int diaria;
	private double valor;
	

	public Hospede getIdHospede() {
		return idHospede;
	}
	public void setIdHospede(Hospede idHospede) {
		this.idHospede = idHospede;
	}
	public Quarto getIdQuarto() {
		return idQuarto;
	}
	public void setIdQuarto(Quarto idQuarto) {
		this.idQuarto = idQuarto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getDiaria() {
		return diaria;
	}
	public void setDiaria(int diaria) {
		this.diaria = diaria;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "ID: " + id + "  ||*|| Hospede: " + idHospede + "   ||*|| Quarto: " + idQuarto + "   ||*|| Diária: " + diaria
				+ "  ||*|| Total: " + valor ;
	}
	
	
	
	
}
