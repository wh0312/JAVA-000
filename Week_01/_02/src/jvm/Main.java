package jvm;
import jvm.HelloClassLoader;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HelloClassLoader classLoader = new HelloClassLoader("src/jvm/Hello.xlass");
        try {
            Class<?> c = classLoader.findClass("Hello");
            c.getMethod("hello").invoke(c.newInstance());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
