package com.sumit.runcmd.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.sumit.runcmd.CmdUtil;

public class TopFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private CmdUtil cu;
	private JTextPane textPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TopFrame frame = new TopFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TopFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				cu = new CmdUtil();
			}
		});
		setTitle("RunCMD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStart = new JButton("Execute");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cmd = textField.getText();
				String res = null;
				if(null==cmd || "".equals(cmd) || cmd.isEmpty()){
				}
				else{
					try {
						res = cu.execute(cmd);
					} catch (IOException e) {
						res = "Error Occured: "+e.getMessage();
					}
				}
				textPane.setText(res);
			}
		});
		btnStart.setBounds(335, 11, 89, 23);
		contentPane.add(btnStart);
		
		textField = new JTextField();
		textField.setBounds(10, 12, 317, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textPane = new JTextPane();
		textPane.setBounds(10, 43, 414, 401);
		contentPane.add(textPane);
	}
}
