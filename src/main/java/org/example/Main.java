package org.example;

import java.util.Scanner;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        System.out.println("==명언 앱==");

        Scanner sc = new Scanner(System.in);

        String cmd = "명령) ";
        String regist = "명언 : ";
        String author = "작가 : ";

        String viewStr = cmd;

        int num = 0;

        while(true) {
            System.out.print(viewStr);
            String inputValue = sc.nextLine().trim();

            if (inputValue.equals("종료") || inputValue.equals("exit")) {
                System.out.println("프로그램을 종료합니다");
                break;
            }
            if(inputValue.equals("등록")) {
                viewStr = regist;
            } else if(viewStr.equals(regist)) {
                viewStr = author;
                num++;
            } else if(viewStr.equals(author)) {
                viewStr = cmd;
                System.out.println(num + " 번 명언이 등록되었습니다.");
            }
        }

        sc.close();

    }
}