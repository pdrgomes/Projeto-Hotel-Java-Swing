package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Hotel.Comprar;
import Hotel.Hospede;
import Hotel.Quarto;
import connection.ConnectionMySql;



final class DaoComprar implements DaoBase<Comprar> {

	@Override
	public void insert(Comprar object) {
		
		String query = " insert into comprar (ID_Hospede, ID_Quarto)" + " values (?,?)";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);

			preparedStmt.execute();
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void update(Comprar object) {
		String query = " update comprar set nome = ? where id = ?";
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, object.getId());
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
	public Comprar findById(int id) {
		String query = " select * from comprar where id = ?";
		Comprar comprar = null;
		
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = ConnectionMySql.getConn().prepareStatement(query);
			preparedStmt.setInt(1, id);
			ResultSet rs =  preparedStmt.executeQuery();
			
			while (rs.next()) {
				comprar = new Comprar();
				comprar.setId(rs.getInt("ID"));
				comprar.setIdHospede(rs.getInt("ID_HOSPEDE"));
				comprar.setIdQuarto(rs.getInt("ID_QUARTO"));
				
				break;
			}			
			
			preparedStmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return comprar;
	}

	@Override
	public List<Comprar> findAll() {
		String query = "SELECT * FROM comprar";
		List<Comprar> compras = new ArrayList<Comprar>();
		
		Statement statment = null;
		try {
			statment = ConnectionMySql.getConn().createStatement();
			ResultSet rs =  statment.executeQuery(query);
			
			while (rs.next()) {
				
				Comprar comprar = findById(rs.getInt("id"));
				
				compras.add(comprar);
			}			
			
			statment.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return compras;
	}

	@Override
	public List<Comprar> findAllOcupados() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comprar> findAllDisponiveis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkout(Comprar object) {
		// TODO Auto-generated method stub
		
	}

}
