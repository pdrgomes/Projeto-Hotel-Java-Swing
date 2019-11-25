package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hotel.Hospede;
import Hotel.Quarto;
import connection.ConnectionMySql;



final class DaoHospede implements DaoBase<Hospede> {

	@Override
	public void insert(Hospede object) {
		
		String query = " insert into hospede (nome, idade, telefone, email, idpagamento)" + " values (?,?,?,?,?)";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setString(1, object.getNome());
			preparedStmt.setInt(2, object.getIdade());
			preparedStmt.setString(3, object.getTelefone());
			preparedStmt.setString(4, object.getEmail());
			preparedStmt.setInt(5, object.getMetPagamento().getId());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void update(Hospede object) {
		String query = " update hospede set nome = ? where id = ?";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, object.getId());
			preparedStmt.setString(2, object.getNome());
//			preparedStmt.setInt(3, object.getIdade());
//			preparedStmt.setString(4,  object.getTelefone());
//			preparedStmt.setString(5, object.getEmail());
//			preparedStmt.setString(6, "teste");
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Hospede findById(int id) {
		String query = " select * from hospede where id = ?";
		Hospede hospede = null;
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs =  preparedStmt.executeQuery();
			
			while (rs.next()) {
				hospede = new Hospede();
				hospede.setId(rs.getInt("id"));
				hospede.setNome(rs.getString("nome"));
				hospede.setIdade(rs.getInt("idade"));
				hospede.setTelefone(rs.getString("telefone"));
				hospede.setEmail(rs.getString("email"));
				hospede.setMetPagamento(DaoSupplier.getDaoMetodoPagamento().findById(rs.getInt("idpagamento")));
				

				
				break;
			}			
			
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return hospede;
	}

	@Override
	public List<Hospede> findAll() {
		String query = " select * from hospede";
		List<Hospede> hospedes = new ArrayList<Hospede>();
		
		Statement statment = null;
		try {
			statment = ConnectionMySql.getConn().createStatement();
			ResultSet rs =  statment.executeQuery(query);
			
			while (rs.next()) {
				
				Hospede hospede = findById(rs.getInt("id"));
				
				hospedes.add(hospede);
			}			
			
			statment.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return hospedes;
	}

	@Override
	public List<Hospede> findAllOcupados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hospede> findAllDisponiveis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkout(Hospede object) {
		// TODO Auto-generated method stub
		
	}

}
