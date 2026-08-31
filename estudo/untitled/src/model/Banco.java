package model;
import java.util.HashMap;
import java.util.Map;

public class Banco {

    private Map<Integer, Conta> contas;

    public Banco() {
        this.contas = new HashMap<>();
    }
    public boolean cadastro(int id){
        if(contas.containsKey(id)){
            return false;
        } else {
            contas.put(id, new Conta(id));
            return true;
        }
    }
    public Conta buscar(int id){
        return contas.get(id);
    }
    public Map<Integer, Conta> getContas() {
        return contas;
    }
}
