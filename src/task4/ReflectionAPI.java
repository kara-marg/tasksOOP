package task4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ReflectionAPI {

    public static String getInformationAboutClass(Class cls) {
        StringBuilder result = new StringBuilder("");
        result.append(cls.getName() + "\n");
        setInResultInformationAboutFields(cls, result);
        setInResultInformationAboutConstructors(cls, result);
        setInResultInformationAboutMethods(cls, result);
        setInResultInformationAboutSuperClassesAndInterfaces(cls, result);
        return result.toString();
    }

    private static void setInResultInformationAboutFields(Class cls, StringBuilder result) {
        result.append("Information about fields:\n");
        Stream.of(cls.getDeclaredFields()).map(f->f.toGenericString()).forEach(s->result.append("\t"+s+"\n"));
//        Field[] fields = cls.getDeclaredFields();
//        for (Field currentField : fields) {
//            result.append("\t" + parseWithoutPackagePath(currentField.toGenericString()) + "\n");
//        }
    }

//    private static String parseWithoutPackagePath(String field) { //private static int main.java.ua.com.mykola.task4.A.f (e.g.) -> private static int f
//        return field.substring(0, field.lastIndexOf(" ")) + " " + field.substring(field.lastIndexOf(".") + 1);
//    }

    private static void setInResultInformationAboutConstructors(Class cls, StringBuilder result) {
        result.append("Information about constrictors:\n");
        Stream.of(cls.getDeclaredConstructors()).map(f->f.toGenericString()).forEach(s->result.append("\t"+s+"\n"));
//        Field[] fields = cls.getDeclaredFields();
//        for (Field currentField : fields) {
//            result.append("\t" + parseWithoutPackagePath(currentField.toGenericString()) + "\n");
//        }
    }
    private static void setInResultInformationAboutMethods(Class cls, StringBuilder result) {
        result.append("Information about methods:\n");
        Stream.of(cls.getDeclaredMethods()).map(f->f.toGenericString()).forEach(s->result.append("\t"+s+"\n"));
//        Method[] methods = cls.getDeclaredMethods();
//        for (Method currentMethod : methods) {
//            result.append("\t" + parseWithoutPackagePath(currentMethod.toGenericString()) + "\n");
//        }
    }

    private static void setInResultInformationAboutSuperClassesAndInterfaces(Class cls, StringBuilder result) {
        Set<Class> setOfSuperClassesAndInterfaces = new HashSet<>();
        recursionFindSuperClassesAndInterfaces(cls, setOfSuperClassesAndInterfaces);
        setOfSuperClassesAndInterfaces.remove(cls);
        result.append("Interfaces:\n");
        setOfSuperClassesAndInterfaces.stream().filter(c -> c.isInterface()).map(i -> i.getName()).forEach(s->result.append("\t"+s+"\n"));
        result.append("Classes:\n");
        setOfSuperClassesAndInterfaces.stream().filter(c -> !c.isInterface()).map(i -> i.getName()).forEach(s->result.append("\t"+s+"\n"));
    }

    private static void recursionFindSuperClassesAndInterfaces(Class cls, Set<Class> setOfSuperClassesAndInterfaces) {
        if (cls == null) {
            return;
        }
        setOfSuperClassesAndInterfaces.add(cls);
        recursionFindSuperClassesAndInterfaces(cls.getSuperclass(), setOfSuperClassesAndInterfaces);
        for (Class currentClass : cls.getInterfaces()) {
            recursionFindSuperClassesAndInterfaces(currentClass, setOfSuperClassesAndInterfaces);
        }
    }



}

