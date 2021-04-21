```Java
//1.AidlDemoInterface：继承IInterface接口，同时是一个接口；
//所有可以在Binder中传输的接口都需要继承IInterface接口
//通过AidlDemoInterface类我们可以清楚地了解到Binder的工作机制

//3.3.根据3.1和3.2推测：这个接口的核心实现就是它的内部类Stub和Stub的内部代理类Proxy
public interface AidlDemoInterface extends android.os.IInterface
{
  /** Default implementation for AidlDemoInterface. */
  public static class Default implements com.jack.aidl01.AidlDemoInterface
  {
    /**
         * Demonstrates some basic types that you can use as parameters
         * and return values in AIDL.
         */
    @Override public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, java.lang.String aString) throws android.os.RemoteException
    {
    }
    //2.1.声明了方法sendTwoNums,同时声明了方法标识（整型的id）
    @Override public void sendTwoNums(int nums1, int nums2) throws android.os.RemoteException
    {
    }
    //2.2.声明了方法getTwoNumsResult,同时声明了方法标识（整型的id）
    @Override public int getTwoNumsResult() throws android.os.RemoteException
    {
      return 0;
    }
    @Override
    //5.此方法用于返回当前Binder对象
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  //3.声明内部类（是一个Binder类）
  public static abstract class Stub extends android.os.Binder implements com.jack.aidl01.AidlDemoInterface
  {
  	//4.Binder的唯一标识
    private static final java.lang.String DESCRIPTOR = "com.jack.aidl01.AidlDemoInterface";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an com.jack.aidl01.AidlDemoInterface interface,
     * generating a proxy if needed.
     */
     //4.1.asInterface：用于将服务端的Binder对象转换成客户端所需的AIDL接口类型的对象。这种转换过程是区分进程的，如果客户端和服务端位于同一进程，那么此方法返回的就是服务端的Stub对象本身，否则返回的是系统封装后的Stub.proxy对象。
    public static com.jack.aidl01.AidlDemoInterface asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      //3.1.当客户端和服务端都位于同一个进程时，方法调用不会走跨进程的transact过程
      if (((iin!=null)&&(iin instanceof com.jack.aidl01.AidlDemoInterface))) {
        return ((com.jack.aidl01.AidlDemoInterface)iin);
      }
      //3.2.当两者位于不同进程时，方法调用需要走transact过程，这个逻辑由Stub的内部代理类Proxy来完成
      return new com.jack.aidl01.AidlDemoInterface.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    //6.这个方法运行在服务端中的Binder线程池中，当客户端发起跨进程请求时，远程请求会通过系统底层封装后交由此方法来处理
    //6.1.code可以确定客户端所请求的目标方法是什么
    //6.2.接着从data中取出目标方法所需的参数（如果目标方法有参数的话）
    //6.3.目标方法执行
    //6.4.当目标方法执行完毕后，就向reply中写入返回值（如果目标方法有返回值的话）
    //6.5.注意的是，如果此方法返回false，那么客户端的请求会失败(可以利用这个特性来做权限验证，毕竟我们也不希望随便一个进程都能远程调用我们的服务)。
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_basicTypes:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          long _arg1;
          _arg1 = data.readLong();
          boolean _arg2;
          _arg2 = (0!=data.readInt());
          float _arg3;
          _arg3 = data.readFloat();
          double _arg4;
          _arg4 = data.readDouble();
          java.lang.String _arg5;
          _arg5 = data.readString();
          this.basicTypes(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_sendTwoNums:
        {
          data.enforceInterface(descriptor);
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
          data.enforceInterface(descriptor);
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
    private static class Proxy implements com.jack.aidl01.AidlDemoInterface
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      /**
           * Demonstrates some basic types that you can use as parameters
           * and return values in AIDL.
           */
      @Override public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, java.lang.String aString) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(anInt);
          _data.writeLong(aLong);
          _data.writeInt(((aBoolean)?(1):(0)));
          _data.writeFloat(aFloat);
          _data.writeDouble(aDouble);
          _data.writeString(aString);
          boolean _status = mRemote.transact(Stub.TRANSACTION_basicTypes, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().basicTypes(anInt, aLong, aBoolean, aFloat, aDouble, aString);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      //7.这个方法（其它的同理）运行在客户端
      //7.1.当客户端远程调用此方法时（内部实现是：见7.2）
      //7.2.内部实现
      //a.首先创建该方法所需要的输入型Parcel对象_data、输出型Parcel对象_reply和返回值对象List;
      //b.接着调用transact方法来发起RPC（远程过程调用）请求，同时当前线程挂起;
      //c.然后服务端的onTransact方法会被调用，直到RPC过程返回后，当前线程继续执行，并从_reply中取出RPC过程的返回结果；
      //d.有返回值的情况下，最后需要返回_reply中的数据。改方法没有，故只有前面3步；
      
      //7.3.如此:可以算是了解了Binder的工作机制
      //7.4.但是，有两个需要注意的点：
      //7.4.1.如果一个远程方法是很耗时的，那么不能在UI线程中发起此远程请求；
      //7.4.2.其次，由于服务端的Binder方法运行在Binder的线程池中，所以Binder方法不管是否耗时都应该采用同步的方式去实现，因为它已经运行在一个线程中了。
      @Override public void sendTwoNums(int nums1, int nums2) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(nums1);
          _data.writeInt(nums2);
          boolean _status = mRemote.transact(Stub.TRANSACTION_sendTwoNums, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().sendTwoNums(nums1, nums2);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public int getTwoNumsResult() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_getTwoNumsResult, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().getTwoNumsResult();
          }
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      public static com.jack.aidl01.AidlDemoInterface sDefaultImpl;
    }
    static final int TRANSACTION_basicTypes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    //2.3.id用于标识在transact过程中客户端所请求的到底是哪个方法
    static final int TRANSACTION_sendTwoNums = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_getTwoNumsResult = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    public static boolean setDefaultImpl(com.jack.aidl01.AidlDemoInterface impl) {
      if (Stub.Proxy.sDefaultImpl == null && impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static com.jack.aidl01.AidlDemoInterface getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  /**
       * Demonstrates some basic types that you can use as parameters
       * and return values in AIDL.
       */
  public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, java.lang.String aString) throws android.os.RemoteException;
  public void sendTwoNums(int nums1, int nums2) throws android.os.RemoteException;
  public int getTwoNumsResult() throws android.os.RemoteException;
}
```

+ 参考：《Android开发艺术探索》
+ 附上一张Binder工作机制的图
+ ![Binder工作机制](https://github.com/MrFishC/Practice/blob/master/image/01.Binder的工作机制.jpg#pic_center)

