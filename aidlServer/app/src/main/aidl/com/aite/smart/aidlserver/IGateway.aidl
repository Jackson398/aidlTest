// IGateway.aidl
package com.aite.smart.aidlserver;

interface IGateway {
    String request(String requestType, String protocol,String reqBody, int timeout);
}
