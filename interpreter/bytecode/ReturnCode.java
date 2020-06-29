package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode {
    private String label;
    private int index;

    @Override
    public void init(ArrayList<String> args) {
        if(!args.isEmpty()){
            label = args.get(0);
        } else {
            label = null;
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setProgramCounter(vm.popReturnCode());
        vm.popFrame();
        index = vm.peek();
    }

    @Override
    public String toString() {
        if(label != null) {
            return "RETURN " + label;
        } else {
            return "RETURN ";
        }
    }
}
