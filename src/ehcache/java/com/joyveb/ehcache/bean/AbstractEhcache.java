package com.joyveb.ehcache.bean;


import javax.annotation.PreDestroy;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;

public class AbstractEhcache<K> {

	protected String cachename;
	protected CacheManager cm;
	protected Cache cache;

	public AbstractEhcache(String cachename){
		cm = CacheManager.getInstance();
		cache = cm.getCache(cachename);
	}
	
	public void printConfig(){
		System.out.println("--------------config start--------------------");
		CacheConfiguration config = cache.getCacheConfiguration();
//		cache.disableDynamicFeatures();//disable 
		System.out.println("timeToLiveSeconds:"+config.getTimeToLiveSeconds());
		System.out.println("timeToidleSeconds:"+config.getTimeToIdleSeconds());
		System.out.println("--------------config end--------------------");
	}
	/**
	 * Get an object from a cache model
	 * 
	 * @param cacheModel
	 *            - the model
	 * @param key
	 *            - the key to the object
	 * @return the object if in the cache, or null(?)
	 */
	public K getObject(Object key) {
		Element element = cache.get(key);
		return element != null ? (K)element.getObjectValue() : null;
	}

	/**
	 * Remove an object from a cache model
	 * 
	 * @param cacheModel
	 *            - the model to remove the object from
	 * @param key
	 *            - the key to the object
	 * @return the removed object(?)
	 */
	public boolean removeObject(Object key){
		return cache.remove(key);
	}

	/**
	 * Put an object into a cache model
	 * 
	 * @param cacheModel
	 *            - the model to add the object to
	 * @param key
	 *            - the key to the object
	 * @param object
	 *            - the object to add
	 */
	public void putObject(Object key, K object){
		Element element = new Element(key, object);
		cache.put(element);
	}
	
	@PreDestroy
	public void dispose(){
		cache.dispose();
	}

}
