package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import persitencia.PessoaDAO;
import beans.Pessoa;

@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable{

	private static final long serialVersionUID = 1l;
	private Pessoa pessoa;
			
	public Pessoa getPessoa(){
		return pessoa;
		
	}
	public void setPessoa(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	public List<Pessoa> getListagem(){
		return PessoaDAO.listagem("");
	}
	public String actionGravar(){
		if(pessoa.getId() == 0){
			PessoaDAO.inserir(pessoa);
			return actionInserir();
		}
		else{
			PessoaDAO.alterar(pessoa);
				return "lista_pessoa";
		}
	}
	
	public String actionInserir(){
		pessoa = new Pessoa();
		return "form_pessoa";
	}
	public String actionExcluir(Pessoa p){
			PessoaDAO.excluir(p);
			return"lista_pessoa";
	}
	
	public String actionAlterar(Pessoa p){
			pessoa = p;
			return "form_pessoa";
	}
}

