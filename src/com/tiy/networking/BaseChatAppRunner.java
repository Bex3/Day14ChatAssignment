package com.tiy.networking;

/**
 * Created by bearden-tellez on 8/25/16.
 */
public class BaseChatAppRunner {
    public static void main(String[] args) {

        SampleServer myServer = new SampleServer();
        myServer.StartServer();
    }
}
