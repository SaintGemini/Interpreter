package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {
    private int num;
    private String var = "";

    @Override
    public void init(ArrayList<String> args) {
        num = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            var = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(var.equals("")){
            vm.push(num);
        } else {
            vm.push(0);
        }
    }

    @Override
    public String toString() {
        if (var.equals("")) {
            return "LIT " + num;
        } else {
            return "LIT " + num + " " + var;
        }
    }

}
