package eXample;

import java.util.*;


public class Lotto {
	
	static ArrayList<String> contestant =new ArrayList<String>(50);
	static double[] winning_amount = {0.75, 0.15, 0.1};
	static ArrayList<Double> winnersprice = new ArrayList<Double>();
	static int lot = 50;
	static int win,j, amount=0;
	

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        
        startUp();
        
        
    }
    
    public static void startUp(){
        System.out.println("\n####################################\n||||||||||||||||||||||||||||||||||||\n||||| WELCOME TO LOTTO QUEBEC ||||||\n||||||||||||||||||||||||||||||||||||\n####################################\n");
        
        System.out.println("~> Press 1 for Lottery Purchase.\n~> Press 2 for a Lucky Draw. \n~> Press 3 to see the Winning price.\n~> Press 4 to see the list of contestants.");
        Scanner input = new Scanner(System.in);
        String selection = input.nextLine();
        
        switch (selection){
        
        case "1":
            purchase();
            break;
        case "2":
        	
            draw();
            break;
        case "3":
            winningAmount();
            break;
        case "4":
        	buyerslist();
        	break;
            
            default: startUp();
        }
        
    }
    public static void purchase(){
                              
        System.out.println("\n \n \n--------------------------------------\n## You are in purchasing department ##\n--------------------------------------\n");
        System.out.println(">>Please enter the number of lotteries you want to buy.\n>>Remeber taht ! YOU CAN NOT BUY more than 50 LOTTORIES");
        Scanner quantity = new Scanner (System.in);
        int lotto_number = quantity.nextInt();
        
        if (lotto_number<=lot && contestant.size()<50){   
        
        
        for (int i=1; i<=lotto_number; i++){
        	
//        	int ticket_no = 1+ ticket;        
            System.out.println("\n ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\nPlease enter the name of " + i +" person");
            Scanner name = new Scanner(System.in);
            String input_name = name.nextLine();
            contestant.add(input_name);
            
            System.out.println(input_name + " bought a Lottery no (' " + contestant.size() + " ')\n^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
           
        }
        }
        
        else {
        	
        	System.out.println("\n\n :::You can not buy more!!!! ::: \n");
        	
        }
        
//        System.out.println(contestant.get(3) + "  " + contestant.get(0));
        startUp();
        
    }
    
    
    public static void draw(){
    	
    	
        System.out.println("\n:::::::::::::::::::::::::::::::::::::::::::::::\n::Hold your breath! This game will start soon::\n:::::::::::::::::::::::::::::::::::::::::::::::\n");
        System.out.println("Press Enter to play \n \n \n \n \n \n \n \n");
        Scanner play = new Scanner(System.in);
        String yes = play.nextLine();
        
        if(contestant.size()<3){
        	
        	System.out.println("Winner will be announced when more than 3 tickets are sold. \n");
        }
        else {
	        for(j=1; j<=3; j++){
	        Random winner_no = new Random();
	        int final_no = winner_no.nextInt((contestant.size()-1) +1)+1;
	        win = final_no;
	        
	        winners();
		      	}
        }
		    	amount =0;
        		contestant.clear();
		        startUp();
    }
    
    public static void winners(){
    	
    		if (win == 0){
//    			System.out.println("when 0" + win + j);
    			winningAmount();
    			System.out.println(j + " winner is '" + contestant.get(win)+ "' He won " + winnersprice.get(j-1)+ "$");
    			
    			contestant.remove(win);
    			

    		}
    		else {
//    			System.out.println("not 0" + win + j);
    			System.out.println(j + " winner is '" + contestant.get(win-1)+ "' He won (" + winnersprice.get(j-1)+ "$)");
    			
    			contestant.remove(win-1);
    			
    		}
    	
    
    		
    	}
    
    public static void winningAmount(){
    	
    	System.out.println("No. of lotteries sold = " + amount + "\n");
    	int result = (10*contestant.size())/2;
    	
    	for(int a=0; a<3; a++) {
    	double winning_price= winning_amount[a]*result; 
    	winnersprice.add(a,winning_price);
   
    	System.out.println(a+1 +" winner will get " + winnersprice.get(a) + "$");
    	}
    			
    	
    	startUp();
    }
    
    public static void buyerslist(){
    	if(contestant.size()!=0){
    	for(int i= 0; i<contestant.size(); i++ ){
    		System.out.println(contestant.get(i) + " has lottery number = " + i);
    		}
    	}
    	else{
    		
    System.out.println("No lottery has been sold");
    	}
    	startUp();
    }
}
  