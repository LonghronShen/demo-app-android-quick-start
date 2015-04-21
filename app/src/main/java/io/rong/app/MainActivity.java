package io.rong.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;


public class MainActivity extends ActionBarActivity implements Handler.Callback {


    private static final String TAG = MainActivity.class.getSimpleName();
    private String Token = "d6bCQsXiupB/4OyGkh+TOrI6ZiT8q7s0UEaMPWY0lMxmHdi1v/AAJxOma4aYXyaivfPIJjNHdE+FMH9kV/Jrxg==";//test
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("RongCloud Demo");
        getSupportActionBar().setLogo(R.drawable.de_bar_logo);
        mHandler = new Handler(this);


        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                /**
                 * 连接融云
                 */
                RongIM.connect(Token, new RongIMClient.ConnectCallback() {
                    @Override
                    public void onSuccess(String userId) {
                        Log.e(TAG, "------onSuccess----" + userId);
                    }

                    @Override
                    public void onError(RongIMClient.ErrorCode error) {
                        Log.e(TAG, "------onError----" + error);
                    }
                });
            }
        }, 3000);

    }

    private void initDate() {
        Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                .appendPath("conversationlist")
                .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName().toLowerCase(), "false") //设置私聊会话是否聚合显示
                .appendQueryParameter(Conversation.ConversationType.DISCUSSION.getName().toLowerCase(), "false") //设置私聊会话是否聚合显示
                .build();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            if (RongIM.getInstance() != null) {
                RongIM.getInstance().startPrivateChat(MainActivity.this, "2462", "hello");
            }
            return true;
        } else if (id == R.id.action_add) {
            initDate();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean handleMessage(Message msg) {
        return false;
    }
}
