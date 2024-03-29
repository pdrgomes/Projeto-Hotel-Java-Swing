package Hotel;

public class Hospede {

	private int id;
	private String nome;
	private int idade;
	private String telefone;
	private String email;
	private MetodoPagamento metPagamento;
	private boolean statusHospede;

	public boolean isStatusHospede() {
		return statusHospede;
	}

	public void setStatusHospede(boolean statusHospede) {
		this.statusHospede = statusHospede;
	}

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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MetodoPagamento getMetPagamento() {
		return metPagamento;
	}

	public void setMetPagamento(MetodoPagamento metPagamento) {
		this.metPagamento = metPagamento;
	}

	@Override
	public String toString() {
		return "ID: " + id + " | Nome: " + nome + " | Idade: " + idade + " | Tel: " + telefone + " | Mail: " + email
				+ " | Pagamento: " + metPagamento + "| Status: " + statusHospede;
	}

}
