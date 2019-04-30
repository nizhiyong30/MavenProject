package cn.designpattern.abstractfactory.factory;

import cn.designpattern.abstractfactory.login.ILogin;
import cn.designpattern.abstractfactory.login.MysqlLogin;
import cn.designpattern.abstractfactory.user.IUser;
import cn.designpattern.abstractfactory.user.MysqlUser;

/**
 * Created by nizy on 2019/4/2.
 */
public class MysqlFactory implements SqlFactory {
    @Override
    public IUser createUser() {
        return new MysqlUser();  //访问mysql中User表的对象
    }
    @Override
    public ILogin createLogin() {
        return new MysqlLogin();
    }
}
