/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

/**
 *
 * @author delta
 */
public class ConnectBean {
    private String driverName;
    
    private String url;
    
    private String userName;
    
    private String password;

    public ConnectBean() {
        
    }

    public ConnectBean(String driverName, String url, String userName, String password) {
        this.driverName = driverName;
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ConnectBean{" + "driverName=" + driverName + ", url=" + url + ", userName=" + userName + ", password=" + password + '}';
    }
    
    
}
