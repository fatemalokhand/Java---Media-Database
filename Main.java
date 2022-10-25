// Importing the java util package 
import java.util.*;

// Importing I/O
import java.io.*;

// Importing time package for date functionality
import java.time.*;

class Main {
  public static void main(String[] args) throws IOException, FileNotFoundException
  {
    // Instantiating an object of class LaunchPage
    LaunchPage lp = new LaunchPage();

    // Declaring a variable to store the user's choice from the menu
    int choice = 0;

    // Declaring some variables to error catch the user's inputs
    boolean errorCatchChoice = false;
    boolean errorCatchChoice1 = false;

    // Declaring a variable to store the value of the Scanner
    Scanner input = new Scanner(System.in);

    // Outputting a blank line
    System.out.println();

    // Do while loop to error catch if the user has entered their choice as an integer between 1-10
    do
    {
      // Do while loop to error catch if the user has entered their choice as an integer
      do
      {
        // Try/catch block to error catch if the user has entered their choice as an integer
        try
        {
          // Getting the user's input for the choice 
          choice = input.nextInt();

          // Setting the variable's value to false
          errorCatchChoice = false;

          // Breaking out of the loop
          break;
        }
        catch(Exception e)
        {
          // Outputting a blank line
          System.out.println();

          // Outputting an error message to the user
          System.out.println("Error! Please enter an integer.");

          // Setting the variable's value to true
          errorCatchChoice = true;

          //
          input.next();
        }
      }
      while(errorCatchChoice);

      // Switch/case to error catch if the user has entered their choice as a number between 1-10
      switch(choice)
      {
        // Checking if the user's choice is equal to 1
        case 1: getMedia(choice, input, "List of Media.txt");
                errorCatchChoice1 = true;
        break;
        // Checking if the user's choice is equal to 2
        case 2: getMedia(choice, input, "List of Upcoming Media.txt");
                errorCatchChoice1 = true;
        break;
        // Checking if the user's choice is equal to 3
        case 3: getGenreRecommendation();
                errorCatchChoice1 = true;
        break;
        // Checking if the user's choice is equal to 4
        case 4: getRandomRecommendation();
                errorCatchChoice1 = true;
        break;
        // Checking if the user's choice is equal to 5 
        case 5: getOpinion(choice, input, "Opinions of Media.text");
                errorCatchChoice1 = true;
        break;
        // Checking if the user's choice is equal to 6 
        //case 6: getRanking();
        //break;
        // Checking if the user's choice is equal to 7
        case 7: upcomingMediaReminder();
                errorCatchChoice1 = true;
        break;
        // Checking if the user's choice is equal to 8
        case 8: getMediaDatabase();
                errorCatchChoice1 = true;
        break;
        // Checking if the user's choice is equal to 9
        case 9: getUpcomingMediaDatabase();
                errorCatchChoice1 = true;
        break;
        // Checking if the user has entered an invalid choice
        default: System.out.println();
                 System.out.println("Error! Please enter an integer between 1-9.");
                 errorCatchChoice1 = true;
      }
        
      // Outputting a blank line
      System.out.println();

      // Prompting the user to enter their choice 
      System.out.println("Please enter your next choice from the menu displayed above (Please enter an integer between 1-9):");
    }
    while(errorCatchChoice1);
  }

