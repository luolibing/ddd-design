package cn.tim.ddd.report.domain.notification;

/**
 * 消息通知追溯
 * User: luolibing
 * Date: 2017/10/11 14:07
 */
public class PublishedNotificationTracker {

    private int concurrencyVersion;
    private long mostRecentPublishedNotificationId;
    private long publishedNotificationTrackerId;
    private String typeName;
}
