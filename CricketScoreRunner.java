//Runner Class
//Responsible for the execution of whole program
//Carries out the process with main() method



package com.climateconnect.assignment;

import java.io.IOException;

public class CricketScoreRunner {

	public static void main(String[] args) throws IOException {
		Object O1 = new ScoreCardTeam1();
		int noOfPlayers = ((ScoreCardTeam1) O1).teamDetails(); 
		int noOfOvers = ((ScoreCardTeam1) O1).overDetails(); 
		int target = ((ScoreCardTeam1) O1).scoreBoardTeam1();
		Object O2 = new ScoreCardTeam2();
		((ScoreCardTeam2) O2).scoreBoardTeam2(target, noOfPlayers, noOfOvers);  
	}
}
