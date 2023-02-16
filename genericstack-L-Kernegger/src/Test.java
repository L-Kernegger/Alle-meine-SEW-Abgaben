import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws StackEmptyException,StackFullException{
        Stack<Integer> intStack = new Stack<Integer>(5);
    	intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        while (!intStack.isEmpty()) {
            System.out.print(intStack.pop());
        }
        System.out.println();


        Stack<String> stringStack = new Stack<String>(10);
        stringStack.push("hello");
        stringStack.push("world");

        while (!stringStack.isEmpty()) {
            System.out.print(stringStack.pop());
        }
        System.out.println();


        Stack<Object> objStack = new Stack<Object>(20);
        objStack.push(1);
        objStack.push("hello");
        objStack.push(new ArrayList<String>());

        while (!objStack.isEmpty()) {
            System.out.print(objStack.pop());
        }
        System.out.println();


        // Erstelle einen Stack, der bis zu 5 Zeichen speichern kann
        Stack<Character> charStack = new Stack<>(5);

        // Füge einige Zeichen hinzu
        charStack.push('h');
        charStack.push('e');
        charStack.push('l');
        charStack.push('l');
        charStack.push('o');

        // Gib die Zeichen in umgekehrter Reihenfolge aus
        while (!charStack.isEmpty()) {
            System.out.print(charStack.pop());
        }
        System.out.println();

        // Erstelle einen Stack, der bis zu 4 Bytes speichern kann
        Stack<Byte> byteStack = new Stack<>(4);

        // Füge einige Bytes hinzu
        byteStack.push((byte) 0x12);
        byteStack.push((byte) 0x34);
        byteStack.push((byte) 0x56);

        // Gib die Bytes in umgekehrter Reihenfolge aus
        while (!byteStack.isEmpty()) {
            System.out.print(String.format("%02X ", byteStack.pop()));
        }
        System.out.println();
    }
}
