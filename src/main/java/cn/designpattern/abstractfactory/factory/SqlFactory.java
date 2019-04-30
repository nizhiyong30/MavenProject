package cn.designpattern.abstractfactory.factory;

import cn.designpattern.abstractfactory.login.ILogin;
import cn.designpattern.abstractfactory.user.IUser;

public interface SqlFactory {
    public IUser createUser();
    public ILogin createLogin();
}
