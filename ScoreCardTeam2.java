//This class manages scoreboard for team batting 2nd
//Figures out the result of match




package com.climateconnect.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ScoreCardTeam2{
	int p6Score = 0, p6Balls=0, p6Fours=0, p6Six=0;
	int p7Score = 0, p7Balls=0, p7Fours=0, p7Six=0;
	int p8Score = 0, p8Balls=0, p8Fours=0, p8Six=0;
	int p9Score = 0, p9Balls=0, p9Fours=0, p9Six=0;
	int p10Score = 0, p10Balls=0, p10Fours=0, p10Six=0;
	
	public void displayDataTeam2(int totalRuns, int wickets, float over) {
		System.out.println("ScoreCard for Team 2");
		System.out.println("PlayerName"+" "+"Score"+" "+"4s"+" "+"6s"+" "+"Balls");
		System.out.println("P6"+"         "+p6Score+"     "+p6Fours+"     "+p6Six+"    "+p6Balls);
		System.out.println("P7"+"         "+p7Score+"     "+p7Fours+"     "+p7Six+"    "+p7Balls);
		System.out.println("P8"+"         "+p8Score+"     "+p8Fours+"     "+p8Six+"    "+p8Balls);
		System.out.println("P9"+"         "+p9Score+"     "+p9Fours+"     "+p9Six+"    "+p9Balls);
		System.out.println("P10"+"         "+p10Score+"     "+p10Fours+"     "+p10Six+"    "+p10Balls);
		System.out.println("Total:"+" "+totalRuns+'/'+wickets);
		System.out.println("Overs:"+" "+over);  
	}
	
	public void playerScoresTeam2(char ball, String strikeBatsman){
		int wicketCheck = Character.compare(ball, 'W'); 
		int fourCheck = Character.compare(ball, '4');
		int sixCheck = Character.compare(ball, '6');
		if (strikeBatsman.equals("P6")) {
			if (fourCheck==0) {
				p6Fours++;
				p6Score = p6Score + 4;
				p6Balls++;
			}
			else if (sixCheck==0) {
				p6Six++;
				p6Score = p6Score + 6;
				p6Balls++;
			}
			else if (wicketCheck==0) {
				p6Balls++;
			}
			else {
				p6Score = p6Score + (int) ball - 48;
				p6Balls++;
			}
		}
		else if (strikeBatsman.equals("P7")) {
			if (fourCheck==0) {
				p7Fours++;
				p7Score = p7Score + 4;
				p7Balls++;
			}
			else if (sixCheck==0) {
				p7Six++;
				p7Score = p7Score + 6;
				p7Balls++;
			}
			else if (wicketCheck==0) {
				p7Balls++;
			}
			else {
				p7Score = p7Score + (int) ball - 48;
				p7Balls++;
			}
		}
		else if (strikeBatsman.equals("P8")) {
			if (fourCheck==0) {
				p8Fours++;
				p8Score = p8Score + 4;
				p8Balls++;
			}
			else if (sixCheck==0) {
				p8Six++;
				p8Score = p8Score + 6;
				p8Balls++;
			}
			else if (wicketCheck==0) {
				p8Balls++;
			}
			else {
				p8Score = p8Score + (int) ball - 48;
				p8Balls++;
			}
		}
		else if (strikeBatsman.equals("P9")) {
			if (fourCheck==0) {
				p9Fours++;
				p9Score = p9Score + 4;
				p9Balls++;
			}
			else if (sixCheck==0) {
				p9Six++;
				p9Score = p9Score + 6;
				p9Balls++;
			}
			else if (wicketCheck==0) {
				p9Balls++;
			}
			else {
				p9Score = p9Score + (int) ball - 48;
				p9Balls++;
			}
		}
		else {
			if (fourCheck==0) {
				p10Fours++;
				p10Score = p10Score + 4;
				p10Balls++;
			} 
			else if (sixCheck==0) {
				p10Six++;
				p10Score = p10Score + 6;
				p10Balls++;
			}
			else if (wicketCheck==0) {
				p10Balls++;
			}
			else {
				p10Score = p10Score + (int) ball - 48;
				p10Balls++;
			}
		}
	}
	
	public void scoreBoardTeam2(int target, int noOfPlayers, int noOfOvers) throws IOException {
		Scanner scan = new Scanner(System.in); 
		float over = 0;
		String battingOrderTeam2[] = new String[noOfPlayers];
		System.out.println("Enter the batting order for team2");
		InputStreamReader in = new InputStreamReader (System.in); 
	    BufferedReader br = new BufferedReader (in);
	    for(int i=0; i<noOfPlayers; i++){
	    	battingOrderTeam2[i] = br.readLine();
	    } 
		float balls = 0;
		int totalRuns = 0;
		int wickets = 0;
		char ball;
		String strikeBatsman = battingOrderTeam2[wickets]; 
		String nonStrikeBatsman = battingOrderTeam2[wickets+1]; 
		while (over<noOfOvers && wickets<noOfPlayers-1) {
			strikeBatsman = battingOrderTeam2[wickets]; 
			nonStrikeBatsman = battingOrderTeam2[wickets+1];
			System.out.println("Enter the over details");
			while(balls<6){
				int run = 0;
		    	ball = scan.next().charAt(0);
		    	int wicketCheck = Character.compare(ball, 'W'); 
		    	int wideCheck = Character.compare(ball, 'w');  
		    	int noballCheck = Character.compare(ball, 'N'); 
		    	if (wideCheck!=0 && noballCheck!=0) {
		    		balls++;
		    		if (wicketCheck!=0) {
		    			run = (int) ball - 48;
			    		totalRuns = totalRuns + run;
			    		playerScoresTeam2(ball, strikeBatsman); 
			    		if (run%2!=0) {
			    			String temp = strikeBatsman;
			    			strikeBatsman = nonStrikeBatsman;
			    			nonStrikeBatsman = temp;
			    		}
		    		}
		    		else {
			    		wickets++;
			    		if (wickets<noOfPlayers-1) {
			    			playerScoresTeam2(ball, strikeBatsman);
				    		strikeBatsman = battingOrderTeam2[wickets+1];
			    		}
			    		else {
			    			break; 
			    		}
		    		} 
		    		if (balls==6) {
		    			String temp = strikeBatsman;
		    			strikeBatsman = nonStrikeBatsman;
		    			nonStrikeBatsman = temp;
		    		}
		    	}
		    	else {
		    		totalRuns++;
		    	}
		    }
			if (balls<6) {
				over = over + (balls/10);
			}
			else {
				over++;
			}
			displayDataTeam2(totalRuns, wickets, over);
			balls = 0; 
		}
		System.out.println();
		if (totalRuns < target) {
			System.out.println("Result : Team1 won the match by "+ (target-totalRuns)+" runs" );
		}
		else {
			System.out.println("Result : Team2 won the match by "+ (noOfPlayers-wickets)+" wickets" );
		}
	}
}
