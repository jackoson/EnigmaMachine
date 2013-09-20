package machine;

import java.io.File;
import java.util.Hashtable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class EnigmaMachine {
	public RotorGroup rotorGroup;
	
	public EnigmaMachine(int  a, int b, int c){
		RotorInner ri1 = null;
		RotorInner ri2 = null;
		RotorInner ri3 = null;
		
		Hashtable[] h = getRotorConfigs(a,b,c);
		
		try{
			ri1 = new RotorInner(h[0]);
			ri2 = new RotorInner(h[1]);
			ri3 = new RotorInner(h[2]);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("\t\t\t fudge");
		}
		

		Rotor r1 = new Rotor(ri1);
		Rotor r2= new Rotor(ri2);
		Rotor r3 = new Rotor(ri3);
		
		rotorGroup = new RotorGroup(new Rotor[]{r1,r2,r3});
		rotorGroup.setRotorPositions('a', 'a', 'a');
		
		
	}
	
	public void setRotorPositions(char a, char b, char c){
		rotorGroup.setRotorPositions(a, b, c);
		System.out.println("positions set to "+ a +", "+ b +", "+ c);
	}
	
	public String getRotorPos() {
		return rotorGroup.getRotorPos();
	}
	
	public char Encrypt(char ch){
		return rotorGroup.Encode(ch);
	}
	
	 Hashtable[] getRotorConfigs(int a, int b, int c) {

		
		
		try {
			 
			File f = new File("rotorInnerPairs.xml");
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder = factory.newDocumentBuilder();
		    Document doc = docBuilder.parse(f);
		   
		    return new Hashtable[]{getHash(doc,a),getHash(doc,b),getHash(doc,c)};
		    
		    
		    } catch (Exception e) {
			e.printStackTrace();
		    }	
		
		return null;
	
}

	private static Hashtable getHash(Document doc, int c) {
		
		Hashtable ht = new Hashtable();
		
		Element bookElement = (Element) doc.getElementsByTagName("rotor"+c).item(0);
	    
	     // make a list of its number pairs
          NodeList pairnodes = bookElement.getElementsByTagName("pair");
          //loop through each pair
          for(int z = 0; z < pairnodes.getLength(); z++){
        	  //creating an element from it
	          Element pair = (Element)pairnodes.item(z);
	          //gettting the pair values
	         String from = pair.getElementsByTagName("from").item(0).getFirstChild().getNodeValue();
	         String to = pair.getElementsByTagName("to").item(0).getFirstChild().getNodeValue();
	         
	         ht.put(Integer.parseInt(from), Integer.parseInt(to));
	         //printing to screen
	         //System.out.println(String.format("from %s to %s", from,to));
	        
          }
		return ht;
	}
	
	
}