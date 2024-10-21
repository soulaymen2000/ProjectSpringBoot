package com.example.projetspring;

import com.example.projetspring.Repository.UserRepository;
import com.example.projetspring.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository Repo;
    @Autowired
    private TestEntityManager entityManager ;
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("test@dfg.com");
        user.setPassword("password");
        user.setFirstName("dfgh");
        user.setLastName("Ufyuser");
        User savedUser = Repo.save(user);
        User existUser = entityManager.find(User.class, savedUser.getId());
        assert(existUser.getEmail().equals(user.getEmail()));

    }
    @Test
    public void testFindUserByEmail() {

        String email = "test@dfg.com";
        User user = Repo.findByEmail(email);
        assert(user!=null);
    }
}
