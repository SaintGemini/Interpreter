package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode {
    private int offset, storedValue;
    private String id;

    @Override
    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        id = args.get(1);
    }

    @Override
    public void execute(VirtualMachine vm) {
        storedValue = vm.peek();
        vm.store(offset);
    }

    public String toString(){
        return "STORE " + offset + " " + id + " " + id + " = " + storedValue;
    }
}
