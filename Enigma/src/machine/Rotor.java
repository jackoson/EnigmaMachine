package machine;

import java.util.Hashtable;

public class Rotor {
	
	RotorInner rInner;
	private int InneroffSet;
	
	Rotor(RotorInner i){
		rInner = i;
		System.out.println("rotor created");
	}
	
	void setOffSet(int i){
		InneroffSet = i;
	}
	
	void incrementOffSet(){
		InneroffSet++;
	}
	
	int getOffSet(){
		return InneroffSet;
	}
	
	char Scramble(char ch){
		
		int letterNum = ch - 97;

		int offsetNum = letterNum + InneroffSet;
	
		if((int) offsetNum > 25){
			offsetNum = (char) (0 + offsetNum%26);
		}

		int scrambled = rInner.Scramble((int)offsetNum);

		int offSetScrambled = scrambled - InneroffSet;
	
	
		offSetScrambled = offSetScrambled + 97;
		if((int) offSetScrambled < 97){
			offSetScrambled = (char) (123 - (97-offSetScrambled));
		}
		return (char) offSetScrambled;
	}
	
}
