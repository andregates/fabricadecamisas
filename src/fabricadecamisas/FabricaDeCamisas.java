
package fabricadecamisas;

/**
 *
 * @author André Gomes
 */
public class FabricaDeCamisas {
   
    public static void main(String[] args) {
        // TODO code application logic here
        int geracao=0;
        System.out.println("Geração: "+geracao);
        System.out.println("===================================================================================");
        Genetico g = new Genetico();
        Populacao pp = g.getPopulacao();
        Populacao p;
        //geracao++;
        
        int contEstagnar=0;
        double anterior=-1;
        //System.out.print("\tMelhor Indivíduo - Aptidão: "+pp.getIndividuo(0).getAptidao());
        //System.out.println("\t"+pp.getIndividuo(0));
        do{
            System.out.println("Geração: "+geracao);
            System.out.println("===================================================================================");
            
            
            p = g.gerarNovaPopulacao(true, pp);
            System.out.print("\tMelhor Indivíduo - Aptidão: "+p.getIndividuo(0).getAptidao());
            System.out.println("\t"+p.getIndividuo(0));
            if(geracao==0 || p.getIndividuo(0).getAptidao()!=anterior){
                anterior = p.getIndividuo(0).getAptidao();
                contEstagnar = 1;
            }else{
                contEstagnar++;
            }
            
            if(contEstagnar>25){ 
                System.out.println("Processamento Estagnado");
                System.out.println("====================================================");
                break;
            }
            
            if(geracao++ >= g.getMaxGeracoes()) break;
        }while(p.getIndividuo(0).getAptidao()>0);
    
    }
    
}

/*
Resumo do problema:

* Fábrica produz camisas de manga longa e manga curta. Ponto crítico é a mão-de-obra
* Camisa manga longa usa 50% de mão de obra a mais que camisa manga curta
* Se só produzisse manga curta, capacidade produtiva seria de 400 und por dia
* Limitação do mercado: 150 longas e 300 curtas por dia.
* Lucro bruto LONGA 5,00 u.m.   CURTA 3,5 u.m.

*Objetivo: Permitir a determinação das quantidades de camisas a serem produzidas de modo a
 otimizar o lucro.



*/
