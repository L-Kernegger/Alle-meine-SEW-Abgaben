/**
 * Eine generische Stack-Klasse zum Speichern von Elementen. Es kann sowohl primitive Datentypen als auch
 * Objekte speichern.
 *
 * @param <T> Der Typ der Elemente, die im Stack gespeichert werden.
 */
public class Stack<T> {
    private int maxSize;
    private int top;
    private T[] stackArray;

    /**
     * Konstruiert einen neuen Stack mit der angegebenen maximalen Größe.
     * 
     * @param maxSize die maximale Größe des Stacks
     */
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        stackArray = (T[]) new Object[maxSize];
    }

    /**
     * Fügt ein Element oben auf den Stack hinzu.
     * 
     * @param item das Element, das hinzugefügt werden soll
     * @throws StackFullException wenn der Stack voll ist und kein weiteres Element hinzugefügt werden kann
     */
    public void push(T item) throws StackFullException {
        if (top == maxSize - 1) {
            throw new StackFullException("Stack is full.");
        }
        stackArray[++top] = item;
    }

    /**
     * Entfernt das oberste Element vom Stack und gibt es zurück.
     * 
     * @return das entfernte Element
     * @throws StackEmptyException wenn der Stack leer ist und kein Element entfernt werden kann
     */
    public T pop() throws StackEmptyException {
        if (top == -1) {
            throw new StackEmptyException("Stack is empty.");
        }
        return stackArray[top--];
    }

    /**
     * Gibt zurück, ob der Stack leer ist.
     * 
     * @return true, wenn der Stack leer ist, ansonsten false
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Gibt zurück, ob der Stack voll ist.
     * 
     * @return true, wenn der Stack voll ist, ansonsten false
     */
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    /**
     * Gibt das oberste Element des Stacks zurück, ohne es zu entfernen.
     * 
     * @return das oberste Element des Stacks
     */
    public T peek() {
        return stackArray[top];
    }
}
