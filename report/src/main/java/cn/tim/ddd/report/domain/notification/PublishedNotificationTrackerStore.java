package cn.tim.ddd.report.domain.notification;

import java.util.List;

/**
 * 事件追溯存储
 * 先将事件进行存储，然后进行对外发布，最后再更改发布状态
 * User: luolibing
 * Date: 2017/10/11 14:09
 */
public interface PublishedNotificationTrackerStore {

    PublishedNotificationTracker publishedNotificationTracker();

    PublishedNotificationTracker publishedNotificationTracker(String aTypeName);

    void trackMostRecentPublishedNotification(
            PublishedNotificationTracker aPublishedNotificationTracker,
            List<Notification> aNotifications);

    String typeName();
}
