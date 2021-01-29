package com.aite.smart.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

public class GatewayService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private final IGateway.Stub mBinder = new IGateway.Stub() {
        @Override
        public String request(String requestType, String protocol, String reqBody, int timeout) throws RemoteException {
            return null;
        }
    };
}
