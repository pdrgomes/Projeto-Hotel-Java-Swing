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
		
		String query = " insert into registrarquartos (nome ,numeroq, idtipoquarto, diaria, total)" + " values (?,?,?,?,?)";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setString(1, object.getNomeHospede());
			preparedStmt.setInt(2, object.getNumeroQuarto());
			preparedStmt.setInt(3, object.getTipoQuarto().getId());
			preparedStmt.setInt(4, object.getDiaria());
			preparedStmt.setDouble(5, object.getValor());
		
			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void update(QuartoDados object) {
		String query = " update registrarquartos set nome = ? where id = ?";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, object.getId());
//			preparedStmt.setString(2, object.getNomeServico() );
//			preparedStmt.setDouble(3, object.getPrecoServico());
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
				quartos.setNomeHospede(rs.getString("nome"));
				quartos.setNumeroQuarto(rs.getInt("NUMEROQ"));
				quartos.setTipoQuarto(DaoSupplier.getDaoTipoQuarto().findById(rs.getInt("idTipoQuarto")));
				quartos.setDiaria(rs.getInt("diaria"));
				quartos.setValor(rs.getDouble("Total"));
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
				quarto.setId(rs.getInt("id"));
//				quarto.setNomeHospede(rs.getString("nome"));
//				quarto.setNumeroQuarto(rs.getInt("NUMEROQ"));
//				quarto.setTipoQuarto(tipoQuarto);
//				quarto.setNomeServico(rs.getString("nome"));
//				quarto.setPrecoServico(rs.getDouble("valor"));
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
