package cn.telltao.study.zookeeper.entity;

import lombok.Builder;

/**
 * Created By telltao
 * telltao@qq.com
 * 用户实体
 * @Date 2020/12/1 11:04
 */
@Builder
public class User extends BaseEntity {

    Integer id;
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
