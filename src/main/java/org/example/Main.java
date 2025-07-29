package org.example;

import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        System.out.println("==명언 앱==");

        Scanner sc = new Scanner(System.in);

        String cmd = "명령) ";
        String text = "";
        String author = "";
        String viewText = "명령) ";


        Map<Integer, wiseSaying> sayings = new TreeMap<>(Comparator.reverseOrder());
        int id = 0;

        while(true) {
            System.out.print(viewText);
            String inputValue = sc.nextLine().trim();

            if (inputValue.equals("종료") || inputValue.equals("exit")) {
                System.out.println("프로그램을 종료합니다");
                break;
            }

            if(inputValue.equals("등록")) {   // 다음텍스트는 명언 :
                viewText = "명언 : ";
            }else if(inputValue.equals("목록")) {
                viewText = "번호 / 작가 / 명언 \n----------------------\n";

                for (wiseSaying value : sayings.values()) {
                    viewText += value.toString();
                    viewText += "\n";
                }
                System.out.println(viewText);
                viewText = "명령) ";
            }  else if(inputValue.contains("삭제?id=")) {
                int deleteId = Integer.parseInt(inputValue.substring(6));
                if(sayings.get(deleteId) != null) {
                    sayings.remove(deleteId);
                    System.out.println(deleteId + "번 명언이 삭제되었습니다.");
                } else {
                    System.out.println(deleteId + "번 명언은 존재하지 않습니다.");
                }
                viewText = "명령) ";
            } else if(viewText.equals("명언 : ")) { // 다음 텍스트는 작가 :
                text = inputValue;
                viewText = "작가 : ";
            } else if(viewText.equals("작가 : ")) { // 다음텍스트는 명령)
                viewText = "명령) ";
                author = inputValue;
                id++;
                sayings.put(id, new wiseSaying(id, text, author));
                text = "";
                author = "";
                System.out.println(id + "번 명언이 등록되었습니다.");
            }
        }

        sc.close();

    }
}

class wiseSaying {
    private int id;
    private String text;
    private String author;

    public wiseSaying(int id, String text, String author) {
        this.id = id;
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("%d / %s / %s", this.id, this.author, this.text);
    }
}