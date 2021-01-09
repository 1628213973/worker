package cn.X.jm.ylh.frm;



import cn.X.sjk.ylh.dbc.DBHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

;


//b3

//b4
/**修改界面*/
 public class AlterJPanel {

    public AlterJPanel() {
        JFrame jFrame = new JFrame("职员信息管理系统");
        jFrame.setSize(600, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        Container container = jFrame.getContentPane();
        jFrame.setVisible(true);
        JLabel jLabel = new JLabel("员工信息修改界面");
        jLabel.setFont(new Font("宋体", Font.PLAIN, 28));
        jLabel.setBounds(180, 40, 450, 30);

        JLabel lbName = new JLabel("姓名", JLabel.CENTER);
        lbName.setFont(new Font("宋体", Font.PLAIN, 20));
        lbName.setBounds(107, 225, 50, 25);
        JLabel lbPhone = new JLabel("电话", JLabel.CENTER);
        lbPhone.setFont(new Font("宋体", Font.PLAIN, 20));
        lbPhone.setBounds(250, 225, 50, 25);
        JLabel lbCNumber = new JLabel("身份证", JLabel.CENTER);
        lbCNumber.setFont(new Font("宋体", Font.PLAIN, 20));
        lbCNumber.setBounds(107, 255, 60, 25);

        JLabel lbPosition = new JLabel("职位", JLabel.CENTER);
        lbPosition.setFont(new Font("宋体", Font.PLAIN, 20));
        lbPosition.setBounds(107, 285, 50, 25);
        TextField tfPosition = new TextField();
        tfPosition.setBounds(157, 285, 200, 25);

        TextField tfName = new TextField();
        tfName.setBounds(157, 225, 80, 25);
		//tfName.setBounds(x, y, width, height);
        TextField tfPhone = new TextField();
        tfPhone.setBounds(300, 225, 200, 25);
        TextField tfCNumber = new TextField();
        tfCNumber.setBounds(173, 255, 200, 25);

        TextArea textArea=new TextArea("按身份证号查询修改信息" ,40, 60);
        textArea.setBounds(107, 93, 400, 120);

        JButton jButton = new JButton("确认修改");
        jButton.setBounds(100, 320, 100, 30);
        JButton jButton2 = new JButton("查询全部");
        jButton2.setBounds(250, 320, 100, 30);
        JButton jButton1 = new JButton("返回上一级");
        jButton1.setBounds(400, 320, 100, 30);

        container.add(jButton1);
        container.add(jButton2);
        container.add(jButton);
        container.add(textArea);
        container.add(tfCNumber);
        container.add(tfPhone);
        container.add(tfName);
        container.add(lbCNumber);
        container.add(lbPhone);
        container.add(lbName);
        container.add(jLabel);
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
                String content4 = tfPosition.getText();
                //UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值
                //UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing' WHERE LastName = 'Wilson'
                String sql = "update staff set tfPosition='"+content4+"',Phone='"+content3 +"',name='"+content1+"'where CNumber='"+content2+"'";
                DBHelper dbHelper= new DBHelper(sql);
                conn= dbHelper.conn;
                try {
                    pst=conn.prepareStatement(sql);
                    int i=pst.executeUpdate();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                JOptionPane .showMessageDialog(null, "修改成功","输入用户信息提示框", JOptionPane.INFORMATION_MESSAGE);
                clear();
            }


            public void clear() {
                tfName.setText(null);
                tfCNumber.setText(null);
                tfPhone.setText(null);
                tfPosition.setText(null);
            }
        });
/**注册jButton2的触发事件*/
        jButton2.addActionListener(new ActionListener() {

            @Override
            public  void actionPerformed(ActionEvent e) {
                ResultSet rs=null;
                String resultStr ="";
                //准备执行
                Statement stmt=null;
                //获得conn
                Connection conn = null;
                // 生成一条sql语句
                String sql = "select * from staff ";

                try {
                    DBHelper dbHelper = new DBHelper(sql);
                    //与数据库建立连接
                    conn = dbHelper.conn;
                    //实例化Statement对象
                    stmt=conn.createStatement();
                    rs=stmt.executeQuery(sql);
                    while(rs.next())
                    {
                        resultStr = "姓名:"+rs.getString("name")+"  身份证号:"+rs.getString("CNumber")+"  电话号码:"+rs.getString("Phone")+"  职位:"+rs.getString("position");
                        resultStr = resultStr + "\n";
                        textArea.append(resultStr);
                    }
                    stmt=conn.prepareStatement(sql);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }
}

