import MeusRobos.Teste1Robot;
import robocode.Robot;
import robocode.control.BattleSpecification;
import robocode.control.BattlefieldSpecification;
import robocode.control.RobocodeEngine;
import robocode.control.RobotSpecification;

public class BattleRunner {
	 public static void main(String[] args) {
		 
         // Disable log messages from Robocode
         RobocodeEngine.setLogMessagesEnabled(false);

         // Create the RobocodeEngine
         //   RobocodeEngine engine = new RobocodeEngine(); // Run from current working directory
         RobocodeEngine engine = new RobocodeEngine(new java.io.File("C:/Robocode")); // Run from C:/Robocode
 
         // Add our own battle listener to the RobocodeEngine 
         engine.addBattleListener(new BattleObserver());
 
         // Show the Robocode battle view
         engine.setVisible(true);
         
         // Setup the battle specification
 
         int numberOfRounds = 2;
         BattlefieldSpecification battlefield = new BattlefieldSpecification(800, 600); // 800x600
         RobotSpecification[] selectedRobots = engine.getLocalRepository("sample.Corners,sample.Crazy");
         //RobotSpecification[] selectedRobotsA = engine.getLocalRepository("sampleex.Alien,samplesentry.BorderGuard");
         
            
         
         BattleSpecification battleSpec = new BattleSpecification(numberOfRounds, battlefield, selectedRobots);
         //BattleSpecification battleSpecA = new BattleSpecification(numberOfRounds, battlefield, selectedRobotsA);
         
         
 
         // Run our specified battle and let it run till it is over
         for(int i=0;i<3;i++){
        	 engine.runBattle(battleSpec, true); // waits till the battle finishes
        	 //engine.runBattle(battleSpecA, true);
         }
 
         // Cleanup our RobocodeEngine
         engine.close();
 
         // Make sure that the Java VM is shut down properly
         System.exit(0);
     }
}
