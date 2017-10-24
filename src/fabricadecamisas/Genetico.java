package fabricadecamisas;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author André Gomes
 */
public class Genetico {
    
    private Random random = new Random();
    private final double taxaCruzamento=0.9;
    private boolean elitismo;
    private final int maxGeracoes=1000;
    private final int tamPopulacao=50;
    private Populacao populacao;

    public Populacao getPopulacao() {
        return populacao;
    }
    
    public Genetico(){
        this.populacao = new Populacao(tamPopulacao);
    }
    
    public Populacao gerarNovaPopulacao(boolean elitismo, Populacao pp){
        
        Populacao populacaoTemporaria = new Populacao();
       
        if(elitismo){
            //elege o mais apto como sendo o primeiro indíviduo da lista recém ordenada
            pp.ordenarPopulacao();
            populacaoTemporaria.setIndividuo(pp.getIndividuo(0));   
            
      
        } 
        
        while(populacaoTemporaria.getNumIndividuos()<this.tamPopulacao){
            
            
            ArrayList<Individuo> pais = selecao(populacao);
            ArrayList<Individuo> filhos = new ArrayList<>();
            
            if(random.nextDouble()<=this.taxaCruzamento){
                filhos= cruzamento(pais);
            }else{
                filhos.add(pais.get(0));
                filhos.add(pais.get(1));
            }
            populacaoTemporaria.setIndividuo(filhos.get(0));
            populacaoTemporaria.setIndividuo(filhos.get(1));  
        }    
        populacaoTemporaria.ordenarPopulacao();
        return populacaoTemporaria;
    }
    
    
    public ArrayList<Individuo> selecao(Populacao populacao){
       
        ArrayList<Individuo> ind = new ArrayList<>();
        for(int i=0; i<2;i++){
            int a=random.nextInt(this.tamPopulacao);
            int b=random.nextInt(this.tamPopulacao);
            if(this.populacao.getIndividuo(a).getAptidao()>this.populacao.getIndividuo(b).getAptidao()){
                ind.add(this.populacao.getIndividuo(a));
            }else if(this.populacao.getIndividuo(a).getAptidao()<this.populacao.getIndividuo(b).getAptidao()){
                ind.add(this.populacao.getIndividuo(b));
            }else{
                ind.add(this.populacao.getIndividuo(a));
            }
        }      
        return ind;
    }
    
    public ArrayList<Individuo> cruzamento(ArrayList<Individuo> pais){
        
        ArrayList<Individuo> filhos = new ArrayList<>();
        
        int[] geneFilho1 = pais.get(0).getGenes();
        int[] geneFilho2 = pais.get(1).getGenes();
        
        int aux = geneFilho1[0];
        geneFilho1[0] = geneFilho2[0];
        geneFilho2[0] = aux;
        
        filhos.add(new Individuo(geneFilho1));
        filhos.add(new Individuo(geneFilho2));
        
        return filhos;
    }

    public int getMaxGeracoes() {
        return maxGeracoes;
    }
    
    

    
}
