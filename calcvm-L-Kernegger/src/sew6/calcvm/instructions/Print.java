package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;
/**
 * @author Leopold Kernegger
 * @version 26-4-2023
 */
public class Print implements Instruction {

    @Override
    public void execute(Interpreter interpreter) {
        System.out.println(interpreter.getStack().pop());
    }
}
