package io.rong.app;

import android.app.Application;
import android.net.Uri;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.UserInfo;

/**
 * Created by Bob 2015/4/16.
 */
public class DemoApp extends Application {
    private static final String TAG = DemoApp.class.getSimpleName();


    @Override
    public void onCreate() {
        super.onCreate();


        /**
         * IMKit SDK调用第一步 初始化
         * context上下文
         */

        RongIM.init(this);

//        RongIM.setGetUserInfoProvider(new RongIM.GetUserInfoProvider() {
//            @Override
//            public UserInfo getUserInfo(String userId) {
//                return new UserInfo("2462", "yangb111", Uri.parse("tet"));
//            }
//        }, false);
//
//
//        RongIM.setGetGroupInfoProvider(new RongIM.GetGroupInfoProvider() {
//            @Override
//            public Group getGroupInfo(String groupId) {
//
//                return null;
//            }
//        });
    }

}
