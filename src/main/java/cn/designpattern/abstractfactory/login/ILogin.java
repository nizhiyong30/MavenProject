package cn.designpattern.abstractfactory.login;

/**
 * Created by nizy on 2019/4/2.
 */
public interface ILogin {
    public void insert(Login login);
    public Login getLogin(int id);
}
