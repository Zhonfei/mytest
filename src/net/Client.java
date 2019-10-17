/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author delta
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream ops = socket.getOutputStream();
        ops.write("hello".getBytes("utf-8"));
        socket.close();
    }
}
