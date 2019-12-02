package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hotel.CamareiraQuarto;
import Hotel.Hospede;
import Hotel.Quarto;
import Hotel.QuartoDados;
import Hotel.Servicos;
import connection.ConnectionMySql;



final class DaoDesignarCamareira implements DaoBase<CamareiraQuarto> {

	@Override
	public void insert(CamareiraQuarto object) {
		
		String query = " insert into camareiraquarto (ID_Camareira, ID_Quarto, QuartoLimpo)" + " values (?,?,?)";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, object.getCamareira().getId());
			preparedStmt.setInt(2, object.getQuarto().getId());
			preparedStmt.setBoolean(3, object.isQuartoLimpo());
	
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void update(CamareiraQuarto object) {
		String query = "update camareiraquarto set quartoLimpo = ? where id = ?";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setBoolean(1, true);
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
	public CamareiraQuarto findById(int id) {
		String query = " select * from camareiraquarto where id = ?";
		CamareiraQuarto camareiras = null;
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs =  preparedStmt.executeQuery();
			
			while (rs.next()) {
				
				camareiras = new CamareiraQuarto();
				camareiras.setCamareira(DaoSupplier.getDaoCamareira().findById(rs.getInt("ID_Camareira")));
				camareiras.setQuarto(DaoSupplier.getDaoQuarto().findById(rs.getInt("ID_Quarto")));
				camareiras.setQuartoLimpo(rs.getBoolean("QuartoLimpo"));
				break;
			}			
			
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return camareiras;
	}

	@Override
	public List<CamareiraQuarto> findAll() {
		String query = " select * from camareiraquarto";
		List<CamareiraQuarto> quartos = new ArrayList<CamareiraQuarto>();
		
		Statement statment = null;
		try {
			statment = ConnectionMySql.getConn().createStatement();
			ResultSet rs =  statment.executeQuery(query);
			
			while (rs.next()) {
				CamareiraQuarto quarto = new CamareiraQuarto();
				quarto.setId(rs.getInt("id"));

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
	public List<CamareiraQuarto> findAllOcupados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CamareiraQuarto> findAllDisponiveis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkout(CamareiraQuarto object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFalse(CamareiraQuarto object) {
		// TODO Auto-generated method stub
		
	}

}
