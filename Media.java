// Declaring a class called Media
public class Media
{
  // Declaring a private variable to store the media's title 
  private String titleOfMedia;

  // Declaring a private variable to store the media's genre 
  private String genreOfMedia;
  
  // Declaring a private variable to store the media's review 
  private String reviewOfMedia;

  // Declaring a private variable to store the media's rating 
  private double ratingOfMedia;

  // Constructor to set the values of the instance variables
  Media(String theTitle, String theGenre, String theReview, double theRating)
  {
    this.titleOfMedia = theTitle;
    this.genreOfMedia = theGenre;
    this.reviewOfMedia = theReview;
    this.ratingOfMedia = theRating;
  }

  // Default constructor to set the values of the instance variables
  Media()
  {
    this.titleOfMedia = "";
    this.genreOfMedia = "";
    this.reviewOfMedia = "";
    this.ratingOfMedia = 0.0;
  }

  // Set method to set the value of the title instance variable 
  public void setTitle(String newTitle)
  {
    this.titleOfMedia = newTitle;
  }

  // Set method to set the value of the genre instance variable 
  public void setGenre(String newGenre)
  {
    this.genreOfMedia = newGenre;
  }

  // Set method to set the value of the review instance variable 
  public void setReview(String newReview)
  {
    this.reviewOfMedia = newReview;
  }
  
  // Set method to set the value of the rating instance variable 
  public void setRating(double newRating)
  {
    this.ratingOfMedia = newRating;
  }

  // Get method to return the value of the title instance variable 
  public String getTitle()
  {
    return this.titleOfMedia;
  }

  // Get method to return the value of the genre instance variable 
  public String getGenre()
  {
    return this.genreOfMedia;
  }

  // Get method to return the value of the review instance variable 
  public String getReview()
  {
    return this.reviewOfMedia;
  }

  // Get method to return the value of the rating instance variable 
  public double getRating()
  {
    return this.ratingOfMedia;
  }
}