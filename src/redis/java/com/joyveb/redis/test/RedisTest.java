package com.joyveb.redis.test;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

import com.joyveb.redis.bean.ParaDrawnumber;
import com.joyveb.redis.dao.RedisDao;

/**
 * 
 * 项目名称：MySpace 类名称：RedisTest
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-8-4 下午4:15:01 修改备注：
 * @version
 * 
 */
public class RedisTest {
	RedisDao dao = null;

	@Before
	public void setUp() throws Exception {
		// 设置redis数据源
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxActive(1000);
		poolConfig.setMaxIdle(100);
		poolConfig.setMinIdle(10);
		poolConfig.setTestOnBorrow(true);
		JedisConnectionFactory redisDataSource = new JedisConnectionFactory();
		redisDataSource.setHostName("192.168.3.146");
		redisDataSource.setPort(6379);
		redisDataSource.setTimeout(60000);
		redisDataSource.setPoolConfig(poolConfig);
		redisDataSource.setShardInfo(null);
		redisDataSource.afterPropertiesSet();
		RedisTemplate template = new RedisTemplate();
		JacksonJsonRedisSerializer jjrs = new JacksonJsonRedisSerializer(
				ParaDrawnumber.class);
		StringRedisSerializer srs = new StringRedisSerializer();
		template.setConnectionFactory(redisDataSource);
		template.setValueSerializer(jjrs);
		template.setKeySerializer(srs);
		dao = new RedisDao(template);
	}

	@Test
	public void test() {
		Map<String, ParaDrawnumber> map = dao.getAllPeriod();
		for (Entry<String, ParaDrawnumber> entry : map.entrySet()) {
			System.out.println(entry.getValue().getEdrawnumber()+":"+entry.getValue().getProcessstatus());
//			if("2013001".equals(entry.getKey())){
//				ParaDrawnumber p = entry.getValue();
//				p.setProcessstatus(-91001);
//				dao.addPeriod(p);
//			}
		}
	}
	
	@Test
	public void insert(){
		ParaDrawnumber period = new ParaDrawnumber();
		period.setEdrawnumber(new BigDecimal("2013001"));
		period.setProcessstatus(2222);
		dao.addPeriod(period);
	}
	
	@Test
	public void delete(){
		dao.cleanEndPeriod(new BigDecimal("2013002"));
	}

}
