package jvm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class HelloClassLoader extends ClassLoader{
    private String classPath;
    HelloClassLoader(String path)
    {
        classPath = path;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            FileInputStream fileForInput = new FileInputStream(classPath);
            byte[]   bytes   =   new   byte[fileForInput.available()];
            fileForInput.read(bytes);
            for(int i = 0; i < bytes.length; i++)
            {
                bytes[i] = (byte) (255-(int)bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
