package ntt.global.web.controller;

import ntt.global.dto.User;
import ntt.global.dto.UserQueryCondition;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import sun.reflect.ReflectionFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * <p></p>
 *
 * @Author Yang yingjie(杨英杰)
 * @Created 2020/4/24 13:03
 */
@RestController
public class UserController {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public List<User> queryUser(@RequestParam(required = false,name = "nickname",defaultValue = "Yangyingjie") String username){
        System.out.println(username);
        List<User> userList=new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
       // System.out.println("query user successfully");
        return userList;
    }
    @RequestMapping(value = "/user1",method = RequestMethod.GET)
    public List<User> queryUser1(UserQueryCondition userQueryCondition, @PageableDefault(size = 10,page = 2,sort="username,desc") Pageable pageable){
        System.out.println(ReflectionToStringBuilder.toString(userQueryCondition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        List<User> userList=new ArrayList<>();
        userList.add(new User());
        userList.add(new User());
        userList.add(new User());
        // System.out.println("query user successfully");
        return userList;
    }
}
