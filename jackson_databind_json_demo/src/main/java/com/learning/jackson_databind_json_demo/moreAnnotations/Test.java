package com.learning.jackson_databind_json_demo.moreAnnotations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static void main(String[] args) throws JsonProcessingException {
		ExtendableBean bean = new ExtendableBean();
		
		bean.setId(1001);
		bean.setName("My Bean");
		bean.add("attr_1", "val_1");
		bean.add("attr_2", "val_2");
		bean.setSomeStr("{\"value\":false}");
		
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.writeValueAsString(bean);
		
		System.out.println(result);
		
		ExtendableBean bean1 = mapper.readValue(result, ExtendableBean.class);
		
		System.out.println(bean1);
	}

}
