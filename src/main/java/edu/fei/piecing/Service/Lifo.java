package edu.fei.piecing.Service;


import edu.fei.piecing.Model.Student;

import java.util.Stack;

public class Lifo {
    private Stack<Integer> stackOfPeople = new Stack<>();
    public void pushToStack(Integer id){
        stackOfPeople.push(id);
    }
    public void popFromStack(){
        stackOfPeople.pop();
    }
    public Stack<Integer> getStack(){
        return stackOfPeople;
    }
    public Integer getFirst(){
        return stackOfPeople.peek();
    }
    public Integer getIndex(Integer id){
        return stackOfPeople.indexOf(id);
    }
    public String getStringStack(){
        return stackOfPeople.toString();
    }

}
