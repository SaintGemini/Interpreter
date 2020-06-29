package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode {
    private int pLevel;

    @Override
    public void init(ArrayList<String> args) {
        pLevel = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        // insure pop won't pop more than what is on the stack
        int insurance = vm.popInsurance();
        if(insurance >= pLevel){
            insurance = pLevel;
        }
        for(int i = 0; i < insurance; i++){
            vm.pop();
        }
    }

    @Override
    public String toString() {
        return "POP " + pLevel;
    }
}