  // Method for choices 1 + 2
  public static void getMedia(int theChoice, Scanner userInput, String fileName) throws IOException, FileNotFoundException
  {
    // Declaring a variable to store the title of the media
    String mediaTitle = ""; 

    // Declaring a variable to store the genre of the media
    String mediaGenre = "";

    // Declaring a variable to store the media
    String objectContent = "";

    // Declaring a variable to store the release date of the media
    String releaseDate = "";

    //
    boolean redo = true;

    // Placeholder date until we get user's input
    LocalDate userInputDate = LocalDate.now(); 

    // Declaring a variable to store the number of lines in a file
    int lenOfFile = 0;

    // Stores whether file exists
    boolean exist = true;

    // Makes Scanner.next() only go to the 'next' after a new line
    userInput.useDelimiter("\n"); 

    // Outputting a blank line
    System.out.println();

    // Prompting the user to enter the title of the media
    System.out.println("Please enter the title of the media:");

    // Getting the user's input for the title of the media
    mediaTitle = userInput.next();

    // For loop to loop through all the characters in the media title string
    for(int i=0; i<mediaTitle.length(); i++)
    {
      // Condition to check if the character at the nth index is a '%'
      if(mediaTitle.charAt(i) == '%')
      {
        // Outputting a blank line
        System.out.println();

        // Outputting an error message to the user
        System.out.println("Error! The title of the media cannot contain a \'%'");

        // Returning back to the method call
        return; 
      }
    }

    // Checking if the file already exists
    try
    {
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);

      while (br.readLine() != null)
      {
        lenOfFile++;
      }
    }
    catch(Exception e)
    {
      exist = false;
    }  

    if(exist)
    {
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      Scanner read = new Scanner(fr);

      if(theChoice == 1)
      {
        // Creating an array to store all the media already in the database
        Media arrOfMedia[] = new Media[lenOfFile];
        for (int i = 0; i < lenOfFile; i++)
        {
          arrOfMedia[i] = new Media();
        }

        // Looping through line in file, storing info as elements in array
        for (int i = 0; i < lenOfFile; i++)
        {
          String text = read.nextLine();

          String elements[] = text.split("%");

          arrOfMedia[i].setTitle(elements[0]);
          arrOfMedia[i].setGenre(elements[1]);
          arrOfMedia[i].setReview(elements[2]);
          arrOfMedia[i].setRating(Double.parseDouble(elements[3]));
        }

        // Ensuring that user doesn't enter a piece of media twice
        for(int i = 0; i < lenOfFile; i++)
        {
          String title = arrOfMedia[i].getTitle().toLowerCase();
          if(title.equals(mediaTitle.toLowerCase()))
          {
            // Outputting a blank line
            System.out.println(); 

            System.out.println("You have already entered " + title + " in your database.");

            // Returning back to the method call
            return;
          }
        }
      }
      else // The choice would be 2
      {
        // Creating an array to store all the media in this database
        UpcomingMedia arrOfUMedia[] = new UpcomingMedia[lenOfFile];
        for (int i = 0; i < lenOfFile; i++)
        {
          arrOfUMedia[i] = new UpcomingMedia();
        }

        // Looping through all the lines in the file, storing the media as elements in the array
        for (int i = 0; i < lenOfFile; i++)
        {
          String text = read.nextLine();

          String elements[] = text.split("%");

          arrOfUMedia[i].setTitle(elements[0]);
          arrOfUMedia[i].setGenre(elements[1]);
          arrOfUMedia[i].setDate(elements[2]);
          arrOfUMedia[i].setReview(elements[3]);
          arrOfUMedia[i].setRating(Double.parseDouble(elements[4]));
        }
        
        // Ensuring they don't enter a piece of media that they've already entered
        for(int i = 0; i < lenOfFile; i++)
        {
          String title = arrOfUMedia[i].getTitle().toLowerCase();
          if(title.equals(mediaTitle.toLowerCase()))
          {
            System.out.println("You have already entered " + title + " in your database.");

            // Returning back to the method call
            return;
          }
        }
      }
    }

    // Outputting a blank line
    System.out.println();

    // Prompting the user to enter the genre of the media
    System.out.println("Please enter the genre of the media:");

    // Getting the user's input for the genre of the media
    mediaGenre = userInput.next();

    // For loop to loop through all the characters in the media genre string
    for(int i=0; i<mediaGenre.length(); i++)
    {
      // Condition to check if the character at the nth index is a '%'
      if(mediaGenre.charAt(i) == '%')
      {
        // Outputting a blank line
        System.out.println();

        // Outputting an error message to the user
        System.out.println("Error! The genre of the media cannot contain a \'%'");

        // Returning back to the method call
        return; 
      }
    }

