package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method : Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                try {
                    method.invoke(address);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                String type= method.getReturnType().toString();
                System.out.println(
                        "Method " + method.getName() + " returns a value of type " + getHumanableType(type));
            }
        }
        // END
    }

    static String getHumanableType(String text) {
        if (text.equals("class java.lang.String")) {
            return "String";
        }
        return text;
    }
}