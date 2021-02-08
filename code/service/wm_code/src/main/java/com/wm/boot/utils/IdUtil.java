package com.wm.boot.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wilson
 * @title IdUtil
 * @description Id工具类
 * @date 2021.02.08 19:58
 */
@Component
public class IdUtil implements IKeyGenerate {

    @Autowired
    //@Qualifier("redisDb")
    private ReactiveStringRedisTemplate redisDb;

    private static final String cacheKey = "ENTITY::ID::GENERATE";

    private static final long timeOut = 24 * 60 * 60;

    @Override
    public Long newLongID(Class<?> clazz) {
        synchronized (clazz) {
            try {
                String key = clazz.getName();
                String json = redisDb.opsForValue().get(cacheKey).block();
                Map<String, String> cacheMap = StringUtils.isEmpty(json) ?
                        new HashMap<>()
                        : (Map<String, String>) JSONObject.parseObject(json, Map.class);

                if (!cacheMap.containsKey(key)) {
                    Table annotation = clazz.getAnnotation(Table.class);
                    if (annotation != null && !StringUtils.isEmpty(annotation.value())) {
                        cacheMap.put(key, annotation.value());
                        redisDb.opsForValue().set(cacheKey, JSON.toJSONString(cacheMap)).block();
                    }
                }

                String tableName = cacheMap.get(key);
                if (!StringUtils.isEmpty(tableName)) {
                    DateFormat df = DateUtil.getFormat(DateUtil.YYYYMMDD);
                    long now = DateUtil.now().getTime();
                    String day = df.format(now);
                    tableName += "_" + day;
                    Long offset = redisDb.opsForValue().increment(tableName).block();
                    if (offset == 1) {
                        redisDb.expire(tableName, Duration.ofSeconds(timeOut));
                    }
                    return createID(offset, day, 8);
                }

            } catch (Exception ex) {
            }
        }
        return IKeyGenerate.super.newLongID();

    }

    private Long createID(Long num, String day, Integer length) {
        String id = String.valueOf(num);
        if (id.length() < length) {
            NumberFormat nf = NumberFormat.getInstance();
            nf.setGroupingUsed(false);
            nf.setMaximumIntegerDigits(length);
            nf.setMinimumIntegerDigits(length);
            id = nf.format(num);
        }
        return Long.parseLong(day + id);
    }
}
