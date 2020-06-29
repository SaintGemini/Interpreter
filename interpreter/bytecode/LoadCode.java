package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode {
    private int offset;
    private String id = "";

    @Override
    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        if(args.size() > 1){
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.load(offset);
    }

    @Override
    public String toString() {
        if (id.equals("")){
            return "LOAD " + offset;
        } else {
            return "LOAD " + offset + " " + id;
        }
    }
}
