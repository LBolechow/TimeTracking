package pl.lukbol.TimeTracking;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.lukbol.TimeTracking.controllers.WorkdayController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TimeTrackingApplicationTests {
	@Autowired
	private MockMvc mvc;
	@Autowired
    WorkdayController controller;


	@Test
	public void contextLoads() {
		Assertions.assertThat(controller).isNotNull();
	}
	@Test
	public void AddWorkDay() throws Exception {
		this.mvc.perform(post("/workdays")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"date\": \"2023\"}"))
				.andDo(print())
				.andExpect(status().is2xxSuccessful());

	}
	@Test
	public void GetWorkdays() throws Exception {
		this.mvc
				.perform(MockMvcRequestBuilders.get("/workdays"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void UpdateWorkDay() throws Exception {
		this.mvc.perform(put("/workdays/2")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"date\": \"2003\"}"))
				.andDo(print())
				.andExpect(status().is2xxSuccessful());
	}

	@Test
	public void DeleteWorkDay() throws Exception {
		mvc.perform(MockMvcRequestBuilders.delete("/workdays/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}
	@Test
	public void AddTimeEntry() throws Exception {
		this.mvc.perform(post("/workdays/1/entries")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{\"description\": \"dsasda\", \"time_spent\": 1234}"))
				.andDo(print())
				.andExpect(status().is2xxSuccessful());

	}
	@Test
	public void GetEntriesFromWorkDay() throws Exception {
		this.mvc
				.perform(MockMvcRequestBuilders.get("/workdays/1/entries"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}



}
