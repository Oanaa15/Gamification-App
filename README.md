# Gamification-App
I have implemented a gamification application, which allows users to earn "tokens", "badges", and a ranking system based on solving quests. Quests can be proposed by anyone, provided they have enough "tokens". The main way to earn "tokens" is by solving quests.

The app's purpose is to help users develop skills in a fun and engaging way by offering challenges and quests.

Upon creating an account, the user is prompted to enter personal information such as name, email, password, and age. The user's information is stored in a database, and they are given a starting badge and zero tokens. Once logged in, the user can participate in challenges, quests, and earn tokens by completing various tasks.
The app includes several features such as adding quests, viewing the palyers ranking, and solving quests. 

Controllers:
The ProfileController class is responsible for managing the user's profile page. It interacts with the UsersService and other views such as the add quest, ranking, and solve quests pages. The controller contains several @FXML annotated methods and instance variables to support these functionalities.
Methods:
setData(): This method updates the view with the user's information such as their name, email, tokens, and badges.
setCurrentUser(Long user): This method takes in a Long value that represents the user's ID and sets it as the current user. It then calls the setData() method to update the view with the user's information.
onAddQuest(): This method is triggered when the user clicks the add quest button. It opens the add quest page and passes the current user's ID to the AddQuestController.
onSignOut(ActionEvent event): This method is triggered when the user clicks the sign-out button. It opens the log-in page and closes the current profile page.
onShowRanking(ActionEvent event): This method is triggered when the user clicks the show ranking button. It opens the ranking page and calls the showRanking() method in the RankingController.
onSolveQuests(ActionEvent event): This method is triggered when the user clicks the solve quests button. It opens the solve quests page and passes the current user's ID to the QuestGameController. After the user solves quests and earns tokens, this method updates the token count in the user's profile view.
Overall, the ProfileController class serves as the intermediary between the user's profile page view and the service layer. It handles user input from the view, passes data to other views, and updates the profile view with the user's information.

QuestGameController is a controller for a view that displays a list of quests that a user can solve. The user can select a quest from the list and submit their answer. If the answer is correct, the user receives a token. This class is responsible for handling user input, updating the view and interacting with the data layer.

This is a JavaFX controller class named "RankingController" that implements the Initializable interface. It is responsible for displaying a table view of the users' ranking in the game.

The AddQuestController class is responsible for controlling the add quest view. It contains methods for adding a new quest, setting the current user, and handling the button event for adding a new quest. The controller retrieves user and quest data from the corresponding services.

The LogInController class is a controller class that handles the logic for the login functionality of the application. This controller interacts with the UsersService to retrieve and authenticate user credentials.

The SignUpController class is responsible for handling user sign up requests in the gamification system. It contains several JavaFX components, such as TextField, PasswordField, Button, and Label, that are used for user input and output.

Overall, Gamification Accesa aims to promote a fun and interactive learning environment by rewarding users for their progress and achievements. It is a user-friendly app with a design that is easy to navigate. Overall, the app is suitable for anyone who wants to improve their skills and enjoy a gamified learning experience
