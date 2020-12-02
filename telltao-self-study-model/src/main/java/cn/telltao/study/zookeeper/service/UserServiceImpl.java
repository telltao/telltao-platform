package cn.telltao.study.zookeeper.service;

import cn.telltao.study.zookeeper.entity.User;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created By telltao
 * telltao@qq.com
 *
 * @Date 2020/12/1 11:18
 */
@Service(version = "1.0.0")
@Component
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getAllUsers() {

        return  Arrays.asList(User.builder().id(123).name("张三").build());
    }

    @Override
    public User getUserByUserName(String username) {

        return User.builder().id(123).name("张三").build();
    }
}
