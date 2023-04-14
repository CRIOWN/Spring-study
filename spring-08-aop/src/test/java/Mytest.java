import com.criown.service.UserService;
import com.criown.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理代理的是接口！！ 不是实现类
        UserService userService = context.getBean("userService", UserService.class);
        userService.select();
    }
}
