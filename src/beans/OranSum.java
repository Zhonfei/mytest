/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import utils.Tools;

/**
 *
 * @author delta
 */
public class OranSum {
    
    private Map parentMap;
    
    private Set levelSet;

    public OranSum(Map parentMap, Set levelSet) {
        this.parentMap = parentMap;
        this.levelSet = levelSet;
    }

    public OranSum() {
    }

    public void setParentMap(Map parentMap) {
        this.parentMap = parentMap;
    }

    public void setLevelSet(Set levelSet) {
        this.levelSet = levelSet;
    }

    public Map getParentMap() {
        return parentMap;
    }

    public Set getLevelSet() {
        return levelSet;
    }
    
    @Override
    public String toString() {
        return "OranSum{" + "parentMap=" + parentMap + ", levelSet=" + levelSet + '}';
    }
    
    
    
}
