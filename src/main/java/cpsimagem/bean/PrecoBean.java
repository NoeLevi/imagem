package cpsimagem.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import cpsimagem.model.Preco;
import cpsimagem.repositorio.PrecoRepositorio;

@SuppressWarnings({ "serial", "deprecation" })
@ManagedBean
@SessionScoped
public class PrecoBean implements Serializable {

	private Preco preco;

	@Autowired
	private PrecoRepositorio precoRepositorio;

	

	public Preco getPreco() {
		return preco;
	}

	public void setPreco(Preco preco) {
		this.preco = preco;
	}

	@PostConstruct
	public void novo() {
		preco = new Preco();

	}

	public void salvar() {
		try {
			
			
			// UsuarioDAO usuarioDAO = new UsuarioDAO();
			// usuarioDAO.salvar(usuario);
			precoRepositorio.save(preco);
			
			Messages.addGlobalInfo("Gravado com sucesso");
			
			novo();
		} catch (RuntimeException ex) {
			Messages.addGlobalInfo("Erro ao criar com sucesso");

			ex.printStackTrace();

		}

	}
	
	public void excluir(ActionEvent evento) {
		try {
			preco = (Preco) evento.getComponent().getAttributes().get("precoSelecionado");
			// usuarioDAO.salvar(usuario);
			precoRepositorio.delete(preco);

			Messages.addGlobalInfo("Removido com sucesso");
			
			
		} catch (RuntimeException ex) {
			Messages.addGlobalInfo("Erro ao remover");

			ex.printStackTrace();

		}

	}
	
	public void actualizar(ActionEvent evento) {
		try {
			preco = (Preco) evento.getComponent().getAttributes().get("precoSelecionado");
			// usuarioDAO.salvar(usuario);

			Messages.addGlobalInfo("Editado com sucesso");
			
			
		} catch (RuntimeException ex) {
			Messages.addGlobalInfo("Erro ao remover");

			ex.printStackTrace();

		}

	}
	public String novoR(){
		FacesMessage msg = new FacesMessage("Successful",
				"Welcome :");
				FacesContext.getCurrentInstance().addMessage(null, msg);
		return "/registarPreco?faces-redirect=true";
	}
	
	public ArrayList<Preco> lista(){
		
	return	(ArrayList<Preco>) precoRepositorio.findAll();

	}
	
	public String listarP(){
		
		return "/listarPreco.xhml?faces-redirect=true";

		}
}
