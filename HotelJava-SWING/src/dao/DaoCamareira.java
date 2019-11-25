package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hotel.Camareira;
import Hotel.Hospede;
import Hotel.Quarto;
import connection.ConnectionMySql;



final class DaoCamareira implements DaoBase<Camareira> {

	@Override
	public void insert(Camareira object) {
		
		String query = " insert into camareira (Nome, Disponibilidade)" + " values (?,?)";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setString(1, object.getNome());
			preparedStmt.setString(2, "TRUE");
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void update(Camareira object) {
		String query = " update camareira set nome = ? where id = ?";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, object.getId());
			preparedStmt.setString(2, object.getNome());
			preparedStmt.setString(3, "FALSE");
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
	}

	@Override
	public Camareira findById(int id) {
		String query = " select * from camareira where id = ?";
		Camareira camareira = null;
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs =  preparedStmt.executeQuery();
			
			while (rs.next()) {
				camareira = new Camareira();
				camareira.setId(rs.getInt("ID"));
				camareira.setNome(rs.getString("Nome"));
				camareira.setDispCamareira(rs.getBoolean("Disponibilidade"));
				break;
			}			
			preparedStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return camareira;
	}

	@Override
	public List<Camareira> findAll() {
		String query = "select * from camareira";
		List<Camareira> camareiras = new ArrayList<Camareira>();
		
		Statement statment = null;
		try {
			statment = ConnectionMySql.getConn().createStatement();
			ResultSet rs =  statment.executeQuery(query);
			
			while (rs.next()) {
				Camareira camareira = findById(rs.getInt("id"));
				camareiras.add(camareira);
			}			
			
			statment.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return camareiras;
	}

	
	
	
	@Override
	public List<Camareira> findAllOcupados() {
		String query = "select * from camareira where Disponibilidade = 'FALSE'";
		List<Camareira> camareiras = new ArrayList<Camareira>();
		
		Statement statment = null;
		try {
			statment = ConnectionMySql.getConn().createStatement();
			ResultSet rs =  statment.executeQuery(query);
			
			while (rs.next()) {
				Camareira camareira = findById(rs.getInt("id"));
				camareiras.add(camareira);
			}			
			
			statment.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return camareiras;
	}

	@Override
	public List<Camareira> findAllDisponiveis() {
		String query = "select * from camareira where Disponibilidade = 'TRUE'";
		List<Camareira> camareiras = new ArrayList<Camareira>();
		
		Statement statment = null;
		try {
			statment = ConnectionMySql.getConn().createStatement();
			ResultSet rs =  statment.executeQuery(query);
			
			while (rs.next()) {
				Camareira camareira = findById(rs.getInt("id"));
				camareiras.add(camareira);
			}			
			
			statment.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return camareiras;
	}

	@Override
	public void checkout(Camareira object) {
		// TODO Auto-generated method stub
		
	}

}
