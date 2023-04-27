package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;
/**
 * @author Leopold Kernegger
 * @version 26-4-2023
 */
public class Store implements Instruction {
    private int value;

    public Store(int value) {
        this.value = value;
    }

    @Override
    public void execute(Interpreter interpreter) {
        interpreter.getStack().push(value);
    }
}
