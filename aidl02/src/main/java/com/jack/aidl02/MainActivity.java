package com.jack.aidl02;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
//import com.jack.aidl01.AidlDemoInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoConnectService();
//        autoConnectService();
    }

    //使用自定义的aidl测试
    private boolean mIsConnect;
    private ServiceConnection mServiceConnection;
    private CustomAidlInterface mCustomAidlInterface;
    private void autoConnectService() {
        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mIsConnect = true;
                mCustomAidlInterface = CustomImpl.asInterface(service);
                try {
                    service.linkToDeath(mDeathRecipient,0);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mIsConnect = false;
            }
        };

        Intent intent = new Intent();
        intent.setPackage("com.jack.aidl01");
        intent.setAction("com.jack.aidl01");
        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
    }

    private IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() {
        @Override
        public void binderDied() {
            if(mCustomAidlInterface == null){
                mCustomAidlInterface.asBinder().unlinkToDeath(mDeathRecipient,0);
                mDeathRecipient = null;

                //重新bindService
                autoConnectService();
            }
        }
    };

    public void sendNums(View view) {
        if(mIsConnect){
            try {
                mCustomAidlInterface.sendTwoNums(1,2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this,"未连接",Toast.LENGTH_SHORT).show();
        }
    }

    public void getNums(View view) {
        if(mIsConnect){
            try {
                int result = mCustomAidlInterface.getTwoNumsResult();
                Toast.makeText(this,result + "",Toast.LENGTH_SHORT).show();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this,"未连接",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mIsConnect) {
            unbindService(mServiceConnection);
        }
    }

    //    private boolean mIsConnect;

//    private void autoConnectService() {
//        mServiceConnection = new ServiceConnection() {
//            @Override
//            public void onServiceConnected(ComponentName name, IBinder service) {
//                mIsConnect = true;
//                mAidlDemoInterface = AidlDemoInterface.Stub.asInterface(service);
//            }
//
//            @Override
//            public void onServiceDisconnected(ComponentName name) {
//                mIsConnect = false;
//            }
//        };
//
//        Intent intent = new Intent();
//        intent.setPackage("com.jack.aidl01");
//        intent.setAction("com.jack.aidl01");
//        bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
//    }

//    private AidlDemoInterface mAidlDemoInterface;
//    private ServiceConnection mServiceConnection;
//
//    public void sendNums(View view) {
//        if(mIsConnect){
//            try {
//                mAidlDemoInterface.sendTwoNums(1,2);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }else {
//            Toast.makeText(this,"未连接",Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    public void getNums(View view) {
//        if(mIsConnect){
//            try {
//                int result = mAidlDemoInterface.getTwoNumsResult();
//                Toast.makeText(this,result + "",Toast.LENGTH_SHORT).show();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
//        }else {
//            Toast.makeText(this,"未连接",Toast.LENGTH_SHORT).show();
//        }
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if(mIsConnect) {
//            unbindService(mServiceConnection);
//        }
//    }

}