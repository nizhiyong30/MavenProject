package cn.designpattern.abstractfactory.factory;

import cn.designpattern.abstractfactory.login.ILogin;
import cn.designpattern.abstractfactory.login.OracleLogin;
import cn.designpattern.abstractfactory.user.IUser;
import cn.designpattern.abstractfactory.user.OracleUser;

/**
 * Created by nizy on 2019/4/2.
 */
public class OracleFactory implements SqlFactory {
    @Override
    public IUser createUser() {
        return new OracleUser();   //访问oracle中User表的对象
    }

    @Override
    public ILogin createLogin() {
        return new OracleLogin();
    }
}
