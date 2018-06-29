package cpsimagem.model;

import javax.persistence.Column;
import javax.persistence.Entity;


@SuppressWarnings("serial")

@Entity

public class Preco extends GenericModel {

	@Column(length = 30, nullable = false)
	private String descricao;

	private String tipoServico;
	private String cronometro;

	private String tempo;

	private double preco;
public String getCronometro() {
	return cronometro;
}

public void setCronometro(String cronometro) {
	this.cronometro = cronometro;
}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		this.tempo = tempo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
