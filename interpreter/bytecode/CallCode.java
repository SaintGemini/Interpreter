package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends BranchCode {
    private int index;
    private String label;

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushToAddRes(vm.getProgramCounter());
        vm.setProgramCounter(index);
    }

    @Override
    public String getByteCode() {
        return label;
    }

    @Override
    public void setIndex(int idx) {
        index = idx;
    }

    public String toString(){
        return "CALL " + label;
    }
}
