package dao;

import java.util.List;

import Hotel.Quarto;

public interface DaoBase<T> {
	void insert (T object);
	void update(T object);
	void checkout(T object);
	void delete(int id);
	T findById(int id);
	List<T> findAll();
	List<T> findAllOcupados();
	List<T> findAllDisponiveis();
}
