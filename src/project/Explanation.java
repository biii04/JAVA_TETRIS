package project;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


 
public class Explanation extends JFrame {

    //생성자
    public Explanation() {

        //타이틀 생성
        setTitle("Main");

       
        JLabel label1 = new JLabel("← :     왼쪽으로 이동");
        JLabel label2 = new JLabel("→ :     오른쪽으로 이동");
        JLabel label3 = new JLabel("↓ :     아래쪽으로 이동");
        JLabel label4 = new JLabel("↑ :     위쪽으로 이동");
        JLabel label5 = new JLabel("↑ :     위쪽으로 이동");
        JLabel label6 = new JLabel("P :     일시정지");
        JLabel label7 = new JLabel("D :     한 칸씩 내림");
        JLabel label8 = new JLabel("SPACE : 한 번에 내림");
        JLabel label9 = new JLabel("ESC :   일시정지 창");
        JLabel label10 = new JLabel("(재시작 / 나가기)");
        JLabel label11 = new JLabel("");
        
        
        //버튼 디자인
        class RoundedButton extends JButton {
           public RoundedButton() { super(); decorate(); } 
           public RoundedButton(String text) { super(text); decorate(); } 
           public RoundedButton(Action action) { super(); decorate(); } 
           public RoundedButton(Icon icon) { super(icon); decorate(); } 
           public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
           protected void decorate() { setBorderPainted(false); setOpaque(false); }
           @Override 
           protected void paintComponent(Graphics g) {
        	   Color c=new Color(102,102,255); //배경색 결정
               Color o=new Color(255,255,255); //글자색 결정
              setFont(new Font("monospaced", Font.BOLD | Font.ITALIC,14));
              int width = getWidth(); 
              int height = getHeight(); 
              Graphics2D graphics = (Graphics2D) g; 
              graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
              if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
              else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
              else { graphics.setColor(c); } 
              graphics.fillRoundRect(0, 0, width, height, 10, 10); 
              FontMetrics fontMetrics = graphics.getFontMetrics(); 
              Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
              int textX = (width - stringBounds.width) / 2; 
              int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
              graphics.setColor(o); 
              graphics.setFont(getFont()); 
              graphics.drawString(getText(), textX, textY); 
              graphics.dispose(); 
              super.paintComponent(g); 
              }
           }
        
        //버튼 생성
        RoundedButton b1 = new RoundedButton("메인화면으로 이동");

        
        setSize(200,400); //크기 설정
        

        //컴포넌트 생성 및 추가
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(label8);
        this.add(label9);
        this.add(label10);
        this.add(label11);
        this.add(b1);

        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //닫은 후 프로그램 종료
        

        setLayout(null); //배치 관리자 설정
        // setLayout(null);을 해줌으로써 수동으로 크기 조절 가능
        b1.setBounds(20, 300, 150, 30);

        label1.setBounds(40, 30, 150, 30);
        label2.setBounds(40, 55, 150, 30);
        label3.setBounds(40, 80, 150, 30);
        label4.setBounds(40, 105, 150, 30);
        label5.setBounds(40, 130, 150, 30);
        label6.setBounds(40, 155, 150, 30);
        label7.setBounds(40, 180, 150, 30);
        label8.setBounds(40, 205, 150, 30);
        label9.setBounds(40, 230, 150, 30);
        label10.setBounds(40, 255, 150, 30);
        label11.setBounds(40, 280, 150, 30);
        
        
        setVisible(true);

        b1.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new Start();
        		
        		
        	}
        });
    }

        


    //실행창
    public static void main(String[] args) {

        new Explanation();
    }

 
}