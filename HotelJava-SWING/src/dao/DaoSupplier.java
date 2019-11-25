package dao;


import Hotel.Camareira;
import Hotel.Comprar;
import Hotel.Hospede;
import Hotel.MetodoPagamento;
import Hotel.Quarto;
import Hotel.QuartoDados;
import Hotel.Servicos;
import Hotel.TipoQuarto;


public class DaoSupplier {
	
	public static DaoBase<Hospede> getDaoHospede() {
		return new DaoHospede();
	}
	public static DaoBase<Quarto> getDaoQuarto() {
		return new DaoQuarto();
	}
	public static DaoBase<MetodoPagamento> getDaoMetodoPagamento() {
		return new DaoMetodoPagamento();
	}
	public static DaoBase<TipoQuarto> getDaoTipoQuarto() {
		return new DaoTipoQuarto();
	}
	public static DaoBase<Servicos> getDaoServico() {
		return new DaoServico();
	}
	public static DaoBase<QuartoDados> getDaoRegistrarQuarto() {
		return new DaoRegistrarQuarto();
	}
	public static DaoBase<Comprar> getDaoComprar() {
		return new DaoComprar();
	}
	public static DaoBase<Camareira> getDaoCamareira() {
		return new DaoCamareira();
	}
	
}
