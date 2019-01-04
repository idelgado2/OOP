/*************************************************************************
 * Project_1(ElectronioStore_Project1)
 * COSC3324
 * 10/30/2016
 * Purpose: This class implements the Electronics store by the criteria 
 *          provided by BlackBoard project1. This Class creates an online 
 *          store that can registers memebers as a geek, standard memeber,
 *          or as an admin user. A all memebers inherit from another class
 *          called basic user. All memebers' usernames are their usernames
 *          Geek memeber has an attribute of geek points that are determined
 *          by the purchases made. The admin user's only
 *          functionality is to see a specific user's (by usename(email)) 
 *          history
 * 
 * Attributes: This class uses a textfile as a database. The textfile is 
 *              is called "input.txt". The entire file's data is then  
 *              traversed distributed through specific arrays.
 *          
 **************************************************************************/

package electronicstore_project1;


import static com.sun.org.apache.bcel.internal.Repository.instanceOf;
import java.io.*;
import java.util.Scanner;

public class ElectronicStore_Project1 {
    
    public static void main(String[] args) throws IOException{
        
        BasicUser [] Users = new BasicUser[20]; //array of BasicUsers for Polymorphic manipulation
        int userIndex = 0; //to keep track of the # of users in the Users array
        
        /////////////data structures to hold database information//////////////
        String[]itemList = new String [50];                                                                      
        Double[] priceList = new Double[50];
        int[] stockList = new int[50];
        String[] categories ={"TV", "Cell Phones", "Wearables", 
                              "PC & Accessories", "Video Game Consoles",
                              "Cameras", "Speakers", "Car Electronics",
                              "Musical Instruments", "Office Electronics"};
        ///////////////////////////////////////////////////////////////////////
        
        
        ////User Information////////////////////////////////////
        String fname = "", mname = "", lname = "", email = "";
        long creditAccount = 0;                               
        ////////////////////////////////////////////////////////
        
        
        Scanner reader = new Scanner(System.in);
        Scanner loginReader = new Scanner(System.in);
        boolean loggedIn = false, repeatMain = false;
        int currentUser = 0;
        
        System.out.println("*** Welcome to the Electronics Store ***\n\n");
        System.out.println("(Please choose by precceding number)");
        
     do{ //do while to repeat if user logsout
            loggedIn = false; //to fully logout
        
        do{  //to repeat if unsuccessful login or created account
            
            System.out.println("\n1. Login\n" + "2. Create an Account\n" + "3. Exit");
            switch(reader.nextInt()){
                    case 1:     //login
                        System.out.println("Please enter your email address");
                        String loginEmail = loginReader.nextLine();
                        
                        for (int i = 0; i < userIndex; i++){
                            if (Users[i].getEmail().equals(loginEmail)){ //if the email of the i-th user on the list matches the user input
                                currentUser = i;
                                System.out.println("Successfully logged in");
                                loggedIn = true; 
                            }
                        } 
                    
                        if(!loggedIn){
                            System.out.println("\n*** Login NOT successful ***");
                        }
                        break;
                    case 2:
                        System.out.println("\n*** Would You like create a Geek or Standard Account ***");
                        System.out.println("1. Geek Account\n" + "2. Standard Account\n" 
                                                + "3. Admin User\n");
                        int choice = reader.nextInt();

                        Scanner input = new Scanner(System.in); //new scanner to avoid scanner issues
                        System.out.println("(Please input your information)");
                        System.out.print("---First Name: ");
                        fname = input.nextLine();
                     
                        System.out.print("---Middle Name: ");
                        mname = input.nextLine();
                     
                        System.out.print("---Last Name: ");
                        lname = input.nextLine();
                        
                        System.out.print("---Email: ");
                        email = input.nextLine();
                        
                        System.out.println("\n** (NOTE) Geek Membership requires Monthly payment of 5.99 **");
                        System.out.print("---Credit Account #: ");
                        creditAccount = input.nextInt();
                        
                        switch (choice) {
                                case 1: //create geekUser
                                    Users[userIndex] = new GeekUser(fname, mname, lname, email, creditAccount);
                                    userIndex++;
                                    break;
                                case 2: //Standard User
                                    Users[userIndex] = new StandardUser(fname, mname, lname, email, creditAccount);//UserList.add(newStandardUser);                        
                                    userIndex++;    //increment amount of Users
                                    break;
                                case 3:     //admin user
                                    Users[userIndex] = new AdminUser(fname, mname, lname, email);//UserList.add(newStandardUser);                        
                                    userIndex++;    //increment amount of Users
                                    break;
                                default:
                                    System.out.println("error");
                                    break;
                            }
                        System.out.println("\n*** Thank you for creating an Account ***");
                        break;
                    case 3:     //terminate program
                        System.out.println("*** Goodbye ***\n");
                        System.exit(0); //terminate program
                    default:
                        System.out.println("*** Inccorect input ***\n");
                        break;   ///terminate program   
            }
        }while(!loggedIn);
        
        //////////////////////////////////////////////////////////////////////
        readDataBase(itemList, priceList, stockList); //extract database info setup parallel arrays
        //////////////////////////////////////////////////////////////////////
        
        int choice, categoryChoice;
        boolean repeatMenu = true;
        
        do{
            
        System.out.println("*** Menu ***\n");
        System.out.println("1. View Cataloge\n" + "2. View your Purchases\n" 
                + "3. System Hisory\n" + "4. Logout\n" +"5. Exit");
        switch(reader.nextInt()){
        	case 1:     //view cataloge
                    boolean repeat = false, exit = false; //booleans to stay in loops
                    do{
                        
                        System.out.println("Choose from the following Categories");
                        System.out.println("*** Categories ***");
                        printStringArray(categories, 0, categories.length);
                        categoryChoice = reader.nextInt();      //hold category of choice
                        
                        System.out.println("Choose which items you would like to purchase");
                        System.out.println("\n*** " + categories[categoryChoice - 1] + " ***");
                        
                        printStringArrayWithPrices(itemList, priceList, stockList, ((categoryChoice - 1) * 5), (categoryChoice * 5));
                        System.out.println("11. Categories\n12. Back to Menu\n13. Exit");
                    
                        do{                         
                            choice = reader.nextInt();
                            if(choice == 11){
                                repeat = true;         //get out of loop to repeat outter loop
                            }else if(choice == 12){     //get out of all loops except menu loop
                                repeat = true;         //get out of inner most loop
                                exit = true;           //to get out of category loop
                            }else if(choice == 13){
                                System.exit(0); //exit program
                            }else{
                                //user purchase here
                                int itemPosition = (((categoryChoice - 1) * 5) + (choice - 1));  //to get appropriate item
                                
                                if(stockList[itemPosition] > 0){    //check if item has availiable stock
                                    Users[currentUser].purchase(itemList[itemPosition], priceList[itemPosition]);
                                    stockList[itemPosition]--; //decrement stock for the purchased item
                                    System.out.println("\n*** item was added to purchases ***\n");
                                }else{
                                    System.out.println("\n*** APOLOGIES this item is UNAVAILABLE at the moment ***\n");
                                }
                                
                                System.out.println("(choose another item, go back to categories, or exit)");
                                
                                System.out.println("\n*** " + categories[categoryChoice - 1] + " ***");
                                printStringArrayWithPrices(itemList, priceList, stockList, ((categoryChoice - 1) * 5), (categoryChoice * 5));
                                System.out.println("11. Categories\n12. Back to Menu\n13. Exit");
                            }                       
                        
                        }while(!repeat); //while repeat is false
                        
                        if(exit){
                            repeat = false; //switch back to false to get out of category loop
                        }
                        
                    }while(repeat);
                    break;
        	case 2:     //view purchases
                    System.out.println("*** Your current Purchases ***");
                    Users[currentUser].printPurchases();
                    break;
                case 3: //system history
                    Scanner historyScanner = new Scanner(System.in);  //New Scanner to avoid Scanner issues
                    
                    if(Users[currentUser] instanceof AdminUser){ //only Admin users can access history
                        System.out.println("*** Please input desired UserName(email) ***\n");
                        System.out.print("UserName(email): ");
                        String userHistory = historyScanner.nextLine();
                        
                        for(int i = 0; i < userIndex; i++){     //loop to find matching username
                            if(Users[i].getEmail().equals(userHistory)){
                                System.out.println("Username (email): " + Users[i].getEmail());
                                System.out.println("Full Name (Last, First): " + Users[i].getLastName() 
                                                        + ", "+ Users[i].getFirstName());
                                System.out.print("Purchases:\n");
                                Users[i].printPurchases();
                                System.out.println("*********************");
                                break;
                            }
                        }
                        
                    }else{
                        System.out.println("*** this is only allowed for Admin Users ***");  
                    }
                    break;
                case 4: //logout
                    repeatMain = true; //to logout
                    repeatMenu = false; //get out of menue loop
                    break;
                case 5: //terminate program
                    System.out.println("*** Goodbye ***\n");
                    repeatMenu = false;
                    System.exit(0);
        	default:
                    System.out.println("*** Inccorect input ***\n");
                    System.exit(1);   ///terminate program
            }//end of switch
        
        }while(repeatMenu);
        
     }while(repeatMain);//do while to repeat if user logsout
    }
    
