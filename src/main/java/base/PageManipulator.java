package base;

import com.codeborne.selenide.Selenide;

public class PageManipulator {

    public static <T> T at(Class<T> pageClass) {
        return Selenide.page(pageClass);
    }

   /* public static <T extends Pages> T goTo(Class<T> pageClass) {
        return Selenide.page(pageClass).get();
    }*/
}