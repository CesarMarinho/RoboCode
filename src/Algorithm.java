import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Algorithm {
	
	private final static int popSize = 4;
	private final int maxGen = 100;
	private static int[] chromosome = {0,0,0,0,0,0,0,0,0,0,0,0,0};
	private static Random random = new Random();
	static FileWriter fstream;	
	static BufferedWriter out;
	
	private static String name = new String();
	private static String generation = new String();
	
	
	public static String genPopInicial(){
		
		String initialPop = new String();
		
		for(int i=0; i<popSize;i++){				
			
			name = "rb"+i;
			
			for(int j=0;j<17;j++){//preenchendo Vetor de características
				chromosome[i] = random.nextInt(4);			
			}
			CreateRobots.generateEspecimen(chromosome, name);
			initialPop = initialPop + "sampleex." + name + "," ;
		}
		
		return initialPop;
		
	}

}
