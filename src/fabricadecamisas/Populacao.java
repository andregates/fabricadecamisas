/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricadecamisas;

import java.util.ArrayList;
import java.util.Collections;

public class Populacao {
    
    private ArrayList<Individuo> individuos;

    public ArrayList<Individuo> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(ArrayList<Individuo> individuos) {
        this.individuos = individuos;
    }

	public Populacao(){
		individuos = new ArrayList<>();
       }
        
        public Populacao(int tamanho){
		individuos = new ArrayList<>();
                iniciarPopulacao(tamanho);
	}
	
        public void iniciarPopulacao(int tamPop) {
		for (int i = 0; i < tamPop; i++) {
			individuos.add(new Individuo());
                }
                ordenarPopulacao();
	}

	// ordenar populacao (ordem crescente)
	public void ordenarPopulacao() {
		Collections.sort(individuos, Collections.reverseOrder());
                /*for(Individuo i : individuos){
                    System.out.print("\t\tAptidão (u.m.): "+i.getAptidao());
                    System.out.println("\t"+i);
                }*/
                
               // System.out.print("\tMelhor Indivíduo - Aptidão: "+individuos.get(0).getAptidao());
               // System.out.println("\t"+individuos.get(0));
       }

	public Individuo getIndividuo(int pos) {
		return individuos.get(pos);
	}

	// coloca um individuo na proxima posicao disponivel da populacao
	public void setIndividuo(Individuo individuo) {
		individuos.add(individuo);

	}

	// numero de individuos existentes na populacao
	public int getNumIndividuos() {
		return individuos.size();
	}

}
