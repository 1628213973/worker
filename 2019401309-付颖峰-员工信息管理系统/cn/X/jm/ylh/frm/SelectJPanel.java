package cn.X.jm.ylh.frm;



import cn.X.sjk.ylh.dbc.DBHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

;


//b3
/**选择界面*/
public class SelectJPanel {
   public SelectJPanel() {
       JFrame jFrame = new JFrame("职员信息管理系统");
       jFrame.setSize(600, 400);
       jFrame.setLocationRelativeTo(null);
       jFrame.setResizable(false);
       jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jFrame.setLayout(null);
       Container container = jFrame.getContentPane();
       jFrame.setVisible(true);
       JLabel jLabel = new JLabel("请输入需要查询的员工的身份证");
       jLabel.setFont(new Font("宋体", Font.PLAIN, 28));
       jLabel.setBounds(120, 40, 450, 30);

       JLabel lbName = new JLabel("员工身份证", JLabel.CENTER);
       lbName.setFont(new Font("宋体", Font.PLAIN, 20));
       lbName.setBounds(150, 90, 100, 30);

       TextField tfName = new TextField();
       tfName.setBounds(250, 93, 200, 25);
       TextArea textArea=new TextArea(40, 60);
       textArea.setBounds(107, 130, 420, 150);
       JScrollPane a7=new JScrollPane();
        a7.setBounds(107,130,420,150);
        a7.setViewportView(textArea);
       JButton jButton = new JButton("查询");
       jButton.setBounds(100, 300, 100, 30);
       JButton jButton2 = new JButton("查询全部");
       jButton2.setBounds(250, 300, 100, 30);
       JButton jButton1 = new JButton("返回上一级");
       jButton1.setBounds(400, 300, 100, 30);

       container.add(jLabel);
       container.add(jButton2);
       container.add(lbName);
       container.add(tfName);
       container.add(textArea);
       container.add(jButton);
       container.add(jButton1);
/**注册触发器，点击输出指定数据*/
       jButton1.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               // TODO Auto-generated method stub
               new SelectionFuncation();

           }
       });

       jButton.addActionListener(new ActionListener() {

           @Override
           public  void actionPerformed(ActionEvent e) {
               ResultSet rs=null;
               String resultStr ="";
               //准备执行
               Statement stmt=null;
               //获得conn
               Connection conn = null;
               String content= tfName.getText();
               // 生成一条sql语句
               String sql = "select * from staff where CNumber='"+content+"'";

               if (conn!=null) {
                   System.out.println("连接成功");
               }

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
                   }
                   textArea.setText(resultStr);

               } catch (Exception e1) {

                   e1.printStackTrace();
               }
               clear();

           }

           public void clear() {
               tfName.setText(null);
           }
       });
/**注册触发器，点击输出所以数据*/
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
                   //stmt=conn.prepareStatement(sql);
                   conn.close();
               } catch (Exception e1) {
                   e1.printStackTrace();
               }
           }
       });

   }

}

