package com.du.hd_proxy;

public class UsbKingFactory implements UsbSell {
    @Override
    public float Proxy_sell(int usbNum) {
        return 25.5f * usbNum;
    }
}
