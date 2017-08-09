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
	/*>> 1ª posição - Movimentação (4 posições)
	 * 0 - trás
	 * 1 - direita 	(vire à direita)
	 * 2 - esquerda	(vire à esquerda)
	 * 3 - frente	
	 * 
	 * >>2ª posição - Esquiva (4 posições)
	 * 0 - trás
	 * 1 - direita 	(vire à direita)
	 * 2 - esquerda	(vire à esquerda)
	 * 3 - frente	
	 * 
	 * >>3ª posição - Movimento do canhão (4 posições)
	 * 0 - +15 graus
	 * 1 - -15 graus
	 * 2 - +30 graus
	 * 3 - -30 graus
	 * 
	 * >>4ª posição - Potencia do tiro (1 posição)
	 * Valor do random = valor do tiro
	 * 
	 * >>5ª posição - Movimento do radar (4 posições)
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
	 * deverá ler o gene correspondente a cada robô 
	 * serão criados x robôs (x é o número da população) e cada um irá ler a "sua linha" 
	 */
	
	public void setArchValues(){ //lê os valores do gene diretamente de um arquivo 
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
