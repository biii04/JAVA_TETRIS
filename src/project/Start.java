package project;
 
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


 
public class Start extends JFrame {
    
    //생성자
    public Start() {
    	
        //타이틀 생성
        setTitle("Main");

       //텍스트 생성
        JLabel label = new JLabel("TETRIS");
        //폰트, 색상, 크기 변경
        label.setFont(new Font("Serif", Font.BOLD, 11));
        label.setForeground(Color.BLUE);
        label.setFont(label.getFont().deriveFont(15.0f));
        
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
        RoundedButton b1 = new RoundedButton("시작");
        RoundedButton b2 = new RoundedButton("나가기");
       
        //설명 버튼 생성
        RoundedButton b3 = new RoundedButton("조작법 설명");
       

        
        setSize(200,400); //크기 설정
        

        //컴포넌트 생성 및 추가
        this.add(label);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //닫은 후 프로그램 종료
        

        setLayout(null); //배치 관리자 설정
        // setLayout(null);을 해줌으로써 수동으로 크기 조절 가능
        
        //text 및 버튼 위치
        b1.setBounds(45, 110, 100, 30);
        b2.setBounds(45, 190, 100, 30);
        b3.setBounds(45, 270, 100, 30);
        label.setBounds(68, 50, 100, 30);
        
        setVisible(true);
        

        b1.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new Tetris();	
        	}
        });

        
        b2.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        
        b3.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new Explanation();
        	}
        });
         }
    

    //실행창
    public static void main(String[] args) {

        new Start();
    }

 
}