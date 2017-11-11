package com.ffdc.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class AWSController {

 	  @RequestMapping("/redis/del/{id}")
	  @ResponseBody
	  public Long redisDel(@PathVariable("id") String id)   {

		  return  5L;

	  }



}
