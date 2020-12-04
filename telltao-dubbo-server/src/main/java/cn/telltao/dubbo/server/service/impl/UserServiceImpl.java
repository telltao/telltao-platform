package cn.telltao.dubbo.server.service.impl;

import cn.telltao.dubbo.server.entity.User;
import cn.telltao.dubbo.server.mapper.UserMapper;
import cn.telltao.dubbo.server.service.UserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created By telltao
 * telltao@qq.com
 *
 * @Date 2020/12/1 16:40
 */
@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl  implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getUser() {

        return userMapper.list();


    }
}
