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
		
		String query = " insert into quarto (numero, valor, idTipoQuarto, STATUS_QUARTO)" + " values (?,?,?,?)";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, object.getNumQuarto());
			preparedStmt.setDouble(2, object.getPrecoQuarto());
			preparedStmt.setInt(3, object.getTipoQuarto().getId());
			preparedStmt.setBoolean(4, object.isStatusQuarto());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void update(Quarto object) {
		String query = " update quarto set STATUS_QUARTO = ? where id = ?";
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setString(1, "TRUE");
			preparedStmt.setInt(2, object.getId());
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void checkout(Quarto object) {
		String query = " update quarto set STATUS_QUARTO = ? where id = ?";
		boolean status = false;
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setString(1, "FALSE");
			preparedStmt.setInt(2, object.getId());
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
				quarto.setPrecoQuarto((rs.getDouble("id")));
				quarto.setNumQuarto(rs.getInt("numero"));
				quarto.setTipoQuarto(DaoSupplier.getDaoTipoQuarto().findById(rs.getInt("idTipoQuarto")));
				quarto.setStatusQuarto(rs.getBoolean("STATUS_QUARTO"));
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
	
	@Override
	public List<Quarto> findAllOcupados() {
		String query = "SELECT * FROM QUARTO WHERE STATUS_QUARTO = 'TRUE'";
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

	@Override
	public List<Quarto> findAllDisponiveis() {
		String query = "SELECT * FROM QUARTO WHERE STATUS_QUARTO = 'FALSE'";
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
