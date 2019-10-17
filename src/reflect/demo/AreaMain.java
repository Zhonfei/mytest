/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reflect.demo;

import reflect.bean.Circle;
import reflect.bean.Rectangle;
import reflect.bean.ShapeA;

/**
 *
 * @author delta
 */
public class AreaMain {
    public static  void main(String[] args){
        AreaTools at = new AreaTools();
        ShapeA cir = new Circle(10.0);
        ShapeA rec = new Rectangle(0.3, 0.6);
        double cirArea = at.getArea(cir);
        double recArea = at.getArea(rec);
        System.out.println(cirArea+"\t"+recArea);
    }
}
