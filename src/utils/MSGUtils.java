/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author delta
 */
public class MSGUtils {
    private static final String PATH = "G:\\temp\\test.bat";
    
    public static File sendMessage(String ip,String msg) throws Exception{
        File file = new File(PATH);
        if(file.exists()){
            file.delete();
        }
            file.createNewFile();
            OutputStream os = new FileOutputStream(file);
            String message = (msg==null?"":msg);
            String content = "msg /server:"+ip+" * \""+message+"\"";
            byte[] bs = content.getBytes();
            os.write(bs);
            os.flush();
       
        System.out.println("create file over");
        return file;
    }
}
