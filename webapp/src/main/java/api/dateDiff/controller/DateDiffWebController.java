package api.dateDiff.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import api.dateDiff.model.DateDiff;
import api.dateDiff.service.DateDiffWebServiceImpl;

@RestController
@RequestMapping(value = "/dateDiff")
public class DateDiffWebController {
	@Autowired
	DateDiffWebServiceImpl dateDiffWebServiceImpl;

	@RequestMapping(value = "/calcDiff", method = RequestMethod.POST, consumes = { "application/json" })
	public DateDiff calcDiff(@RequestBody DateDiff dateDiff) throws IllegalAccessException, InvocationTargetException, JsonMappingException, JsonProcessingException {
		return dateDiffWebServiceImpl.calculateDifference(dateDiff);
	}

}
