package fretes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

import pessoas.Cliente;
import util.Situacao;

@Entity
public class Frete implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFrete")
	private Long id;
	private double valor;
	private String cidadeOrigem;
	private String cidadeDestino;
	private Cliente cliente;

	@Enumerated(EnumType.ORDINAL)
	private Situacao situacao;

	private ArrayList<ItemFrete> itens;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;

	public Frete() {
	}

	public Frete(Long id, double valor, String cidadeOrigem,
			String cidadeDestino, Cliente cliente, Situacao situacao,
			ArrayList<ItemFrete> itens) {
		super();
		this.id = id;
		this.valor = valor;
		this.cidadeOrigem = cidadeOrigem;
		this.cidadeDestino = cidadeDestino;
		this.cliente = cliente;
		this.situacao = situacao;
		this.itens = itens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}

	public String getCidadeDestino() {
		return cidadeDestino;
	}

	public void setCidadeDestino(String cidadeDestino) {
		this.cidadeDestino = cidadeDestino;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public ArrayList<ItemFrete> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemFrete> itens) {
		this.itens = itens;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cidadeDestino == null) ? 0 : cidadeDestino.hashCode());
		result = prime * result
				+ ((cidadeOrigem == null) ? 0 : cidadeOrigem.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result
				+ ((situacao == null) ? 0 : situacao.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frete other = (Frete) obj;
		if (cidadeDestino == null) {
			if (other.cidadeDestino != null)
				return false;
		} else if (!cidadeDestino.equals(other.cidadeDestino))
			return false;
		if (cidadeOrigem == null) {
			if (other.cidadeOrigem != null)
				return false;
		} else if (!cidadeOrigem.equals(other.cidadeOrigem))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (situacao != other.situacao)
			return false;
		if (Double.doubleToLongBits(valor) != Double
				.doubleToLongBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Frete [id=" + id + ", valor=" + valor + ", cidadeOrigem="
				+ cidadeOrigem + ", cidadeDestino=" + cidadeDestino
				+ ", cliente=" + cliente + ", situacao=" + situacao
				+ ", itens=" + itens + ", dataCadastro=" + dataCadastro + "]";
	}

}