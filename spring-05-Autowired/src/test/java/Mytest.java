import com.criown.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mytest {
    @Test
    public void test1()
    {
        ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
        People people =(People) context.getBean("people");

        people.getCat().shout();
        people.getDog().shout();
    }
}
