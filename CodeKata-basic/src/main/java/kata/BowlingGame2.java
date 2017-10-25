package kata;

public class BowlingGame2 {
	  private int rolls[] = new int[21];
	  private int framescore[] = new int[14];
	  private int framebonusstatus[] = new int[14];
	  private char framestatus[] = new char[14];
	  private int currentRoll = 0;
	  private int currentframe = 0;

	  private int score2 = 0;
	  public static final  int SPARE = 1;
	  public static final  int STRIKE = 2;
	  public static final  int FIRSTROLLINFRAME = 0;
	  public static final int SECONDROLL = 3;
	  public static final int FRAMEEND = 4;
	  public static final int STRIKEONEBONUS = 5;	
	  
	 /* public BowlingGame()
	  {
		  for(int i=0;i<framestate.length;i++)
		  {
			  framestate[i] = FIRSTROLLINFRAME;
		  }
	  }*/
	  public void roll(int pins) {
		int indexofthisframe =  currentframe; 
	    rolls[currentRoll++] = pins;
	    
	    switch(framebonusstatus[currentframe])   {
	    case FIRSTROLLINFRAME:	    
	    	framescore[currentframe] = pins;
	    	if(pins == 10){
	    		framebonusstatus[currentframe] = STRIKE;
	    		framestatus[currentframe] = 'X';
	    		currentframe++;	
	    	}else{
	    		framebonusstatus[currentframe] = SECONDROLL;
	    		framestatus[currentframe] = '.';
	    	}
	    	break;
	    case  SECONDROLL:
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
	    case 23:
	    	framescore[indexofthisframe-1] += pins;
	    	framebonusstatus[indexofthisframe-1] = FRAMEEND;
	    	score2 += framescore[indexofthisframe-1];
	    	break;  
	    default:
	    	//break;
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

/*	public int getFrameState() {
		return state;
	}*/
	public char getFrameStatus(int i) {
		return framestatus[i-1];
	}

}
