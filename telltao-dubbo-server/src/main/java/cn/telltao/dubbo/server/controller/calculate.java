package cn.telltao.dubbo.server.controller;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class calculate extends JFrame {
	JButton[] b = new JButton[10];
	JPanel panel1 = new JPanel(); // 实例化面板
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	//计算器面板上显示的数字
	JTextField answer = new JTextField(10);
	JButton clear = new JButton("清除");
	JButton equal = new JButton("=");
	JButton point = new JButton(".");
	JButton plus = new JButton("+");
	JButton minus = new JButton("-");
	JButton multi = new JButton("×");
	JButton division = new JButton("÷");
	//用来存储输入的值
	LinkedList numList = new LinkedList<>();
	Object op = new String();
	//使用包装类型来处理值
	Double d;


	int i = 9;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame calculator = new calculate();
		calculator.setVisible(true);

	}

	public calculate() {
		setTitle("Java简易计算器");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();//获取屏幕分辨率
		setLocation(screenSize.width / 4, screenSize.height / 4);//位置
		for (i = 9; i >= 0; i--) {
			b[i] = new JButton(Integer.toString(i));// 实例化数字按钮
			b[i].addActionListener(new MyListener1());
			panel2.add(b[i]); // 增加按钮到面板

		}

		setLayout(new FlowLayout()); // 设置布局管理器
		panel1.setLayout(new FlowLayout());
		panel2.setLayout(new GridLayout(4, 3, 10, 8));
		panel3.setLayout(new GridLayout(4, 1, 8, 12));
		clear.setFont(new Font("隶书", Font.PLAIN, 15));
		clear.setForeground(Color.BLUE);
		clear.addActionListener(new MyListener1());
		equal.setForeground(Color.RED);
		equal.addActionListener(new MyListener1());
		plus.setForeground(Color.RED);
		plus.addActionListener(new MyListener1());
		minus.setForeground(Color.RED);
		minus.addActionListener(new MyListener1());
		multi.setForeground(Color.RED);
		multi.addActionListener(new MyListener1());
		division.setForeground(Color.RED);
		division.addActionListener(new MyListener1());
		equal.setFont(new Font("隶书", Font.PLAIN, 20));
		plus.setFont(new Font("隶书", Font.PLAIN, 18));
		minus.setFont(new Font("隶书", Font.PLAIN, 18));
		multi.setFont(new Font("隶书", Font.PLAIN, 18));
		division.setFont(new Font("隶书", Font.PLAIN, 18));
		point.addActionListener(new MyListener1());
		panel1.add(answer);
		panel1.add(clear);
		panel2.add(point);
		panel2.add(equal);
		panel3.add(plus);
		panel3.add(minus);
		panel3.add(multi);
		panel3.add(division);
		add(panel1);
		add(panel2);
		add(panel3);
	}

	class MyListener1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			for (int i = 0; i <= 9; i++) {
				if (e.getSource() == b[i] || e.getSource() == point) {
					//answer.setText("");
					//如果点击了小数点 则拼接小数点
					if (e.getSource() == point) {
						String text = b[i].getText() + ".";
						//表示此处为 2.XX 要对他们进行拼接
						if (!answer.getText().isEmpty()) {
							String newStr = answer.getText() + ".";
							answer.setText(newStr);
						} else {
							//默认拼接
							answer.setText(text);
							numList.add(text);
						}

						break;
					} else {
						//判断 answer.getText() 中是否以 .结尾 如果是,则输入的为小数 要对小数进行拼接
						if (answer.getText().endsWith(".")) {
							//既然此处已经有小数点了 那么我们需要将之前保存在numList中的值进行删除 因为这是添加小数点进行运算的
							//先获取字符串的长度 假如 answer.getText() = 2. 那么长度为 2位 我们只要去掉小数点的位数就行 所以要减1
							int length = answer.getText().length() - 1;
							//substring 方法是截取字符串用的 例如字符为 2.0 截取后就变为2了 目的是去掉那个小数点
							String removeStr = answer.getText().substring(0, length);
							//现在小数点已经被去掉了 我们要吧这个数字从numList中删除 因为它是小数 不是整数是用来拼接用的
							numList.remove(removeStr);
							//删除之后 重新添加即可
							String newStr = answer.getText() + b[i].getText();
							numList.add(newStr);
							//返显值
							answer.setText(newStr);
						} else {
							//未点击小数点 直接拼接
							numList.add(b[i].getText());
							//返显值
							answer.setText(b[i].getText());
						}


					}
				}
			}
			if (e.getSource() == clear) {
				//点击清除按钮 重置值
				answer.setText("");
				numList.removeAll(numList);
			}
			if (e.getSource() == plus || e.getSource() == minus || e.getSource() == multi || e.getSource() == division) {
				answer.setText("");
				op = e.getSource();
			}
			if (e.getSource() == equal) {
				//点击 = 按钮 重置值
				answer.setText("");
				// +
				if (op == plus) {
					if (!numList.isEmpty()) {
						for (Object val : numList) {
							//如果d为null 则表示为首次加载 首次加载需要设置初始值
							if (d == null) {
								d = Double.valueOf(val.toString());
							} else {
								//非首次加载 直接进行运算
								d += Double.valueOf(val.toString());
							}
						}
					}
				}
				// -
				if (op == minus) {
					if (!numList.isEmpty()) {
						for (Object val : numList) {
							if (d == null) {
								d = Double.valueOf(val.toString());
							} else {
								d -= Double.valueOf(val.toString());
							}
						}
					}
				}
				// *
				if (op == multi) {
					if (!numList.isEmpty()) {
						for (Object val : numList) {
							if (d == null) {
								d = Double.valueOf(val.toString());
							} else {
								d *= Double.valueOf(val.toString());
							}
						}
					}
				}
				// /
				if (op == division) {
					if (!numList.isEmpty()) {
						for (Object val : numList) {

							if (d == null) {
								d = Double.valueOf(val.toString());
							} else {
								d /= Double.valueOf(val.toString());
							}
						}
					}
				}
				answer.setText("" + d);
				//返显完毕 重置此list的值
				d = null;
				numList.removeAll(numList);
			}
		}
	}
}

