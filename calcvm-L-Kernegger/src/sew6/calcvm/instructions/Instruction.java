package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;
/**
 * @author Leopold Kernegger
 * @version 26-4-2023
 */
public interface Instruction {
    void execute(Interpreter interpreter);
}
