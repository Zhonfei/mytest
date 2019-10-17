/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package annotation;

/**
 *
 * @author delta
 */
public class TestController {
    
    
    @ReQuestMapping(value = "/getSome")
    public String getSome(){
        String str = "133333";
        
        return str;
    }
}
