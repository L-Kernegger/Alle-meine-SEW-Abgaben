package sew6.calcvm.instructions;

import sew6.calcvm.Interpreter;
/**
 * @author Leopold Kernegger
 * @version 26-4-2023
 */
public class Sub implements Instruction {

    public void execute(Interpreter interpreter){
        int a = interpreter.getStack().pop();
        int b = interpreter.getStack().pop();
        interpreter.getStack().push((b - a));  
    }
}
