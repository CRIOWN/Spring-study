# Spring-04-DI注入
1. 依赖注入

```xml
        <property name="name" value="宋天玥"></property>
        <!--ref 引用beans.xml中已经声明的类-->
        <property name="address" ref="address"/>

```
```xml
       <!--数组注入-->
        <property name="books">
            <array>
                <value>红楼梦</value>
                <value>西游记</value>
                <value>水浒传</value>
                <value>三国志</value>
            </array>
        </property>
```
```xml
     <!--List注入-->
        <property name="hobbys">
          <list>
              <value>听歌</value>
              <value>读书</value>
              <value>跳舞</value>
          </list>
        </property>

```
```xml
<!--map注入-->
        <property name="card">
            <map>
                <entry key="身份证" value="111"/>
                <entry key="银行卡" value="222"/>
                <entry key="学生证" value="333"/>
            </map>
        </property>
```
```xml
       <!--Set注入-->
        <property name="games">
            <set>
                <value>LOL</value>
                <value>CSGO</value>
                <value>COC</value>
            </set>
        </property>
        <!--空值-->
        <property name="wife">
            <null/>
        </property>
```
        
 ```xml
         <!--properties注入-->
<property name="info">
    <props>
        <prop key="学号">201910311123</prop>
        <prop key="url">qweqweqwe</prop>
        <prop key="username">sty</prop>
        <prop key="password">123456</prop>
    </props>
</property>
 ```
2. C/P命名空间注入

```xml
<!--xmlns:p="http://www.springframework.org/schema/p"-->
<bean id="user" class="com.criown.pojo.User" p:name="宋天玥"  p:age="18" ></bean>
```
P ：porperty 属性 可以直接注入类属性的值  （需要无参构造器或者默认）

```xml
<!--xmlns:c="http://www.springframework.org/schema/c"-->
<bean id="user2" class="com.criown.pojo.User" c:age="18" c:name="加载"></bean>
```
C: construct 可以通过构造器进行有参注入  
_CP命名空间需要导入约束才能使用_

# Spring-05-bean作用域
singleton  单例模式（默认） 只会创建一个对象         
prototype  原型模式 每次get都会创建一个对象         
request session application websocket用于web MVC