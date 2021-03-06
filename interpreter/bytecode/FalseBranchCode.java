package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends BranchCode {
    private int index;
    private String label;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(vm.pop() == 0){
            vm.setProgramCounter(index);
        }
    }

    @Override
    public String getByteCode() {
        return label;
    }

    @Override
    public void setIndex(int idx) {
        index = idx;
    }

    @Override
    public String toString() {
        return "FALSEBRANCH " + label;
    }
}
