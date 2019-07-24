package com.bridgelabz;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
//@RunWith(MockitoJUnitRunner.class)
class MathUtilTest {
//	@Rule
//	public MockitoRule mockrule=MockitoJUnit.rule();
	
	@Mock
	Calculator calculator;
	
	
	MathUtil mathUtil=null;
	
	@BeforeEach
	void mathUtilInstance() {
		MockitoAnnotations.initMocks(this);
		mathUtil=new MathUtil(calculator);
	}
	
	@Test
	void testAdd() {
		
		when(calculator.add(2, 3)).thenReturn(5);
		assertEquals(5,mathUtil.add(2, 3) );
		verify(calculator).add(2, 3);
	}

	@Test
	void testDivide() {
		when(calculator.devide(15, 3)).thenReturn(5);
		assertEquals(5,mathUtil.divide(15, 3));
		verify(calculator).devide(15, 3);
	}
	@Test
	void testMultiply() {
		
		when(calculator.multiply(15, 3)).thenReturn(45);
		assertEquals(45,mathUtil.multiply(15, 3));
		verify(calculator).multiply(15, 3);		
	}
}
