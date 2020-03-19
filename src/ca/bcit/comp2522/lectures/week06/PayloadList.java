package ca.bcit.comp2522.lectures.week06;

import java.util.List;

/**
 * Payload list.
 *
 * @author Chloe Glave
 * @version 2020
 */
public interface PayloadList<E, P> extends List<E> {
    @Override
    E get(int index);

    @Override
    E set(int index, E element);
}
