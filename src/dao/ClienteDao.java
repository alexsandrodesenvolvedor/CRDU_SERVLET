package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext;

import model.Cliente;

public class ClienteDao {

	public String salvar(Cliente cliente) {
		String retorno = "falha";
		Conexao conexao = new Conexao();
		try {
			Statement stmt = (Statement) conexao.getConnection().createStatement();
			stmt.execute("insert into cliente (nome) values ('"+ cliente.getNome() + "')");
			retorno = "sucesso";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return retorno;
	}

	public List<Cliente> listar() {
		List<Cliente> clientes = new ArrayList();
		Conexao conexao = new Conexao();

		try {
			Statement stmt = (Statement) conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from cliente");
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCpf(rs.getInt("cpf"));
				cliente.setNome(rs.getString("nome"));

				clientes.add(cliente);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return clientes;
	}

	public Cliente selecionar(int cpf){
		Cliente cliente = new Cliente();
		Conexao conexao = new Conexao();
		try{
			Statement stmt = (Statement) conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select * from cliente where cpf = '"+cpf+"'");
			rs.next();
			cliente.setCpf(rs.getInt("cpf"));
			cliente.setNome(rs.getString("nome"));
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			conexao.fecharConexao();
		}
		return cliente;
	}

	public String atualizar(Cliente cliente){
		String  retorno = "falha";
		Conexao conexao = new Conexao();
		try {
			Statement stmt = (Statement) conexao.getConnection().createStatement();
			stmt.execute("update cliente set nome = '"+cliente.getNome()+"'where cpf = '"+cliente.getCpf()+"'");
			retorno = "sucesso";

		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			conexao.fecharConexao();
		}
		return retorno;
	}

	public String remover(int cpf){
		String retorno = "falha";
		Conexao conexao = new Conexao();
		try {
			Statement stmt = (Statement) conexao.getConnection().createStatement();
			stmt.execute("delete from cliente where cpf ='"+cpf+"'");
			retorno = "sucesso";
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			conexao.fecharConexao();
		}
		return retorno;
	}

}
