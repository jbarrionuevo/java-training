package edu.globant.day1.layerandtiers.exercices;

public class LayerAndTierDescription {

	/*
	 * The following application receives as an input a configuration
	 * and a user name and depending of how it is configure retrieves
	 * the user data from Twitter or from a Historical Database of
	 * users and tweets
	 * 
	 * 	 * For this project I could identified 4 tiers
	 * 
	 * 1 - Client Tier: which is the web browser from where
	 * the user would send a Twitter User as an input and a 
	 * configuration in order to retrieve the data from a 
	 * database or from the twitter page online
	 * 
	 * 2 - Presentation tier: This would be the JSP that 
	 * generates the page to be renderized on the client
	 * tier
	 * 
	 * 3 - Business tier: This are the Java classes that were
	 * separated on layers and it would all the processing 
	 * needed to recover the data from the database or from 
	 * Twitter and then transform that data and send it back
	 * to the presentation layer as requested
	 * 
	 * 4 - Data Tier: the data for this application would
	 * be store online on a Twitter account or in database
	 * of historical MySql database of users. Depending of
	 * the configuration would access to one of these two
	 * storages
	 * 
	 * 	+------------------------------------------------+
		|                                                |
		|                         +--------------------+ |
		|  Client Tier            |Client's Web Browser| |
		|                         +----------+---------+ |
		|                                    |           |
		+------------------------------------------------+
		|                                    |           |
		|   Presentation           +---------v---------+ |
		|   Tier                   |        JSP  	   | |
		|                          +---------+---------+ |
		|                                    |           |
		+------------------------------------------------+
		|                                    |           |
		|   Business               +---------v---------+ |
		|   Tier                   |    Java classes   | |
		|                          ++-----------+------+ |
		|                           |           |        |
		+------------------------------------------------+
		|                           |           |        |
		|               +-----------v+   +------v------+ |
		|   Data Tier   | MySql Tweet|   |Twitter Page | |
		|               | Database   |   +-------------+ |
		|               +------------+                   |
		+------------------------------------------------+

	 * 
	 * For the layer representation of the project I could
	 * identified 3 layers:
	 * 
	 * 1 - The presentation layer that renderize the data coming
	 * from the service layer and also takes the input from the
	 * users and pass it to the service layer in order to make
	 * a query to the database or to the Twitter WEB.
	 * 
	 * 2 - The service layer wich has a facade in order to 
	 * have a unique interface with the presentation layer
	 * and connect in a proper way to the Offline services
	 * and the Online services depending of the user 
	 * configuration. Both services would connect to the 
	 * proper DAO on the Data access layer
	 * 
	 * 3 - The data access layer receives and retrieves 
	 * queries from the service layer and access to the 
	 * database or to the twitter page by using the proper
	 * DAO for the task.
	 * 
     				  +--------------------+
		              |Client's Web Browser|
		              +----------+---------+
		                         |
		                         |
		+------------------------v--------------------------+
		|                                                   |
		|                           +----------------+      |
		| Presentation Layer        |JSP & JavaScript|      |
		|                           +----------------+      |
		|                                                   |
		+---------------------------------------------------+
		|                 +-------------------------------+ |
		|                 | Application Service Facade    | |
		| Service Layer   +-------------------------------+ |
		|                 +-------------+  +-------------+  |
		|                 |  OffLine    |  | Online      |  |
		|                 |  Services   |  | Services    |  |
		|                 +-------------+  +-------------+  |
		|                                                   |
		+---------------------------------------------------+
		|                                                   |
		|                    +------------+  +------------+ |
		| Data Access Layer  |DataBase DAO|  | TwitterDAO | |
		|                    |            |  |            | |
		|                    +------------+  +------------+ |
		+------------+--------------------------------------+
		             |                       |
		             |                       |
		      +------v---- +          +------v------+
		      | MySql Tweet|          |Twitter Page |
		      | Database   |          +-------------+
		      +------------+
	 * 
	 * */
}
