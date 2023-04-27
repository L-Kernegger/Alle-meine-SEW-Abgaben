package sew6.calcvm;


import java.util.Stack;

/**
 * @author Leopold Kernegger
 * @version 26-4-2023
 */
public class Interpreter {
    private Stack<Integer> stack = new Stack<>();
    private Program program;

    public Interpreter(Program program) {
        this.program = program;
    }

    /**
     * This method implements the actual interpreter.
     * Iterate over all instructions of the program and execute them, the end of the program is reached
     * when all instructions have been executed.
     */
    public void run() {
        while(program.size() >  0) {
            program.deleteInstruction(0).execute(this);
        }
    }
    public Stack<Integer> getStack() {
        return stack;
    }
}
