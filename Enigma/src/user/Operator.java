package user;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import machine.*;

public class Operator {

	static Hashtable ht1;
	static Hashtable ht2;
	static Hashtable ht3;
	static Hashtable ht5;
	static Hashtable ht4;
	
	public static void main(String[] args) {
		
		
		
		
		
		//printoutRotors();
		//createPairings();
		//configurePairs();
		
		Scanner in = new Scanner(System.in);
		System.out.println("select rotors");
		String i = in.nextLine();
		try{
			EnigmaMachine em = new EnigmaMachine(Character.getNumericValue(i.charAt(0)), Character.getNumericValue(i.charAt(1)),Character.getNumericValue(i.charAt(2)));
		
			System.out.println("select rotor positions (letters)");
			String pos = in.nextLine();
			em.setRotorPositions(pos.charAt(0), pos.charAt(1),pos.charAt(2));
			
			while(true){
				String inputString = in.nextLine();
				
				if(inputString.equals("res")){
					em.setRotorPositions(pos.charAt(0), pos.charAt(1),pos.charAt(2));
				}else if(inputString.equals("set")){
					i = in.nextLine();
					em.setRotorPositions(i.charAt(0), i.charAt(1),i.charAt(2));
				}else{
					String code = "";
					for(int c = 0; c< inputString.length();c++){
						char ch = inputString.charAt(c);
						if(ch != ' ')
							code = code + em.Encrypt(inputString.charAt(c));
					}
					System.out.println(code);
				}
				
				
			}
		
		}catch(NullPointerException e){
			System.out.println(e.getMessage());
		}	
	}
		
		

			
	

		private static void createPairings() {
			boolean[] j = new boolean[26];
			
			Random r = new Random();
			
			while(stillfalses(j)){
				
				int x = r.nextInt(26);
				if(j[x]==false){
					
					j[x] = true;
					int i = r.nextInt(26);
					while(j[i]==true)
						i = r.nextInt(26);
					j[i] = true;
					
					System.out.println("ht5.put("+x+","+i+");");
					System.out.println("ht5.put("+i+","+x+");");
									
				}
			}
		
	}

		static boolean stillfalses(boolean[] b){
			for(int x = 0;x<26;x++){
				if(b[x]==false)
					return true;
			}
			return false;
		}

