package Hotel;

public class Comprar {
	private int id;
	private int idHospede;
	private int idQuarto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdHospede() {
		return idHospede;
	}
	public void setIdHospede(int idHospede) {
		this.idHospede = idHospede;
	}
	public int getIdQuarto() {
		return idQuarto;
	}
	public void setIdQuarto(int idQuarto) {
		this.idQuarto = idQuarto;
	}
	@Override
	public String toString() {
		return "ID: "+ id +" | HOSPEDE: "+  idHospede+" | QUARTO: "+ idQuarto;
	}
	
}
