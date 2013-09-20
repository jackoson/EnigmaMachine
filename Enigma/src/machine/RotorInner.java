package machine;

import java.util.Hashtable;

 class RotorInner {

	Hashtable numberPairs;

	RotorInner(Hashtable np) throws Exception{
		if(containsAllNumbers(np)){
			numberPairs = np;
			
		}else{
			throw new Exception("Does not contain all numbers");
		}
	}

	private boolean containsAllNumbers(Hashtable np) {
		for(int i = 1; i<26; i++){
			if(np.containsKey(i)==false){
				return false;
			}
		}
		return true;
	}
	
	int Scramble(int i){
		return (int) numberPairs.get(i);
	}
	
}
