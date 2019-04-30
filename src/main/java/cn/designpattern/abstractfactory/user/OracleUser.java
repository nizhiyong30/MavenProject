package cn.designpattern.abstractfactory.user;

/**
 * Created by nizy on 2019/4/2.
 */
public class OracleUser implements IUser {

    @Override
    public void insert(User user) {
        System.out.println("在oracle中的user表中插入一条元素");
    }

    @Override
    public User getUser(int uid) {
        System.out.println("在oracle中的user表得到id为" + uid + "的一条数据");
        return null;
    }
}
