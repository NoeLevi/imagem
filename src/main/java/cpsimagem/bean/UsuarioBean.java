package cpsimagem.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;

import cpsimagem.model.Usuario;
import cpsimagem.repositorio.UsuarioRepositorio;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private Usuario usuario;

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void novo() {
		usuario = new Usuario();

	}

	public String salvar() {
		try {
			// UsuarioDAO usuarioDAO = new UsuarioDAO();
			// usuarioDAO.salvar(usuario);
			usuarioRepositorio.save(usuario);

			Messages.addGlobalInfo("Gravado com sucesso");
			
			return "/login";
			
		} catch (RuntimeException ex) {
			Messages.addGlobalInfo("Erro ao criar com sucesso");

			ex.printStackTrace();

			return "";
		}

	}
	
	public void excluir(ActionEvent evento) {
		try {
			 usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");
			// usuarioDAO.salvar(usuario);
			usuarioRepositorio.delete(usuario);

			Messages.addGlobalInfo("Removido com sucesso");
			
			
		} catch (RuntimeException ex) {
			Messages.addGlobalInfo("Erro ao remover");

			ex.printStackTrace();

		}

	}
	
	public ArrayList<Usuario> lista(){
		
	return	(ArrayList<Usuario>) usuarioRepositorio.findAll();

	}
}