	private static void configurePairs() {
		ht1 = new Hashtable();
		ht2 = new Hashtable();
		ht3 = new Hashtable();
		ht5 = new Hashtable();
		ht4 = new Hashtable();
		
		ht1.put(10,4);
		ht1.put(4,10);
		ht1.put(20,8);
		ht1.put(8,20);
		ht1.put(23,19);
		ht1.put(19,23);
		ht1.put(6,24);
		ht1.put(24,6);
		ht1.put(13,11);
		ht1.put(11,13);
		ht1.put(16,14);
		ht1.put(14,16);
		ht1.put(17,5);
		ht1.put(5,17);
		ht1.put(1,21);
		ht1.put(21,1);
		ht1.put(22,0);
		ht1.put(0,22);
		ht1.put(18,3);
		ht1.put(3,18);
		ht1.put(12,25);
		ht1.put(25,12);
		ht1.put(2,7);
		ht1.put(7,2);
		ht1.put(9,15);
		ht1.put(15,9);




				
		ht2.put(21,10);
		ht2.put(10,21);
		ht2.put(15,12);
		ht2.put(12,15);
		ht2.put(24,19);
		ht2.put(19,24);
		ht2.put(23,16);
		ht2.put(16,23);
		ht2.put(5,2);
		ht2.put(2,5);
		ht2.put(6,22);
		ht2.put(22,6);
		ht2.put(4,14);
		ht2.put(14,4);
		ht2.put(8,25);
		ht2.put(25,8);
		ht2.put(7,17);
		ht2.put(17,7);
		ht2.put(3,20);
		ht2.put(20,3);
		ht2.put(0,18);
		ht2.put(18,0);
		ht2.put(1,11);
		ht2.put(11,1);
		ht2.put(13,9);
		ht2.put(9,13);



				
		ht3.put(24,15);
		ht3.put(15,24);
		ht3.put(25,12);
		ht3.put(12,25);
		ht3.put(0,9);
		ht3.put(9,0);
		ht3.put(14,10);
		ht3.put(10,14);
		ht3.put(11,18);
		ht3.put(18,11);
		ht3.put(4,2);
		ht3.put(2,4);
		ht3.put(22,8);
		ht3.put(8,22);
		ht3.put(13,7);
		ht3.put(7,13);
		ht3.put(20,23);
		ht3.put(23,20);
		ht3.put(17,21);
		ht3.put(21,17);
		ht3.put(1,6);
		ht3.put(6,1);
		ht3.put(5,3);
		ht3.put(3,5);
		ht3.put(16,19);
		ht3.put(19,16);		
		
		ht4.put(1,22);
		ht4.put(22,1);
		ht4.put(5,10);
		ht4.put(10,5);
		ht4.put(23,9);
		ht4.put(9,23);
		ht4.put(24,12);
		ht4.put(12,24);
		ht4.put(19,4);
		ht4.put(4,19);
		ht4.put(3,18);
		ht4.put(18,3);
		ht4.put(21,25);
		ht4.put(25,21);
		ht4.put(16,14);
		ht4.put(14,16);
		ht4.put(7,0);
		ht4.put(0,7);
		ht4.put(8,6);
		ht4.put(6,8);
		ht4.put(20,2);
		ht4.put(2,20);
		ht4.put(13,11);
		ht4.put(11,13);
		ht4.put(15,17);
		ht4.put(17,15);
		
		ht5.put(17,20);
		ht5.put(20,17);
		ht5.put(7,14);
		ht5.put(14,7);
		ht5.put(3,12);
		ht5.put(12,3);
		ht5.put(8,11);
		ht5.put(11,8);
		ht5.put(0,18);
		ht5.put(18,0);
		ht5.put(23,19);
		ht5.put(19,23);
		ht5.put(6,22);
		ht5.put(22,6);
		ht5.put(4,2);
		ht5.put(2,4);
		ht5.put(9,10);
		ht5.put(10,9);
		ht5.put(21,25);
		ht5.put(25,21);
		ht5.put(13,1);
		ht5.put(1,13);
		ht5.put(5,15);
		ht5.put(15,5);
		ht5.put(24,16);
		ht5.put(16,24);

		String bob = "<?xml version=\"1.0\"?>\n<rotors>";
		for(int f= 1;f<6;f++){
			bob = bob + "\n<rotor>";
			for(int x = 0;x<26;x++){
				int d = 0;
				switch(f){
				case 1:d = (int) ht1.get(x);
					break;
				case 2:d = (int) ht2.get(x);
					break;
				case 3:d = (int) ht3.get(x);
				break;
				case 4:d = (int) ht4.get(x);
				break;
				case 5:d = (int) ht5.get(x);
				break;
				}
				bob = bob + String.format("\n\t<pair>\n\t\t<from>%d</from>\n\t\t<to>%d</to>\n\t</pair>" ,x ,d);
			}
			bob = bob + "\n</rotor>";
			
		}
		bob = bob + "\n</rotors>";
		System.out.println(bob);
	}
	
	/*
	private static void printoutRotors() {
	// TODO Auto-generated method stub

		try {
			 
			File f = new File("rotorInnerPairs.xml");
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder = factory.newDocumentBuilder();
		    Document doc = docBuilder.parse(f);
		   
		    //get a list of the rotors
		    NodeList rotorNodes = doc.getElementsByTagName("rotor*");
		    //loop through each one
		      for (int i = 0; i < rotorNodes.getLength(); i++) {
		    	  //create an element from each node
		          Element bookElement = (Element)rotorNodes.item(i); // <book> element
		          
		          
		          //get its id
		          System.out.println("rotor " + (i+1));
		          String isbn = bookElement.getAttribute("id"); // <book> attribute
		          System.out.println("\tid:\t" + isbn);
		    
		          // make a list of its number pairs
		          NodeList pairnodes = bookElement.getElementsByTagName("pair");
		          //loop through each pair
		          for(int z = 0; z < pairnodes.getLength(); z++){
		        	  //creating an element from it
			          Element pair = (Element)pairnodes.item(z);
			          //gettting the pair values
			         String from = pair.getElementsByTagName("from").item(0).getFirstChild().getNodeValue();
			         String to = pair.getElementsByTagName("to").item(0).getFirstChild().getNodeValue();
			         //printing to screen
			         System.out.println(String.format("from %s to %s", from,to));
			        
		          }
		       }
			
		    } catch (Exception e) {
			e.printStackTrace();
		    }	
		  }
		*/
	
}
