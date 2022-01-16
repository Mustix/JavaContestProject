
//* Filename: ContestProject.java
//* Created by: Aknan Mustafa
//* Date: 11/03/2021




import java.util.Scanner;  // Import the Scanner class
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List;
import CSE234.SimplePicture;
import CSE234.Pixel;

class ContestProject {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      boolean exit = false; 
      Picture loadedPic = null;
      Picture meme = new Picture(".jpg");
      Picture pic = new Picture("myself.jpg");
      System.out.println("Enter username");
      String userName = keyboard.nextLine(); 
      System.out.println("Welcome, " + userName + ", to our great game. ");  // Output user input
      System.out.println(userName + ", please enter a help for list of commands or exit to quit" );
      while (!exit) { 
      String command = keyboard.nextLine();
      if ("exit".equals(command)) {  
         System.out.println("Are you sure you want to quit this perfectly-amazing app? Choose + or - "); 
         String commande = keyboard.nextLine();
         if ("+".equals(commande)) {
            System.out.println("Exit the program");
            meme.explore();
            exit = true;
         } else if ("-".equals(commande)){
            System.out.println("Please Wait!!!");
            for (int z = 90; z > 0; z--) { 
               System.out.println("Second left"  + z);
            }           
             System.out.println(userName + ", please enter a help for list of commands or exit to quit" );
          }      
      }  else if ("help".equals(command)) { 
            System.out.println("Avaiable Commands:");
            System.out.println("grayscale");
            System.out.println("negative");
            System.out.println("sepia");
            System.out.println("flipHorizontal");
            System.out.println("flipVertical");
            System.out.println("replaceAllColor");
            System.out.println("continue");
            System.out.println("Watch picture");
            //help uodate
      }  else if ("LoadPicture".equals(command)) {
            loadedPic = new Picture ("Anna.jpg"); 
      }  else if ("grayscale".equals(command)) {
            System.out.println("Please wait while we aplying filter 3..2..");
                        loadedPic.explore();

      } else if ("negative".equals(command)) {
            System.out.println("Please wait while we aplying filter 3..2..");
            loadedPic.negative(1,  loadedPic.getWidth() *  loadedPic.getHeight() );
            loadedPic.explore();
      } else if ("sepia".equals(command)) {
            System.out.println("Please wait while we aplying filter 3..2..");
             loadedPic.sepia(1,  loadedPic.getWidth() *  loadedPic.getHeight() );
            loadedPic.explore();
      } else if ("flipHorizontal".equals(command)) {
            System.out.println("Please wait while we aplying effect 3..2..");
            loadedPic.flipHorizontalRectangle(2, 2, 2, 2);         
            loadedPic.explore();
         
      } else if ("flipVertical".equals(command)) {
            System.out.println("Please wait while we aplying effect 3..2..");
            loadedPic.flipVerticalRectangle(2, 2, 2, 2);     
            loadedPic.explore();
        
      } else if ("replaceAllColor".equals(command)) {
            System.out.println("Please wait while we aplying effect 3..2..");
             Picture background = new Picture("circus.jpg"); 
             loadedPic = loadedPic.replaceAllColor(background, Color.GREEN, 180);
             loadedPic.explore();
      } else if ("Save".equals(command)) {
          //String Rule = keyboard.nextLine();
         // System.out.println( userName + ", please enter a help for list of commands or exit to quit or continue for the next step" ); 
          loadedPic.write("modifiedPic.jpg");
       } else if ("no".equals(command)) {
          System.out.println( userName + ", please enter a help for list of commands or exit to quit or continue for the next step" ); 
       } else if ("continue".equals(command)){
            System.out.println( userName +  " , Which method would you like to apply? or press exit.");
            System.out.println("    1) Place Picture ");
            System.out.println("    2) Collage " );
            System.out.println("    3) My Collage " );
            String method = keyboard.nextLine();
         if ("Place Picture".equals(method)){
            System.out.println("Please wait while we aplying filter 3..2..");
            Picture original = new Picture( "Contest.jpg");
            Picture newPicture = new Picture( "Contest1.jpg");
            original.placePicture(newPicture, 150, 20);
            original.explore();
            System.out.println( userName + ", please enter a help for list of commands or exit to quit or continue for the next step" );
       } else if ("Collage".equals(method)){
            System.out.println("Please wait while we aplying filter 3..2..");
            Picture original = new Picture( "Contest.jpg");
            Picture newPicture = new Picture( "Contest1.jpg");
            original.placePicture(newPicture, 150, 20);
            original.explore();
            System.out.println( userName + ", please enter a help for list of commands or exit to quit or continue for the next step" );
       } else if ("My Collage".equals(method)){
            System.out.println("Please wait while we aplying filter 3..2..");
            Picture photo = new Picture("mountain.jpg");
            Picture photo1 = new Picture("Smile.jpg");
            Picture photo2 = new Picture("Car.jpg");
            Picture photo3 = new Picture("Contest1.jpg");
            Picture[] array = {photo1, photo2, photo3};
            photo.mycollage(array);
            photo.explore();
            System.out.println( userName + ", please enter a help for list of commands or exit to quit or continue for the next step" );
         }  
       } else if ("Watch picture".equals(command)){ //This is photo explorer 
             System.out.println("Choose a picture 1, 2, 3, 4, 5, 6, 7 or exit");
             Picture photo1 = new Picture(".jpg");
             Picture photo2 = new Picture("myself.jpg");
             Picture photo3 = new Picture("mountain.jpg");
             Picture photo4 = new Picture("Smile.jpg");
             Picture photo5 = new Picture("Car.jpg");
             Picture photo6 = new Picture("Contest1.jpg");
             Picture photo7 = new Picture("Contest.jpg");
             boolean picture_exit = false;
           while (!picture_exit) {
               String commander = keyboard.nextLine();
               if ("1".equals(commander)){
                  photo1.explore();
               } else if ("2".equals(commander)){
                  photo2.explore();
               } else if ("3".equals(commander)){
                  photo3.explore();
               } else if ("4".equals(commander)){
                  photo4.explore();
               } else if ("5".equals(commander)){
                  photo5.explore();
               } else if ("6".equals(commander)){
                  photo6.explore();
               } else if ("7".equals(commander)){
                  photo7.explore();
               } else if ("exit".equals(commander)) { 
               
               picture_exit = true ; 
               } 
            }
      } else {
         System.out.println("Command " + command + " not recognized."); 
         // It is our break from incorrect commands
      }  
                 
   }
   }  
}
                