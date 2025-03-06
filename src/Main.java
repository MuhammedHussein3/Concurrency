import java.util.*;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (var i = 0; i < 100; i++) {
                System.out.println(System.currentTimeMillis());
            }
        });
        thread.start();
        thread.join();
        

    }


    static int index = -1;
    public static void getMaxStarting(int[] gas, int[] cost, Map<Integer, Integer> map){

        for (int i = 0; i < gas.length - 1; i++){
            map.put(i, gas[i] - cost[i] + gas[i+1]);
        }
        map.put(gas.length - 1, gas[gas.length - 1] - cost[gas.length - 1] + gas[0]);

        int max = -1;
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());

            if (m.getValue() >= max){
                max = m.getValue();
                index = m.getKey();
            }
        }
    }

    public static int backtracking(String str, int s, int  e, List<String> res){


        if (s >= e){
            return 0;
        }
        String temp = "";
        int a = 0;
        for (int i = s; i < e; i++){
            temp+= str.substring(s, i+1);

            if (res.isEmpty() || !res.contains(temp)) {
                res.add(temp);
               a = Math.max(a, backtracking(str, i+1, e, res) + 1);
                res.remove(temp);
            }
        }
        return a;
    }


    public static StringBuilder  invertAndReverse(StringBuilder  s){
        StringBuilder invertedS = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '0')
                invertedS.append('1');
            else invertedS.append('0');
        }
        System.out.println(invertedS);
        return invertedS.reverse();
    }

    public String reverse(StringBuilder s){
        return s.reverse().toString();
    }
}