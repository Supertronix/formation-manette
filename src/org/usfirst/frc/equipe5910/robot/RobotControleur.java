package org.usfirst.frc.equipe5910.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotControleur extends IterativeRobot {

	public static final int MANETTE_CONDUITE_PRINCIPALE = 0;
	public static final int MANETTE_ACCESSOIRE = 1;	
	
	// PWM Outputs
	public static final int ROUE_AVANT_GAUCHE = 10; // SP 1
	public static final int ROUE_ARRIERE_GAUCHE = 14; // SP 2
	public static final int ROUE_AVANT_DROIT= 13; // SP 3
	public static final int ROUE_ARRIERE_DROIT = 17; // SP 4
	
	public static final boolean INVERSION_ROUE_AVANT_GAUCHE = true;
	public static final boolean INVERSION_ROUE_ARRIERE_GAUCHE = true;
	public static final boolean INVERSION_ROUE_AVANT_DROIT = false;
	public static final boolean INVERSION_ROUE_ARRIERE_DROIT= false;
	
    private Joystick manetteConduitePrincipale;
    private Joystick manetteAccessoire;	
    VictorSP roueAvantGauche; 
	VictorSP roueArriereGauche; 
	VictorSP roueAvantDroite; 
	VictorSP roueArriereDroite; 
	
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
    	
		roueAvantGauche = new VictorSP(ROUE_AVANT_GAUCHE);
		roueArriereGauche = new VictorSP(ROUE_ARRIERE_GAUCHE);
		roueAvantDroite = new VictorSP(ROUE_AVANT_DROIT);
		roueArriereDroite = new VictorSP(ROUE_ARRIERE_DROIT);
		 	
		roueAvantGauche.setInverted(INVERSION_ROUE_AVANT_GAUCHE); // TRUE
		roueArriereGauche.setInverted(INVERSION_ROUE_ARRIERE_GAUCHE); // TRUE
		roueAvantDroite.setInverted(INVERSION_ROUE_AVANT_DROIT);
		roueArriereDroite.setInverted(INVERSION_ROUE_ARRIERE_DROIT);
		
		
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
	    this.roueAvantGauche.set(xGauche);
	    
	    //public double getConduiteGaucheY() {
	    double yGauche = -manetteConduitePrincipale.getRawAxis(CONDUITE_Y_GAUCHE); 
	    System.out.println("Y gauche : " + yGauche);
	    this.roueArriereGauche.set(yGauche);
	    
	    //public double getConduiteDroiteX() {
	    double xDroit = manetteConduitePrincipale.getRawAxis(CONDUITE_X_DROITE);
	    System.out.println("X droit : " + xDroit);
	    this.roueAvantDroite.set(xDroit);
	      
	    //public double getConduiteDroiteY() {
	    double yDroit = -manetteConduitePrincipale.getRawAxis(CONDUITE_Y_DROITE);
	    System.out.println("Y droit : " + yDroit);
	    this.roueArriereDroite.set(yDroit);	
	    
	    // Robot.drive.conduire(Calculateur.clamp(x + y1, -1, 1), Calculateur.clamp(y2 - x, -1, 1), Calculateur.clamp(y1 - x, -1, 1), Calculateur.clamp(x + y2, -1, 1));
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
