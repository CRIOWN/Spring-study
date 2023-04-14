import com.criown.config.CriownConfig;
import com.criown.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Mytest
{
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(CriownConfig.class);
        User user = (User) context.getBean("getUser");
        System.out.println(user.getName());
    }
}
