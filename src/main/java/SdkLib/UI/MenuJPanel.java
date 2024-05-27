/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package SdkLib.UI;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import oracle.net.aso.g;

/**
 *
 * @author priya
 */
public class MenuJPanel extends javax.swing.JPanel {

    /**
     * Creates new form MenuJPanel
     */
    public MenuJPanel() {
        initComponents();
        setOpaque(true); 
        listMenu1.setOpaque(false);
        
        
        
        
    }
    public void addItem(ImageIcon icon,String name, String type){
        type=type.toUpperCase();
        switch(type){
            case "MENU":
                listMenu1.addItem(new MenuModel(icon,name,MenuModel.MenuType.MENU));
                break;
                 case "TITLE":
                listMenu1.addItem(new MenuModel(icon,name,MenuModel.MenuType.TITLE));
                break;
                 case "EMPTY":
                listMenu1.addItem(new MenuModel(icon,name,MenuModel.MenuType.EMPTY));
                break;
        }
    }
    
/**
     * @param color1 the color1 to set
     */
    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    /**
     * @param color2 the color2 to set
     */
    public void setColor2(Color color2) {
        this.color2 = color2;
    }
    
    private String Color1="#1CB5E0",Color2="#000046";
    private Color color1=Color.decode(Color1),color2=Color.decode(Color2);
    

    
    
    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2=(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint grd = new GradientPaint(0,0,color1,0,getHeight(),color2);
        g2.setPaint(grd);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth()-20,0, getWidth(), getHeight());
        g2.setBackground(getBackground());
        super.paintChildren(g); 
        
    }
    private int x,y;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMov = new javax.swing.JPanel();
        AppName = new javax.swing.JLabel();
        Logo = new javax.swing.JLabel();
        listMenu1 = new SdkLib.UI.ListMenu<>();

        setLayout(null);

        panelMov.setOpaque(false);
        panelMov.setLayout(null);

        AppName.setBackground(new java.awt.Color(255, 255, 255));
        AppName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        AppName.setText("APPLICATION NAME");
        panelMov.add(AppName);
        AppName.setBounds(53, 5, 178, 25);
        panelMov.add(Logo);
        Logo.setBounds(236, 17, 0, 0);

        listMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        panelMov.add(listMenu1);
        listMenu1.setBounds(0, 90, 290, 620);

        add(panelMov);
        panelMov.setBounds(0, 0, 290, 704);
    }// </editor-fold>//GEN-END:initComponents
    public void initmoving(JFrame jf){
        panelMov.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me){
                x=me.getX();
                y=me.getY();
                super.mousePressed(me);
            }
        });
        panelMov.addMouseMotionListener(new MouseMotionAdapter(){

            @Override
            public void mouseDragged(MouseEvent me) {
                jf.setLocation(me.getXOnScreen()-x,me.getYOnScreen()-y);
                super.mouseDragged(me); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AppName;
    private javax.swing.JLabel Logo;
    private SdkLib.UI.ListMenu<String> listMenu1;
    private javax.swing.JPanel panelMov;
    // End of variables declaration//GEN-END:variables
}
