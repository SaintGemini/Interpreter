
package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;

    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }

    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     * Tokenize string to break it into parts. Can also use the split function in the String class.
     * Grab THE correct class name for the given ByteCode from CodeTable
     * Create an instance of the ByteCode class name returned from code table.
     * Parse any additional arguments for the given ByteCode and send them to
     * the newly created ByteCode instance via the init function.
     *
     * @return
     */
    public Program loadCodes() {
        String line;
        String[] items;
        ArrayList<String> args = new ArrayList<>();
        String byteCodeName;
        String className;
        Class classBluePrint;
        Program program = new Program();
        ByteCode bc;
        try {
            while (this.byteSource.ready()) {
                // tokenize read line
                line = this.byteSource.readLine();
                items = line.split("\\s+");
                // grab first token of line
                byteCodeName = items[0];
                // grab class name from token
                className = CodeTable.getClassName(byteCodeName);
                // load class blueprint from classname
                classBluePrint = Class.forName("interpreter.bytecode." + className);
                // get declared constructor (should be no-arg constructor)
                // create a new instance of bytecode using constructor
                bc = (ByteCode) classBluePrint.getDeclaredConstructor().newInstance();

                // grab remaining arguments
                for (int i = 1; i < items.length; i++){
                    args.add(items[i]);
                }
                // pass args to bytecode init function
                bc.init(args);
                // add bytecode to program
                program.add(bc);
                //clear args for next loop
                args.clear();
            }
        } catch (IOException | ClassNotFoundException | NoSuchMethodException e) {
            System.out.println(e);
            System.exit(255);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        program.resolveAddress(program);
        return program;
    }
}
