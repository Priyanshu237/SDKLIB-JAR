/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SdkLib.UI;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author priya
 */
public class MenuModel {

    /**
     * @return the Icon
     */
    public ImageIcon getIcon() {
        return Icon;
    }

    /**
     * @param Icon the Icon to set
     */
    public void setIcon(ImageIcon Icon) {
        this.Icon = Icon;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public MenuType getType() {
        return type;
    }
    
    public void setPath(String path){
        Path=path;
    }

    public MenuModel( ImageIcon Icon, String name, MenuType type) {
        
        this.Icon = Icon;
        this.name = name;
        this.type = type;
        
    }
    
    
    /**
     * @param type the type to set
     */
    public void setType(MenuType type) {
        this.type = type;
    }
    private ImageIcon Icon;
    private String name;
    private MenuType type;
    public static enum MenuType{
        TITLE,MENU,EMPTY
    }
    private String Path="";
    
}
