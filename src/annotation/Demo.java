/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import sun.util.calendar.CalendarUtils;

/**
 *
 * @author delta
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        Demo demo = new Demo();
        demo.invokeByAnn();
//        demo.anno01();
        Class cla = Class.forName("annotation.Demo");
        Method method = cla.getMethod("area", double.class,double.class);
        AreaAn an = method.getAnnotation(AreaAn.class);
        System.out.println("len:"+an.len()+",wid:"+an.wid());
        Object obj = method.invoke(cla.newInstance(),an.len(),an.wid());
        System.out.println(obj);
    }
    
    @AreaAn(len = 3.00,wid = 0.5)
    public double area(double len,double wid){
        System.out.println("area:"+(len*wid));
        return len*wid;
    }
    
    @DemoAn(value = true)
    public void anno01(){
        System.out.println("start...");
        System.out.println("over...");
    }
    
    public String invokeByAnn() throws Exception{
        String reStr = null;
        Class cla = Class.forName("annotation.TestController");
        TestController tc = (TestController) cla.newInstance();
        Annotation[] ann = tc.getClass().getDeclaredAnnotations();
        for (int i = 0; i < ann.length; i++) {
            Annotation annotation = ann[i];
            System.out.println(annotation);
        }
        return reStr;
    }
}
