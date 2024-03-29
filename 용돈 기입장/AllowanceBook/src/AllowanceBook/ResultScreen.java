package AllowanceBook;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ResultScreen extends JFrame {

	private JPanel Panel;
	private JButton closeBtn;
	private JButton incomeT, spendT, total;
	private String money;
	private int incomeMoney, spendMoney;
	
	private JTextField incomeTotal, spendTotal, Total;
	
	private ImageIcon closeBtnE = new ImageIcon(getClass().getResource("../image/closeBtnE.png"));
	private ImageIcon closeBtnB = new ImageIcon(getClass().getResource("../image/closeBtnB.png"));
	

	public ResultScreen() {
		setTitle("�� �հ�");
		setIconImage(Toolkit.getDefaultToolkit().getImage(test.class.getResource("/image/MoneyGun.png")));
		Panel = new JPanel();
		Panel.setBackground(new Color(255, 222, 239));
		
		closeBtn = new JButton();
		closeBtn.setBounds(120, 255, 100, 40);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusable(false);	
		closeBtn.addMouseListener((MouseListener) new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				closeBtn.setIcon(closeBtnE);
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			@Override
			public void mouseExited(MouseEvent e) {
				closeBtn.setIcon(closeBtnB);
				closeBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});	
		closeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)   {		
				try {
		            dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				};
			}
		});
		
		try { 

			BufferedReader income = new BufferedReader(new FileReader("���� ����.txt"));
			BufferedReader spend = new BufferedReader(new FileReader("���� ����.txt"));
			
			String incomeS, spendS;
			
			while ((incomeS = income.readLine()) != null) {
				
			String[] split = incomeS.split("\t");

			money = split[1];
			incomeMoney += Integer.parseInt(money);

			}
			while ((spendS = spend.readLine()) != null) {
			
				String[] split = spendS.split("\t");

				money = split[1]; 
				spendMoney += Integer.parseInt(money);

			}
			
			income.close();
			spend.close();
			
			} catch (IOException ioe) {
				System.err.println(ioe);
			}
		
		incomeT = new JButton("���Ծ�");
		incomeT.setFont(new Font("������������� ExtraBold", Font.PLAIN, 18));
		incomeT.setFocusable(false);
		incomeT.setContentAreaFilled(false);
		incomeT.setBorderPainted(false);
		incomeT.setBounds(26, 21, 100, 35);
		
		spendT = new JButton("�����");
		spendT.setFont(new Font("������������� ExtraBold", Font.PLAIN, 18));
		spendT.setFocusable(false);
		spendT.setContentAreaFilled(false);
		spendT.setBorderPainted(false);
		spendT.setBounds(26, 78, 100, 35);
		
		total = new JButton("�� �հ�");
		total.setFont(new Font("������������� ExtraBold", Font.PLAIN, 18));
		total.setFocusable(false);
		total.setContentAreaFilled(false);
		total.setBorderPainted(false);
		total.setBounds(26, 177, 100, 35);
		
		incomeTotal = new JTextField();
		incomeTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		incomeTotal.setFont(new Font("������������� ExtraBold", Font.PLAIN, 18));
		incomeTotal.setEnabled(false);
		incomeTotal.setBounds(152, 22, 160, 35);
		incomeTotal.setColumns(10);
		incomeTotal.setText(Integer.toString(incomeMoney));
		
		spendTotal = new JTextField();
		spendTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		spendTotal.setFont(new Font("������������� ExtraBold", Font.PLAIN, 18));
		spendTotal.setEnabled(false);
		spendTotal.setBounds(152, 79, 160, 35);
		spendTotal.setColumns(10);
		spendTotal.setText(Integer.toString(spendMoney));
		
		Total = new JTextField();
		Total.setHorizontalAlignment(SwingConstants.RIGHT);
		Total.setFont(new Font("������������� ExtraBold", Font.PLAIN, 18));
		Total.setEnabled(false);
		Total.setBounds(152, 178, 160, 35);
		Total.setColumns(10);
		Total.setText(Integer.toString(incomeMoney - spendMoney));
		
		Panel.add(closeBtn);
		Panel.add(total);
		Panel.add(incomeT);
		Panel.add(spendT);
		Panel.add(incomeTotal);
		Panel.add(spendTotal);
		Panel.add(Total);
		
		Panel.setLayout(null);
		getContentPane().add(Panel);
	
		setResizable(false);
		setBounds(630, 160, 350, 350);
		setVisible(true);
	}
}
