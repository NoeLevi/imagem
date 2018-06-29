package cpsimagem.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")

@Entity

public class Servico extends GenericModel {

	@Column(length = 30, nullable = true)
	private String estacao;
	
	
	private String tipo;
	private String documento;
	private String personagem;
	
	
	public String getPersonagem() {
		return personagem;
	}
	
	public void setPersonagem(String personagem) {
		this.personagem = personagem;
	}

	public String getTipo() {
		return tipo;
	}
	
	
	public String getDocumento() {
		return documento;
	}
	
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	private String servico;

	private String canal;

	public void setCanal(String canal) {
		this.canal = canal;
	}

	public String getCanal() {
		return canal;
	}
	
	
	private String observacao;

	public String getObservacao() {
		return observacao;
	}
	
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	private String duracao;

	public String getServico() {
		return servico;

	}
	
	private String anexo;
	
	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	
	public String getAnexo() {
		return anexo;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}

	public String getEstacao() {
		return estacao;
	}

	public void setEstacao(String estacao) {
		this.estacao = estacao;
	}

}
