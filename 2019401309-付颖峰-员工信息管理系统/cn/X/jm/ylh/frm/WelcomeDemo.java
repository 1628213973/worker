package cn.X.jm.ylh.frm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

;


public class WelcomeDemo extends JFrame{/**主窗口类*/
    private JFrame window;
    private JButton enter,exit;
    private JLabel lb;
    private JPanel pEnter;
    public WelcomeDemo() {
        window=new JFrame("职员信息登录系统");
        window.setSize(750, 540);
        window.setLocationRelativeTo(null);/**设置主窗口显示在屏幕中央*/
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);/**清空布局管理器*/
        window.setResizable(false);
        ImageIcon icon = new ImageIcon("D:/新建文件夹 (2)/src/20151126111222923.png");
        icon.setImage(icon.getImage().getScaledInstance((int)(icon.getIconWidth()),
                (int)(icon.getIconHeight()),0 ));
        lb=new JLabel(new ImageIcon("src/20151126111222923.png"));
        lb.setBounds(0, 0, (int)(icon.getIconWidth()), (int)(icon.getIconHeight()));
        window.add(lb,BorderLayout.NORTH);
        exit = new JButton("退出系统");
        enter=new JButton("进入系统");
        enter.setBounds(200,440,120,50);
        exit.setBounds(350, 440,120,50);
        window.add(enter);
        window.add(exit);
        addListened();
        window.setVisible(true);
    }

    public void addListened() {/**注册事件监听器，重写actionPerformed方法*/
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                window.dispose();
            }
        });
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
new SelectionFuncation();
                window.dispose();
            }
        });

    }
}

//b3

