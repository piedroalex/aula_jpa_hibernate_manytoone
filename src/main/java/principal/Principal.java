package principal;

import dao.PessoaDAO;
import dao.DespesaDAO;
import entities.Pessoa;
import entities.Despesa;

/**
 * @author Pedro Alex
 */
public class Principal {
	
	public static void main(String[] args) {
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Luana");
		
		pessoaDAO.salvar(pessoa);		
				
		pessoa = pessoaDAO.buscarPorNome("Luana");

		DespesaDAO despesaDAO = new DespesaDAO();
		
		Despesa despesa1 = new Despesa();
		despesa1.setDescricao("Energia");
		despesa1.setValor(272.47);
		despesa1.setPessoa(pessoa);
		
		Despesa despesa2 = new Despesa();
		despesa2.setDescricao("Aluguel");
		despesa2.setValor(408.76);
		despesa2.setPessoa(pessoa);
		
		despesaDAO.salvar(despesa1);
		despesaDAO.salvar(despesa2);
		
	}
}
