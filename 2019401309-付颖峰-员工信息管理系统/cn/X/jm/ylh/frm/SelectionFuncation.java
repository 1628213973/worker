package cn.X.jm.ylh.frm;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

;


/**第二个选择功能界面*/
 public class SelectionFuncation extends JFrame {
    public SelectionFuncation() {
        JFrame window = new JFrame("职员信息管理系统");
        window.setSize(750, 540);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        window.setResizable(false);

        ImageIcon icon = new ImageIcon("src/26574409_160027717000_2.png");
        icon.setImage(icon.getImage().getScaledInstance((int) (icon.getIconWidth()), (int) (icon.getIconHeight()), 0));
        JLabel lb = new JLabel(new ImageIcon("src/26574409_160027717000_2.png"));
        lb.setBounds(0, 0, (int) (icon.getIconWidth()), (int) (icon.getIconHeight()));
        window.add(lb, BorderLayout.NORTH);

        JButton b1 = new JButton("添加员工信息");
        b1.setFont(new Font("宋体", Font.PLAIN, 30));
        JButton b2 = new JButton("删除员工信息");
        b2.setFont(new Font("宋体", Font.PLAIN, 30));
        JButton b3 = new JButton("查询员工信息");
        b3.setFont(new Font("宋体", Font.PLAIN, 30));
        JButton b4 = new JButton("修改员工信息");
        b4.setFont(new Font("宋体", Font.PLAIN, 30));

        b1.setBounds(200, 60, 300, 70);
        b2.setBounds(200, 160, 300, 70);
        b3.setBounds(200, 260, 300, 70);
        b4.setBounds(200, 360, 300, 70);
        window.add(b1);
        window.add(b2);
        window.add(b3);
        window.add(b4);

        window.setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
new AddJPanel();/**加载增加按键界面*/
                window.dispose();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteJPanel();/**加载删除按键界面*/
                window.dispose();

            }
        });

        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectJPanel();/**加载查找按键界面*/
                window.dispose();

            }
        });

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AlterJPanel();/**加载修改按键界面*/
                window.dispose();

            }
        });
    }
    }

//b3

