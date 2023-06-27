package com.Darus.demo.coindesk.api;

public class Coin {
    Time time;
    Bpi bpi;

    public Coin(Time time, Bpi bpi) {
        this.time = time;
        this.bpi = bpi;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "time=" + time +
                ", bpi=" + bpi +
                '}';
    }
}
