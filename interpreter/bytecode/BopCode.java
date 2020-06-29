package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode {
    private String operator;

    @Override
    public void init(ArrayList<String> args) {
        operator = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        int second = vm.pop();
        int first = vm.pop();
        int result = 0;

        if(operator.equals("+")){
            result = first + second;
        }
        else if(operator.equals("-")){
            result = first - second;
        }
        else if(operator.equals("*")){
            result = first * second;
        }
        else if(operator.equals("/")){
            result = first / second;
        }
        else if(operator.equals("==")){
            if(first == second){
                result = 1;
            } else {
                result = 0;
            }
        }
        else if(operator.equals("!=")){
            if(first != second){
                result = 1;
            } else {
                result = 0;
            }
        }
        else if(operator.equals("<=")){
            if(first <= second){
                result = 1;
            } else {
                result = 0;
            }
        }
        else if(operator.equals("<")){
            if(first < second){
                result = 1;
            } else {
                result = 0;
            }
        }
        else if(operator.equals(">=")){
            if(first >= second){
                result = 1;
            } else {
                result = 0;
            }
        }
        else if(operator.equals(">")){
            if(first > second){
                result = 1;
            } else {
                result = 0;
            }
        }
        else if(operator.equals("|")){
            if(first == 1 || second == 1){
                result = 1;
            } else {
                result = 0;
            }
        }
        else if(operator.equals("&")){
            if(first == 1 && second == 1){
                result = 1;
            } else {
                result = 0;
            }
        }
        vm.push(result);
    }

    public String toString(){
        return "BOP " + operator;
    }
}
