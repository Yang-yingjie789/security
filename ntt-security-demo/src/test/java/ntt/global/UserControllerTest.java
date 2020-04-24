package ntt.global;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * <p></p>
 *
 * @Author Yang yingjie(杨英杰)
 * @Created 2020/4/24 12:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    /**
     * 创建虚拟的mvc 服务
     */
    @Before
    public void setup(){
       mockMvc= MockMvcBuilders.webAppContextSetup(wac).build();
   }
   @Test
    public void whenQuerySuccess() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.get("/user")
               .param("nickname","stephen")
               .contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
   }
    @Test
    public void whenQuerySuccess1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/user1")
                .param("username","stephen")
                .param("password","123")
                .param("age","100")
                .param("xxx","123")
                /*.param("size","15")
                .param("page","2")
                .param("sort","age,desc")*/
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));
    }

}
