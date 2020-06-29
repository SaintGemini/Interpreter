package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean        dumpState;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        dumpState = true;

        while(isRunning){
            // Get Byte Code
            ByteCode code = program.getCode(programCounter);
            // Execute Byte Code
            code.execute(this);
            // Dump state = ON and if not a DumpCode
            if(dumpState && (!(code instanceof DumpCode))){
                // Print code
                System.out.println(code.toString());
                // Dump
                runTimeStack.dump();
            }
            programCounter++;
        }
    }

    public int peek(){
        return runTimeStack.peek();
    }

    public int pop(){
        return runTimeStack.pop();
    }

    public int push(int idx){
        return runTimeStack.push(idx);
    }

    public int getProgramCounter(){
        return programCounter;
    }

    public void setProgramCounter(int x){
        programCounter = x;
    }

    public void store(int x){
        runTimeStack.store(x);
    }

    public void load(int x){
        runTimeStack.load(x);
    }

    public void newFrame(int args){
        runTimeStack.newFrameAt(args);
    }

    public void popFrame(){
        runTimeStack.popFrame();
    }

    public void setDumpState(boolean newDumpState){
        dumpState = newDumpState;
    }

    public void stop(){
        isRunning = false;
    }

    public void pushToAddRes(int x){
        returnAddress.push(x);
    }
    // For ReturnCode execute function
    public int popReturnCode(){
        return (Integer)returnAddress.pop();
    }
    // For PopCode execute function
    public int popInsurance() {
        return runTimeStack.popInsurance();
    }
}
