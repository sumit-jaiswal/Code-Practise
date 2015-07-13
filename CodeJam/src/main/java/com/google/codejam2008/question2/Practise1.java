package com.google.codejam2008.question2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.TreeSet;

/**
 * https://code.google.com/codejam/contest/32013/dashboard#s=p1
 * 
 * @author sumijaiswal
 *
 */
public class Practise1 {

	public static void main(String[] args) throws Exception {
		Practise1.readLine();
	}

	public static void readLine() throws Exception {
		BufferedReader reader = null;
		BufferedWriter writer = null;
		String baseDir = "src/main/java/com/google/codejam2008/question2/";
		String inputType = "small";
		String inputFile = baseDir + inputType + "-input.in";
		String outputFile = baseDir + inputType + "-output.in";
		try {
			reader = new BufferedReader(new FileReader(new File(inputFile)));
			writer = new BufferedWriter(new FileWriter(new File(outputFile)));
			
			int noOfTestCases = Integer.parseInt(reader.readLine());
			for (int i = 1; i <= noOfTestCases; i++) {
				
				int turnAroundTime = Integer.parseInt(reader.readLine());
				
				String[] schedules = reader.readLine().split(" ");
				int noOfTrainASchedules = Integer.parseInt(schedules[0]);
				int noOfTrainBSchedules = Integer.parseInt(schedules[1]);
				
				/**
				 * Add the train schedule for each station in sorted set
				 */
				TreeSet<TrainTime> trainScheduleA = new TreeSet<TrainTime>();
				for (int j = 1; j <= noOfTrainASchedules; j++) {
					String[] scheduleLine = reader.readLine().split(" ");
					addTrainSchedule(scheduleLine, trainScheduleA);
				}

				TreeSet<TrainTime> trainScheduleB = new TreeSet<TrainTime>();
				for (int j = 1; j <= noOfTrainBSchedules; j++) {
					String[] scheduleLine = reader.readLine().split(" ");
					addTrainSchedule(scheduleLine, trainScheduleB);
				}

				int countOfTrainAtA = 0;
				int countOfTrainAtB = 0;
				TreeSet<Integer> trainsStartedAtA = new TreeSet<Integer>();
				TreeSet<Integer> trainsStartedAtB = new TreeSet<Integer>();

				TreeSet<Integer> trainsArrivingAtA = new TreeSet<Integer>();
				TreeSet<Integer> trainsArrivingAtB = new TreeSet<Integer>();

				TrainTime trainTimeAtA = trainScheduleA.pollFirst();
				TrainTime trainTimeAtB = trainScheduleB.pollFirst();
				for (int k = 1; k <= (noOfTrainASchedules+noOfTrainBSchedules); k++) {
					System.out.println();
					System.out.println("Train Time at Station A:"+trainTimeAtA);
					System.out.println("Train Time at Station B:"+trainTimeAtB);
					if (trainTimeAtA != null
							&& (trainTimeAtB == null || trainTimeAtA.compareTo(trainTimeAtB) <= 0)) {
						
						// Start the train at Station A
						trainsStartedAtA.add(trainTimeAtA.departureTime);
						trainsArrivingAtB.add(trainTimeAtA.arrivalTime);
						
						if (!trainsArrivingAtA.isEmpty()
								&& trainTimeAtA.departureTime >= (trainsArrivingAtA
										.first() + turnAroundTime)) {
							// Reusing the train already waiting at Station A
							trainsArrivingAtA.pollFirst();
						} else {
							//New train starting at Station A
							countOfTrainAtA++;
						}
						// Fetch the next train schedule for Station A
						trainTimeAtA = trainScheduleA.pollFirst();
					} else if (trainTimeAtB != null) {
						// Start the train at Station B
						trainsStartedAtB.add(trainTimeAtB.departureTime);
						trainsArrivingAtA.add(trainTimeAtB.arrivalTime);
						
						if (!trainsArrivingAtB.isEmpty()
								&& trainTimeAtB.departureTime >= (trainsArrivingAtB
										.first() + turnAroundTime)) {
							// Reusing the train already waiting at Station B
							trainsArrivingAtB.pollFirst();
						} else {
							//New train starting at Station B
							countOfTrainAtB++;
						}
						// Fetch the next train schedule for Station B
						trainTimeAtB = trainScheduleB.pollFirst();
					}
				}

				writer.write("Case #" + i + ": " + countOfTrainAtA + " "
						+ countOfTrainAtB + "\n");
				System.out.println("Case #" + i + ": " + countOfTrainAtA + " "
						+ countOfTrainAtB + "\n");
			}
		} finally {
			if (reader != null)
				reader.close();
			if (writer != null)
				writer.close();
		}
	}

	private static void addTrainSchedule(String[] scheduleLine,
			TreeSet<TrainTime> trainSchedule) {
		int departureTime = getTimeInMinutes(scheduleLine[0].split(":"));
		int arrivalTime = getTimeInMinutes(scheduleLine[1].split(":"));
		trainSchedule.add(new TrainTime(arrivalTime, departureTime));
	}

	private static int getTimeInMinutes(String[] timeFormat) {
		return Integer.parseInt(timeFormat[0]) * 60
				+ Integer.parseInt(timeFormat[1]);
	}
}

class TrainTime implements Comparable {
	public int departureTime;
	public int arrivalTime;

	public TrainTime() {
	}

	public TrainTime(int arrivalTime, int departureTime) {
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	public int compareTo(Object o) {
		int deptTime = ((TrainTime) o).departureTime;
		int returnVal = 0;
		if (departureTime > deptTime)
			returnVal = 1;
		else if (departureTime < deptTime)
			returnVal = -1;
		return returnVal;
	}

	public String formatMinutes(int minutes) {
		return ((int) minutes / 60) + ":" + ((int) minutes % 60);
	}

	@Override
	public String toString() {
		return "TrainTime [departureTime=" + formatMinutes(departureTime)
				+ ", arrivalTime=" + formatMinutes(arrivalTime) + "]";
	}

}
