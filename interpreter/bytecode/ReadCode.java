package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode {
    private int input;

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public void execute(VirtualMachine vm) {
        boolean wasInt = false;
        // continually ask for int until int is given
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please enter an integer: ");
                input = Integer.parseInt(scanner.nextLine());
                wasInt = true;
            } catch (Exception e) {
                System.out.println("Please enter an integer: ");
            }
        } while(wasInt == false);

        vm.push(input);
    }

    @Override
    public String toString() {
        return "READ " + input;
    }
}
