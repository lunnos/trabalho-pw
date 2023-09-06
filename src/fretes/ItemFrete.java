package fretes;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ItemFrete
 * 
 */
@Entity
public class ItemFrete implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private double peso;

	public ItemFrete() {
	}

	public ItemFrete(String descricao, double peso) {
		super();
		this.descricao = descricao;
		this.peso = peso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		long temp;
		temp = Double.doubleToLongBits(peso);
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
		ItemFrete other = (ItemFrete) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (Double.doubleToLongBits(peso) != Double
				.doubleToLongBits(other.peso))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemFrete [descricao=" + descricao + ", peso=" + peso + "]";
	}

}