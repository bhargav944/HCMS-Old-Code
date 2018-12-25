package com.bhargav.hcms.service;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.bhargav.hcms.PortalPage;
import com.bhargav.hcms.R;
import com.bhargav.hcms.data.FriendDB;
import com.bhargav.hcms.data.StaticConfig;
import com.bhargav.hcms.model.ListFriend;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.Query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gurramkonda Bhargav on 05-05-2018.
 */

public class FriendChatService extends Service {

    private static String TAG = "FriendChatService";
    // Binder given to clients
    public final IBinder mBinder = new LocalBinder();
    public Map<String, Boolean> mapMark;
    public Map<String, Query> mapQuery;
    public Map<String, ChildEventListener> mapChildEventListenerMap;
    public Map<String, Bitmap> mapBitmap;
    public ArrayList<String> listKey;
    public ListFriend listFriend;
    public CountDownTimer updateOnline;

    public FriendChatService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mapMark = new HashMap<>();
        mapQuery = new HashMap<>();
        mapChildEventListenerMap = new HashMap<>();
        listFriend = FriendDB.getInstance(this).getListFriend();
        listKey = new ArrayList<>();
        mapBitmap = new HashMap<>();
        updateOnline = new CountDownTimer(System.currentTimeMillis(), StaticConfig.TIME_TO_REFRESH) {
            @Override
            public void onTick(long l) {
                ServiceUtils.updateUserStatus(getApplicationContext());
            }

            @Override
            public void onFinish() {

            }
        };
        updateOnline.start();
    }

    public void stopNotify(String id) {
        mapMark.put(id, false);
    }

    public void createNotify(String name, String content, int id, Bitmap icon, boolean isGroup) {
        Intent activityIntent = new Intent(this, PortalPage.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, activityIntent, PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notificationBuilder = new
                NotificationCompat.Builder(this)
                .setLargeIcon(icon)
                .setContentTitle(name)
                .setContentText(content)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[] { 1000, 1000})
                .setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setAutoCancel(true);
        if (isGroup) {
            notificationBuilder.setSmallIcon(R.drawable.ic_tab_group);
        } else {
            notificationBuilder.setSmallIcon(R.drawable.ic_tab_person);
        }
        NotificationManager notificationManager =
                (NotificationManager) this.getSystemService(
                        Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(id);
        notificationManager.notify(id,
                notificationBuilder.build());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "OnStartService");
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "OnBindService");
        return mBinder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        for (String id : listKey) {
            mapQuery.get(id).removeEventListener(mapChildEventListenerMap.get(id));
        }
        mapQuery.clear();
        mapChildEventListenerMap.clear();
        mapBitmap.clear();
        updateOnline.cancel();
        Log.d(TAG, "OnDestroyService");
    }

    public class LocalBinder extends Binder {
        public FriendChatService getService() {
            // Return this instance of LocalService so clients can call public methods
            return FriendChatService.this;
        }
    }
}
