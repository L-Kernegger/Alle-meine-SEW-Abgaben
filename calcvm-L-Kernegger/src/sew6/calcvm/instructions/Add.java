package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;
/**
 * @author Leopold Kernegger
 * @version 26-4-2023
 */
public class Add implements Instruction {
    public void execute(Interpreter interpreter) {
        int b = interpreter.getStack().pop();
        int a = interpreter.getStack().pop();
        interpreter.getStack().push((a+b));
    }
}
