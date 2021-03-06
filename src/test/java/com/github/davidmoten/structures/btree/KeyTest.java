package com.github.davidmoten.structures.btree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.base.Optional;

public class KeyTest {

	@Test
	public void testHasChild() {
		NodeLoader<Double> n = new NodeLoader<Double>() {

			@Override
			public void load(NodeRef<Double> node) {

			}

		};
		Optional<NodeRef<Double>> absent = Optional.absent();

		Key<Double> k = new Key<Double>(1.0);
		NodeRef<Double> left = new NodeRef<Double>(n,
				Optional.<Position> absent(), 3, false);
		NodeRef<Double> right = new NodeRef<Double>(n,
				Optional.<Position> absent(), 3, false);

		assertFalse(k.hasChild());
		k.setLeft(Optional.of(left));
		k.setRight(absent);
		assertTrue(k.hasChild());
		k.setLeft(absent);
		k.setRight(Optional.of(right));
		assertTrue(k.hasChild());
		k.setLeft(Optional.of(left));
		k.setRight(Optional.of(right));
		assertTrue(k.hasChild());
	}
}
