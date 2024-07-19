package com.kh.model.vo;

import java.util.concurrent.atomic.AtomicBoolean;

import com.kh.Controller.GameController;

public class TimeLimit extends Thread {
    private AtomicBoolean inputCheck;

    public TimeLimit(AtomicBoolean inputCheck) {
        this.inputCheck = inputCheck;
    }

    @Override
    public void run() {
        System.out.println("제한시간은 10초입니다");

        try {
            for (int i = 0; i < 10; i++) {
                if (inputCheck.get()) {
                    return; // 입력이 확인되면 스레드를 종료합니다.
                }
                System.out.println(i);
                sleep(1000);
            }
            System.out.println("제한시간 초과");
            GameController.overTime = true;
        } catch (InterruptedException e) {
            System.out.println("Enter키를 누르면 메뉴로 돌아갑니다.");
        }
    }
}
