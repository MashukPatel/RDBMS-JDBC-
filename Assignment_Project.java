package com.sw;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class Registration implements ActionListener
{
	JFrame frame;
	JPanel p1,p2;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JTextField t1,t2,t3,t4;
	JRadioButton r1,r2;
	ButtonGroup bg1;
	JTextArea ta1;
	JButton b1,b2,b3,b4,b5,b6;
	JTable table1;
	DefaultTableModel model;
	JScrollPane sp1;
	
	String[] c= {"SR No.","ID","Name","Gender","Address","Mobile No."}; 
	String gender,name,address,mobile,gen;
	int srno;
	int id,rowremover=0;
	
	public Registration() 
	{
		frame=new JFrame();
		frame.setLayout(null);
		frame.setSize(1100,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		p1=new JPanel();
		p1.setBounds(0,0,370,1000);
		p1.setLayout(null);
	
		p2=new JPanel();
		p2.setBounds(370,0,730,1000);
		p2.setLayout(null);
		
	
		l1=new JLabel("Registration Form");
		l1.setBounds(100,10,200,40);
		l1.setFont(new Font("Times New Roman",Font.PLAIN,25));
		p1.add(l1);
		
		l2=new JLabel("ID :");
		l2.setBounds(20,70,30,30);
		l2.setFont(new Font("Arial",Font.PLAIN,20));
		p1.add(l2);
		
		t1=new JTextField();
		t1.setBounds(140,70,210,30);
		t1.setFont(new Font("Times New Roman",Font.PLAIN,18));
		p1.add(t1);
		
		l3=new JLabel("Name :");
	    l3.setBounds(20,120,70,30);
	    l3.setFont(new Font("Arial",Font.PLAIN,20));
		p1.add(l3);
		
		t2=new JTextField();
		t2.setBounds(140,120,210,30);
		t2.setFont(new Font("Times New Roman",Font.PLAIN,18));
		p1.add(t2);
		
		l4=new JLabel("Gender :");
	    l4.setBounds(20,170,80,30);
	    l4.setFont(new Font("Arial",Font.PLAIN,20));
		p1.add(l4);
		
		r1=new JRadioButton("Male");
		r1.setBounds(140,170,70,30);
		r1.setFont(new Font("Times New Roman",Font.PLAIN,18));
		p1.add(r1);
		
		r2=new JRadioButton("Female");
		r2.setBounds(220,170,100,30);
		r2.setFont(new Font("Times New Roman",Font.PLAIN,18));
		p1.add(r2);
	
		bg1=new ButtonGroup();
		bg1.add(r1);
		bg1.add(r2);
		
		l5=new JLabel("Address :");
	    l5.setBounds(20,220,90,30);
	    l5.setFont(new Font("Arial",Font.PLAIN,20));
		p1.add(l5);
		
		ta1=new JTextArea();
		ta1.setBounds(140,220,210,70);
		ta1.setFont(new Font("Times New Roman",Font.PLAIN,15));
		p1.add(ta1);
		
		l6=new JLabel("Mobile No :");
	    l6.setBounds(20,310,110,30);
	    l6.setFont(new Font("Arial",Font.PLAIN,20));
		p1.add(l6);
		
		t3=new JTextField();
		t3.setBounds(140,310,210,30);
		t3.setFont(new Font("Times New Roman",Font.PLAIN,18));
		p1.add(t3);
		
		b1=new JButton("Exit");
		b1.setBounds(50,390,120,40);
		b1.setFont(new Font("Times New Roman",Font.PLAIN,18));
		b1.addActionListener(this);
		p1.add(b1);
		
		b2=new JButton("Register");
		b2.setBounds(190,390,120,40);
		b2.setFont(new Font("Times New Roman",Font.PLAIN,18));
		b2.addActionListener(this);
		p1.add(b2);
		
		b3=new JButton("Delete");
		b3.setBounds(50,450,120,40);
		b3.setFont(new Font("Times New Roman",Font.PLAIN,18));
		b3.addActionListener(this);
		p1.add(b3);
		
		b4=new JButton("Update");
		b4.setBounds(190,450,120,40);
		b4.setFont(new Font("Times New Roman",Font.PLAIN,18));
		b4.addActionListener(this);
		p1.add(b4);
		
		b5=new JButton("Reset");
		b5.setBounds(125,510,120,40);
		b5.setFont(new Font("Times New Roman",Font.PLAIN,18));
		b5.addActionListener(this);
		p1.add(b5);
		
		
		
		model=new DefaultTableModel();
		model.setColumnIdentifiers(c);
		table1=new JTable();
		table1.setModel(model);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table1.setFont(new Font("Arial",Font.PLAIN,15));
		
		sp1=new JScrollPane(table1);
		sp1.setBounds(0,30,700,400);
		sp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//sp1.setViewportView(table1);
		p2.add(sp1);
		
		b6=new JButton("Refresh Table");
		b6.setBounds(200,450,300,35);
		b6.setFont(new Font("Times New Roman",Font.PLAIN,18));
		b6.addActionListener(this);
		p2.add(b6);
		
		frame.setVisible(true);
		frame.add(p1);
		frame.add(p2);

				
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b1)
		{
			System.exit(0);
		}
		
		if(e.getSource()==b2)
		{
			if(t1.getText().trim().equals("") || t2.getText().trim().equals("") || t3.getText().trim().equals("") || ta1.getText().trim().equals("") || (!r1.isSelected() && !r2.isSelected()))
			{
				if(t1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame, "Please enter your id.");					
				}
				else if(t2.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame, "Please enter your name.");					
				}
				else if(!(r1.isSelected() || r2.isSelected()))
				{
					JOptionPane.showMessageDialog(frame, "Please specify your gender..");					
				}
				else if(ta1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame, "Please enter your address.");					
				}
				else if(t3.getText().equals(""))
				{
					JOptionPane.showMessageDialog(frame, "Please enter your mobile no.");					
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "All the fields are manadatory.");
				}
			}
			else
			{
				if(r1.isSelected())
				{
					gender="Male";
				}
				else
				{
					gender="Female";
				}
				
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
					Statement st=con.createStatement();
					int x=st.executeUpdate("insert into userdetails values(null,'"+t1.getText().toString()+"', '"+t2.getText().toString()+"', '"+gender+"', '"+ta1.getText().toString()+"', '"+t3.getText().toString()+"')");
					if(x>0)
					{
						JOptionPane.showMessageDialog(frame,"Data inserted successfully.");
					}
					else
					{
						JOptionPane.showMessageDialog(frame,"Data not inserted. Please try again!");
					}
					con.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
						
		}
		
		if(e.getSource()==b3)
		{
			if(t1.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(frame, "Please enter id to delete a record.");
			}
			else
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
					Statement st=cn.createStatement();
					int x=st.executeUpdate("delete from userdetails where id='"+t1.getText()+"'");
					if(x>0)
					{
						JOptionPane.showMessageDialog(frame, "Record deleted successfully.");
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Record not deleted.");
					}
					cn.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		}
		
		if(e.getSource()==b4)
		{
			if(t1.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(frame, "Please enter id to update a record.");
			}
			else
			{
				if(r1.isSelected())
				{
					gender="Male";
				}
				else
				{
					gender="Female";
				}
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
					Statement st=cn.createStatement();
					int x=st.executeUpdate("update userdetails set uname='"+t2.getText().toString()+"', gender='"+gender+"', address='"+ta1.getText()+"', mobile='"+t3.getText().toString()+"' where id="+t1.getText().toString()+"");
					if(x>0)
					{
						JOptionPane.showMessageDialog(frame, "Record updated successfully.");
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Record not updated.");
					}
					cn.close();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if(e.getSource()==b5)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			ta1.setText("");
		}
		if(e.getSource()==b6)
		{
			rowremover++;
			if(rowremover>1)
			{
				model.getDataVector().removeAllElements();
			}
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment","root","");
				Statement st=cn.createStatement();
				ResultSet rs=st.executeQuery("select * from userdetails");
				
				while(rs.next())
				{
					srno=rs.getInt("srno");
					id=rs.getInt("id");
					name=rs.getString("uname");
					gen=rs.getString("gender");
					address=rs.getString("address");
					mobile=rs.getString("mobile");
					String[] row= {Integer.toString(srno),Integer.toString(id),name,gen,address,mobile};
					model.addRow(row);
				}
				
				cn.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		
	}
}
public class Assignment_Project 
{
	public static void main(String[] args) 
	{
		new Registration();
	}
}
