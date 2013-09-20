package machine;

class RotorGroup {

	
	Rotor[] rotors;
	
	RotorGroup(Rotor[] r){
		System.out.println("rotor group created");
		rotors = r;
		
	}
	
	public void increamentRotors() {
		// TODO Auto-generated method stub
		if(rotors[0].getOffSet() < 25){
			rotors[0].incrementOffSet();
		}else{
			rotors[0].setOffSet(0);
			if(rotors[1].getOffSet() < 25){
				rotors[1].incrementOffSet();
			}else{
				rotors[1].setOffSet(0);
				if(rotors[2].getOffSet() < 25){
					rotors[2].incrementOffSet();
				}else{
					rotors[2].setOffSet(0);
				}
			}
		}
	}
	
	char Encode(char c){
		char temp = c;
		
		temp = rotors[0].Scramble(temp);
		temp = rotors[1].Scramble(temp);
		temp = rotors[2].Scramble(temp);
		temp = rotors[1].Scramble(temp);
		temp = rotors[0].Scramble(temp);
		
		increamentRotors();
		return temp;
		
	}	
	
	void setRotorPositions(char a, char b, char c){
		rotors[0].setOffSet(a-97);
		rotors[1].setOffSet(b-97);
		rotors[2].setOffSet(c-97);
	}
	
	String getRotorPos() {
		// TODO Auto-generated method stub
		return String.format("a: %d B: %d c:%d", rotors[0].getOffSet(), rotors[1].getOffSet(), rotors[2].getOffSet());
	}
	
}
