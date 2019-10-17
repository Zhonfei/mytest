/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reflect.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author delta
 */
public class ReDemo {
    
    //调用有参方法
    public void demo06(){
         Class cla = Student.class;
         Student stu;
         Method m; 
         try {
            stu= (Student)cla.newInstance();
            m = cla.getDeclaredMethod("show", String.class,Integer.class);
            m.invoke(stu, "zz",12);
        } catch (Exception e) {
            e.printStackTrace();
        }
         
         
    }
    
    //调用无参方法
    public void demo05(){
        Class cla = Student.class;
        try {
            Method m = cla.getDeclaredMethod("toString");
            Student stu = (Student)cla.newInstance();
            stu.name = "zz";
            stu.ageI = 20;
            stu.sex = '1';
            String str = (String)m.invoke(stu);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //获取属性
    public void demo04(){
        Class cla = Student.class;
        Field[] fs = cla.getDeclaredFields();
        for (Field field : fs) {
            field.setAccessible(true);
            System.out.println(field.getName());
        }
    }
    
    //调用构造方法
    public void demo03(){
         Class cla = Student.class;
         Constructor[] con = cla.getDeclaredConstructors();
         for (Constructor constructor : con) {
            System.out.println(constructor);
        }
         try {
             //调用无参构造
             //Constructor dy = con[con.length-1];
             //Object obj = dy.newInstance();
             //调用1个参数
             //Constructor dy = con[con.length-2];
            // Object obj = dy.newInstance("zhangsan");
             //调用4个参数
             Constructor dy = con[1];
             Object obj = dy.newInstance("zzz",22,'男',"12345678");
             Student stu = (Student)obj;
             
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println("******************************************");
         }
    }
    
    //通过反射获取构造方法
    public void demo02(){
        //1.加载Class对象
        Class cla = Student.class;
        //2.获取所有公有构造方法
        Constructor[] pubCon = cla.getConstructors();
        for (Constructor constructor : pubCon) {
            System.out.println(constructor);
        }
        System.out.println("------------------------");
        //获取所有构造方法
        Constructor[] con = cla.getDeclaredConstructors();
        for (Constructor constructor : con) {
             System.out.println(constructor);
        }
        System.out.println("------------------------");
        //获取公有、无参的构造方法
        //Constructor[] ncon = cla.getConstructors(null);
        //暴力访问
         Constructor[] ccon = cla.getDeclaredConstructors();
         for (Constructor constructor : ccon) {
            constructor.setAccessible(true);
            System.out.println(constructor);
        }
        System.out.println("******************************************");
    }
    
    //获取Class对象的三种方式
    public void demo01(){
        Student stu = new Student();
        //1.Obejct --> getClass();
        Class cla1 = stu.getClass();
        System.out.println(cla1);
        System.out.println(cla1.getSimpleName());
        //2.任何的数据类型都有一个"静态"的class属性
        Class cla2 = Student.class;
        System.out.println(cla2);
        System.out.println(cla2.getSimpleName());
        //3.通过Class类的静态方法forName方法
        Class cla3 = null;
        try {
            cla3 = Class.forName("reflect.bean.Student");
             System.out.println(cla3);
             System.out.println(cla3.getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("cla1==cla2?\t"+(cla1==cla2));
        System.out.println("cla1==cla3?\t"+(cla1==cla3));
        System.out.println("******************************************");
    }
    
    
}
