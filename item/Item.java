package item;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pay.Pay;
import ui.Ui;

import static ui.Ui.total;

public class Item extends JButton{

    public String name;
    public float price;
    public int st;
    Pay pay = new Pay();
    public Item (int x,int y,String name,float price,JPanel panel,JPanel car,JLabel pTotal,boolean u,int st)
    {
        super(name+"价格:"+price);
        this.name = name;
        this.st = st;
        this.price = price;

        setBounds(x,y,250,200);
        panel.add(this);
        if(u)
            this.setVisible(true);
        else
            this.setVisible(false);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pay.item += 1;
                JLabel text = new JLabel(name + "价格：" + price);
                setVisible(false);
                setVisible(true);
                car.add(text);
                total +=price;
                pTotal.setText("总计:"+total);
            }


        });



}
    public void setName (String name) {this.name = name;}
    public void setPrice(float price) {this.price = price;}


}





