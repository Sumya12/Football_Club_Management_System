package com.pro.soccer.controller;

import java.util.List;

public interface CrudController<K,V> {
	public int add(K model);
	public int delete(V id);
	public int update(K model);
	public List<K> getAll();
	public K getById(V id);
	
}
