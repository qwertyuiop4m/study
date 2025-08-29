package 프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

public class 파일명정렬 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(
                solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II",
                        "F-14 Tomcat"})));
    }
    public static String[] solution(String[] files) {
       Arrays.sort(files, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {
               String[] file1 = separationFile(o1);
               String[] file2 = separationFile(o2);

               int result = file1[0].compareTo(file2[0]);

               if(result == 0){
                   int number1 = Integer.parseInt(validateNumber(file1[1]));
                   int number2 = Integer.parseInt(validateNumber(file2[1]));
                   return number1 - number2;
               }
               return result;
           }
       });
        return files;
    }

    private static String validateNumber(String number) {
        StringBuilder sb = new StringBuilder();
        for(char c : number.toCharArray()){
            if(Character.isDigit(c) && sb.length()<=5){
                sb.append(c);
            }else{
                return sb.toString();
            }
        }
        return sb.toString();
    }

    private static String[] separationFile(String file) {
        file = file.toLowerCase();

        String head = file.split("[0-9]")[0];
        String number = file.substring(head.length());
        return new String[]{head, number};
    }
}
