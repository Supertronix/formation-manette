package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotControleur extends IterativeRobot {

	public class CommandeGrimpeurDemarrer extends Command {
		public CommandeGrimpeurDemarrer() {
			//requires(RobotControleur.robot.grimpeur);
			 
		 }
		 
		 @Override
		protected void initialize() {
			 //RobotControleur.robot.grimpeur.grimper();
			 System.out.println("Executer Grimper");
		}
		 
		@Override
		protected boolean isFinished() {
			return true;
		}
	}
		
	public static final int MANETTE_CONDUITE_PRINCIPALE = 0;
	public static final int MANETTE_ACCESSOIRE = 1;	
	public static final int BOUTON_GRIMPEUR = 6;
	public static final int BOUTON_INTAKE = 5;
	public static final int BOUTON_MACHOIRE = 10;
	public static final int BOUTON_INDEXEUR = 1;
	
    private Joystick manetteConduitePrincipale;
    private Joystick manetteAccessoire;	

    
    
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 * 
	 */
	@Override
	public void robotInit() {
		System.out.println("robotInit()");
    	manetteConduitePrincipale = new Joystick(MANETTE_CONDUITE_PRINCIPALE);
    	manetteAccessoire = new Joystick(MANETTE_ACCESSOIRE);
    	JoystickButton actionGrimpeur = new JoystickButton(manetteConduitePrincipale, BOUTON_GRIMPEUR);
    	actionGrimpeur.whenPressed(new CommandeGrimpeurDemarrer());
    	//actionGrimpeur.whenReleased(new CommandeGrimpeurArreter());
	}

	/**
	 * This function is run once each time the robot enters autonomous mode
	 */
	@Override
	public void autonomousInit() {
		System.out.println("autonomousInit()");
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		System.out.println("autonomousPeriodic()");
	}

	/**
	 * This function is called once each time the robot enters tele-operated
	 * mode
	 */
	@Override
	public void teleopInit() {
		System.out.println("teleopInit()");
	}

	
	public static final int CONDUITE_X_GAUCHE = 0;
	public static final int CONDUITE_Y_GAUCHE = 1;
	public static final int CONDUITE_X_DROITE = 4;
	public static final int CONDUITE_Y_DROITE = 5;
	
	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		System.out.println("teleopPeriodic()");
	    //public double getConduiteGaucheX() {
	    double xGauche = manetteConduitePrincipale.getRawAxis(CONDUITE_X_GAUCHE);
	    System.out.println("X gauche : " + xGauche);
	    
	    //public double getConduiteGaucheY() {
	    double yGauche = -manetteConduitePrincipale.getRawAxis(CONDUITE_Y_GAUCHE); 
	    System.out.println("Y gauche : " + yGauche);
	    
	    //public double getConduiteDroiteX() {
	    double xDroit = manetteConduitePrincipale.getRawAxis(CONDUITE_X_DROITE);
	    System.out.println("X droit : " + xDroit);
	      
	    //public double getConduiteDroiteY() {
	    double yDroit = -manetteConduitePrincipale.getRawAxis(CONDUITE_Y_DROITE);
	    System.out.println("Y droit : " + yDroit);
	  		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		System.out.println("testPeriodic()");
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testInit() {
		System.out.println("testInit()");
	}
	
}
