package cpsimagem.model;

import javax.persistence.Column;
import javax.persistence.Entity;


@SuppressWarnings("serial")

@Entity

public class Usuario extends GenericModel {

	@Column(length = 30, nullable = false)
	private String nome;

	private String senha;

	private String contacto;

	private String email;
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
}
