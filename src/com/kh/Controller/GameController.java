package com.kh.Controller;

import java.util.ArrayList;

import com.kh.model.vo.*;
import com.kh.model.vo.Sentence;

public class GameController {

	ArrayList<Sentence> sList = new ArrayList<>();
	private String sentence = "";
	public static volatile boolean inputCheck = false;
	public static volatile boolean overTime = false;
	
	public GameController() {
		
		sList.add(new Level1("public"));
		sList.add(new Level1("void"));
		sList.add(new Level1("main"));
		sList.add(new Level2("java.util.Scanner;"));
		sList.add(new Level2("public String toString(){}"));
		sList.add(new Level2("list.add(new Parents)"));
		sList.add(new Level3("for(int i=0;i<arr.length;i++)"));
		sList.add(new Level3("System.out.println(\"HELLO, WORLD\")"));
		sList.add(new Level3("public static void main(String[] args){}"));
		
	}
	
	
	public String getSentence(int i) {
		int min = i + 2*i;		// 0 ( 0 + 0), 3 ( 1 + 2 ), 6 ( 2 + 4 ), 9 ( 3 + 6)
		int max = min + 2;            // 2 ( 0 + 2), 5 (1 + 4), 8 (2 + 6) , 11 (3 + 8)
		int index = (int)(Math.random() * (max - min + 1) + min);
		sentence = sList.get(index).getSentence();
		return sentence;
	}
	
	
	public boolean check(String input){
		
		//전달받은 input을 sentence와 비교하여
		//같으면 true, 다르면 false 반환
		inputCheck = true;
		
		if(sentence.equals(input)) {
			return true;
		}
		else if(overTime=true) {
			overTime=false;
			return false;
		}
		return false;
	}
}
