package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hotel.Quarto;
import connection.ConnectionMySql;



final class DaoQuarto implements DaoBase<Quarto> {

	@Override
	public void insert(Quarto object) {
		
		String query = " insert into quarto (numero, valor, idTipoQuarto)" + " values (?,?,?)";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, object.getNumQuarto());
			preparedStmt.setDouble(2, object.getPrecoQuarto());
			preparedStmt.setInt(3, object.getTipoQuarto().getId());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void update(Quarto object) {
		String query = " update quarto set nome = ? where id = ?";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, object.getNumQuarto());
			preparedStmt.setDouble(2, object.getPrecoQuarto());
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
	public Quarto findById(int id) {
		String query = " select * from quarto where id = ?";
		Quarto quarto = null;
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs =  preparedStmt.executeQuery();
			
			while (rs.next()) {
				quarto = new Quarto();
				quarto.setId(rs.getInt("id"));
				quarto.setNumQuarto(rs.getInt("numero"));
				quarto.setTipoQuarto(DaoSupplier.getDaoTipoQuarto().findById(rs.getInt("idTipoQuarto")));
				break;
			}			
			
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return quarto;
	}

	@Override
	public List<Quarto> findAll() {
		String query = " select * from quarto";
		List<Quarto> quartos = new ArrayList<Quarto>();
		
		Statement statment = null;
		try {
			statment = ConnectionMySql.getConn().createStatement();
			ResultSet rs =  statment.executeQuery(query);
			
			while (rs.next()) {
				Quarto quarto = findById(rs.getInt("id"));

				quartos.add(quarto);
			}			
			
			statment.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return quartos;
	}

}
