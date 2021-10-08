package com.spring.professional.exam.tutorial.module04.question43;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.spring.professional.exam.tutorial.module04.question43.data.layer.FtpDataLayer;
import com.spring.professional.exam.tutorial.module04.question43.data.layer.HttpDataLayer;
import com.spring.professional.exam.tutorial.module04.question43.data.transfer.DataTransferAction;
import com.spring.professional.exam.tutorial.module04.question43.ds.Person;

@SpringBootTest
public class DataTransferActionMockBeanTest {

	private static final List<Person> PERSON_LIST = Arrays.asList(new Person(1,"Test-1"),new Person(2, "Test-2"));
	
	@Autowired private DataTransferAction dataTransferAction;
	
	@MockBean private FtpDataLayer ftpDataLayer;
	
	@MockBean private HttpDataLayer httpDataLayer;
	
	@Test
	public void shouldTransferDataFromFtpToHttp() {
		
		when(ftpDataLayer.getData()).thenReturn(PERSON_LIST);
		dataTransferAction.transfer();
		verify(httpDataLayer,times(1)).saveData(PERSON_LIST);
	}
}
