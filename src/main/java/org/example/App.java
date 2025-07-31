package org.example;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {
    Map<Integer, wiseSaying> sayings = new TreeMap<>(Comparator.reverseOrder());
    int lastId = 0;
    Scanner sc = new Scanner(System.in);

    public void run() {
        System.out.println("==명언 앱==");
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getActionName()) {
                case "종료"->{
                    System.out.println("프로그램을 종료합니다.");
                    sc.close();
                    return;
                }
                case "등록" -> actionWrite();
                case "목록" -> actionList();
                case "삭제" -> actionDelete(rq.getParamInt("id", -1));
                case "수정" -> actionModify(rq.getParamInt("id", -1));
            }
        }

    }
    void actionWrite() {
        System.out.print("명언 : ");
        String writeText = sc.nextLine().trim();
        System.out.print("작가 : ");
        String writeAuthor = sc.nextLine().trim();
        lastId++;
        sayings.put(lastId, new wiseSaying(lastId, writeText, writeAuthor));
        System.out.println(lastId + "번 명언이 등록되었습니다.");
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for (wiseSaying value : sayings.values()) {
            System.out.println(value.toString());
        }
    }
    void actionDelete(int id) {
        if (sayings.get(id) != null) {
            sayings.remove(id);
            System.out.println(String.format("%d번 명언이 삭제되었습니다.",id));
        } else {
            System.out.printf(String.format("%d번 명언은 존재하지 않습니다.", id));
        }
    }
    void actionModify(int id) {
        if (sayings.get(id) != null) {
            System.out.println("명언(기존) : " + sayings.get(id).getText());
            System.out.print("명언 : ");
            String changeValueText = sc.nextLine().trim();
            System.out.println("작가(기존) : " + sayings.get(id).getAuthor());
            System.out.print("작가 : ");
            String changeValueAuthor = sc.nextLine().trim();
            sayings.put(id, new wiseSaying(id, changeValueText, changeValueAuthor));
        } else {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
        }
    }
    void actionFileWrite(int id) {
        Path dir = Path.of("db", "wiseSaying");

    }
}
