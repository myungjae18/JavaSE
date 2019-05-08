package p0102;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ChatA extends JFrame implements ActionListener, KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JPanel p_south;
	JTextField t_input;
	JButton bt;
	ChatB chatB;
	ChatC chatC;
				
	//chatA 초기화
	public ChatA(){
		area=new JTextArea();
		scroll=new JScrollPane(area);
		p_south=new JPanel();
		t_input=new JTextField(12);
		bt=new JButton("open");
		
		add(scroll);
		p_south.add(t_input);
		p_south.add(bt);
		add(p_south, BorderLayout.SOUTH);
		setVisible(true);
		setBounds(200,100,300,400);

		bt.addActionListener(this);
		t_input.addKeyListener(this);
	}
	public void actionPerformed(ActionEvent e){
		chatB=new ChatB(this);
		chatC=new ChatC(this);
	}
	public void keyReleased(KeyEvent k){
		if(k.getKeyCode()==KeyEvent.VK_ENTER){
			System.out.println("키 누름");
			String msg=t_input.getText();
			sendMsg(msg);
			//기존의 t_input의 입력값을 다시 초기화
			t_input.setText("");
		}
	}
	public void keyPressed(KeyEvent k){}
	public void keyTyped(KeyEvent k){}
	
	//대화 상대방의 textarea뿐만 아니라 나의 textarea에 메세지를 출력하자
	public void sendMsg(String msg){
		area.append(msg+"\n");
		chatB.area.append(msg+"\n");
		chatC.area.append(msg+"\n");
	}
	public static void main(String[] args){
		new ChatA();
	}
}
