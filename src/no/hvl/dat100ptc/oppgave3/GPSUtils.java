package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import java.lang.reflect.Array;
import java.util.Arrays;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}

		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		
		double result[] = new double[2];
		
		double a = Double.parseDouble(Arrays.toString(gpspoints).substring(4,12));
		double b = Double.parseDouble(Arrays.toString(gpspoints).substring(31,40));
		
		result[0] = a;
		result[1] = b;
		
		return result;
		
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		
		double result[] = new double[2];
		
		double a = Double.parseDouble(Arrays.toString(gpspoints).substring(13,21));
		double b = Double.parseDouble(Arrays.toString(gpspoints).substring(42,50));

		result[0] = a;
		result[1] = b;
		
		return result;

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;
		
		latitude1 = gpspoint1.getLatitude();
		latitude2 = gpspoint2.getLatitude();
		longitude1 = gpspoint1.getLongitude();
		longitude2 = gpspoint2.getLongitude();
		
		double v = Math.toRadians(latitude1);
		double w = Math.toRadians(latitude2);
		double x =Math.toRadians(latitude2 - latitude1);
		double y =Math.toRadians(longitude2 - longitude1);
		
		double a = Math.pow(Math.asin(x/2),2) + Math.cos(v) * Math.cos(w) * Math.pow(Math.asin(y/2),2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt((1-a)));
		d = R*c;
		
		return d;

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int time1 = gpspoint1.getTime();
		int time2 = gpspoint2.getTime();
		int secs = (time2 - time1);
		double speed;
		double d = GPSUtils.distance(gpspoint1, gpspoint2);
		
		speed = ((d/secs) * 3600)/1000;
		
		return speed;

	}

	public static String formatTime(int secs) {

		String timestr;
		int hr, min, sec;
		
		hr = secs/3600;
		min = (secs - (hr * 3600))/60;
		sec = (secs - (hr * 3600)) - (min * 60);
		
		String hour = String.format("%02d", hr);
		String minute = String.format("%02d", min);
		String second = String.format("%02d", sec);
		timestr = "  " + hour + ":" + minute + ":" + second;
		
		return timestr;

	}
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String zero = Double.toString(Math.round(d));
		int i = Integer.parseInt(zero.substring(0,1));
		
		String rounder = Double.toString(d).substring(2,4) + "." + Double.toString(d).substring(4,5);
		String e = Double.toString(Math.round(Double.parseDouble(rounder)));
		int f = Integer.parseInt(e.substring(0,2));
		
		String nearly = Integer.toString(i) + "." + Integer.toString(f);
		String rounded = Double.toString(Double.parseDouble(nearly));
		String result = "      " + rounded;
		
		return result;
		
	}
}
