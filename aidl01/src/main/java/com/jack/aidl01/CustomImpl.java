package com.jack.aidl01;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * @创建者 Jack
 * @创建时间 2021/4/22 14:09
 * @描述
 *  实现CustomAidlInterface接口
 *  参考自动生成的源代码文件来写
 *      定义构造方法
 *      copy asInterface 方法 （略改）
 *      copy onTransact 方法（略改）
 */
public class CustomImpl extends Binder implements CustomAidlInterface{

    private int mReuslt;

    //1.定义构造方法
    public CustomImpl() {
        this.attachInterface(this,DESCRIPTOR);
    }

    @Override
    public void sendTwoNums(int nums1, int nums2) {
        //打印日志查看一下，验证自定义的aidl文件是否成功
        mReuslt = nums1 + nums2;
        System.out.println(" 查看数据 1 === " + nums1);
        System.out.println(" 查看数据 2 === " + nums2);
    }

    @Override
    public int getTwoNumsResult() {
//        return 0;
        System.out.println(" 查看数据 3 === " + mReuslt);
        return mReuslt;
    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    public static CustomAidlInterface asInterface(IBinder obj) {
        if ((obj==null)) {
            return null;
        }

        android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);

        if (((iin!=null)&&(iin instanceof CustomAidlInterface))) {
            return ((CustomAidlInterface)iin);
        }

        return new CustomImpl.Proxy(obj);
    }

    public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code)
        {
            case INTERFACE_TRANSACTION:
            {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            case TRANSACTION_sendTwoNums:
            {
                data.enforceInterface(DESCRIPTOR);
                int _arg0;
                _arg0 = data.readInt();
                int _arg1;
                _arg1 = data.readInt();
                this.sendTwoNums(_arg0, _arg1);
                reply.writeNoException();
                return true;
            }
            case TRANSACTION_getTwoNumsResult:
            {
                data.enforceInterface(DESCRIPTOR);
                int _result = this.getTwoNumsResult();
                reply.writeNoException();
                reply.writeInt(_result);
                return true;
            }
            default:
            {
                return super.onTransact(code, data, reply, flags);
            }
        }
    }

    //定义内部类-Proxy
    private static class Proxy implements CustomAidlInterface{

        //copy
        private IBinder mRemote;

        //copy
        Proxy(IBinder remote){
            mRemote = remote;
        }

        //copy
        public String getInterfaceDescriptor() {
            return DESCRIPTOR;
        }

        @Override
        public IBinder asBinder() {
            return mRemote;
        }

        @Override
        public void sendTwoNums(int nums1, int nums2) throws RemoteException{
            Parcel _data = Parcel.obtain();
            Parcel _reply = Parcel.obtain();

            try {
                _data.writeInterfaceToken(DESCRIPTOR);
                _data.writeInt(nums1);
                _data.writeInt(nums2);
                mRemote.transact(TRANSACTION_sendTwoNums, _data, _reply, 0);
                _reply.readException();
            }

            finally {
                _reply.recycle();
                _data.recycle();
            }
        }

        @Override
        public int getTwoNumsResult() throws RemoteException{
            Parcel _data = Parcel.obtain();
            Parcel _reply = Parcel.obtain();
            int _result;
            try {
                _data.writeInterfaceToken(DESCRIPTOR);
                mRemote.transact(TRANSACTION_getTwoNumsResult, _data, _reply, 0);
                _reply.readException();
                _result = _reply.readInt();
            }
            finally {
                _reply.recycle();
                _data.recycle();
            }
            return _result;
        }
    }

}
