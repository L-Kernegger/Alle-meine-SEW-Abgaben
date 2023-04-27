package sew6.calcvm;

import java.util.ArrayList;

import sew6.calcvm.instructions.Instruction;
/**
 * @author Leopold Kernegger
 * @version 26-4-2023
 * Klasse zum Speichern der Instructions
 */
public class Program {
    private ArrayList<Instruction> instructions;
    
    public Program(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }
    public Program() {
        this.instructions = new ArrayList<>();
    }
    public Instruction getInstructions(int index) {
        return this.instructions.get(index);
    }
    public Instruction deleteInstruction(int index){
        Instruction x = instructions.get(index);
        this.instructions.remove(index);
        return x;
    }
    public void addInstruction(Instruction instruction){
        this.instructions.add(instruction);
    }
    public int size(){
        return this.instructions.size();
    }
    public String toString(){
        return this.instructions.toString();
    }

}
