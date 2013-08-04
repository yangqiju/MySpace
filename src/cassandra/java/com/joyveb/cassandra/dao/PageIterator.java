package com.joyveb.cassandra.dao;

import java.util.List;


public interface PageIterator<K, T extends CassandraPrimaryKey<K>> {

	public boolean hasNext();
	public List<T> next(int pagesize);
	
}
