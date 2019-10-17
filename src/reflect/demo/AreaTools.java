/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reflect.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import reflect.bean.Circle;
import reflect.bean.Rectangle;
import reflect.bean.ShapeA;



/**
 *
 * @author delta
 */
public class AreaTools {
    
    public final double getArea(ShapeA sa){
        double area = 0.00;
        Class cla = sa.getClass();
        //获取属性
        Field[] fields = cla.getDeclaredFields();
        int i=0;
        //要调用的方法参数类型
        Class[] claTy = new Class[fields.length];
        for (Field field : fields) {
            //暴力访问
            field.setAccessible(true);
            claTy[i++] = field.getType();
            //System.out.println(field.getType());
        }
        Method method = null;
        try {
            //获取要调用的方法
            method = cla.getDeclaredMethod("area", claTy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Object[] obj = null;
        //判断所传参数属于哪个类
        if (sa instanceof Circle) {
            Circle c = (Circle)sa;
            obj =new Object[]{c.radiu};
        }else if(sa instanceof Rectangle){
            Rectangle r = (Rectangle)sa;
            obj = new Object[]{r.len,r.wid};
        }else{}
        
        try {
            //调用方法
            area =(double)method.invoke(sa, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return area;
    }
}
