package com.pro.soccer.service;

import java.util.List;

public interface CrudService<T,K> {
	public void add(T t);
	public T getById(K id);
	public List<T> getAll();
	public void update(T t);
	public K delete(K id); // returns deleted id
}
