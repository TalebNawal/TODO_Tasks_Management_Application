package ma.ac.emi.info.taskmate.Service;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.ac.emi.info.taskmate.Entities.User;
import ma.ac.emi.info.taskmate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
    public class UserService {
        @Autowired
        private UserRepository userRepository;

        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        public Optional<User> getUserById(String id) {
            return userRepository.findByUsername(id);
        }

        public Optional<User> getUserByusername(String username) {
            return userRepository.findByUsername(username);
        }

        public User createUser(User user) {
            return userRepository.save(user);
        }

        public User updateUser(String id, User user) {
            Optional<User> existingUser = userRepository.findById(id);
            if (existingUser.isPresent()) {
                User updatedUser = existingUser.get();
                updatedUser.setUsername(user.getUsername());
                updatedUser.setPassword(user.getPassword());
                return userRepository.save(updatedUser);
            }
            return null;
        }

        public boolean deleteUser(String id) {
            Optional<User> existingUser = userRepository.findById(id);
            if (existingUser.isPresent()) {
                userRepository.deleteById(id);
                return true;
            }
            return false;
        }
    }


