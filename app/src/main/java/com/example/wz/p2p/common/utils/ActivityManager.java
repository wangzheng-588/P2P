package com.example.wz.p2p.common.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * Created by wz on 17-6-21.
 */

public class ActivityManager {

    private static ActivityManager sActivityManager = null;
    private static Stack<Activity> mActivities = new Stack<>();

    private ActivityManager() {
    }

    public static ActivityManager getInstance() {
        if (sActivityManager == null) {
            synchronized (ActivityManager.class) {
                if (sActivityManager == null) {
                    sActivityManager = new ActivityManager();
                }
            }
        }
        return sActivityManager;
    }

    public static void addActivity(Activity activity) {
        if (activity != null) {
            mActivities.add(activity);
        }

    }


    public static void removeActivity(Activity activity) {
        if (activity != null) {
            for (int i = mActivities.size() - 1; i >= 0; i--) {
                if (activity == mActivities.get(i)) {
                    mActivities.get(i).finish();
                    mActivities.remove(i);
                }
            }
        }
    }


    public static void removeAllActivity() {

        for (int i = mActivities.size() - 1; i >= 0; i--) {

            mActivities.get(i).finish();
            mActivities.remove(i);


        }
    }

}
