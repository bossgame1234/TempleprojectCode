package camt.se331.templeProject.entity;

import camt.se331.templeProject.repository.RoleRepository;
import camt.se331.templeProject.repository.UserRepository;
import camt.se331.templeProject.service.UserService;
import camt.se331.templeProject.service.UserServiceImpl;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.mockito.Mockito.*;

/**
 * Created by SONY on 19/5/2558.
 */
public class UserTest {

    @Before
    public void setUp(){

    }
    @Test
    public void testFindAllUser(){

        Set<Role> roles = new HashSet<>();
        Role role = Mockito.mock(Role.class);
        role.setId(2L);
        role.setRoleName("user");
        roles.add(role);


        List<User> userList = new ArrayList<>();
        User user1 = new User("Thitiworada","5492134322","thitiworada_t@cmu.ac.th","Thongprasert",role);
        User user2 = new User("Pimpaporn","123456789","pimpaporn_c@cmu.ac.th","Chaichompoo",role);
        userList.add(user1);
        userList.add(user2);

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        RoleRepository roleRepository = Mockito.mock(RoleRepository.class);
        UserService userService = new UserServiceImpl(userRepository , roleRepository);
        when(userRepository.findAll()).thenReturn(userList);
        assertThat(userService.findAll(), is(userList));

        List<User> userList2 = new ArrayList<>();
        when(userRepository.findAll()).thenReturn(userList2);
        assertThat(userService.findAll().size(),is(0));
    }

    @Test
    public void testFindByUserName(){

        Set<Role> roles = new HashSet<>();
        Role role = Mockito.mock(Role.class);
        role.setId(2L);
        role.setRoleName("user");
        roles.add(role);


        List<User> userList = new ArrayList<>();
        User user1 = new User("Thitiworada","5492134322","thitiworada_t@cmu.ac.th","Thongprasert",role);
        User user2 = new User("Pimpaporn","123456789","pimpaporn_c@cmu.ac.th","Chaichompoo",role);
        userList.add(user1);
        userList.add(user2);

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        RoleRepository roleRepository = Mockito.mock(RoleRepository.class);
        UserService userService = new UserServiceImpl(userRepository , roleRepository);

        when(userRepository.findByUsername("Thitiworada")).thenReturn(user1);
        assertThat(userService.findByUserName("Thitiworada"),is(user1));
    }

    @Test
    public void testAddUser(){
        Set<Role> roles = new HashSet<>();
        Role role = Mockito.mock(Role.class);
        role.setId(2L);
        role.setRoleName("user");
        roles.add(role);


        List<User> userList = new ArrayList<>();
        User user1 = new User("Thitiworada","5492134322","thitiworada_t@cmu.ac.th","Thongprasert",role);
        User user2 = new User("Pimpaporn","123456789","pimpaporn_c@cmu.ac.th","Chaichompoo",role);
        User user3 = new User("Supakarn","0000","supakarn_g@cmu.ac.th","Graisaard",role);
        userList.add(user1);
        userList.add(user2);

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        RoleRepository roleRepository = Mockito.mock(RoleRepository.class);
        UserService userService = new UserServiceImpl(userRepository , roleRepository);

        when(userRepository.save(user3)).thenReturn(user3);
        assertThat(userService.addUser(user3), is(user3));
        userList.add(user3);
        when(userRepository.findAll()).thenReturn(userList);
        assertThat(userService.findAll().size(), is(3));

    }

    @Test
    public void testEditUser(){
        Set<Role> roles = new HashSet<>();
        Role role = Mockito.mock(Role.class);
        role.setId(2L);
        role.setRoleName("user");
        roles.add(role);


        List<User> userList = new ArrayList<>();
        User user1 = new User("Thitiworada","5492134322","thitiworada_t@cmu.ac.th","Thongprasert",role);
        User user2 = new User("Pimpaporn","123456789","pimpaporn_c@cmu.ac.th","Chaichompoo",role);
        userList.add(user1);
        userList.add(user2);

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        RoleRepository roleRepository = Mockito.mock(RoleRepository.class);
        UserService userService = new UserServiceImpl(userRepository , roleRepository);

        user2.setPassword("666666");
        when(userRepository.save(user2)).thenReturn(user2);
        assertThat(userService.editUser(user2),is(user2));

        when(userRepository.findByUsername("Pimpaporn")).thenReturn(user2);
        assertThat(userService.findByUserName("Pimpaporn").getPassword(), is("666666"));

    }
}
