import java.util.Scanner;
public class DataProjectTester {

public static void main(String [] args) {
String userInput;
String userAmount=null;
String mostPopularAuthor=null;
String initialPost=null;
int a=0;
int b=1;
int c=0;
int d=0;
int e=0;
int f=0;
int count=0;
int count2=0;
int position=0;

Scanner input = new Scanner(System.in);
DataProject [] arrayOfData=new DataProject[6466];

System.out.println("Hello, I'm a bot designed to analyze data from the subreddit The Donald");
System.out.println("Based on the input that you provide, I'll search the data that was provided to me for information about that input");
System.out.println("\nPlease give me a few seconds to compile all of the data");

while (position<6466) {
arrayOfData[position]=new DataProject();
arrayOfData[position].FileReader("RedditAuthors.txt", "RedditPosts.txt","PostScore.txt","NumberOfComments.txt",position+1);
arrayOfData[position].popularityRank=position+1;
position++;
}

//User input to decide what to search for

System.out.println("Data compilation complete:");
System.out.println("Please enter a string that you would like me to analyze");

userInput=input.nextLine();

System.out.println("To only see the most popular post based on Reddit Score containing your string, input: mostpopular");
System.out.println("To see the top five most popular posts based on Reddit Score containing your string, input: top5");
System.out.println("To see all of the posts containing your string, input: all");

userAmount=input.nextLine();

//Determines the posts containing the user input and how many results to display

while(a<6466 && b<=5) {
	
if (userAmount.equalsIgnoreCase("mostpopular") || userAmount.equalsIgnoreCase("most popular")) {

arrayOfData[a].PostSearcher(userInput);

if (arrayOfData[a].includedContent==1) {
b=6;

}
}

else if (userAmount.equalsIgnoreCase("top5") || userAmount.equalsIgnoreCase("top 5")) {

arrayOfData[a].PostSearcher(userInput);	

if (arrayOfData[a].includedContent==1) {
b++;

}
}

else if (userAmount.equalsIgnoreCase("all")) {

arrayOfData[a].PostSearcher(userInput);
}

else {
System.out.println("Please enter a valid input");
b=6;
}

a++;
}

//Determining the most popular author with user input

while (c<6466 && d<5) {
if (arrayOfData[c].includedContent==1) {
initialPost=arrayOfData[c].redditPost;
mostPopularAuthor=arrayOfData[c].author;
System.out.println("***********************************************************************************************************************************************************************************");
System.out.println("\n\nThe most popular author containing your input is: "+mostPopularAuthor+"\n");
d=6;
}
c++;
}

//Finding other posts by the most popular author in the data

while (e<6466) {
arrayOfData[e].OtherPostsByAuthor(mostPopularAuthor, initialPost);
if (arrayOfData[e].includedContent==2) {
count++;
}
else if (arrayOfData[e].includedContent==0) {
count2++;
}
e++;
}

//Determining the amount of times the most popular author posted/catch for a string that wasn't contained in the data

if (count>0) {
arrayOfData[0].AuthorActivity(mostPopularAuthor,count+1);
}

else if (count==0 && mostPopularAuthor!=null) {
System.out.println("\n"+mostPopularAuthor+" did not post anymore in the selected data");
arrayOfData[0].AuthorActivity(mostPopularAuthor, count+1);
}

if (count2==6466) {
	System.out.println("The string that you entered was not found in the post, please run the program again with a different string");
}
}
}