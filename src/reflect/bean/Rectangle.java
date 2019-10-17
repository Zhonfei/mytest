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
public class Rectangle extends ShapeA{
    public double len;
    public double wid;

    public Rectangle() {
    }
    
    public Rectangle(double len, double wid) {
        this.len = len;
        this.wid = wid;
    }

    public double getLen() {
        return len;
    }

    public void setLen(double len) {
        this.len = len;
    }

    public double getWid() {
        return wid;
    }

    public void setWid(double wid) {
        this.wid = wid;
    }
    
    public double area(double len,double wid) {
        return len*wid;
    }
    
}
