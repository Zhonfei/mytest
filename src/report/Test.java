/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package report;

import com.google.gson.Gson;
import java.util.List;
import utils.Tools;

/**
 *
 * @author delta
 */
public class Test {
    
    public String upSum(List resultList) throws Exception{
        Tools.upSum(resultList, Test.class);
        return new Gson().toJson(resultList);
    }
}
