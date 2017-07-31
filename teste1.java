import java.util.Random;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Teste1Robot extends Robot {+
private int[] vetor = [I@6d06d69c;
public void run(){
	int i = 0;
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
back(20);
turnRight(30);
ahead(20);
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