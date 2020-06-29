package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {
    private int argCount;

    @Override
    public void init(ArrayList<String> args) {
        argCount = Integer.parseInt(args.get(0));
    }

    public void execute(VirtualMachine vm) {
        vm.newFrame(argCount);
    }

    public String toString() {
        return "ARGS " + argCount;
    }
}
