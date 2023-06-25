package e0144_dmdev_level2_15_ReflectionAPI.model;

import java.lang.reflect.*;

public class ReflectionApiExample44 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        User44 user = new User44(25L, "Ivan", 24);
        testMethods(user);
//        testFields(user);
//        Class<? extends User> userClass = user.getClass();
//        Class<User> userClass1 = User.class;
//        System.out.println(userClass == userClass1);

//        testConstructor();
    }


    private static void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<User44> constructor = User44.class.getConstructor(Long.class, String.class);
        User44 petr = constructor.newInstance(5L, "Petr");
        System.out.println(petr);

    }

    private static void testFields(Object object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getSuperclass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(object);
            System.out.println(declaredField.getModifiers());
            System.out.println(Modifier.isPrivate(declaredField.getModifiers()));
            System.out.println(value);
        }
    }

    private static void testMethods(User44 user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = user.getClass().getDeclaredMethod("setName", String.class);
        method.invoke(user, "Sveta");
        System.out.println(user);
    }




    private class Test1 {


    }

    private static class Test3 {

    }

    private enum Test2 {

    }


}
