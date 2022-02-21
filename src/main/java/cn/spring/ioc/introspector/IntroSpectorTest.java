package cn.spring.ioc.introspector;

import cn.spring.ioc.bean.TestBean;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author nizy
 * @date 2021/9/30 下午4:41
 */
public class IntroSpectorTest {

    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(TestBean.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : pds) {
                System.out.println(propertyDescriptor.getName() + "->" + propertyDescriptor);
                propertyDescriptor.getReadMethod();
                propertyDescriptor.getWriteMethod();
            }
        } catch (Exception e) {

        }
    }
}
