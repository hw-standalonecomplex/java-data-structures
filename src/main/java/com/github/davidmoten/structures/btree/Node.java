package com.github.davidmoten.structures.btree;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Optional;

interface Node<T extends Serializable & Comparable<T>> {

    /**
     * Adds the element t to the node. If root node of BTree is changed then
     * returns new root node otherwise returns {@link Optional}.absent().
     * 
     * @param t
     * @return
     */
    Optional<Node<T>> add(T t);

    Optional<Node<T>> add(Key<T> key);

    /**
     * Returns the T matching t from this node or its children. Returns
     * {@link Optional}.absent() if not found.
     * 
     * @param t
     * @return
     */
    Optional<T> find(T t);

    /**
     * Marks all keys as deleted that equal t.
     * 
     * @param t
     * @return
     */
    long delete(T t);

    List<? extends Key<T>> getKeys();

    void setFirst(Optional<Key<T>> first);

    Optional<Key<T>> bottomLeft();

    Iterator<T> iterator();

    String keysAsString();

    Optional<KeySide<T>> getParentKeySide();

    void setParentKeySide(Optional<KeySide<T>> parentKeySide);

    String toString(String space);

    void save();

    long getPosition();

}