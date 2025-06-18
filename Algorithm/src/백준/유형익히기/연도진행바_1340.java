package 백준.유형익히기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class 연도진행바_1340 {
  public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String input= br.readLine();
    int[] calender={ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] calender2={  31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm", Locale.ENGLISH);
    LocalDateTime dateTime=LocalDateTime.parse(input, formatter);

    int year=dateTime.getYear();
    int month=dateTime.getMonthValue();
    int day=dateTime.getDayOfMonth();
    int hour=dateTime.getHour();
    int minute=dateTime.getMinute();

    boolean flag=(year%4==0&&year%100!=0)||(year%400==0);
    int total=flag ? 527040 : 525600;

    int result=0;
    for (int i=0;i<month-1;i++){
      result+= (flag ? calender2[i]:calender[i]) * 24 * 60;
    }

    result+=(day-1)*24*60;
    result+=hour*60+minute;

    System.out.println((double) result/total*100);
    br.close();
  }
}
