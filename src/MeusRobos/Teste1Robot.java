package MeusRobos;
import java.util.Random;

import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Teste1Robot extends Robot {
	
	private int[] vetor = new int[17];
	private boolean flag = true;
	Random random = new Random();
	//private int[] mov = new int[4];
	/*>> 1� posi��o - Movimenta��o (4 posi��es)
	 * 0 - tr�s
	 * 1 - direita 	(vire � direita)
	 * 2 - esquerda	(vire � esquerda)
	 * 3 - frente	
	 * 
	 * >>2� posi��o - Esquiva (4 posi��es)
	 * 0 - tr�s
	 * 1 - direita 	(vire � direita)
	 * 2 - esquerda	(vire � esquerda)
	 * 3 - frente	
	 * 
	 * >>3� posi��o - Movimento do canh�o (4 posi��es)
	 * 0 - +15 graus
	 * 1 - -15 graus
	 * 2 - +30 graus
	 * 3 - -30 graus
	 * 
	 * >>4� posi��o - Potencia do tiro (1 posi��o)
	 * Valor do random = valor do tiro
	 * 
	 * >>5� posi��o - Movimento do radar (4 posi��es)
	 * 0 - 0 graus
	 * 1 - -15 graus
	 * 2 - +15 graus
	 * 3 - 360 graus
	 * */
	
	public void run(){
		int i = 0;
		if(flag){
			setValues();
			//if(vetor[1]==1)ahead(300);
			//turnGunRight(180);
		}
		while(true){	
			if(i==0)moves();
			else gunMoves();
			i++;
			if(i==2)i=0;
		}
		
	}
	
	public void onScannedRobot(ScannedRobotEvent e){
		fire(vetor[12]);
	}
	
	public void onHitByBullet(HitByBulletEvent e) {
		for(int i=4;i<7;i++)	
			if(vetor[i]==0)back(100);
			else if(vetor[i]==1)turnRight(90);
			else if(vetor[i]==2)turnLeft(90);
			else if(vetor[i]==3)ahead(100);
	}	
	
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
		turnRight(30);
		ahead(20);
	}	
	
	public void setValues(){
		for(int i=0;i<17;i++){
			vetor[i] = random.nextInt(4);			
		}
		flag = false;
		//turnLeft(900);
	}
	
	/* 
	 * dever� ler o gene correspondente a cada rob� 
	 * ser�o criados x rob�s (x � o n�mero da popula��o) e cada um ir� ler a "sua linha" 
	 */
	
	public void setArchValues(){ //l� os valores do gene diretamente de um arquivo 
		flag = false;
	}
	
	public void moves(){
		for(int i=0;i<3;i++){	
			if(vetor[i]==0)back(100);
			else if(vetor[i]==1)turnRight(90);
			else if(vetor[i]==2)turnLeft(90);
			else if(vetor[i]==3)ahead(100);
		}
	}
	
	public void gunMoves(){
		for(int i=8;i<11;i++){	
			if(vetor[i]==0)turnGunRight(90);
			else if(vetor[i]==1)turnGunLeft(90);
			else if(vetor[i]==2)turnGunRight(360);
			else if(vetor[i]==3)turnGunLeft(360);
			ahead(10);
		}
	}
	
}
