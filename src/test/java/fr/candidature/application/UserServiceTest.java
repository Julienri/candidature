package fr.candidature.application;

import fr.candidature.domain.UserEventPublisher;
import fr.candidature.domain.event.UserActivatedEvent;
import fr.candidature.domain.event.UserCreatedEvent;
import fr.candidature.domain.event.UserDeactivatedEvent;
import fr.candidature.domain.event.UserDeletedEvent;
import fr.candidature.domain.exception.UserAlreadyExistsException;
import fr.candidature.domain.exception.UserNotFoundException;
import fr.candidature.domain.model.User;
import fr.candidature.domain.model.UserRepository;
import fr.candidature.fixtures.UserFixture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserEventPublisher userEventPublisher;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        userService = new UserService(userRepository, userEventPublisher);
    }

    @DisplayName("Create user")
    @Test
    public void saveUserTest() {
        // GIVEN
        User user = UserFixture.getUser();
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
        // WHEN
        userService.create(user);
        // THEN
        verify(userRepository, times(1)).save(user);

        ArgumentCaptor<UserCreatedEvent> eventCaptor = ArgumentCaptor.forClass(UserCreatedEvent.class);
        verify(userEventPublisher, times(1)).publish(eventCaptor.capture());
        assertEquals(user.getId(), eventCaptor.getValue().getUserId());
    }

    @DisplayName("Exception already exists when create user")
    @Test
    public void saveUserExceptionTest() {
        User user = UserFixture.getUser();
        when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

        assertThatThrownBy(() -> userService.create(user))
                .isInstanceOf(UserAlreadyExistsException.class)
                .hasMessage(String.format("L'utilisateur ayant comme adresse mail %s existe déjà", user.getEmail()));
    }

    @DisplayName("Activate user")
    @Test
    public void activateUserTest() {
        // GIVEN
        User user = UserFixture.getUser();
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        // WHEN
        userService.activate(user.getId());

        // THEN
        assertTrue(user.getActive());
        verify(userRepository, times(1)).save(user);

        ArgumentCaptor<UserActivatedEvent> eventCaptor = ArgumentCaptor.forClass(UserActivatedEvent.class);
        verify(userEventPublisher, times(1)).publish(eventCaptor.capture());
        assertEquals(user.getId(), eventCaptor.getValue().getUserId());
    }

    @DisplayName("Exception not found when activate user")
    @Test
    public void activeUserExceptionTest() {
        User user = UserFixture.getUser();
        when(userRepository.findById(user.getId())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.activate(user.getId()))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining(String.format("Aucun utilisateur trouvé avec l'id : %s.", user.getId()));
    }

    @DisplayName("Deactivate user")
    @Test
    public void deactivateUserTest() {
        // GIVEN
        User user = UserFixture.getUser();
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        // WHEN
        userService.deactivate(user.getId());

        // THEN
        assertFalse(user.getActive());
        verify(userRepository, times(1)).save(user);

        ArgumentCaptor<UserDeactivatedEvent> eventCaptor = ArgumentCaptor.forClass(UserDeactivatedEvent.class);
        verify(userEventPublisher, times(1)).publish(eventCaptor.capture());
        assertEquals(user.getId(), eventCaptor.getValue().getUserId());
    }

    @DisplayName("Exception not found when deactivate user")
    @Test
    public void deactiveUserExceptionTest() {
        User user = UserFixture.getUser();
        when(userRepository.findById(user.getId())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.deactivate(user.getId()))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining(String.format("Aucun utilisateur trouvé avec l'id : %s.", user.getId()));
    }

    @DisplayName("Delete user")
    @Test
    public void deleteUserTest() {
        // GIVEN
        User user = UserFixture.getUser();
        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        // WHEN
        userService.delete(user.getId());

        // THEN
        ArgumentCaptor<UserDeletedEvent> eventCaptor = ArgumentCaptor.forClass(UserDeletedEvent.class);
        verify(userEventPublisher, times(1)).publish(eventCaptor.capture());
        assertEquals(user.getId(), eventCaptor.getValue().getUserId());
    }

    @DisplayName("Exception not found when deactivate user")
    @Test
    public void deleteUserExceptionTest() {
        User user = UserFixture.getUser();
        when(userRepository.findById(user.getId())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userService.delete(user.getId()))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessageContaining(String.format("Aucun utilisateur trouvé avec l'id : %s.", user.getId()));
    }
}
