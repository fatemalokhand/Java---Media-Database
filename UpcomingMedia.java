// Importing localdate from time package
import java.time.LocalDate; 

// Declaring a class called UpcomingMedia
public class UpcomingMedia extends Media 
{
  // Declaring a private variable to store the media's release date 
  private LocalDate dateOfRelease;

  // Constructor to set the value of the instance variable
  UpcomingMedia(LocalDate date)
  {
    this.dateOfRelease = date;
  }

  // Default constructor to set the value of the instance variable
  UpcomingMedia()
  {
    this.dateOfRelease = null;
  }

  // Set method to set the value of the date instance variable 
  public void setDate(String dateInput)
  {
    this.dateOfRelease = LocalDate.parse(dateInput);
  }

  // Get method to return the value of the date instance variable 
  public LocalDate getDate()
  {
    return this.dateOfRelease;
  }
}