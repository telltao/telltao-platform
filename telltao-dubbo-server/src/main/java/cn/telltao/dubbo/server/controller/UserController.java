package cn.telltao.dubbo.server.controller;

import cn.telltao.dubbo.server.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By telltao
 * telltao@qq.com
 *
 * @Date 2020/12/2 17:56
 */
@RestController
public class UserController {


    @Reference
    UserService userService;
    /**
     * 跳转到主页面
     *
     * @author yuxq
     * @Date 2020-08-26
     */
    @RequestMapping("/list")
    public String index() {
        userService.getUser();
        return "";
    }

}
