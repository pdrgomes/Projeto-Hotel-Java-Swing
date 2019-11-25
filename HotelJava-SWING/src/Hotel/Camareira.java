package Hotel;

public class Camareira {

	private int id;
	private String nome;
	private boolean dispCamareira;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isDispCamareira() {
		return dispCamareira;
	}
	public void setDispCamareira(boolean dispCamareira) {
		this.dispCamareira = dispCamareira;
	}

	@Override
	public String toString() {
		return "ID: "+ id +" | Nome: "+  nome+" | Disponibilidade: "+ dispCamareira;
	}
	
	
	
	
}
