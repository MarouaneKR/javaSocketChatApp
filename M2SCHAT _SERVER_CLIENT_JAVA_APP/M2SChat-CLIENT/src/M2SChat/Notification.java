/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M2SChat;

/**
 *
 * @author M-KR
 */
public class Notification {
    
    public boolean notif;
    public String Name;
    public Notification(String Name, boolean msg)
    {
        this.Name = Name;
        this.notif = msg;
        
    }
    
}
