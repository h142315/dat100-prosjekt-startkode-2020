package no.hvl.dat100ptc.oppgave4;

import java.text.DecimalFormat;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {

	private GPSPoint[] gpspoints;

	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	// a) beregn total distances (i meter)
	public double totalDistance() {

		double distance = 0;

		// TODO - START
		//Lager en forløkke som går gjennom alle gpspunktene. 
		//Siden vi brukar i+1 inni løkken, kan den bare gå til lengde-1
		for(int i = 0; i < gpspoints.length-1; i++) {
			//Brukar distance-metoden fra oppgave 3 for å finne avstand mellom to punkter. 
			double tempDistance = GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
			
			//Legger til denne avstanden til den totale avstanden. 
			distance += tempDistance; 
		}
		return distance;
		// TODO - SLUTT

	}

	// b) beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0;
		// TODO - START
		//Lager en løkke som går gjennom alle gpspunktene. 
		for(int i = 1; i < gpspoints.length; i++) {

			//Dersom punktet har en elevation som er større enn forrige punkt sin elevation..
			if(gpspoints[i].getElevation() > gpspoints[i-1].getElevation()) {
				//.. så legger vi på høydeforskjellen til totalt antall høydemeter.  
				elevation += (gpspoints[i].getElevation() - gpspoints[i-1].getElevation());
			}
		}
		return elevation;
		// TODO - SLUTT

	}

	// c) beregn total tiden for hele turen (i sekunder)
	public int totalTime() {
		
		int time = 0;
		for(int i = 1; i < gpspoints.length; i++) {
			//Legger til tidsforskjellen mellom punktene til den totale tiden.
			time += (gpspoints[i].getTime() - gpspoints[i-1].getTime());
			
		}
		return time;
	}

	// d) beregn gjennomsnitshastighets mellom hver av gps punktene
	public double[] speeds() {
		// TODO - START		// OPPGAVE - START
		double[] speed = new double[gpspoints.length -1];
		
		for(int i = 0; i < gpspoints.length-1; i++) {
			
			//Finner først endringen i tid mellom et punkt og det forrige. 
			double deltaTime = gpspoints[i+1].getTime() - gpspoints[i].getTime();
			
			//Finner avstanden mellom de samme punktene. 
			double distance = GPSUtils.distance(gpspoints[i], gpspoints[i+1]);
			
			//Gjennomsnittsfart = distansen/ endring i tid.
			//Ganger med 3,6 for å få km/t istedenfor m/s. 
			double averageSpeed = distance/deltaTime*3.6;
			
			//Lagrer gjennomsnittsfarten i speed-tabellen.
			speed[i] = averageSpeed;	
		}
		return speed;
		// TODO - SLUTT
	}

	// e) finner største hastighet mellom to punkter på ruten
	public double maxSpeed() {

		double maxspeed = 0;

		// TODO - START
		//Henter inn alle gjennomsnittsfartene
		double[] averageSpeeds = speeds();
		
		//Bruker findMax-metoden for å finne den største farten i tabellen. 
		maxspeed = GPSUtils.findMax(averageSpeeds);

		return maxspeed; 
		// TODO - SLUTT

	}

	// f) finner gjennomsnittsfart
	public double averageSpeed() {

		double average = 0;

		// TODO - START
		//Gjennomsnittsfart er total distanse delt på total tid. 
		//Som før ganger vi med 3,6 for å finne km/t istedenfor m/s. 
		average = totalDistance()/totalTime()*3.6;
		return average; 
		// TODO - SLUTT

	}

	/*
	 * bicycling, <10 mph, leisure, to work or for pleasure 4.0 bicycling,
	 * general 8.0 bicycling, 10-11.9 mph, leisure, slow, light effort 6.0
	 * bicycling, 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 14-15.9
	 * mph, racing or leisure, fast, vigorous effort 10.0 bicycling, 16-19 mph,
	 * racing/not drafting or >19 mph drafting, very fast, racing general 12.0
	 * bicycling, >20 mph, racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// g) beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		double kcal;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;		
		double speedmph = speed * MS;

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	// h) totalt antall kalorier forbrent
	public double totalKcal(double weight) {

		double totalkcal = 0;

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	private static double WEIGHT = 80.0;

	
	// i) vise statistikk
	public void displayStatistics() {

		System.out.println("==============================================");

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

}
