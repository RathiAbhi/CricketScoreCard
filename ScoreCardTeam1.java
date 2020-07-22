//Class takes input for match details
//Manages scoreboard for team batting first



package com.climateconnect.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ScoreCardTeam1 {
	int noOfPlayers=0, noOfOvers=0;
	int p1Score = 0, p1Balls=0, p1Fours=0, p1Six=0;
	int p2Score = 0, p2Balls=0, p2Fours=0, p2Six=0;
	int p3Score = 0, p3Balls=0, p3Fours=0, p3Six=0;
	int p4Score = 0, p4Balls=0, p4Fours=0, p4Six=0;
	int p5Score = 0, p5Balls=0, p5Fours=0, p5Six=0;
	
	public int teamDetails(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of players in each team");
		noOfPlayers = scan.nextInt();
		return noOfPlayers; 
	}
	 
	public int overDetails(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of overs per inning");
		noOfOvers = scan.nextInt();
		return noOfOvers; 
	}
	
	public void displayDataTeam1(int totalRuns, int wickets, float over) {
		System.out.println("ScoreCard for Team 1");
		System.out.println("PlayerName"+" "+"Score"+" "+"4s"+" "+"6s"+" "+"Balls");
		System.out.println("P1"+"         "+p1Score+"     "+p1Fours+"     "+p1Six+"    "+p1Balls);
		System.out.println("P2"+"         "+p2Score+"     "+p2Fours+"     "+p2Six+"    "+p2Balls);
		System.out.println("P3"+"         "+p3Score+"     "+p3Fours+"     "+p3Six+"    "+p3Balls);
		System.out.println("P4"+"         "+p4Score+"     "+p4Fours+"     "+p4Six+"    "+p4Balls);
		System.out.println("P5"+"         "+p5Score+"     "+p5Fours+"     "+p5Six+"    "+p5Balls);
		System.out.println("Total:"+" "+totalRuns+'/'+wickets);
		System.out.println("Overs:"+" "+over);  
	}
	
	public void playerScoresTeam1(char ball, String strikeBatsman){
		int wicketCheck = Character.compare(ball, 'W'); 
		int fourCheck = Character.compare(ball, '4');
		int sixCheck = Character.compare(ball, '6');
		if (strikeBatsman.equals("P1")) {
			if (fourCheck==0) {
				p1Fours++;
				p1Score = p1Score + 4;
				p1Balls++;
			}
			else if (sixCheck==0) {
				p1Six++;
				p1Score = p1Score + 6;
				p1Balls++;
			}
			else if (wicketCheck==0) {
				p1Balls++;
			}
			else {
				p1Score = p1Score + (int) ball - 48;
				p1Balls++;
			}
		}
		else if (strikeBatsman.equals("P2")) {
			if (fourCheck==0) {
				p2Fours++;
				p2Score = p2Score + 4;
				p2Balls++;
			}
			else if (sixCheck==0) {
				p2Six++;
				p2Score = p2Score + 6;
				p2Balls++;
			}
			else if (wicketCheck==0) {
				p2Balls++;
			}
			else {
				p2Score = p2Score + (int) ball - 48;
				p2Balls++;
			}
		}
		else if (strikeBatsman.equals("P3")) {
			if (fourCheck==0) {
				p3Fours++;
				p3Score = p3Score + 4;
				p3Balls++;
			}
			else if (sixCheck==0) {
				p3Six++;
				p3Score = p3Score + 6;
				p3Balls++;
			}
			else if (wicketCheck==0) {
				p3Balls++;
			}
			else {
				p3Score = p3Score + (int) ball - 48;
				p3Balls++;
			}
		}
		else if (strikeBatsman.equals("P4")) {
			if (fourCheck==0) {
				p4Fours++;
				p4Score = p4Score + 4;
				p4Balls++;
			}
			else if (sixCheck==0) {
				p4Six++;
				p4Score = p4Score + 6;
				p4Balls++;
			}
			else if (wicketCheck==0) {
				p4Balls++;
			}
			else {
				p4Score = p4Score + (int) ball - 48;
				p4Balls++;
			}
		}
		else {
			if (fourCheck==0) {
				p5Fours++;
				p5Score = p5Score + 4;
				p5Balls++;
			}
			else if (sixCheck==0) {
				p5Six++;
				p5Score = p5Score + 6;
				p5Balls++;
			}
			else if (wicketCheck==0) {
				p5Balls++;
			}
			else {
				p5Score = p5Score + (int) ball - 48;
				p5Balls++;
			}
		}
	}
	
	public int scoreBoardTeam1() throws IOException { 
		Scanner scan = new Scanner(System.in);
		float over = 0; 
		String battingOrderTeam1[] = new String[noOfPlayers];
		System.out.println("Enter the batting order for team1");
		InputStreamReader in = new InputStreamReader (System.in);
	    BufferedReader br = new BufferedReader (in);
	    for(int i=0; i<noOfPlayers; i++){
	    	battingOrderTeam1[i] = br.readLine();
	    }
		float balls = 0;
		int totalRuns = 0;
		int wickets = 0;
		char ball;
		String nonStrikeBatsman = battingOrderTeam1[wickets+1];
		String strikeBatsman = battingOrderTeam1[wickets];
		while (over<noOfOvers && wickets<noOfPlayers-1) {
			strikeBatsman = battingOrderTeam1[wickets]; 
			nonStrikeBatsman = battingOrderTeam1[wickets+1];
			System.out.println("Enter the over details");
			while(balls<6){
				int run = 0;
		    	ball = scan.next().charAt(0); 
		    	int wicketCheck = Character.compare(ball, 'W'); 
		    	int wideCheck = Character.compare(ball, 'w');  
		    	int noballCheck = Character.compare(ball, 'N'); 
		    	if (wideCheck!=0 && noballCheck!=0) {
		    		if (wicketCheck!=0) {
		    			run = (int) ball - 48;
			    		totalRuns = totalRuns + run;
			    		playerScoresTeam1(ball, strikeBatsman); 
			    		if (run%2!=0) {
			    			String temp = strikeBatsman;
			    			strikeBatsman = nonStrikeBatsman;
			    			nonStrikeBatsman = temp;
			    		}
		    		}
		    		else {
			    		wickets++;
			    		if (wickets<noOfPlayers-1) {
			    			playerScoresTeam1(ball, strikeBatsman);
				    		strikeBatsman = battingOrderTeam1[wickets+1]; 
			    		}
			    		else {
			    			break;
			    		}
		    		}
		    		balls++; 
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
			displayDataTeam1(totalRuns, wickets, over);
			balls = 0;
		}
		return totalRuns; 
	}

	public static void main(String[] args) throws IOException{
		Object O = new ScoreCardTeam1(); 
		((ScoreCardTeam1) O).scoreBoardTeam1(); 
	}
}
