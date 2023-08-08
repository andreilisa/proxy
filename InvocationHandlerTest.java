import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

/**
 * @author Andrei Lisa
 * @created 08/08/2023 - 16:18
 */
public class InvocationHandlerTest implements InvocationHandler {

  private final List proxied;

  public InvocationHandlerTest(List proxied) {
    this.proxied = proxied;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    if (method.getName().startsWith("remove") ||
        method.getName().startsWith("contains") ||
        method.getName().startsWith("equals")) {
      return false;
    }
    return method.invoke(proxied,  args);
  }
}
