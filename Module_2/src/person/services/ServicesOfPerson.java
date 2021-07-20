package person.services;

import java.util.List;

public interface ServicesOfPerson<E> {
    boolean add(E e);
    boolean edit(E e,int index);
    boolean delete(int index);
    List<E> list();
    E inputAddOrEdit();
}
