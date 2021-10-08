package com.spring.professional.exam.tutorial.module04.question43.data.transfer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.professional.exam.tutorial.module04.question43.data.layer.FtpDataLayer;
import com.spring.professional.exam.tutorial.module04.question43.data.layer.HttpDataLayer;
import com.spring.professional.exam.tutorial.module04.question43.ds.Person;

@Component
public class DataTransferAction {

	private FtpDataLayer ftpDataLayer;
	
	private HttpDataLayer httpDataLayer;
	
	public DataTransferAction(final FtpDataLayer ftpDataLayer, final HttpDataLayer httpDataLayer) {
		this.ftpDataLayer = ftpDataLayer;
		this.httpDataLayer = httpDataLayer;	
	}
	
	public void transfer() {
		List<Person> personData = ftpDataLayer.getData();
		httpDataLayer.saveData(personData);
	}
}
