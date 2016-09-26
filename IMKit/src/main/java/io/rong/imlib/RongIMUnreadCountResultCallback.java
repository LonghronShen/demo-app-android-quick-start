package io.rong.imlib;

public abstract class RongIMUnreadCountResultCallback
    extends  io.rong.imlib.RongIMClient.ResultCallback<java.lang.Integer>
{

    @Override
    public void onSuccess(java.lang.Integer p0)
    {
        this.onSuccessInt(p0);
    }

    public abstract void onSuccessInt (java.lang.Integer p0);

    private  class RongIMUnreadCountResultCallbackWrapper{
        
    }

}