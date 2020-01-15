package com.org.problemsolving.ds.first.programming.practice.dynamic;
import java.util.Scanner;
import java.math.*;

public class BalanceLog {
	public double balancePoint(Log log) {
		 // YOUR CODE HERE
		 BigDecimal lenght= new BigDecimal(log.length());
		 
		 BigDecimal start  = new BigDecimal(".5");

		 BigDecimal totalWeight  = new BigDecimal(log.weightUpto(lenght.doubleValue()));
		
		 BigDecimal halfWeight = totalWeight.multiply(new BigDecimal(".5"));
		 
		 while(start.doubleValue() < lenght.doubleValue()){
			 BigDecimal wightedPoint =  new BigDecimal(log.weightUpto(start.doubleValue()));
		     if(halfWeight.abs().equals(wightedPoint.abs())){
		         return wightedPoint.doubleValue();
		     }
		     start = start.add(new BigDecimal(".5"));
		 }
		 
		 return -1;
	}

	// DO NOT MODIFY CODE BELOW THIS LINE
	interface Log {
            double weightUpto(double x); // returns the weightUpto of the part of the log from the left end to a point at distance x from it.
            double length(); // returns the total length of the log
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] tokens = line.split(" ");
			Log c = null;
			switch (tokens[0]) {
			case "LINE":
				c = new Line(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]),
						Double.parseDouble(tokens[3]));
				break;
			case "EXP":
				c = new Exp(Double.parseDouble(tokens[1]));
				break;
			case "POWER":
				c = new Power(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
				break;
			case "SINE":
				c = new Sine(Double.parseDouble(tokens[1]));
				break;
			}

			if (c == null) {
				break;
			}
			BalanceLog t = new BalanceLog();
			double h = t.balancePoint(c);
			System.out.println(Math.round(h * 1000d));
		}

		scanner.close();
	}

	static class Line implements Log {
		private double m;
		private double c;
		private double l;

		public Line(double l, double m, double c) {
			this.m = m;
			this.c = c;
			this.l = l;
		}

		@Override
		public double weightUpto(double x) {
			return m * x + c;
		}

		@Override
		public double length() {
			return l;
		}
	}

	static class Exp implements Log {
		private double l;

		public Exp(double l) {
			this.l = l;
		}

		@Override
		public double weightUpto(double x) {
			if (x < 0) {
				return 0;
			} else if (x > l) {
				return Math.exp(l);
			}
			return Math.exp(x);
		}

		@Override
		public double length() {
			return l;
		}
	}

	static class Power implements Log {
		private double l;
		private double power;

		public Power(double l, double power) {
			this.l = l;
			this.power = power;
		}

		@Override
		public double length() {
			return l;
		}

		@Override
		public double weightUpto(double x) {
			if (x < 0) {
				return 0;
			} else if (x > l) {
				return Math.pow(l, power);
			} else {
				return Math.pow(x, power);
			}
		}
	}

	static class Sine implements Log {
		private double l;

		public Sine(double l) {
			this.l = l;
		}

		@Override
		public double length() {
			return l;
		}

		@Override
		public double weightUpto(double x) {
			if (x < 0) {
				return 0;
			} else if (x > l) {
				return l + Math.sin(l);
			} else {
				return x + Math.sin(x);
			}
		}
	}
}