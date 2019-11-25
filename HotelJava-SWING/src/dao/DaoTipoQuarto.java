package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import Hotel.TipoQuarto;
import connection.ConnectionMySql;



final class DaoTipoQuarto implements DaoBase<TipoQuarto> {

	@Override
	public void insert(TipoQuarto object) {
		
		String query = " insert into tipoquarto (nome)" + " values (?)";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setString(1, object.getNome());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void update(TipoQuarto object) {
		String query = " update tipoquarto set nome = ? where id = ?";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			//preparedStmt.setInt(1, object.getNumQuarto());
			//preparedStmt.setDouble(2, object.getPrecoQuarto());
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
	public TipoQuarto findById(int id) {
		String query = " select * from tipoquarto where id = ?";
		TipoQuarto tipoQuarto = null;
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs =  preparedStmt.executeQuery();
			
			while (rs.next()) {
				tipoQuarto = new TipoQuarto();
				tipoQuarto.setId(rs.getInt("id"));
				tipoQuarto.setNome(rs.getString("nome"));
				break;
			}			
			
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return tipoQuarto;
	}

	@Override
	public List<TipoQuarto> findAll() {
		String query = " select * from tipoquarto";
		List<TipoQuarto> quartos = new ArrayList<TipoQuarto>();
		
		Statement statment = null;
		try {
			statment = ConnectionMySql.getConn().createStatement();
			ResultSet rs =  statment.executeQuery(query);
			
			while (rs.next()) {
				TipoQuarto quarto = new TipoQuarto();
				quarto.setId(rs.getInt("id"));
				quarto.setNome(rs.getString("nome"));
				quartos.add(quarto);
			}			
			
			statment.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return quartos;
	}

	@Override
	public List<TipoQuarto> findAllOcupados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoQuarto> findAllDisponiveis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkout(TipoQuarto object) {
		// TODO Auto-generated method stub
		
	}

}
