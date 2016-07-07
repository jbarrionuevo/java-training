package ilan.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.neo4j.cypher.internal.compiler.v2_2.ast.IsNotNull;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.when;

public class CaseOrderTest {

	@Mock
	ThirdPartyParticipant thirdPartyParticipantMock;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
		when(thirdPartyParticipantMock.getName()).thenReturn("customer");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation() {
		new CaseOrder(null,null,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation2() {
		new CaseOrder(new HashMap<Long,Integer>(),null,null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation3() {
		new CaseOrder(new HashMap<Long,Integer>(),new Date(),null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation4() {
		new CaseOrder(new HashMap<Long,Integer>(),null,thirdPartyParticipantMock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation5() {
		new CaseOrder(null,new Date(),null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation6() {
		new CaseOrder(null,new Date(),thirdPartyParticipantMock);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFailedCreation7() {
		new CaseOrder(null,null,thirdPartyParticipantMock);
	}
	
	@Test
	public void testCreation() {
		CaseOrder test = new CaseOrder(new HashMap<Long,Integer>(),new Date(),thirdPartyParticipantMock);
		assertThat("Case Device wasnt correctly instantiated",test.getDateOfRequest(),is(notNullValue()));
		assertThat("Case Device wasnt correctly instantiated",test.getThirdPartyParticipant().getName(),is("customer"));
		assertThat("Case Device wasnt correctly instantiated",test.getRequestCases().size(),is(0));
	}
	


}
