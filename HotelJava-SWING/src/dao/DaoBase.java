package dao;

import java.util.List;

public interface DaoBase<T> {
	void insert (T object);
	void update(T object);
	void delete(int id);
	T findById(int id);
	List<T> findAll();
}
