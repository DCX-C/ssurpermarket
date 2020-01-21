package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import item.Item;
import pay.Pay;
import java.math.BigDecimal;
import java.util.*;




public class Ui
{

    public static float total = 0;
    public static int currenPage = 1;
    public static void main(String[] args)
    {
        Ui maker = new Ui();
        Item item[];

        item = new Item[100];

        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(null);
        itemPanel.setBounds(0,0,600,600);

        JPanel pagePanel = new JPanel();
        pagePanel.setBounds(0,600,600,200);

        JPanel carPanel = new JPanel();
        carPanel.setLayout(new GridLayout(15,1));
        carPanel.setBounds(600,0,300,600);


        JPanel payPanel = new JPanel();
        payPanel.setBounds(600,600,300,200);
        Pay pay = new Pay();

        //pay
        JLabel label = new JLabel("共计:");
        label.setBounds(0,0,150,75);
        JTextField text = new JTextField("0");
        text.setBounds(0,100,150,75);
        text.setColumns(10);
        JButton buy = new JButton("buy");
        buy.setBounds(200,60,75,75);

        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(Float.parseFloat(text.getText())-total>=0)
                     JOptionPane.showConfirmDialog(null, "找您"+(Float.parseFloat(text.getText())-total)+"元", "找零", JOptionPane.PLAIN_MESSAGE);
                else
                    JOptionPane.showConfirmDialog(null, "金额不足", "金额不足", JOptionPane.PLAIN_MESSAGE);

            }
        });
        payPanel.add(label);
        payPanel.add(text);
        payPanel.add(buy);




        JFrame frame = new JFrame("广工商城");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,800);
        frame.setLayout(null);
        frame.add(itemPanel);
        frame.add(pagePanel);
        frame.add(payPanel);
        frame.add(carPanel);

        item[0] = new Item(0,0,"冰红茶",5,itemPanel,carPanel,label,true,0);
        item[1] = new Item(250,0,"冰绿茶",5,itemPanel,carPanel,label,true,1);
        item[2] = new Item(0,200,"可乐",5,itemPanel,carPanel,label,true,2);
        item[3] = new Item(250,200,"雪碧",5,itemPanel,carPanel,label,true,3);
        item[4] = new Item(0,400,"芬达",5,itemPanel,carPanel,label,true,4);
        item[5] = new Item(250,400,"营养快线",5,itemPanel,carPanel,label,true,5);

        item[6] = new Item(0,0,"",0,itemPanel,carPanel,label,false,6);
        item[7] = new Item(250,0,"",0,itemPanel,carPanel,label,false,7);
        item[8] = new Item(0,200,"",0,itemPanel,carPanel,label,false,8);
        item[9] = new Item(250,200"",0,itemPanel,carPanel,label,false,9);
        item[10] = new Item(0,400,"",0,itemPanel,carPanel,label,false,10);
        item[11] = new Item(250,400,"",0,itemPanel,carPanel,label,false,11);

        for(int i = 12;i<100;i++)
        {
            item[i] = item[i-6];
            item[i].setText("未上架");
        }


        //page
        JLabel page = new JLabel(String.valueOf(currenPage));

        JButton leftButton = new JButton("<");
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Ui ui = new Ui();
                if(currenPage!=1)
                {
                    ui.turnPage(item,"左翻", currenPage);
                    page.setText(String.valueOf(currenPage));
                }
            }
        });




        JButton rightButton = new JButton(">");
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Ui ui = new Ui();

                    ui.turnPage(item,"右翻", currenPage);
                page.setText(String.valueOf(currenPage));

            }
        });



        pagePanel.add(leftButton);
        pagePanel.add(rightButton);
        pagePanel.add(page);
        pagePanel.setVisible(false);
        pagePanel.setVisible(true);















    }

    public void turnPage(Item[] item,String diretion,int page)
    {
        if(diretion == "左翻")
        {
            int i = page*6-6;
            for(int q = i;q < page+6;q++)
                item[q].setVisible(false);
            for(int q = i-6;q<i;q++)
                item[q].setVisible(true);
            currenPage -=1;
        }
        else if(diretion == "右翻")
        {
            int i = page*6-6;
            for(int q = i;q < page+6;q++)
                item[q].setVisible(false);
            for(int q = i+6;q<i+12;q++)
                item[q].setVisible(true);
            currenPage+=1;
        }
        else
            ;


    }







}
