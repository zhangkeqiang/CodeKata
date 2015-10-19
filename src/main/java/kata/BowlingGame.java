package kata;
/**
It has now been more than ten years since Kent Beck and Martin Fowler started to talk about Continuous Integration. 
At that time, it was hard to believe this practice would have such an impact on our daily work and would be so much 
adopted in the world of software development. Today, we at SonarSource but also in many places, can simply not
 imagine to go back and work without Continuous Integration.

Here is what can be read about Continuous Integration on Wikipedia :
Continuous integration aims to improve the quality of software, and to reduce the time taken to deliver it, by
 replacing the traditional practice of applying quality control after completing all development.

The ultimate goal of Continuous is to be able to fire any type of release at any time with minimal risk whether
 it is a Milestone, Release Candidate or GA : quality requirements become a must-have and no more a nice-to-have. 
 Let’s review which requirements are correctly covered by continuous integration environments today :

Anybody must be able to build the project from any place and at anytime.
Every Unit Tests must be executed during the Continuous Integration build.
Every Unit Tests must pass during the Continuous Integration build.
The output of the Continuous Integration build is a package ready to ship.
When one of the above requirement is violated nothing is more important for the team than fixing it.
*/
public class BowlingGame {
	  private int[] rolls = new int[21];
	  private int[] framescore = new int[14];
	  private int[] framebonusstatus = new int[14];
	  private char[] framestatus = new char[14];
	  private int currentRoll = 0;
	  private int currentframe = 0;

	  private int score2 = 0;
	  public static final  int SPARE = 1;
	  public static final  int STRIKE = 2;
	  public static final  int FIRSTROLLINFRAME = 0;
	  public static final int SECONDROLL = 3;
	  public static final int FRAMEEND = 4;
	  public static final int STRIKEONEBONUS = 5;	
	  

	  
	  
//	  Anybody must be able to build the project from any place and at anytime.
//	  Every Unit Tests must be executed during the Continuous Integration build.
//	  Every Unit Tests must pass during the Continuous Integration build.
//	  The output of the Continuous Integration build is a package ready to ship.
//	  When one of the above requirement is violated nothing is more important for the team than fixing it.
	  public void roll(int pins) {
		int indexofthisframe =  currentframe; 
	    rolls[currentRoll++] = pins;
	    
	    switch(framebonusstatus[currentframe])   {
	        case FIRSTROLLINFRAME:	    
	    	rollFirst(pins);
	    	break;
	    case  SECONDROLL:
	    	rollSecond(pins);	
	    	break;
	    default:	
	    	break;
	    }
	    
	    if(indexofthisframe>0){
	    	
	    switch(framebonusstatus[indexofthisframe-1]) {
	    case SPARE:
	    case STRIKEONEBONUS:
	    	framescore[indexofthisframe-1] += pins;
	    	framebonusstatus[indexofthisframe-1] = FRAMEEND;
	    	score2 += framescore[indexofthisframe-1];
	    	break;
	    case STRIKE:
	    	framescore[indexofthisframe-1] += pins;
	    	framebonusstatus[indexofthisframe-1] = STRIKEONEBONUS;
	    	break;

	    default:
	    	break;
	    }
	    }
	    
	    if(indexofthisframe>1){
		switch(framebonusstatus[indexofthisframe-2]) {
		case STRIKEONEBONUS:
			framescore[indexofthisframe-2] += pins;
			framebonusstatus[indexofthisframe-2] = FRAMEEND;
			score2 += framescore[indexofthisframe-2];
			break;
		default: 
			break;
		}
		}
	    
	  }

	private void rollSecond(int pins) {
		framescore[currentframe] += pins;
		if(framescore[currentframe]==10){
			framebonusstatus[currentframe] = SPARE;
			framestatus[currentframe] = '/';
		}else{
			framebonusstatus[currentframe] = FRAMEEND;
			framestatus[currentframe] = '^';
			score2 += framescore[currentframe];
		}
		currentframe++;
	}

	private void rollFirst(int pins) {
		framescore[currentframe] = pins;
		if(pins == 10){
			framebonusstatus[currentframe] = STRIKE;
			framestatus[currentframe] = 'X';
			currentframe++;	
		}else{
			framebonusstatus[currentframe] = SECONDROLL;
			framestatus[currentframe] = '.';
		}
	}
	  
//	  At that time, it was hard to believe this practice would have such an impact on our daily 
//	  work and would be so much 
//	  adopted in the world of software development. Today, we at SonarSource but also in many places, can simply not
//	   imagine to go back and work without Continuous Integration.

//	  Here is what can be read about Continuous Integration on Wikipedia :
//	  Continuous integration aims to improve the quality of software, and to reduce the time taken to deliver it, by
//	   replacing the traditional practice of applying quality control after completing all development.
	   
	  public int score2(){
		  return score2;
	  }
	  public int score() {
	    int score = 0;
	    int frameIndex = 0;
	    for (int frame = 0; frame < 10; frame++) {
	      if (isStrike(frameIndex)) {
	        score += 10 + strikeBonus(frameIndex);
	        frameIndex++;
	      } else if (isSpare(frameIndex)) {
	        score += 10 + spareBonus(frameIndex);
	        frameIndex += 2;
	      } else {
	        score += sumOfBallsInFrame(frameIndex);
	        frameIndex += 2;
	      }
	    }
	    return score;
	  }

//comments1
//comments2
	//comments13
	//comments24
	//comments15
	//comments26
	//comments17
	//comments28
	//comments19
	//comments210
	//comments111
	//comments212
	//comments113
	//comments214
	//comments116
	//comments217
	//comments134
	//comments244
	  private boolean isStrike(int frameIndex) {
	    return rolls[frameIndex] == 10;
	  }

	  private int sumOfBallsInFrame(int frameIndex) {
	    return rolls[frameIndex] + rolls[frameIndex+1];
	  }

	  private int spareBonus(int frameIndex) {
	    return rolls[frameIndex+2];
	  }

	  private int strikeBonus(int frameIndex) {
	    return rolls[frameIndex+1] + rolls[frameIndex+2];
	  }

	  private boolean isSpare(int frameIndex) {
	    return rolls[frameIndex]+rolls[frameIndex+1] == 10;
	  }

	  public int scoreinprogress() {
		 int score = 0;
		 int frameIndex = 0;
		    for (int frame = 0; frame < 10 && frame < (currentRoll/2+1); frame++) {
		      if (isStrike(frameIndex)) {
		        score += 10 + strikeBonus(frameIndex);
		        frameIndex++;
		      } else if (isSpare(frameIndex)) {
		        score += 10 + spareBonus(frameIndex);
		        frameIndex += 2;
		      } else {
		        score += sumOfBallsInFrame(frameIndex);		        
		        frameIndex += 2;
		      }

		    }
		return score;
	}

	public int getFrameScore(int i) {
		
		return framescore[i-1];
	}


	public char getFrameStatus(int i) {
		
		return framestatus[i-1];
	}

}
