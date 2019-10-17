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
public class Circle extends ShapeA{
    public double radiu;

    public double getRadiu() {
        return radiu;
    }

    public void setRadiu(double radiu) {
        this.radiu = radiu;
    }

    public Circle() {
    }

    public Circle(double radiu) {
        this.radiu = radiu;
    }
    
    public double area(double radiu) {
        return Math.PI*Math.pow(radiu, 2);
    }
    
}
