package annotation2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by WUHamster on 27.05.2016.
 * 2. Написать класс TextContainer, который содержит в себе строку. С помощью механизма аннотаций указать
 1) в какой файл должен сохраниться текст 2) метод, который выполнит сохранение. Написать класс Saver,
 который сохранит поле класса TextContainer в указанный файл.
 @SaveTo(path=“c:\\file.txt”)
 class Container {
 String text = “…”;
 @Saver
 public void save(..) {…}
 }
 */
public class Main {

  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
   TextContainer container = new TextContainer();
   Class<?> cls = container.getClass();
   if (cls.isAnnotationPresent(SaveTo.class)) {
    Method[] methods = cls.getMethods();
    for (Method method : methods) {
     if (method.isAnnotationPresent(Saver.class)) {
      SaveTo annotation = cls.getAnnotation(SaveTo.class);
      method.invoke(container, annotation.adress());
     }
    }
   }

  }

}
