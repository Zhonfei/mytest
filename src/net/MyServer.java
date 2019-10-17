/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author delta
 */
public class MyServer {
    public static void main(String[] args) throws Exception{
        ServerSocket socket = new ServerSocket(8080);
        System.out.println("start...");
        Socket accept = socket.accept();
        String hostAddress = accept.getInetAddress().getHostAddress();
        System.out.println(hostAddress);
        InputStream is = accept.getInputStream();
        int i=0;
        
        socket.close();
    }
}
