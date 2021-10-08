package com.spring.professional.exam.tutorial.module04.question43;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.professional.exam.tutorial.module04.question43.data.layer.FtpDataLayer;
import com.spring.professional.exam.tutorial.module04.question43.data.layer.HttpDataLayer;
import com.spring.professional.exam.tutorial.module04.question43.data.transfer.DataTransferAction;
import com.spring.professional.exam.tutorial.module04.question43.ds.Person;

@SpringBootTest
public class DataTransferActionManualMockInjectionTest {

	private static final List<Person> PERSON_LIST = Arrays.asList(new Person(1,"Test-1"),new Person(2, "Test-2"));
	
	private DataTransferAction dataTransferAction;
	@Mock private FtpDataLayer ftpDataLayer;
	@Mock private HttpDataLayer httpDataLayer;
	
	@BeforeEach
	public void setUp() {
		dataTransferAction = new DataTransferAction(ftpDataLayer, httpDataLayer);
	}
	
	@Test
	public void shouldTransferDataFromFtpToHttp() {
		
		when(ftpDataLayer.getData()).thenReturn(PERSON_LIST);
		
		dataTransferAction.transfer();
		
		verify(httpDataLayer, times(1)).saveData(PERSON_LIST);
	}
	
}
