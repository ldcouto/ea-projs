Readme for DBOY : a Digg Database Filler and Load Tester

IMPORTANT NOTICES:
Please make sure the the 'mats' directory is in the same directory as the JAR Archive.
The prompt must be in the same folder as the .jar file and the /mats dir. Otherwise, DBoy will NOT work.


USAGE:
To run the command line tool you should use the following command:
	
	cd /path/to/jar-archive/
	java -jar terminalTool.jar <OPTION> <host_address> <host_port> <database_name> <user> <password>
	
Where OPTION should be one of the following:

	GUI - Opens the graphical user interface.

	FL - Fills the database with random data. Do notice that it will not delete any of the data already present in the database.
	
	LT - Runs some stress tests on the database.
	
	ALL - runs both the filler tool followed by the load tester tool.
	
		
OUTPUTS:
After running the Load Tester, the 'mats' directory will have several new files all named worker_output_X.txt. These files contain the test results. To help you process them a script is included to generate new text files which can be easily fed into a Spreadsheet.

	
USING THE AUXILIARY SCRIPT:
To use the script simply position the prompt in the mats directory and run "./output_proc.sh". Afterwards, several files will be generated. The files and their respective queries are:

top10News.txt - TOP10NEWS - Retrieves the Top 10 news from the DB
top10Followers.txt - TOP10FOLL - Retrieves the Top 10 users with more followers
followersOfUser.txt - FOLlFROM  - Retrieves all the followers from a given user
postsLikedByUser.txt - VOTESFROM - Retrieves all the news that a given user has voted
newsFromUser.txt - NEWSFROM  - Retrieves all the news that a given user has posted
newVote.txt - NEWVOTE   - Inserts a new vote from a given user and a random news
login.txt - LOGIN - Logs in a given user
newPost.txt - NEWPOST - Inserts a new random news
recommendedNews.txt - RECNEWS - Retrieves the recommended news for a given user
recommendedUsers.txt - RECUSERS - Retrieves the recommended users for a given user

	
GRAPHICAL USER INTERFACE:	
	The Swing GUI shows you a general window where you should provide all the information required for it to access the database, and then you simply need to press the button correspondent to the action you want to preform.