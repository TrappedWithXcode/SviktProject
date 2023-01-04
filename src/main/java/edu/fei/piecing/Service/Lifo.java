package edu.fei.piecing.Service;


import edu.fei.piecing.Model.Student;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lifo {
    private Queue<Integer> stackOfPeople = new LinkedList<>();
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
