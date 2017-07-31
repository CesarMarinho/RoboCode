import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class CreateRobots {
	
	static String robotCode = new String();
	
	public static void main(String[] args){
		int[] vetor = new int[17];
		Random random = new Random();
		
		for(int i=0;i<17;i++){//preenchendo Vetor de características
			vetor[i] = random.nextInt(4);			
		}
		
		createCode(vetor);
		//System.out.println(robotCode);
		compileCode();
		System.out.println("finish!");
	}
	
	public static void createCode(int vetor[]){
		
		robotCode = 
		"import java.util.Random;"+
		"\nimport robocode.HitByBulletEvent;"+
		"\nimport robocode.HitWallEvent;"+
		"\nimport robocode.Robot;"+
		"\nimport robocode.ScannedRobotEvent;"+

		"\n\npublic class Teste1Robot extends Robot {+"+
		"\nprivate int[] vetor = "+vetor+";"+
		
		"\npublic void run(){"+
		"\n	int i = 0;"+
			
		"\n	while(true){"+	
				"\nif(i==0)moves();"+
				"\nelse gunMoves();"+
				"\ni++;"+
				"\nif(i==2)i=0;"+
			"\n}"+
			
		"\n}"+
		
		"\npublic void onScannedRobot(ScannedRobotEvent e){"+
			"\nfire(vetor[12]);"+
		"\n}"+
		
		"\npublic void onHitByBullet(HitByBulletEvent e) {"+
			"\nfor(int i=4;i<7;i++)"+	
				"\nif(vetor[i]==0)back(100);"+
				"\nelse if(vetor[i]==1)turnRight(90);"+
				"\nelse if(vetor[i]==2)turnLeft(90);"+
				"\nelse if(vetor[i]==3)ahead(100);"+
		"\n}"+	
		
		"\npublic void onHitWall(HitWallEvent e) {"+			
			"\nback(20);"+
			"\nturnRight(30);"+
			"\nahead(20);"+
		"\n}"+	
		
		"\npublic void moves(){"+
			"\nfor(int i=0;i<3;i++){"+	
				"\nif(vetor[i]==0)back(100);"+
				"\nelse if(vetor[i]==1)turnRight(90);"+
				"\nelse if(vetor[i]==2)turnLeft(90);"+
				"\nelse if(vetor[i]==3)ahead(100);"+
			"\n}"+
		"\n}"+
		
		"\npublic void gunMoves(){"+
			"\nfor(int i=8;i<11;i++){"+	
				"\nif(vetor[i]==0)turnGunRight(90);"+
				"\nelse if(vetor[i]==1)turnGunLeft(90);"+
				"\nelse if(vetor[i]==2)turnGunRight(360);"+
				"\nelse if(vetor[i]==3)turnGunLeft(360);"+
				"\nahead(10);"+
			"\n}"+
		"\n}"+		
		"\n}";
		
	}
	
	public static void compileCode(){
		String kk = "C:\\robocode\\robots\\samplesentry\\teste1.java";
		try{
			FileWriter fstream = new FileWriter(kk);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(robotCode);
			out.close();
		}catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Teoricamente, arquivo criado");
		//compile code
		try {
			execute("javac -cp" + kk);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void execute(String command) throws Exception{
		Process process = Runtime.getRuntime().exec(command);
		printMsg(command + " stdout:", process.getInputStream());
		printMsg(command + " stderr:", process.getErrorStream());
		process.waitFor();
		if(process.exitValue() != 0)
			System.out.println(command + "exited with value " + process.exitValue());
	}
	
	private static void printMsg(String name, InputStream ins) throws Exception {
		String line = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(ins));
		while((line = in.readLine()) != null){
			System.out.println(name + " " + line);
		}
	}

}
