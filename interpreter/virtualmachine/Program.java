package interpreter.virtualmachine;

import interpreter.bytecode.BranchCode;
import interpreter.bytecode.ByteCode;
import interpreter.bytecode.LabelCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> map;

    public Program() {
        program = new ArrayList<>();
        map = new HashMap<>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */

    public void resolveAddress(Program program) {
        int jumpAddress;
        // cycle through program
        for (int i=0; i<program.size()-1; i++) {
            // if branch code
            if (program.getCode(i) instanceof BranchCode) {
                // figure out where to jump
                BranchCode branch = (BranchCode) program.getCode(i);
                jumpAddress = map.get(branch.getByteCode());
                // jump
                branch.setIndex(jumpAddress);
            }
        }
    }
    // for resolveAddress ^^^
    private int size() {
        return this.program.size();
    }

    public void add(ByteCode bc){
        if( bc instanceof LabelCode) {
            LabelCode label = (LabelCode) bc;
            map.put(label.getLabel(), program.size());
        }
        program.add(bc);
    }


}
