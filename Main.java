
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Andrei Lisa
 * @created  08/08/2023 - 16:17
 */
public class Main {

  public static void main(String[] args) {
    var proxy = (List) Proxy.newProxyInstance(InvocationHandlerTest.class.getClassLoader(),
        new Class[] {List.class, Set.class},
        new InvocationHandlerTest(new ArrayList()));

    proxy.add("Barney");
    proxy.add("Homer");
    proxy.add("Moe");
    proxy.add("Moe");
    proxy.remove("Homer");
    proxy.remove("Moe");
    proxy.add(proxy.contains("Homer"));
    proxy.add(proxy.equals(proxy));

    System.out.println(proxy);

  }
}