    // Condition to check if the user chose released media
    if(theChoice == 1)
    {
      // Instantiating an object of class Media and sending in parameters
      Media media1 = new Media(mediaTitle, mediaGenre, "", 0);

      // Populating the objectContent variable
      objectContent = media1.getTitle() + "%" + media1.getGenre() + "%" + media1.getReview() + "%" + media1.getRating();
      
      // Creating a file called List of Media.txt
      FileWriter fw = new FileWriter("List of Media.txt", true);

      // Attaching a buffer to the file 
      BufferedWriter bw = new BufferedWriter(fw);

      // Using the buffer to write to the file 
      bw.write(objectContent);
      bw.newLine();

      // Sending everything from the writer to the file and removing everything from the writer
      bw.flush();

      // Closing the BufferedWriter
      bw.close();

      // Closing the FileWriter
      fw.close();
    }
    // If the choice isn't 1 then it would have to be 2
    else 
    {
      do
      {
        try
        {
          // Outputting a blank line
          System.out.println();

          // Prompting the user to enter the release date of the media
          System.out.println("Please enter the release date of the media. (Make sure it is in the form \"yyyy-mm-dd\"):");
          releaseDate = userInput.next();
          userInputDate = LocalDate.parse(releaseDate);

          // Ensuring user enters a date in the future
          if (userInputDate.isBefore(LocalDate.now()))
          {
            // Outputting a blank line
            System.out.println();

            System.out.println("You must enter a date that is after today. ");
            redo = true;
          }
          else
          { 
            redo = false;
          }
          
        }
        catch(Exception e)
        {
          // Outputting a blank line
          System.out.println();

          // Error catching formatting of the date entered
          System.out.println("That is not a valid date. It must be in format yyyy-MM-dd. For example, \"2021-03-07\".");
          redo = true;
        }
      }while(redo);

      // Creating object with attributes provided by user
      UpcomingMedia newMedia = new UpcomingMedia(userInputDate);
      newMedia.setTitle(mediaTitle);
      newMedia.setGenre(mediaGenre);
      
      // Writing upcoming media to new file
      FileWriter fw = new FileWriter("List of Upcoming Media.txt", true);

      // Attaching a buffer to the file 
      BufferedWriter bw = new BufferedWriter(fw);

      // Populating the objectContent variable
      objectContent = newMedia.getTitle() + "%" + newMedia.getGenre() + "%" + newMedia.getDate() + "%" + newMedia.getReview() + "%" + newMedia.getRating();
      
      // Using the buffer to write to the file 
      bw.write(objectContent);
      bw.newLine();

      // Sending everything from the writer to the file and removing everything from the writer
      bw.flush();

      // Closing the BufferedWriter
      bw.close();

      // Closing the FileWriter
      fw.close();
    }
  }

  // Method for choice 3
  public static void getGenreRecommendation() throws FileNotFoundException, IOException
  {
    Scanner userInput = new Scanner(System.in);
    int lenOfFile = 0; //used to keep track of number of lines in file
    String genreChoice = ""; //used to store the genre the user chooses

    // Checking if database (file) exists
    try
    {
      FileReader fr = new FileReader("List of Media.txt");
      BufferedReader br = new BufferedReader(fr);

      while (br.readLine() != null)
      {
        lenOfFile++;
      }
    }
    catch(Exception e)
    {
      // Outputting a blank line
      System.out.println();

      // Outputting an error message to the user
      System.out.println("Error! Your database is empty. ");

      // Returning back to the method call
      return;
    }  

    FileReader fr = new FileReader("List of Media.txt");
    BufferedReader br = new BufferedReader(fr);
    Scanner read = new Scanner(fr);
    
    ArrayList <Integer> indexesOfGenre = new ArrayList<Integer>(); // will be used to store the indexes where a media with desired genre exists
    
    // Outputting a blank line
    System.out.println(); 

    // Prompting the user to enter the genre for which they want a recommendation
    System.out.println("What genre do you want recommendations for?");

    // Getting the user's input for the genre
    genreChoice = userInput.nextLine();
    
    // Making array of media objects and storing each piece of information from the file as objects in the array
    Media arrOfMedia[] = new Media[lenOfFile];
    for (int i = 0; i < lenOfFile; i++)
    {
      arrOfMedia[i] = new Media();
    }
    for (int i = 0; i < lenOfFile; i++)
    {
      String text = read.nextLine();

      String elements[] = text.split("%");

      arrOfMedia[i].setTitle(elements[0]);
      arrOfMedia[i].setGenre(elements[1]);
      arrOfMedia[i].setReview(elements[2]);
      arrOfMedia[i].setRating(Double.parseDouble(elements[3]));
    }
    
    // Finding the indexes where the desired genre is
    for (int i = 0; i < arrOfMedia.length; i++)
    {
      String genreToCheck = arrOfMedia[i].getGenre();

      if (genreToCheck.toLowerCase().equals(genreChoice.toLowerCase()) || genreToCheck.toLowerCase().contains(genreChoice.toLowerCase()) || genreChoice.toLowerCase().contains(genreToCheck.toLowerCase()))
      {
        indexesOfGenre.add(i); // storing indexes of indexes where desired genre exists
      }
    }

    // Outputting one random recommendation from that genre
    if (indexesOfGenre.isEmpty())
    {
      // Outputting a blank line
      System.out.println();

      System.out.println("You don't have any media of that genre in your database. ");
    }
    else
    {
      Random rand = new Random();
      int randInt = rand.nextInt(indexesOfGenre.size()); // getting a random number within the range of the amount of media of that genre that exist
      
      int recIndex = indexesOfGenre.get(randInt); // getting the corresponding index for the randomly generated piece of media in the database
      String rec = arrOfMedia[recIndex].getTitle();

      // Outputting a blank line
      System.out.println();
      
      // Outputting a design to make the output look neat and pretty
      System.out.println("****************************************************************");

      // Printing out recommendation
      System.out.println("Your recommendation for the genre " + genreChoice + " is " + rec + ". ");

      // Outputting a design to make the output look neat and pretty
      System.out.println("****************************************************************");
      
    }
  }

  // Method for choice 4
  public static void getRandomRecommendation() throws FileNotFoundException, IOException
  {
    // Declaring a variable to store the number of lines in a file
    int noOfLines = 0;

    // Declaring a variable to store the random number being generated 
    int randomNum = 0;

    // Declaring a variable to hold the line of the file
    String line = "";

    // Try/catch block to check if the file called "List of Media.txt" exists or not
    try
    {
      // Connecting to the file
      FileReader fr = new FileReader("List of Media.txt");

      // Attaching a buffer to the file
      BufferedReader br = new BufferedReader(fr);

      // Looping through the no of lines in the file and updating the variable
      while(br.readLine() != null)
      {
        noOfLines++;
      }

      // Closing the BufferedReader
      br.close();

      // Closing the FileReader
      fr.close();
    }
    catch(Exception ex)
    {
      // Outputting an error message to the user
      System.out.println("Error! Your database is empty!");

      // Returning back to the method call
      return;
    }

    // Connecting to the file
    FileReader fr = new FileReader("List of Media.txt");

    // Attaching a buffer to the file
    BufferedReader br = new BufferedReader(fr);

    // Generating a random number
    Random random = new Random();
    randomNum = random.nextInt(noOfLines) + 1;

    // For loop to loop through the lines in the file until the specific line has been found
    for(int i=1; i<randomNum; i++)
    {
      br.readLine();
    }

    // Storing the line in the variable
    line = br.readLine();

    // Splitting the line using the delimiter and storing its components in an array
    String[] substring = line.split("%");

    // Outputting a blank line
    System.out.println(); 

    // Outputting a design to make the output look neat and pretty
    System.out.println("****************************************************************");

    // Outputting the random recommendation to the user
    System.out.println("We recommend you watch \'" + substring[0] + "\'.");

    // Outputting a design to make the output look neat and pretty
    System.out.println("****************************************************************");

    // Closing the BufferedReader
    br.close();

    // Closing the FileReader
    fr.close();
  }

  // Method for choice 5
  public static void getOpinion(int theChoice, Scanner userInput, String fileName) throws IOException, FileNotFoundException
  {
    // Declaring a variable to store the title of the media
    String mediaTitle= "";

    // Declaring a variable to store the review of the media
    String Review = "";

    int Rating = 0;

    // Declaring a variable to store the number of lines in a file
    int lenOfFile = 0;

    // Stores whether file exists
    boolean exist = true;

    // Makes Scanner.next() only go to the 'next' after a \n
    userInput.useDelimiter("\n"); 

    // Outputting a blank line
    System.out.println();

    // Prompting the user to enter the title of the media
    System.out.println("Please enter the title of the media that you would like to write a opinion for:");

    // Getting the user's input for the title of the media
    mediaTitle = userInput.next();

    // For loop to loop through all the characters in the media title string
    for(int i=0; i<mediaTitle.length(); i++)
    {
      // Condition to check if the character at the nth index is a '%'
      if(mediaTitle.charAt(i) == '%')
      {
        // Outputting a blank line
        System.out.println();

        // Outputting an error message to the user
        System.out.println("Error! The title of the media cannot contain a \'%'");

        // Returning back to the method call
        return; 
      }
    }

    // Checking if file already exists
    try
    {
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);

      while (br.readLine() != null)
      {
        lenOfFile++;
      }
    }
    catch(Exception e)
    {
      exist = false;
    }  

    if(exist)
    {
      FileReader fr = new FileReader(fileName);
      BufferedReader br = new BufferedReader(fr);
      Scanner read = new Scanner(fr);

      if(theChoice == 1)
      {
        // Creating an array to store all the media already in the database
        Media arrOfMedia[] = new Media[lenOfFile];
        for (int i = 0; i < lenOfFile; i++)
        {
          arrOfMedia[i] = new Media();
        }

        // Looping through line in file, storing info as elements in array
        for (int i = 0; i < lenOfFile; i++)
        {
          String text = read.nextLine();

          String elements[] = text.split("%");

          arrOfMedia[i].setTitle(elements[0]);
          arrOfMedia[i].setGenre(elements[1]);
          arrOfMedia[i].setReview(elements[2]);
          arrOfMedia[i].setRating(Double.parseDouble(elements[3]));
        }

        // Ensuring that user doesn't enter a piece of media twice
        for(int i = 0; i < lenOfFile; i++)
        {
          String title = arrOfMedia[i].getTitle().toLowerCase();
          if(title.equals(mediaTitle.toLowerCase()))
          {
            System.out.println("You have already entered " + title + " in your database.");

            // Returning back to the method call
            return;
          }
        }
      }
    }
    
    
    
  }

  // Method for choice 6


  // Method for choice 7
  public static void upcomingMediaReminder() throws FileNotFoundException, IOException
  {
    int lenOfFile = 0;
    LocalDate today = LocalDate.now();
    int numWeeks = 0;
    Scanner keyboard = new Scanner(System.in);
    boolean redo = true;

    // Catching if there are no values in database
    try
    {
      FileReader fr = new FileReader("List of Upcoming Media.txt");
      BufferedReader br = new BufferedReader(fr);

      while (br.readLine() != null)
      {
        lenOfFile++;
      }
    }
    catch(Exception e)
    {
      // Outputting a blank line
      System.out.println();

      System.out.println("You do not have any upcoming releases in your database.");

      // Returning back to the method call
      return;
    }
    
    // Outputting a blank line
    System.out.println();

    // Prompting user for date range for recommendation
    System.out.println("How many weeks ahead would you like to check? (enter an integer, eg: if you enter 2, the output would be media coming out within the next 2 weeks). ");
    do
    {
      // Ensuring the user's input is valid
      try
      {
        numWeeks = keyboard.nextInt();
        if (numWeeks < 0)
        {
          // Outputting a blank line
          System.out.println();

          System.out.println("You must enter a positive integer. ");
          redo = true;
        }
        else
        {
          redo = false;
          break;
        }
      }
      catch(Exception e)
      {
        // Outputting a blank line
        System.out.println();

        System.out.println("That is not a valid input, please enter an integer.");
        redo = true;
        keyboard.next();
      }
    } while(redo);
    
    FileReader fr = new FileReader("List of Upcoming Media.txt");
    BufferedReader br = new BufferedReader(fr);
    Scanner read = new Scanner(fr);

    //making arraylists to store indexes where desired dates occur in array of upcoming media
    ArrayList <Integer> indexesOfDates = new ArrayList <Integer>();
    ArrayList <Integer> indexesOfPastDates = new ArrayList <Integer>();

    UpcomingMedia[] arrOfUMedia = new UpcomingMedia[lenOfFile];

    for (int i = 0; i < lenOfFile; i++)
    {
      arrOfUMedia[i] = new UpcomingMedia();
    }

    // Reading file to array of objects, spliting at previously defined delimiter (%)
    for (int i = 0; i < lenOfFile; i++)
    {
      String text = read.nextLine();

      String elements[] = text.split("%");

      arrOfUMedia[i].setTitle(elements[0]);
      arrOfUMedia[i].setGenre(elements[1]);
      arrOfUMedia[i].setDate(elements[2]);
      arrOfUMedia[i].setReview(elements[3]);
      arrOfUMedia[i].setRating(Double.parseDouble(elements[4]));
    }

    for(int i = 0; i < lenOfFile; i++)
    {
      LocalDate dateToCheck = arrOfUMedia[i].getDate();
      // If date is between range
      if (dateToCheck.isBefore(today.plusWeeks(numWeeks)) && dateToCheck.isAfter(today))
      {
        indexesOfDates.add(i);
      }
      // If date is in the past
      else if(dateToCheck.isBefore(today))
      {
        indexesOfPastDates.add(i);
      }
    }
    
    // Printing upcoming releases that are coming out soon
    if(indexesOfDates.isEmpty())
    {
      // Outputting a design to make the output look neat and pretty
      System.out.println("****************************************************************");

      System.out.println("There are no upcoming releases within the next " + numWeeks + " weeks. ");

      // Outputting a design to make the output look neat and pretty
      System.out.println("****************************************************************");
    }
    else
    {
      // Outputting a blank line
      System.out.println();

      System.out.println("Upcoming releases within the next " + numWeeks + " weeks are: ");

      // Outputting a blank line
      System.out.println();

      // Outputting a design to make the output look neat and pretty
      System.out.println("****************************************************************");

      for (int i:indexesOfDates)
      {
        String release = arrOfUMedia[i].getTitle();
        System.out.println(release);
      }
      
      // Outputting a design to make the output look neat and pretty
      System.out.println("****************************************************************");
    }

    // Printing previously upcoming releases (that are now already out)
    if(indexesOfPastDates.isEmpty())
    {
      // Returning back to the method call
      return;
    }
    else
    {
      // Outputting a blank line
      System.out.println();

      System.out.println("Here is a list of media that you were previously interested in, that has already come out:");

      // Outputting a blank line
      System.out.println();

      // Outputting a design to make the output look neat and pretty
      System.out.println("****************************************************************");

      for(int i:indexesOfPastDates)
      {
        String name = arrOfUMedia[i].getTitle();
        System.out.println(name);
      }

      // Outputting a design to make the output look neat and pretty
      System.out.println("****************************************************************");
    }
  }

  // Method for choice 8
  public static void getMediaDatabase()
  {
    // Declaring a variable to store the content of the file called "List of Media.txt"
    String fileContent = "";

    // Try/catch block to check if the file called "List of Media.txt" exists or not
    try
    {
      // Connecting to the file
      FileReader fr = new FileReader("List of Media.txt");
      
      // Creating a scanner to scan through the file
      Scanner scan = new Scanner(fr);

      // Outputting a blank line
      System.out.println();

      // Outputting a message to the user
      System.out.println("Here is your database of released media:");

      // Outputting a blank line
      System.out.println();

      // Outputting a design to make the output look neat and pretty
      System.out.println("****************************************************************");

      // While loop to loop until there are no more lines in the file
      while(scan.hasNextLine())
      {
        String sentence = "";
        String sentence1 = "";
        String sent = "";
        String sent1 = "";

        // Reading a line of data from the file
        fileContent = scan.nextLine();

        // Splitting the line into array based on the delimiter
        String[] substring1 = fileContent.split("%");

        // Code to capitalize the first letter of each word in a string
        sentence = substring1[0];

        sentence = " " + sentence;

        for(int i=0; i<sentence.length(); i++)
        {
          char c = sentence.charAt(i);
          if(c == ' ')
          {
            sent += c;
            i++;
            c = sentence.charAt(i);
            sent = sent + Character.toUpperCase(c);
          }
          else
          {
            sent += c;
          }
        }
        sent = sent.trim();

        sentence1 = substring1[1];

        sentence1 = " " + sentence1;

        for(int i=0; i<sentence1.length(); i++)
        {
          char c1 = sentence1.charAt(i);
          if(c1 == ' ')
          {
            sent1 += c1;
            i++;
            c1 = sentence1.charAt(i);
            sent1 = sent1 + Character.toUpperCase(c1);
          }
          else
          {
            sent1 += c1;
          }
        }
        sent1 = sent1.trim();

        // Outputting the details of the media
        System.out.println("Media Title: " + sent + " || Media Genre: " + sent1);
      }

      // Outputting a design to make the output look neat and pretty
      System.out.println("****************************************************************");

      // Closing the FileReader
      fr.close();
    }
    catch(Exception ex)
    {
      // Outputting a blank line
      System.out.println();

      // Outputting an error message to the user
      System.out.println("Error! Your database is empty!");
    }
  }

  // Method for choice 9
  public static void getUpcomingMediaDatabase()
  {
    // Declaring a variable to store the content of the file called "List of Upcoming Media.txt"
    String fileContent1 = "";

    // Try/catch block to check if the file called "List of Upcoming Media.txt" exists or not
    try
    {
      // Connecting to the file
      FileReader fr = new FileReader("List of Upcoming Media.txt");
      
      // Creating a scanner to scan through the file
      Scanner scan1 = new Scanner(fr);

      // Outputting a blank line
      System.out.println();

      // Outputting a message to the user
      System.out.println("Here is your database of upcoming releases:");

      // Outputting a blank line
      System.out.println();

      // Outputting a design to make the output look neat and pretty
      System.out.println("*************************************************************************************");

      // While loop to loop until there are no more lines in the file
      while(scan1.hasNextLine())
      {
        String sentence2 = "";
        String sentence3 = "";
        String sent2 = "";
        String sent3 = "";

        // Reading a line of data from the file
        fileContent1 = scan1.nextLine();

        // Splitting the line into array based on the delimiter
        String[] substring2 = fileContent1.split("%");

        // Code to capitalize the first letter of each word in a string
        sentence2 = substring2[0];

        sentence2 = " " + sentence2;

        for(int i=0; i<sentence2.length(); i++)
        {
          char c2 = sentence2.charAt(i);
          if(c2 == ' ')
          {
            sent2 += c2;
            i++;
            c2 = sentence2.charAt(i);
            sent2 = sent2 + Character.toUpperCase(c2);
          }
          else
          {
            sent2 += c2;
          }
        }
        sent2 = sent2.trim();

        sentence3 = substring2[1];

        sentence3 = " " + sentence3;

        for(int i=0; i<sentence3.length(); i++)
        {
          char c3 = sentence3.charAt(i);
          if(c3 == ' ')
          {
            sent3 += c3;
            i++;
            c3 = sentence3.charAt(i);
            sent3 = sent3 + Character.toUpperCase(c3);
          }
          else
          {
            sent3 += c3;
          }
        }
        sent3 = sent3.trim();

        // Outputting the details of the media
        System.out.println("Media Title: " + sent2 + " || Media Genre: " + sent3 + " || Media Release Date: " + substring2[2]);
      }

      // Outputting a design to make the output look neat and pretty
      System.out.println("*************************************************************************************");

      // Closing the FileReader
      fr.close();
    }
    catch(Exception ex)
    {
      // Outputting a blank line
      System.out.println();

      // Outputting an error message to the user
      System.out.println("Error! Your database is empty!");
    } 
  }
}