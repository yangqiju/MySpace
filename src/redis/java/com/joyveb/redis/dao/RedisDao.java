package com.joyveb.redis.dao;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.joyveb.redis.bean.ParaDrawnumber;

/**
 * 
 * 项目名称：MySpace 类名称：RedisDao
 * 
 * @Company: 北京畅享互联有限公司
 * @Copyright: Copyright (c) 2012
 * @Author： 杨其桔 创建时间：2013-2-20 下午4:00:52 修改备注：
 * @version
 * 
 */
public class RedisDao {
	private final String DRAWNUMBER_MAP = "T_PARA_DRAWNUMBER";
	private RedisTemplate<String, ParaDrawnumber> redisTemp;

	public RedisDao(RedisTemplate<String, ParaDrawnumber> template) {
		this.redisTemp = template;
	}

	public void addPeriod(final ParaDrawnumber period) {
		final byte[] redisKey = getRedisKey();
		final byte[] mapkey_ = this.redisTemp.getStringSerializer().serialize(
				ObjectUtils.toString(period.getEdrawnumber()));
		@SuppressWarnings("unchecked")
		final RedisSerializer<ParaDrawnumber> sv = (RedisSerializer<ParaDrawnumber>) this.redisTemp
				.getValueSerializer();
//		final Map<byte[], byte[]> map = new HashMap<byte[], byte[]>();
		this.redisTemp.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
//				map.putAll(connection.hGetAll(redisKey));
//				map.put(mapkey_, sv.serialize(period));
//				connection.hMSet(redisKey, map);
				connection.hSet(redisKey, mapkey_, sv.serialize(period));
				return true;
			}
		});
	}

	public Map<String, ParaDrawnumber> getAllPeriod() {
		final byte[] redisKey = getRedisKey();
		final RedisSerializer<String> mapKeySer = this.redisTemp
				.getStringSerializer();
		@SuppressWarnings("unchecked")
		final RedisSerializer<ParaDrawnumber> mapValueSer = (RedisSerializer<ParaDrawnumber>) this.redisTemp
				.getValueSerializer();
		return this.redisTemp
				.execute(new RedisCallback<Map<String, ParaDrawnumber>>() {
					public Map<String, ParaDrawnumber> doInRedis(
							RedisConnection connection)
							throws DataAccessException {
						Map<String, ParaDrawnumber> drawnumberMap = new HashMap<String, ParaDrawnumber>();
						Map<byte[], byte[]> map = null;
						map = connection.hGetAll(redisKey);
						if (map == null) {
							return null;
						}
						for (Entry<byte[], byte[]> entry : map.entrySet()) {
							drawnumberMap.put(
									mapKeySer.deserialize(entry.getKey()),
									mapValueSer.deserialize(entry.getValue()));
						}
						return drawnumberMap;
					}
				});
	}

	public Boolean cleanEndPeriod(BigDecimal period) {
		final byte[] period_ = this.redisTemp.getStringSerializer().serialize(
				period.toString());
		final byte[] redisKey = getRedisKey();
		return this.redisTemp.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.hDel(redisKey, period_);
				return true;
			}
		});
	}

	private byte[] getRedisKey() {
		return this.redisTemp.getStringSerializer().serialize(DRAWNUMBER_MAP);
	}
}
