package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

    public void dump(){
        int startIndex = 0;
        // if more than one element
        if (framePointer.size() > 1) {
            // start i at second element
            for(int i = 1; i < framePointer.size(); i++){
                // subList method automatically formats with square brackets [x,y]
                // create subList from startIndex to index i
                String output = runTimeStack.subList(startIndex, framePointer.get(i)) + " ";
                System.out.print(output);
                // move startIndex before next loop
                startIndex = framePointer.get(i);
            }
        }
        String dumpOutput = runTimeStack.subList(startIndex, runTimeStack.size()) + "\n";
        System.out.println(dumpOutput);
    }

    public int peek() {
        return this.runTimeStack.get(this.runTimeStack.size()-1);
    }

    public int pop() {
        return this.runTimeStack.remove(this.runTimeStack.size()-1);
    }

    public int push(int valueToPush) {
        this.runTimeStack.add(valueToPush);
        return this.peek();
    }

    public int store(int offsetFromFramePointer){
        int value = this.pop();
        runTimeStack.set(framePointer.peek() + offsetFromFramePointer, value);
        return value;
    }

    public int load(int offsetFromFramePointer){
        int value =  runTimeStack.get(framePointer.peek() + offsetFromFramePointer);
        runTimeStack.add(value);
        return value;
    }

    public void newFrameAt(int offsetFromTopOfRunstack){
        framePointer.push(runTimeStack.size() - offsetFromTopOfRunstack);
    }

    public void popFrame(){
        int top = pop();
        int bot = framePointer.pop();
        for(int i= runTimeStack.size()-1; i >= bot; i--){
            pop();
        }
        push(top);
    }
    // Returns full size of RTS as int.
    // Used in PopCode, as to not pop out of bounds
    public int popInsurance() {
        Iterator itr = framePointer.iterator();
        int fullSize = 0;
        int currentFrame = (Integer)itr.next();
        fullSize = this.runTimeStack.size() - currentFrame;

        return fullSize;
    }
    public static void main(String[] args) {
//        RunTimeStack rs = new RunTimeStack();
//        rs.push(1);
//        rs.push(2);
//        rs.push(3);
//        rs.push(4);
//        for (int val: rs.runTimeStack){
//            System.out.println(val);
//        }
//        System.out.println(rs.peek());
//        rs.pop();
//        System.out.println(rs.peek());
    }

}
