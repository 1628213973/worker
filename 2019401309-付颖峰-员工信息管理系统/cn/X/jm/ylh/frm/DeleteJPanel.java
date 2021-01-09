package cn.X.jm.ylh.frm;



import cn.X.sjk.ylh.dbc.DBHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

;


//b2

public class DeleteJPanel extends JFrame {/**删除界面*/

    public DeleteJPanel() {
        JFrame jFrame = new JFrame("职员信息管理系统");
        jFrame.setSize(600, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        Container container = jFrame.getContentPane();
        jFrame.setVisible(true);
        JLabel jLabel = new JLabel("请输入需要删除的员工的身份证号");
        jLabel.setFont(new Font("宋体", Font.PLAIN, 28));
        jLabel.setBounds(110, 40, 450, 30);

        JLabel lbCNumber = new JLabel("员工身份证", JLabel.CENTER);
        lbCNumber.setFont(new Font("宋体", Font.PLAIN, 20));
        lbCNumber.setBounds(150, 140, 100, 30);

        TextField tfCNumber = new TextField();
        tfCNumber.setBounds(250, 143, 200, 25);

        JButton jButton = new JButton("删除");
        jButton.setBounds(230, 260, 60, 30);
        JButton jButton1 = new JButton("返回上一级");
        jButton1.setBounds(330, 260, 100, 30);

        container.add(jLabel);
        container.add(lbCNumber);
        container.add(tfCNumber);
        container.add(jButton);
        container.add(jButton1);
/**注册触发器，点击返回selectfuncation*/
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new SelectionFuncation();

            }
        });
/**注册触发器，点击删除指定数据*/
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //准备执行
                PreparedStatement pst =null;
                //获得conn
                Connection conn = null;
               String content2= tfCNumber.getText();

                // 生成一条sql语句
                String sql = "delete  from staff where CNumber='"+content2+"'";
                DBHelper dbHelper = new DBHelper(sql);
                conn = dbHelper.conn;

//				if (conn!=null) {
//					System.out.println("连接成功");
//				}

                try {
                    pst=conn.prepareStatement(sql);
                    int i=pst.executeUpdate();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "删除成功", "输入用户信息提示框", JOptionPane.INFORMATION_MESSAGE);
                clear();
            }

            public void clear() {
                tfCNumber.setText(null);
            }
        });

    }

}
//b3

