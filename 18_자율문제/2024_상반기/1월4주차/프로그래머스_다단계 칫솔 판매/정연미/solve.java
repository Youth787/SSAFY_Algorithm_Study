package Algo_스터디.Jan_4주차;

import java.util.*;

class Person{
    String name;
    Person parent;
    int profit;

    public Person(String name, Person parent, int profit){
        this.name = name;
        this.parent = parent;
        this.profit = profit;
    }

    public void Calprofit(int profit){
        int parentprofit = profit/10;
        this.profit += (profit - parentprofit);
        if(this.parent !=null && parentprofit >=1){
            this.parent.Calprofit(parentprofit);
        }
    }
}

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        HashMap<String, Person> people = new HashMap<>();
        for(String name : enroll){
            people.put(name, new Person(name,null,0));
        }

        for(int i=0; i<referral.length; i++){
            if(referral[i].equals("-")) continue;
            people.get(enroll[i]).parent = people.get(referral[i]); // 객체
        }

        for(int i=0; i<seller.length; i++){
            people.get(seller[i]).Calprofit(amount[i]*100);
        }

        int[] result = new int[enroll.length];
        for(int i=0; i<enroll.length; i++){
            result[i] = people.get(enroll[i]).profit;
        }
        return result;
    }
}