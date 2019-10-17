/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.formula.functions.Columns;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author delta
 */
public class ExcelParseTools {
    
    public static List<Map> getExcelList(String path){
        List<Map> resultList = new ArrayList<>();
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
             fis = new FileInputStream(path);
             workbook = WorkbookFactory.create(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(workbook != null){
            Sheet sheet = workbook.getSheetAt(0);//获取第一个页签
            int columns = getExcelColumns(path);
            int rows = getExcelRows(path);
            for (int i = 1; i < rows; i++) {
                Map map = new HashMap();
                for (int j = 0; j < columns; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String str = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, str);
                }
                resultList.add(map);
            }
        }
        return resultList;
    }
    
    public static int getExcelRows(String path){
        FileInputStream fis = null;
        Workbook workbook = null;
        int rows = 0;
        try {
            fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(workbook != null){
            Sheet sheet = workbook.getSheetAt(0);
                int columns = getExcelColumns(path);
                while(true){
                    int flag = 0;
                    Object obj = null;
                    for (int i = 0; i < columns; i++) {
                        try{
                            obj = sheet.getRow(rows).getCell(i);
                        }catch(Exception e){
                            System.out.println("exception:("+rows+","+i+")");
                        }finally{
                            if(obj!=null){
                                flag++;
                            }
                        }
                    }
                    //Object obj = sheet.getRow(rows).getCell(0);
                    if(flag==0){
                        break;
                    }
                    rows++;
                }
                //System.out.println("rows="+rows);
        }
        return rows ;
    }
    
    public static int getExcelColumns(String path){
        FileInputStream fis = null;
        Workbook workbook = null;
        int columns = 0;
        try {
            fis = new FileInputStream(path);
            workbook = WorkbookFactory.create(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(workbook != null){
            Sheet sheet = workbook.getSheetAt(0);
                while(true){
                    Object obj = sheet.getRow(0).getCell(columns);
                    if(obj==null){
                        break;
                    }
                    columns++;
                }
                //System.out.println("columns="+columns);
        }
        return columns ;
    }
}
