package cn.X.jm.ylh.frm;
import cn.X.sjk.ylh.dbc.DBHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**增加窗口*/
    public class AddJPanel extends JFrame {//b1
        public Connection conn = null;
        /**增加窗口的构造方法*/
        public AddJPanel() {
            JFrame jFrame = new JFrame("职员信息管理系统");
            jFrame.setSize(600, 400);
            jFrame.setLocationRelativeTo(null);
            jFrame.setResizable(false);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setLayout(null);
            Container container = jFrame.getContentPane();
            jFrame.setVisible(true);
            JLabel jLabel = new JLabel("请输入需要添加的员工的信息");
            jLabel.setFont(new Font("宋体", Font.PLAIN, 28));
            jLabel.setBounds(110, 40, 400, 30);


            JLabel lbName = new JLabel("姓名", JLabel.CENTER);
            lbName.setFont(new Font("宋体", Font.PLAIN, 20));
            lbName.setBounds(150, 100, 50, 25);
            JLabel lbCNumber = new JLabel("身份证", JLabel.CENTER);
            lbCNumber.setFont(new Font("宋体", Font.PLAIN, 20));
            lbCNumber.setBounds(150, 140, 60, 25);
            JLabel lbPhone = new JLabel("电话", JLabel.CENTER);
            lbPhone.setFont(new Font("宋体", Font.PLAIN, 20));
            lbPhone.setBounds(150, 180, 50, 25);

            JLabel lbPosition = new JLabel("职位", JLabel.CENTER);
            lbPosition.setFont(new Font("宋体", Font.PLAIN, 20));
            lbPosition.setBounds(150, 220, 50, 25);

            TextField tfName = new TextField();
            tfName.setBounds(230, 100, 200, 25);
            TextField tfCNumber = new TextField();
            tfCNumber.setBounds(230, 140, 200, 25);
            TextField tfPhone = new TextField();
            tfPhone.setBounds(230, 180, 200, 25);
            TextField tfPosition = new TextField();
            tfPosition.setBounds(230, 220, 200, 25);

            JButton jButton = new JButton("添加");
            jButton.setBounds(230, 260, 60, 30);
            JButton jButton1=new JButton("返回上一级");
            jButton1.setBounds(330, 260, 100, 30);

            container.add(jLabel);
            container.add(lbName);
            container.add(lbCNumber);
            container.add(lbPhone);
            container.add(tfName);
            container.add(tfCNumber);
            container.add(tfPhone);
            container.add(jButton);
            container.add(jButton1);
            container.add(tfPosition);
            container.add(lbPosition);
            /**注册jButton1的触发事件*/
            jButton1.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    new SelectionFuncation();
                }
            });
            /**注册jButton的触发事件*/
            jButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    PreparedStatement pst=null;
                    Connection conn=null;
                    String content1 = tfName.getText();
                    String content2 = tfCNumber.getText();
                    String content3 = tfPhone.getText();
                    String content4=tfPosition.getText();
                    String /**加载增加按键界面*/sql = "insert into staff(name, CNumber, Phone,position) values(?,?,?,?)";
                    DBHelper dbHelper= new DBHelper(sql);
                    conn= dbHelper.conn;
                    try {
                        pst=conn.prepareStatement(sql);
                        pst.setString(1, content1);
                        pst.setString(2, content2);
                        pst.setString(3, content3);
                        pst.setString(4,content4);
                        int i=pst.executeUpdate();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(null, "添加成功","输入用户信息提示框", JOptionPane.INFORMATION_MESSAGE);
                    clear();
                }
/**清除tfName，tfCNumber，tfPhone，tfPosition*/
                public void clear() {
                    tfName.setText(null);
                    tfCNumber.setText(null);
                    tfPhone.setText(null);
                    tfPosition.setText(null);
                }
            });

        }

    }

