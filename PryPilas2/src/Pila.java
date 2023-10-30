import java.util.Stack;

public class Pila{
    private Stack<Character> pila;

    public Pila(){
        pila=new Stack<Character>();
    }
    public boolean estaVacia(){
        return pila.isEmpty();
    }
    public void insertar(Character dato){
        pila.push(dato);
    }
    public  Character eliminar() throws Exception{
        if(estaVacia())
            throw new Exception("Pila vacia sin caracteres");
        return pila.pop();
    }
    public Character cima() throws Exception{
        if(estaVacia())
            throw new Exception("No hay elementos en la pila");
        return pila.peek();
    }
    @Override
    public String toString() {
        String result="Elementos en la pila\n";
        for (int i=pila.size()-1; i>=0; i--){
            result+=pila.get(i)+"\n";
        }
        return pila.isEmpty()?"No existe elementos":result;
    }
}
