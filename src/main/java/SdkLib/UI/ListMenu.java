/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package SdkLib.UI;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/**
 *
 * @author priya
 * @param <E>
 */

public class ListMenu<E extends Object> extends JList<E>  {
    public ListMenu(){
        setOpaque(false);
         model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof MenuModel) {
                        MenuModel menu = (MenuModel) o;
                        if (menu.getType() == MenuModel.MenuType.MENU) {
                            selectedIndex = index;
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
        });
    }
    public ListCellRenderer<? super E> getCellRenderer(){
        
        return new DefaultListCellRenderer(){
            
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object o, int index, boolean selected, boolean focus) {
                
               MenuModel data;
               if(o instanceof MenuModel)
                   data=(MenuModel)o;
               else data=new MenuModel(null,o+"",MenuModel.MenuType.EMPTY);
               MenuItem item=new MenuItem(data);
               item.setSelected(selectedIndex==index);
               return item;
            }    
        };
        
    }
    
     public void addItem(MenuModel data) {
        model.addElement(data);
    }
     
       private final DefaultListModel model;
        private int selectedIndex = -1;
}
