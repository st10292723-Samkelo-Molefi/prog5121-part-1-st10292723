package prog5121.registrationloginsystem;


import java.util.Scanner;

//CODE ATTRIBUTION
//This code was adapted from the source below

//Author: OpenAI
//Date: 2024
//Title: ChatGPT-4 (Apr 9 version) [Large Language Model].
//Source: https://openai.com/


public class RegistrationLoginSystem {
    static String registerUsername;
    static String registerPassword;
    static String registerCellPhoneNumber;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
    // Registration for Account
            
            System.out.println("Registration page");
            
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();
            
            System.out.print("Enter your cellphone number: ");
            String cellphoneNumber = scanner.nextLine();
            
            if (checkUserName(username) && checkPasswordComplexity(password) && checkCellPhoneNumber(cellphoneNumber)) {
                registerUsername = username;
                registerPassword = password;
                registerCellPhoneNumber = cellphoneNumber;
                
                System.out.println(registerUser(true));
            } else {
                System.out.println(registerUser(false));
                return;
            }
            
    // Login to account
            
            System.out.println(" Login ");
            System.out.print("Enter your username: ");
            String loginUsername = scanner.nextLine();
            
            System.out.print("Enter your password: ");
            String loginPassword = scanner.nextLine();
            
            if (loginUsername (loginUsername, loginPassword)) {
                System.out.println(returnLoginStatus(true));
            } else {
                System.out.println(returnLoginStatus(false));
            }
        }
    }

        //CODE ATTRIBUTION
    //This code was adapted from the source below
    
    //Author: Yoel Nunez
    //Author Profile: https://stackoverflow.com/users/4114033/yoel-nunez
    //Date: Oct 7, 2014
    //Title: java-public-static-boolean-method
    //Source: https://stackoverflow.com/questions/26240250/java-public-static-boolean-method
    

    //Validation methods for the RegistrationLoginSystem
    
       public static boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }
    
       public static boolean checkPasswordComplexity(String password) {
        return password.length() >= 8 && //Eight characters long
               password.matches(".*[A-Z].*") && //Capital letters
               password.matches(".*[a-z].*") && 
               password.matches(".*[\\d].*") && //Number
               password.matches(".*[!@#$%^&*_+-?/;'].*"); //Special characters
    }
    
    public static boolean checkCellPhoneNumber(String CellphoneNumber) {
        return CellphoneNumber.matches("^\\+\\d+$") && CellphoneNumber.length() <= 10;
    }
    
    public static String registerUser(boolean success) {
        if (success) {
            return "Successfully captured Username\nSuccessfully captured Password\nSuccessfully added Cellphone Number!";
        } else {
            return "Registration was unsuccessful. Please confirm that all requirement have been fullfilled.";
        }
    }
    
    public static boolean loginUsername(String username, String password) {
        return username.equals(registerUsername) && password.equals(registerPassword);
    }
    
    public static String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome back" + registerUsername + ", it’s wonderful to see you again!";
        } else {
            return "Incorrect username or password , please try again.";
        }
    }
}


