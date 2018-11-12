package p02reflection2;


import utility.UserInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Part02Runner {

    public void run() {

        try {
            Class<?> clazz = UnaryArithmeticOperation.class;

            Constructor<?> constructor = clazz.getConstructor(Double.TYPE);

            UnaryArithmeticOperation reflectUAO = (UnaryArithmeticOperation) constructor.newInstance(6.0);

            System.out.println(UserInterface.BORDER);
            System.out.println(reflectUAO);
            System.out.println();

            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);

            Method[] methods = clazz.getMethods();

            Method setV = null;
            Method toString = null;
            Method incr = null;
            Method decr = null;
            Method viceVersa = null;

            for (Method m : methods) {
                if (m.getName().startsWith("set")) {
                    setV = m;
                }
                if (m.getName().startsWith("incr")) {
                    incr = m;
                }
                if (m.getName().startsWith("decr")) {
                    decr = m;
                }
                if (m.getName().startsWith("vice")) {
                    viceVersa = m;
                }
                if (m.getName().startsWith("toSt")) {
                    toString = m;
                }
            }

            System.out.println("Invoke set:");
            setV.invoke(reflectUAO, 100.0);
            System.out.println("field=" + field.getDouble(reflectUAO));

            System.out.println("Invoke increment:");
            incr.invoke(reflectUAO);
            System.out.println("field=" + field.getDouble(reflectUAO));

            System.out.println("Invoke viceVersa:");
            viceVersa.invoke(reflectUAO);
            System.out.println("field=" + field.getDouble(reflectUAO));

            System.out.println("Invoke decrement:");
            decr.invoke(reflectUAO);
            System.out.println("field=" + field.getDouble(reflectUAO));

            System.out.println("Invoke toString:");
            System.out.println(toString.invoke(reflectUAO));

            System.out.println(UserInterface.BORDER);


        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

}
