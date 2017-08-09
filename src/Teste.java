import java.util.ArrayList;
import java.util.Random;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<int[][]> populacoes = new ArrayList<int[][]>();
		Random random = new Random();
		int genes[] = new int[8];
		int pop[][] = new int[4][8];
		
		for(int i=0;i<5;i++){ // numero de gerações
			for(int j=0;j<4;j++){ // numero de indivíduos
				for(int k=0;k<8;k++){ // numero de genes
					//preenchendo o vetor dos genes
					genes[k] = random.nextInt(4);					
				}	
				for(int k=0;k<8;k++){
					pop[j][k] = genes[k];
				}
			}
			populacoes.add(pop);
		}
		for(int i=0;i<populacoes.size();i++){
			System.out.println("gen. " + i);
			for(int j=0;j<4;j++){
				System.out.println("individuo "+j);
				for(int k=0;k<8;k++){
					System.out.print(populacoes.get(i)[j][k]);
				}
				System.out.println();
			}
			
		}

	}

}
