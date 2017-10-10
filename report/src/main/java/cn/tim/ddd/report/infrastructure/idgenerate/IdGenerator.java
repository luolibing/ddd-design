package cn.tim.ddd.report.infrastructure.idgenerate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: luolibing
 * Date: 2017/9/29 15:25
 */
public class IdGenerator {

    private static Map<String, SnowFlake> snowFlakeMap = new ConcurrentHashMap<>();

    public static String nextId(String key) {
        return Long.toString(snowFlakeMap
                .computeIfAbsent(key, k -> new SnowFlake(2, 3))
                .nextId());
    }
}
