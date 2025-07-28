package karinzz.spring.core.data.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.ArrayList;
import java.util.List;

/**
 * DoubletonScope adalah sebuah kustom scope yang mengizinkan hanya dua instance dari bean yang dikelola dalam konteks Spring.
 * Dima scope ini, pertama kali di buat pada saat pertama kali diakses, dan yang kedua ketika bean di panggil.
 * Jika ada permintaan ketiga, maka akan mengembalikan instance pertama.
  */

public class DoubletonScope implements Scope {

    private List<Object> objects = new ArrayList<>(2);
    private Long counter = -1L;

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        counter++;

//        cek jika sudah ada dua objek
        if (objects.size() == 2) {
            int index = (int) (counter % 2);
            return objects.get(index);
        } else {
            // Jika belum ada dua objek, buat objek baru
            Object object = objectFactory.getObject();
            objects.add(object);
            return object;
        }
    }

    @Override
    public Object remove(String name) {
        if (!objects.isEmpty()) {
           return objects.remove(0);
        }
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "";
    }
}
