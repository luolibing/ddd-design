package cn.tim.ddd.report.infrastructure.idgenerate;

/**
 * User: luolibing
 * Date: 2017/9/29 15:25
 */
public class IdGenerator {

    private static SnowFlake snowFlake = new SnowFlake(2, 3);

    public static String nextId() {
        return Long.toString(snowFlake.nextId());
    }
}
