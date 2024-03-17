# Restaurant Recommendation System

![Application Screenshot](https://github.com/ahmetsaimyilmaz/n11-final-case-ahmet-saim-yilmaz/blob/master/WelcomePage.PNG)

This Java Spring web application is designed to help users find the best nearby restaurants based on user reviews and location. 
It allows for management of user profiles, restaurant details, and user reviews. The core functionality generates restaurant scores from user reviews and recommends the top three restaurants closest to the user's location with the best scores.

## Features

- **User Management:** Create, update, and delete user profiles.
- **Review Management:** Users can submit, update, and delete reviews for restaurants.
- **Restaurant Management:** Add, update, and remove restaurant information.
- **Score Generation:** The application calculates a score for each restaurant based on user reviews.
- **Restaurant Recommendations:** Users receive three recommendations for the best-scored restaurants closest to their location.

## Getting Started

### Prerequisites

- JDK 17 or later
- Maven 3.6.3 or later
- Postgresql 13 or later
- Solr 8.11.3 or later

### Setup

1. Clone the repository: git clone [<repository-url>](https://github.com/ahmetsaimyilmaz/n11-final-case-ahmet-saim-yilmaz.git)https://github.com/ahmetsaimyilmaz/n11-final-case-ahmet-saim-yilmaz.git
2. Navigate to the project directory:
3. Configure your database connection in `n11-final-case-ahmet-saim-yilmaz-user-review/src/main/resources/application.properties`:
4. Configure Solr Core Name: `n11-final-case-ahmet-saim-yilmaz-restaurant/src/main/java/n11/n11finalcaseahmetsaimyilmaz/restaurant`
5. Default Core Name is `core-instance` create with same name or configure at step 4
6. Build the projects seperately: mvn clean install
7. Run the application

The application should now be running and accessible on `http://localhost:8080`.

- **User- User Review - Recommendation System:** Should now be running and accessible on `http://localhost:8080`.
- **Restaurant:** Should now be running and accessible on `http://localhost:8090`.

## Usage

- **Creating a User:** Send a POST request to `http://localhost:8080/api/users` with the user's details.
- **Submitting a Review:** Send a POST request to `http://localhost:8080/api/reviews` with the review details.
- **Adding a Restaurant:** Send a POST request to `http://localhost:8090/restaurants` with the restaurant details.
- **Getting Recommendations:** Access `http://localhost:8080/api/recommendations` with the user's location to receive the top three restaurant recommendations.

## Contributing

We welcome contributions! Please feel free to fork the repository and submit pull requests with any enhancements, bug fixes, or suggestions.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

 
