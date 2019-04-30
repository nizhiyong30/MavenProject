package cn.designpattern.abstractfactory;

import cn.designpattern.abstractfactory.factory.OracleFactory;
import cn.designpattern.abstractfactory.factory.SqlFactory;
import cn.designpattern.abstractfactory.login.ILogin;
import cn.designpattern.abstractfactory.login.Login;
import cn.designpattern.abstractfactory.user.IUser;
import cn.designpattern.abstractfactory.user.User;

/**
 * Created by nizy on 2019/4/2.
 */
public class Client {
    public static void main(String[] args){

        User user=new User();
        Login login = new Login();

        // 只需要确定实例化哪一个数据库访问对象给factory
        // IFactory factory=new MysqlFactory();
        SqlFactory factory=new OracleFactory();

        // 已与具体的数据库访问解除了耦合
        IUser userOperation=factory.createUser();

        userOperation.getUser(1);
        userOperation.insert(user);

        // 已与具体的数据库访问解除了耦合
        ILogin loginOperation=factory.createLogin();

        loginOperation.insert(login);
        loginOperation.getLogin(1);

    }
}
