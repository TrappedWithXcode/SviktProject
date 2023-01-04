package edu.fei.piecing.Service;


import java.util.LinkedList;
import java.util.Queue;

public class Fifo {
    private final Queue<Integer> stackOfPeople = new LinkedList<>();
    public void addToStack(Integer id){
        stackOfPeople.add(id);
    }
    public Integer popFromStack(){
        return stackOfPeople.poll();
    }
    public Queue<Integer> getStack(){
        return stackOfPeople;
    }
    public Integer getFirst(){
        return stackOfPeople.peek();
    }

    public String getStringStack(){
        return stackOfPeople.toString();
    }
    public boolean isEmpty(){
        return stackOfPeople.isEmpty();
    }

}
