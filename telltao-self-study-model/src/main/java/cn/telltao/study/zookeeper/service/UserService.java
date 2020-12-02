package cn.telltao.study.zookeeper.service;

import cn.telltao.study.zookeeper.entity.User;

import java.util.List;

/**
 * Created By telltao
 * telltao@qq.com
 *
 * @Date 2020/12/1 11:18
 */
public interface UserService {

    List<User> getAllUsers();

    User getUserByUserName(String username);


}
