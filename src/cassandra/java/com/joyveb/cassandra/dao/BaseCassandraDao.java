package com.joyveb.cassandra.dao;


public interface BaseCassandraDao<K, T extends CassandraPrimaryKey<K>> {
	public PageIterator<K, T> createPageIterator(K startKey, Example<K> example);
	
}
