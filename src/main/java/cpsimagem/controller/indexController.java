package cpsimagem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class indexController {
	public static Boolean estado =false ;

	
	@RequestMapping("/")
	public String index(){
		
		return "paginaPrincipal.xhtml";
	}
	
	@RequestMapping("/listaSpot")

	public String listaSpot(){		
		return "listarSpot.xhtml";
	}
	@RequestMapping("/listaUsuario")

	public String listaUsuario(){		
		return "listaUsuario.xhtml";
	}
	@RequestMapping("/login")
	public String login(){
		
		return "login.xhtml";
	}
	@RequestMapping("/registar")
	public String registo(){
		
		return "registar.xhtml";
	}
	@RequestMapping("/principal")
	public String principal(){
		
		return "principal.xhtml";
	}
	@RequestMapping("/dashboard")
	public String dashboard(){
		
		return "dashboard.xhtml";
	}
	@RequestMapping("/registarSpot")
	public String registarSpot(Model model){
		model.addAttribute("atributo", estado);

		
		return "registarSpot.xhtml";
	}
	@RequestMapping("/registarPreco")
	public String registarPreco(){
		
		return "registarPreco.xhtml";
	}
	@RequestMapping("/agenciamento")
	public String agenciamento(){
		
		return "agenciamento.xhtml";
	}
	
	@RequestMapping("/plataforma")
	public String plataforma(){
		
		return "plataforma.xhtml";
	}
	
	@RequestMapping("/comunicacao")
	public String comunicacao(){
		
		return "comunicacao.xhtml";
	}
	
	@RequestMapping("/activacao")
	public String activacao(){
		
		return "activacao.xhtml";
	}
	
	@RequestMapping("/listarPreco")
	public String listarPreco(){
		
		return "listarPreco.xhtml";
	}
	@RequestMapping("/listarEncomenda")
	public String listarEncomenda(){
		
		return "listarEncomenda.xhtml";
	}
}
