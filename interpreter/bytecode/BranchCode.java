package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

// subclass of ByteCode used for CallCode, FalseBranchCode and GotoCode
// used for any bytecode with branch instructions
public abstract class BranchCode extends ByteCode {
    @Override
    public abstract void init(ArrayList<String> args);

    @Override
    public abstract void execute(VirtualMachine vm);

    public abstract String getByteCode();

    public abstract  void setIndex(int idx);
}
