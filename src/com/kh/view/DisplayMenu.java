package com.kh.view;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import com.kh.Controller.GameController;
import com.kh.Controller.SoloGameController;
import com.kh.model.vo.TimeLimit;

public class DisplayMenu {
	Scanner sc = new Scanner(System.in);
	GameController gc = new GameController();
	SoloGameController sgc = new SoloGameController();

	public void mainMenu() {
		
		while(true) {
			System.out.println("KH 정보교육원 JAVA 타자연습 게임");
			System.out.println("1. 게임 설명");
			System.out.println("2. 싱글 게임 시작");
			System.out.println("3. 멀티 게임 시작");
			System.out.println("4. 랭킹 보기");
			System.out.println("9. 게임 종료");
			System.out.print("메뉴를 선택하세요 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			
			switch(menu){
			case 1:  break; 		//타자게임 설명 description() 메소드 호출(돌아가기 구현) 
			case 2: soloStart(); break; 		//솔로 게임 시작 singleStart() 메소드 호출
			case 3: multiStart(); break; 		//멀티 게임 시작 multiStart() 메소드 호출
			case 4: rank(); break;		// 랭킹 보기 rank() 메소드 호출
			case 9: return;		//게임종료
			default: System.out.println("잘못 입력하셨습니다. 다시 입력해주세요."); break;
			}
			
		}
		
	}
	
	public void soloStart() {
	    for (int i = 0; i < 7; i++) {
	        AtomicBoolean inputCheck = new AtomicBoolean(false); // 초기화
	        GameController.inputCheck = false;
	        GameController.overTime = false;

	        TimeLimit tl = new TimeLimit(inputCheck);
	        tl.start();

	        int currentLevel = i;

	        System.out.println("문제 : " + gc.getSentence(i));
	        System.out.print("Enter: ");

	        
            String input = sc.nextLine();
            inputCheck.set(true); // 입력이 확인됨
            boolean result = gc.check(input);
            if (result) {
                if (!GameController.overTime) {
                    System.out.println((currentLevel + 1) + "단계 성공!");
                }
            } else {
                if (!GameController.overTime) {
                    System.out.println((currentLevel + 1) + "단계 실패. 오타를 확인하세요.");
                    return;
                }
            }
            
	        // 입력이 틀리거나 시간이 초과된 경우 메서드를 종료
	        if (!GameController.inputCheck || GameController.overTime) {
	            if (GameController.overTime) {
	                System.out.println("시간 초과로 인해 게임이 종료되었습니다.");
	            } else {
	                System.out.println("틀렸습니다. 오타를 확인하세요.");
	                System.out.println("Enter키를 누르면 메뉴로 돌아갑니다.");
	                sc.nextLine(); // 사용자 입력 대기
	            }
	            return;
	        }
	    }
	}
	
	public void multiStart() {
		
	}
	
	public void description() {
		
	}
	
	public void rank() {
	
	}
	
	
}
