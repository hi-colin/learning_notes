package com.example.mybookapplication.activity;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

// 活动收集器
public class ActivityCollector {

    private static List<Activity> activities = new ArrayList<>();

    // 添加活动
    static void addActivity(Activity activity) {
        activities.add(activity);
    }

    // 删除活动
    static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    // 清除所有活动
    public static void finishAllActivities() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activities.clear();
    }


}
