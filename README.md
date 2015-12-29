=================
Problem Statement
=================
1. Create a microservice that stores and shuffles card decks.
*  A card may be represented as a simple string such as “5-heart”, or 
   “K-spade”.
*  A deck is an ordered list of 52 standard playing cards.

Expose a RESTful interface that allows a user to:

2. PUT an idempotent request for the creation of a new named deck.  
*  New decks are created in some initial sorted order.
3. POST a request to shuffle an existing named deck.
4. GET a list of the current decks persisted in the service.
5. GET a named deck in its current sorted/shuffled order.
6. DELETE a named deck.

Design your own data and API structure(s) for the deck.

7. Persist the decks in-memory only, but stub the persistence layer such 
   that it can be later upgraded to a durable datastore.

8. Implement a simple shuffling algorithm that simply randomizes the 
   deck in-place.
9. Implement a more complex algorithm that simulates hand-shuffling, 
   i.e. splitting the deck in half and interleaving the two halves, 
   repeating the process multiple times.
   Allow switching the algorithms at deploy-time only via configuration.


=================
Setup
=================
1. Install Java 8
2. Install Jetty standalone server
   http://download.eclipse.org/jetty/
3. Install Gradle
4. Download this repo
5. Configure gradle.properties to point to Jetty standalone server
6. From command line "gradle deploy"
7. Navigate to Jetty standalone server directory and "java -jar start.jar"


=================
Use Cases
=================
1. curl -X PUT http://localhost:8080/mr_shuffle-1.0/rest/dealer/put/deck/Deck_Name
   //Creates a deck called "Deck_Name" in initial sorted order.
2. curl -X POST http://localhost:8080/mr_shuffle-1.0/rest/dealer/post/shuffle/Deck_Name
   //Shuffles deck "Deck_Name" and stores deck as a attribute in servlet context.
3. curl -X DELETE http://localhost:8080/mr_shuffle-1.0/rest/dealer/delete/deck/Deck_Name
   //Deletes deck "Deck_Name" from servlet context.
4. http://localhost:8080/mr_shuffle-1.0/rest/dealer/get/alldecks
   //Retrieves fjson (fake json) representation of all deck contents
5. http://localhost:8080/mr_shuffle-1.0/rest/dealer/get/deck/Deck_name
   //Retrieves fjson (fake json) representation deck "Deck_Name"
