package com.github.davidmoten.structures.btree;

import static com.google.common.base.Optional.of;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.google.common.base.Optional;

public class NodeRef<T extends Serializable & Comparable<T>> implements
		Node<T>, Serializable {

	private static final long serialVersionUID = -420236968739933117L;

	private final long position;

	private transient Optional<Node<T>> node = Optional.absent();
	private final transient BTree<T> btree;
	private final transient Optional<KeySide<T>> parentKeySide;

	public NodeRef(BTree<T> btree, long position,
			Optional<KeySide<T>> parentKeySide) {
		this.parentKeySide = parentKeySide;
		this.btree = btree;
		this.position = position;
	}

	private synchronized Node<T> node() {
		if (!node.isPresent()) {
			node = of((Node<T>) new NodeActual<T>(btree, parentKeySide));
		}
		return node.get();
	}

	@Override
	public Optional<Node<T>> add(T t) {
		return node().add(t);
	}

	@Override
	public Optional<Node<T>> add(Key<T> key) {
		return node().add(key);
	}

	@Override
	public Optional<T> find(T t) {
		return node().find(t);
	}

	@Override
	public long delete(T t) {
		return node().delete(t);
	}

	@Override
	public List<? extends Key<T>> getKeys() {
		return node().getKeys();
	}

	@Override
	public void setFirst(Optional<Key<T>> first) {
		node().setFirst(first);
	}

	@Override
	public Optional<Key<T>> bottomLeft() {
		return node().bottomLeft();
	}

	@Override
	public Iterator<T> iterator() {
		return node().iterator();
	}

	@Override
	public String keysAsString() {
		return node().keysAsString();
	}

	@Override
	public Optional<KeySide<T>> getParentKeySide() {
		return node().getParentKeySide();
	}

	@Override
	public void setParentKeySide(Optional<KeySide<T>> parentKeySide) {
		node().setParentKeySide(parentKeySide);
	}

	@Override
	public String toString(String space) {
		return node().toString(space);
	}

}