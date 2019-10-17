/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

/**
 *
 * @author delta
 */
public class ExportTools {
    
    public final String exportWord(String templetPath,Map map) throws Exception{
        String fileName = templetPath.substring(templetPath.lastIndexOf("\\")+1).replace(".xml", "_export.docx");
        String path = templetPath.substring(0,templetPath.lastIndexOf("\\")+1)+fileName;
        Configuration configuration = new Configuration();
        configuration.setDefaultEncoding("UTF-8");
        configuration.setClassForTemplateLoading(this.getClass(), "");//模板文件所在路径
        Template t = null;
        t = configuration.getTemplate(templetPath.substring(templetPath.lastIndexOf("\\")+1)); //获取模板文件
        File outFile = new File(path); //导出文件
            File parentFile = outFile.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            outFile.createNewFile();
            Writer out = null;
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
            t.process(map, out); //将填充数据填入模板文件并输出到目标文件 
            out.flush();
            out.close();
        return path;
    }
}
