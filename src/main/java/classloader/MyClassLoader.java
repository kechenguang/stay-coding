package classloader;

import sun.misc.Launcher;



public class MyClassLoader extends ClassLoader {


    public static void main(String[] args) {

        ClassLoader classLoader = Launcher.getLauncher().getClassLoader();
        Object o = new Object();
        try {
            classLoader.loadClass("sun.misc.Launcher");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
