package n11.n11finalcaseahmetsaimyilmaz.user;

import n11.n11finalcaseahmetsaimyilmaz.userReview.UserReview;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(updatedUser.getName());
            existingUser.setSurname(updatedUser.getSurname());
            existingUser.setLatitude(updatedUser.getLatitude());
            existingUser.setLongitude(updatedUser.getLongitude());
            return userRepository.save(existingUser);
        } else {
            return null; // Or throw exception or handle accordingly
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}