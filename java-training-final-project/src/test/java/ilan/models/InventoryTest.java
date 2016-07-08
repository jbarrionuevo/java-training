package ilan.models;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import org.junit.Test;
import org.neo4j.cypher.internal.compiler.v2_0.ast.IsNotNull;

import ilan.enums.Gender;

public class InventoryTest {

	@Test
	public void testCreation() {
		Inventory test = new Inventory();
		assertThat("Inventory wasnt correctly instantiated",test.getStock(),is(notNullValue()));
	}

}
