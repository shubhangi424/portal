/*
 * package com.example.demo;
 * 
 * import org.junit.Before; import org.junit.Test; import
 * org.junit.jupiter.api.BeforeEach; import org.junit.runner.RunWith; import
 * org.mockito.InjectMocks; import org.mockito.Mock; //import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.test.context.junit4.SpringJUnit4ClassRunner; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.setup.MockMvcBuilders;
 * 
 * 
 * //import com.fasterxml.jackson.databind.ObjectMapper;
 * 
 * //import static org.hamcrest.CoreMatchers.is; //import static
 * org.mockito.Mockito.when; import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
 * import static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; //import
 * static org.hamcrest.Matchers.hasSize; import static
 * org.junit.Assert.assertEquals; //import static
 * org.mockito.ArgumentMatchers.any; //import static
 * org.mockito.BDDMockito.given; //import static org.mockito.Mockito.doNothing;
 * //import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; import
 * java.util.ArrayList; //import java.util.Date; import java.util.List;
 * 
 * @RunWith(SpringJUnit4ClassRunner.class) public class UserControllerTest {
 * 
 * private MockMvc mockMvc;
 * 
 * @Mock public UserRepository repo;
 * 
 * @InjectMocks public UserController ur;
 * 
 * 
 * @Before public void setUp() throws Exception { mockMvc =
 * MockMvcBuilders.standaloneSetup(ur) .build(); }
 * 
 * private List<Users> userList ;
 * 
 * @BeforeEach void setUp1() { this.userList=new ArrayList<>();
 * this.userList.add(1,new Users(1, "shubhangi", "Bhise",91,"11111111111",
 * "s@gmail.com", "Shubh", "latur", "f", "img", "2", "3", 1)); }
 * 
 * @Test public void testhelloWorld() throws Exception {
 * //when(userservice.hello()).thenReturn("hello");
 * mockMvc.perform(get("/registration/hello")) .andExpect(status().isOk())
 * .andExpect(content().string("hello")); //verify(userservice).hello();
 * //fail("Not yet implemented"); }
 * 
 * @Test public void testAllUsers() { List<Users> users=repo.findAll();
 * assertEquals(0,users.size()); } // @Test // public void testGetAllUsers()
 * throws Exception { // given(repo.findAll()).willReturn(userList); //
 * this.mockMvc.perform(get("/registration/user")) //
 * .andExpect(status().isOk()) // .andExpect("$.size()",is(userList.size())); //
 * } //
 * 
 * }
 */