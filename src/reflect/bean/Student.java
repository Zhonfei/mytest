/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reflect.bean;

/**
 *
 * @author delta
 */
public class Student {
    public String name;
    protected int ageI;
    char sex;
    private  String phone;

    public Student() {
        System.out.println("无参构造");
    }
    
    public void show(String name,Integer age){
        System.out.println("调用show方法");
        System.out.println("name="+name+"\tage="+age);
    }

    @Override
    public String toString() {
        System.out.println("调用toString了");
        return "Student{" + "name=" + name + ", ageI=" + ageI + ", sex=" + sex + ", phone=" + phone + '}';
    }

    public Student(String name) {
        System.out.println("1个参数（name）");
        this.name = name;
    }

    public Student(String name, int ageI, char sex, String phone) {
        System.out.println("4个参数");
        this.name = name;
        this.ageI = ageI;
        this.sex = sex;
        this.phone = phone;
    }

    protected Student(char sex){
        System.out.println("1个参数（sex）");
        this.sex = sex;
    }
    
    private Student(int age){
        System.out.println("1个参数（age）");
        this.ageI = age;
    }
    
    
}
