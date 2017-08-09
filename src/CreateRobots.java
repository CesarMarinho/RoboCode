import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;



public class CreateRobots {
	
	static String robotCode = new String();
	
	static String PATH = new String("C:\\robocode\\robots\\sampleex");
	static String PACKAGE = new String("sampleex");
	static String JARS = new String("C:\\robocode\\libs\\robocode.jar;");
	
	public static void generateEspecimen(int[] vetor, String name){
		createCode(vetor, name);
		compileCode(name);
	}
	
	private static void createCode(int vetor[], String name){
		
		String v = new String();//converte vetor de int para string
		v = "{";
		for(int t : vetor){
			v = v+t+",";
		}
		v = v+"}";
		
		robotCode = 
		"package "+PACKAGE+";"+
		"\nimport robocode.*;" +
		"\nimport java.util.Random;"+
		"\nimport robocode.HitByBulletEvent;"+
		"\nimport robocode.HitWallEvent;"+
		"\nimport robocode.Robot;"+
		"\nimport robocode.ScannedRobotEvent;"+

		"\n\npublic class "+ name +" extends Robot {"+
		"\nprivate int[] vetor = "+ v + ";"+
		
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
	
	private static void compileCode(String name){
		System.out.println("Entrou na compileCode");		
		try{
			FileWriter fstream = new FileWriter(PATH+"\\"+name+".java");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(robotCode);
			out.close();
		}catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		System.out.println("Teoricamente, arquivo criado");
		//compile code
		
		try {
			execute("javac -cp " + JARS + " " + PATH + "\\"+name+".java");
		}catch(Exception e){
			e.printStackTrace();
		}		
		
	}

	private static void execute(String command) throws Exception{
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
