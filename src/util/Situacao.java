package util;

public enum Situacao {
	EM_ANDAMENTO(1, "1 - Em Andamento"),
	CANCELADO(2, "2 - Cancelado"),
	ENCERRADO(3, "3 - Encerrado");
	
	private final int id;
	private final String nome;
	
	Situacao(final int id, final String nome){
		this.id = id;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
}
