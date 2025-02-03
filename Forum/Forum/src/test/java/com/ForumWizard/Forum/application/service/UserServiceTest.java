package com.ForumWizard.Forum.application.service;

import com.ForumWizard.Forum.models.exceptions.ValidationException;
import com.ForumWizard.Forum.models.user.User;
import com.ForumWizard.Forum.repositories.UserRepository;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testRegisterUser() throws ValidationException {
        User user = new User("Wesley Souza", "wesley@example.com", "flag1234!", UserType.ATHLETE);
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.registerUser(user);
        assertEquals("Wesley Sozua", savedUser.getName());
        verify(userRepository, times(1)).save(user);
    }
}