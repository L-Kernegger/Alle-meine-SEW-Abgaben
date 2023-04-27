package sew6.calcvm;

import sew6.calcvm.instructions.Add;
import sew6.calcvm.instructions.Print;
import sew6.calcvm.instructions.Store;
import sew6.calcvm.instructions.Sub;
/**
 * @author Leopold Kernegger
 * @version 26-4-2023
 */
public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.addInstruction(new Store(3));
        program.addInstruction(new Store(5));
        program.addInstruction(new Add());
        program.addInstruction(new Print());
        program.addInstruction(new Store(3));
        program.addInstruction(new Store(5));
        program.addInstruction(new Sub());
        program.addInstruction(new Print());

        Interpreter interpreter = new Interpreter(program);
        interpreter.run();
    }
}
