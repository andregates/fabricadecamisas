
package fabricadecamisas;

import java.util.Arrays;
import java.util.Random;

public class Individuo implements Comparable<Individuo>{
    
	private Random random = new Random();
	private Double aptidao;
	
	//atributos do problema especifico
	
	private int qtdLonga;
        private int qtdCurta;
        
	//cria um individuo aleatorio da primeira geracao
	public Individuo() {
            	do {
			this.setQtdLonga();
                        this.setQtdCurta();
		} while (!validar());
		avaliar();
	}

	// cria um individuo a partir de genes definidos
	public Individuo(int[] genes) {
            
		qtdLonga = genes[0];
		qtdCurta = genes[1];
                //testa se deve fazer mutacao
		if (random.nextDouble() <= 0.5) {
                    	int posAleatoria = random.nextInt(genes.length); //define gene que sera mutado
			if (!mutacao(posAleatoria)){
                            qtdLonga = genes[0];
                            qtdCurta = genes[1];
                        };
		}
		avaliar();
	}

	public boolean validar() {
            
		double restricao = (3/2)*qtdLonga + qtdCurta;
                
                if (restricao== 400)
			return true;
		return false;
	}

	public boolean mutacao(int posicao) {
			if (posicao == 0)
                                this.setQtdLonga();
			else if (posicao == 1)
				this.setQtdCurta();
            	if(!validar()){
                    return false;
                }else{
                    return true;
                }

	}

	public void setQtdCurta(int qtdCurta) {
		this.qtdCurta = qtdCurta;
	}

	public void setQtdLonga(int qtdLonga) {
		this.qtdLonga = qtdLonga;
	}

	public void setQtdCurta() {
		this.qtdCurta = random.nextInt(300);
	}

	private void setQtdLonga() {
		this.qtdLonga = random.nextInt(150);

	}

	public double getAptidao() {
		return aptidao;
	}

	public int[] getGenes() {
		return new int[] { qtdLonga, qtdCurta };
	}

	public void avaliar() {
            aptidao = 5 * qtdLonga + 3.5 * qtdCurta;
	}

	@Override
	public String toString() {
		return "\tCromossomo " + Arrays.toString(getGenes()) + "\n";
	}

	@Override
	public int compareTo(Individuo i) {
		return this.aptidao.compareTo(i.aptidao);
	}
}
