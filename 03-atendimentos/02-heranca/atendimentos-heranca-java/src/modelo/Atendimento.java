package modelo;

import dao.estatico.DAO;
import java.util.ArrayList;
import util.MyDate;

public class Atendimento {

    public MyDate data;
    public String hora;
    public Cliente cli;
    public ArrayList<Servico> servicos = new ArrayList();
    public ArrayList<Venda> vendas = new ArrayList();
    
    // não é possível haver atendimento sem cliente
    public Atendimento(Cliente c) {
        this.cli = c;
    }
    
    public String toString(){
        
        String s = data+ " às "+hora + "; atendido: "+cli;
        
        for (Servico serv : servicos) {
            s += "\n"+serv;
        }
        for (Venda v : vendas){
            s+= "\n"+v;
        }
        
        s+= "\nTotal: "+ Total();
        
        return s;
    }
    
    public float Total() {
        float total = 0;
        // percorre as vendas (serviços e/ou produtos)
        for (Venda v : vendas){
            // acumula o total do item
            total += (v.item.preco)*(v.qtd);
        }
        return total;
    }
    
    // TESTE DO ATENDIMENTO
    public static void main(String[] args) {
             
        System.out.println("*** Teste do método retornarPrimeiroAtendimento");
        System.out.println(DAO.retornarPrimeiroAtendimento());
        
        System.out.println("*** Teste do método retornarAtendimentos");
        for (Atendimento a : DAO.retornarAtendimentos()) {
            System.out.println(a);
        }
    }
}
