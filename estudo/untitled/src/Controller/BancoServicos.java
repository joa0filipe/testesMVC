package Controller;

import model.Banco;
import model.Conta;

import java.util.Map;


public class BancoServicos {
    private Banco Banco;


    public BancoServicos() {
        this.Banco = new Banco();
    }
    public boolean cadastro(int id){
        return Banco.cadastro(id);
    }
    public Conta buscarConta(int id){
        return Banco.buscar(id);
    }
    public Map<Integer, Conta> listarContas(){
        return Banco.getContas();
    }
    public boolean deposito(int id, float valor){
        Conta conta = Banco.buscar(id);
        if(conta == null){
            return false;
        }else{
            conta.depositar(valor);
            return true;
        }
    }
    public boolean saque(int id, float valor){
        Conta conta = Banco.buscar(id);
        if(conta == null){
            return false;
        }else{
            if (conta.getSaldo() > valor){
            conta.sacar(valor);
            return true;
            }else{
                return false;
            }
        }
    }

}
