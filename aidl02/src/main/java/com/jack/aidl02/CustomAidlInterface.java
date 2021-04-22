package com.jack.aidl02;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

/**
 * @创建者 Jack
 * @创建时间 2021/4/22 14:01
 * @描述 自定义binder
 *
 * 步骤1，2，3：仿照系统的规则来写
 */
public interface CustomAidlInterface extends IInterface {

    //1.声明Binder描述符（定义DESCRIPTOR）
    static final String DESCRIPTOR = "com.jack.aidl01.AidlDemoInterface";

    //2.声明id（定义标识2）
    static final int TRANSACTION_sendTwoNums = (IBinder.FIRST_CALL_TRANSACTION + 1);

    //3.声明id（定义标识3）
    static final int TRANSACTION_getTwoNumsResult = (IBinder.FIRST_CALL_TRANSACTION + 2);

    void sendTwoNums(int nums1,int nums2) throws RemoteException;

    int getTwoNumsResult() throws RemoteException;

}
