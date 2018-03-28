import java.io.*;

public class DataProject {
	
String author;
String redditPost;
int upvotes;
int numberOfComments;
int includedContent;
int nonIncludedContent;
int popularityRank;

DataProject(){
	author = null;
	redditPost = null;
	upvotes = 0;
	numberOfComments = 0;	
	includedContent=0;
	nonIncludedContent=0;
}

//Reads the files line by line to compile the data array in the tester file

public void FileReader(String file1, String file2, String file3, String file4, int iterations) {
	
	try {
		FileReader authorFile= new FileReader(file1);
		FileReader postFile= new FileReader(file2);
		FileReader scoreFile= new FileReader(file3);
		FileReader commentFile= new FileReader(file4);

		BufferedReader authorRead=new BufferedReader(authorFile);
		BufferedReader postRead=new BufferedReader(postFile);
		BufferedReader scoreRead=new BufferedReader(scoreFile);
		BufferedReader commentRead=new BufferedReader(commentFile);

//This for loop is the only way that I could come up with to get the buffered reader to move onto new lines inside the method
//Running it this many times is definitely the source of the delay in the beginning of the program, but it works
		
	for (int i=0; i<iterations; i++) {
		author=authorRead.readLine();
		redditPost=postRead.readLine();
		upvotes=Integer.parseInt(scoreRead.readLine());
		numberOfComments=Integer.parseInt(commentRead.readLine());
	}
	authorRead.close();
	postRead.close();
	scoreRead.close();
	commentRead.close();
	}
	
	catch(Exception e){
	}
}

//Searches for posts containing user input

public void PostSearcher(String userInput) {

if (redditPost.contains(userInput.toLowerCase())) {
includedContent=1;
System.out.println("\n"+author+" said: "+redditPost+"\n");
System.out.println("** " + author + "'s post was ranked " + popularityRank + " in total score and had "+numberOfComments+" total comments **\n");
}

}

//Searches for other posts by the most popular author of the user input

public void OtherPostsByAuthor(String mostPopularAuthor, String initialPost) {
	
if (author.equalsIgnoreCase(mostPopularAuthor) && redditPost!=initialPost) {
includedContent=2;
System.out.println("\n"+mostPopularAuthor+" also posted:\n");
System.out.println(""+redditPost+"\n");
System.out.println("** This post was ranked " + popularityRank + " in total score and had "+numberOfComments+" total comments **\n\n");

}

}

//Categorizes the most popular author based on the amount of times they posted in the data

public void AuthorActivity(String mostPopularAuthor, int count){
	
if (count<=2) {
	System.out.println("\nSince "+mostPopularAuthor+" only posted "+count+" time(s) in all of the data, "+mostPopularAuthor+" is not a very active user of the subreddit.");
	System.out.println("\n\nThank you for using the program. If you want to check for information about another string, please re-run the program");
}
	
else if (count>2 && count<=5) {
	System.out.println("\n"+mostPopularAuthor+" posted "+count+" times in all of the data, making "+mostPopularAuthor+" a moderately active user of the subreddit.");
	System.out.println("\n\nThank you for using the program. If you want to check for information about another string, please re-run the program");
}
	
else if (count>5) {
	System.out.println("\n"+mostPopularAuthor+" posted "+count+" times in all of the data, making "+mostPopularAuthor+" a very frequent user of the subreddit.");
	System.out.println("\n\nThank you for using the program. If you want to check for information about another string, please re-run the program");
}
}

}