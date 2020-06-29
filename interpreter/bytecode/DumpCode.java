package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private String status;

    @Override
    public void init(ArrayList<String> args) {
        status = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(status.equals("ON")){
            vm.setDumpState(true);
        }
        else if(status.equals("OFF")){
            vm.setDumpState(false);
        }
    }

    @Override
    public String toString() {
        return "DUMP " + status;
    }
}
