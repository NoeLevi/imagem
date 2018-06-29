package cpsimagem.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;

import cpsimagem.model.Servico;
import cpsimagem.repositorio.ServicoRepositorio;

@ManagedBean
public class ServicoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Servico servico;
	static boolean mudaduracao = false;
	static boolean mudapersonagem = false;
	static boolean mudaformato = true;
	static boolean mudaradio = false;
	static boolean mudaemissoara = false;
	static boolean mudam = false;

	static boolean canal = false;
	static boolean outro = false;
	static String imagem = "it.png";

	private double preco;

	public static boolean isMudam() {
		return mudam;
	}
	
	public static void setMudam(boolean mudam) {
		ServicoBean.mudam = mudam;
	}
	public static boolean isMudaformato() {
		return mudaformato;
	}
	
	public static void setMudaformato(boolean mudaformato) {
		ServicoBean.mudaformato = mudaformato;
	}
	public static boolean isMudapersonagem() {
		return mudapersonagem;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	private String selecionado;

	public String getSelecionado() {
		return selecionado;
	}

	public void selecionar(ActionEvent evento) {
		selecionado = (String) evento.getComponent().getAttributes().get("selecionado");
	}

	public void setSelecionado(String selecionado) {
		this.selecionado = selecionado;
	}

	private String opcao;

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public static boolean isOutro() {
		return outro;
	}

	public static void setOutro(boolean outro) {
		ServicoBean.outro = outro;
	}

	@Autowired
	private ServicoRepositorio servicoRepositorio;

	private ArrayList<String> li;
	private ArrayList<String> liradio = new ArrayList<String>();
	private ArrayList<String> liCanal;

	@PostConstruct
	public void novo() {
		servico = new Servico();

	}

	public static boolean isCanal() {
		return canal;
	}

	public static boolean isMudaemissoara() {
		return mudaemissoara;
	}

	public static boolean isMudaduracao() {
		return mudaduracao;
	}

	public void ativarSelecao(SelectEvent event) {

		try {
			Object acti = event.getObject();
			ServicoBean.outro = false;

			if (acti.toString().equals("Outro")) {

				setOutro(true);
				ServicoBean.outro = true;
				ServicoBean.imagem = "it.png";
			} else if (acti.toString().equals("STV")) {

				ServicoBean.imagem = "stv.png";
			} else if (acti.toString().equals("TVM")) {

				ServicoBean.imagem = "tvm.png";
			}

			else if (acti.toString().equals("RTP")) {

				ServicoBean.imagem = "rtp.png";
			} else if (acti.toString().equals("TIM")) {

				ServicoBean.imagem = "tim.png";
			} else if (acti.toString().equals("MIRAMAR")) {

				ServicoBean.imagem = "miramar.png";
			} else if (acti.toString().equals("RTP")) {

				ServicoBean.imagem = "rtp.png";
			} else {
				ServicoBean.imagem = "it.png";
			}
		} catch (Exception ex) {
			ServicoBean.imagem = "it.png";
		}

	}

	public static String getImagem() {
		return imagem;
	}

	public static boolean isMudaradio() {
		return mudaradio;
	}

	public void escolherZona(SelectEvent event) {
		Object inte = event.getObject();
		try {
			liCanal = new ArrayList<String>();
			liCanal.add("Maputo");
			liCanal.add("Gaza");
			liCanal.add("Inhambane");
			System.out.println("asas das");
			if (inte.toString().equals("Sul do Pais")) {
				liCanal.add("Maputo");
				liCanal.add("Gaza");
				liCanal.add("Inhambane");
				
				}
			

		} catch (Exception ex) {

		}
	}

	public void mudar(SelectEvent event) {
		
		ServicoBean.mudaformato=true;
		ServicoBean.mudam=false;

		Object inte = event.getObject();
		li = new ArrayList<String>();
		liradio = new ArrayList<String>();
		liCanal = new ArrayList<String>();
		try {
			ServicoBean.mudaduracao = false;
			ServicoBean.mudaradio = false;

			if (inte.toString().equals("Spot de TV")) {
				li.add("Ilustracao de Grafica");
				li.add("Captacao de Imagem");

				li.add("Misto");
				ServicoBean.mudaduracao = true;
				ServicoBean.canal = true;

				liCanal.add("STV");
				liCanal.add("TVM");
				liCanal.add("TIM");
				liCanal.add("MIRAMAR");
				liCanal.add("RTP");
				liCanal.add("Outro");
				ServicoBean.mudaradio = false;

			} else if (inte.toString().equals("Spot de Radio")) {
				li.add("Monologo");
				ServicoBean.canal = false;
				ServicoBean.mudaduracao = true;
				ServicoBean.mudaradio = true;

				li.add("Misto");
				liCanal.add("Maputo");
				liCanal.add("Gaza");
				liCanal.add("Inhambane");
				
				

			} else if (inte.toString().equals("Anuncio")) {
				ServicoBean.mudaduracao = false;
				li.add("Jornal");
				li.add("OutDoor");
				ServicoBean.canal = true;

				liCanal.add("Jornal Noticia");
				liCanal.add("Jornal da tarde");
				liCanal.add("Outro");
				ServicoBean.mudaradio = false;

			} else if (inte.toString().equals("Video")) {
				li.add("Documentario");
				ServicoBean.mudaduracao = false;
				ServicoBean.canal = false;
				ServicoBean.mudaradio = false;
				ServicoBean.mudaformato=false;
				ServicoBean.mudam=true;

			} else {

				li.add("");
				liCanal.add("");

			}
		} catch (Exception ex) {
			ServicoBean.mudaradio = false;
		}
	}

	public void mudarPersonagem(SelectEvent event) {
		Object inte = event.getObject();

		try {
			ServicoBean.mudapersonagem = false;

			if (inte.toString().equals("Producao")) {

				ServicoBean.mudapersonagem = true;

			}
		} catch (Exception ex) {
			ServicoBean.mudapersonagem = false;

		}
	}

	public void setLiradio(ArrayList<String> liradio) {
		this.liradio = liradio;
	}

	public ArrayList<String> getLiradio() {
		liradio = new ArrayList<String>();

		liradio.add("Sul do Pais");
		liradio.add("Centro do Pais");
		liradio.add("Norte do Pais");
		return liradio;
	}

	public ArrayList<String> getLi() {
		return li;
	}

	public ArrayList<String> getLiCanal() {
		return liCanal;
	}

	public void salvar() {
		try {

			// UsuarioDAO usuarioDAO = new UsuarioDAO();
			// usuarioDAO.salvar(usuario);
			String sms = "";
			if (opcao.isEmpty()) {
				sms = servico.getObservacao();

			} else {
				sms = opcao + " : " + servico.getObservacao();
			}

			servico.setObservacao(sms);
			servicoRepositorio.save(servico);

			Messages.addGlobalInfo("Operacao Concluida com sucesso Aguarde o nosso contacto");
			opcao = "";
			novo();
		} catch (RuntimeException ex) {
			Messages.addGlobalInfo("Falhou ao Tentar concluir a operacao");

			ex.printStackTrace();

		}

	}

	public void excluir(ActionEvent evento) {
		try {
			servico = (Servico) evento.getComponent().getAttributes().get("servicoSelecionado");
			// usuarioDAO.salvar(usuario);
			servicoRepositorio.delete(servico);

			Messages.addGlobalInfo("Removido com sucesso");

		} catch (RuntimeException ex) {
			Messages.addGlobalInfo("Erro ao remover");

			ex.printStackTrace();

		}

	}

	public void actualizar(ActionEvent evento) {
		try {
			servico = (Servico) evento.getComponent().getAttributes().get("servicoSelecionado");
			// usuarioDAO.salvar(usuario);

			Messages.addGlobalInfo("Editado com sucesso");

		} catch (RuntimeException ex) {
			Messages.addGlobalInfo("Erro ao remover");

			ex.printStackTrace();

		}

	}

	public void sel(ActionEvent evento) {
		String preco = "0";
		System.out.println("asdas");
		try {

			preco = (String) evento.getComponent().getAttributes().get("precoS");
			// usuarioDAO.salvar(usuario);
			System.out.println(preco);

		} catch (RuntimeException ex) {

			ex.printStackTrace();

		}

	}

	public ArrayList<Servico> lista() {

		return (ArrayList<Servico>) servicoRepositorio.findAll();

	}

	public String listarP() {

		return "/listarSpot.xhml?faces-redirect=true";

	}

	public String registar() {

		return "/registarSpot?faces-redirect=true";

	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
}