    public static void printStringArray(String[] array,int begin, int end){
        int count = 1;
        for(int i = begin; i < end; i++){
            System.out.print(count + ". ");
            System.out.println(array[i]);
            count++;
        }
    }
    public static void printStringArrayWithPrices(String[] item, Double [] price,int [] stock, int begin, int end){
        int count = 1;
        for(int i = begin; i < end; i++){
            System.out.print(count + ". ");
            System.out.println(item[i] + " =========> $" + price[i] + " =========> stock(" + stock[i] + ")" );
            count++;
        }
    }
    public static void readDataBase(String[] itemList, Double[] priceList, int[] stockList)throws IOException{
        
        Double priceConvert;
        int stockConvert; 

        
        File file = new File("input.txt");
        try {
      			
      			FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				StringBuffer stringBuffer = new StringBuffer();
				String line, price, stock;
				
				int i = 0, j = 0, k = 0;
			
				while ((line = bufferedReader.readLine()) != null) {
					stringBuffer.append(line);
					stringBuffer.append("\n");
					
					if(line.substring(0,1).equals("@")){
      					itemList[i] = line.substring(1,line.length());
      					//System.out.println(itemList[i]);
      					i++;
      				}
      				if(line.substring(0,1).equals("$")){
      					price = line.substring(1,line.length());
      					priceConvert = Double.parseDouble(price);
      					priceList[j] = priceConvert;
      					//System.out.println(priceList[j]);
      					j++;
      				}
      				if(line.substring(0,1).equals("#")){
      					stock = line.substring(1,line.length());
      					stockConvert = Integer.parseInt(stock);
      					stockList[k] = stockConvert;
      					//System.out.println(stockList[k]);
      					k++;
      				}
      				
				}

				
				
      			fileReader.close();
      			
      		}
      		//fileReader.close();//scanner.close();
      		catch(FileNotFoundException e){
      			e.printStackTrace();
      		}
    }
}