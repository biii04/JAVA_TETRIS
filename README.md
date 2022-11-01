# JAVA_TETRIS

# JAVA_FINAL
>> 테트리스 구현

참고 사이트 : Java Tetris game - creating Tetris game in Java (zetcode.com)


start - 시작 창

Explanation - 게임방법 설명 창

Tetris - 게임화면

Escape - 일시정지 창(재시작 / 나가기만 가능)

Board - 기능구현

Shape - 도형 모양 구현

-----------------------------------------------

start에서 '시작'을 누르면 Tetris로 넘어가 실행되고 

Tetris에는 Board와 Shape이 실행됨

'조작법 설명' 누르면 Explanation으로 넘어가 실행

그리고 Esc를 누를 경우, Board로 넘어가 KeyEvent 동작됨


>> 이슈 
-----------------------------------------------
버튼과 키보드 눌렸을 때 다른 프레임으로 이동


>> 해결책 
-----------------------------------------------
버튼 -> b1.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		new Tetris();	
        	}
        });
		
키보드 -> case KeyEvent.VK_ESCAPE : new Esc(); break;


>> 추가한 기능 
-----------------------------------------------
1. 시작 창과 일시정지 창, 설명 창 구현(버튼 생성)
2. 시작 창과 일시정지 창은 게임화면과 연결, 설명 창은 시작 창과 연결
3. 버튼 모양 및 색상 변경
4. ESC 누를 시 일시정지 창으로 이동


>> 넣지 못한 기능 
-----------------------------------------------
1. ESC 키로 일시정지 창으로 이동했다가 다시 ESC 키 누르면 게임하던 창으로 이동

(일시정지 창으로 이동 시 게임 창은 일시중지 상태 유지)
2. 게임 창에서 선 구현

