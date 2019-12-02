package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hotel.Hospede;
import Hotel.Quarto;
import Hotel.QuartoDados;
import Hotel.Servicos;
import connection.ConnectionMySql;



final class DaoRegistrarQuarto implements DaoBase<QuartoDados> {

	@Override
	public void insert(QuartoDados object) {
		
		String query = " insert into registrarquartos (idHospede, idQuarto, diaria, total)" + " values (?,?,?,?)";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, object.getIdHospede().getId());
			preparedStmt.setInt(2, object.getIdQuarto().getId());
			preparedStmt.setInt(3, object.getDiaria());
			preparedStmt.setDouble(4, object.getValor());
	
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void update(QuartoDados object) {
//		String query = " update registrarquartos set idHospede = ? where id = ?";
//		
//		PreparedStatement preparedStmt = null;
//		try {
//			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
//			preparedStmt.setInt(1, object.getId());
//  		preparedStmt.setString(2, object.getNomeServico() );
//			preparedStmt.setDouble(3, object.getPrecoServico());
//			preparedStmt.execute();
//			preparedStmt.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QuartoDados findById(int id) {
		String query = " select * from registrarquartos where id = ?";
		QuartoDados quartos = null;
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs =  preparedStmt.executeQuery();
			
			while (rs.next()) {
				
				quartos = new QuartoDados();
				quartos.setId(rs.getInt("id"));
				quartos.setIdHospede(DaoSupplier.getDaoHospede().findById(rs.getInt("idHospede")));
				quartos.setIdQuarto(DaoSupplier.getDaoQuarto().findById(rs.getInt("idQuarto")));
				quartos.setDiaria(rs.getInt("diaria"));
				quartos.setValor(rs.getDouble("total"));
				break;
			}			
			
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return quartos;
	}

	@Override
	public List<QuartoDados> findAll() {
		String query = " select * from registrarquartos";
		List<QuartoDados> quartos = new ArrayList<QuartoDados>();
		
		Statement statment = null;
		try {
			statment = ConnectionMySql.getConn().createStatement();
			ResultSet rs =  statment.executeQuery(query);
			
			while (rs.next()) {
				QuartoDados quarto = new QuartoDados();
				quarto = findById(rs.getInt("id"));
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
	public List<QuartoDados> findAllOcupados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuartoDados> findAllDisponiveis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkout(QuartoDados object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFalse(QuartoDados object) {
		// TODO Auto-generated method stub
		
	}

}
