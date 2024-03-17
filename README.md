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
<pre>
```java
public void testData() {
        resetAutoIncrement();
        // Check if users already exist
        if (userService.count() == 0) {

            Restaurant restaurant1 = new Restaurant(1, "The Gourmet Kitchen", 3,3, 0);
            restaurantServiceClient.createRestaurant(restaurant1);
            Restaurant restaurant2 = new Restaurant(2, "Cafe Delights", 3,3, 0);
            restaurantServiceClient.createRestaurant(restaurant2);
            Restaurant restaurant3 = new Restaurant(3, "Bistro Boulevard", 3,3, 0);
            restaurantServiceClient.createRestaurant(restaurant3);
            Restaurant restaurant4 = new Restaurant( 4,"Dine Fine", 3,3, 0);
            restaurantServiceClient.createRestaurant(restaurant4);
            Restaurant restaurant5 = new Restaurant( 5,"Spice Symphony", 3,3, 0);
            restaurantServiceClient.createRestaurant(restaurant5);
            Restaurant restaurant6 = new Restaurant( 6,"The Curry Leaf", 0,0, 0);
            restaurantServiceClient.createRestaurant(restaurant6);
            Restaurant restaurant7 = new Restaurant(7, "Ocean's Plate", 0,0, 0);
            restaurantServiceClient.createRestaurant(restaurant7);
            Restaurant restaurant8 = new Restaurant(8, "Mountain Munch", 0,0, 0);
            restaurantServiceClient.createRestaurant(restaurant8);
            Restaurant restaurant9 = new Restaurant(9, "Urban Eats", 0,0, 0);
            restaurantServiceClient.createRestaurant(restaurant9);
            Restaurant restaurant10 = new Restaurant( 10,"Garden Bites", 0,0, 0);
            restaurantServiceClient.createRestaurant(restaurant10);
            // No users exist, so we can generate test data
            List<User> temp = new ArrayList<>();
            temp.add(new User(1L,"user1","surname1",0,0));
            temp.add(new User(2L,"user2","surname2",0,0));
            temp.add(new User(3L,"user3","surname3",0,0));
            temp.add(new User(4L,"user4","surname4",0,0));
            temp.add(new User(5L,"user5","surname5",3,3));
            temp.add(new User(6L,"user6","surname6",3,3));
            temp.add(new User(7L,"user7","surname7",3,3));
            temp.add(new User(8L,"user8","surname8",3,3));
            temp.add(new User(9L,"user9","surname9",3,3));

            userService.saveUsers(temp);

            for (int i = 1; i < 10; i++) {
                User user = temp.get(i % temp.size()); // Cycle through users
                UserReview review = new UserReview(
                        user,
                        i,
                        "Review text for restaurant " + i,
                        (i % 5) + 1 // Score cycles from 1 to 5
                );
                userReviewService.save(review);
            }
        } else {
            // Users already exist, do not generate test data
            System.out.println("Test data not generated since data already exists.");
        }
    }
```
</pre>
  

## Contributing

We welcome contributions! Please feel free to fork the repository and submit pull requests with any enhancements, bug fixes, or suggestions.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

 
