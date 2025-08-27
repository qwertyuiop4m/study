package 프로그래머스;

import java.util.*;

public class 주차요금계산 {
    public static int[] solution(int[] fees, String[] records) {
        Map<String , Integer> parking = new HashMap<>();
        Map<String , Integer> totalFee = new TreeMap<>();

        for(int i=0;i<records.length;i++){
            String[] temp =  records[i].split(" ");
            int time = getTime(temp[0]);
            String car = temp[1];
            String inOut = temp[2];
            if (inOut.equals("IN")){
                parking.put(car, time);
            }else {
                if(!totalFee.containsKey(car)){
                    totalFee.put(car, time-parking.get(car));
                }else{
                    totalFee.put(car, totalFee.get(car) + time-parking.get(car));
                }
                parking.remove(car);
            }
        }
        if (!parking.isEmpty()) {
            for (String car : parking.keySet()){
                Integer fee = totalFee.get(car);
                fee = (fee == null) ? 0 : fee;
                totalFee.put(car, fee + (23*60+59) - parking.get(car));
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Integer t : totalFee.values()) {
            int baseTime = fees[0];
            int baseFee = fees[1];
            int partTime = fees[2];
            int partFee =  fees[3];

            if (t <= baseTime){
                result.add(baseFee);
            }else{
                result.add((int) (baseFee + Math.ceil ((double) (t-baseTime)/
                        partTime)*partFee));
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int getTime(String s) {
        String[] strs = s.split(":");
        int hour = Integer.parseInt(strs[0]);
        int minute = Integer.parseInt(strs[1]);
        return 60*hour+minute;
    }

    public static void main(String[] args) {
        int[] fees1= {180, 5000, 10, 600};
        int[] fees2= {120, 0, 60, 591};
        int[] fees3= {1, 461, 1, 10};

        String[] recoders1 =  {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        String[] recoders2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        String[] recoders3 = {"00:00 1234 IN"};
        System.out.println(Arrays.toString(solution(fees1, recoders1)));
        System.out.println(Arrays.toString(solution(fees2, recoders2)));
        System.out.println(Arrays.toString(solution(fees3, recoders3)));
    }
}
