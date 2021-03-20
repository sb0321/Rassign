package org.rsupport.controller.register;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsupport.config.RootConfig;
import com.rsupport.config.ServletConfig;
import com.rsupport.domain.member.Member;
import com.rsupport.domain.member.MemberRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class, ServletConfig.class})
public class RegisterAPIControllerTests {
	
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Autowired
	private MemberRepository MemberRepository;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	@Transactional
	public void testRegisterUserCheck() throws Exception {
		
		// 중복된 아이디가 없을 때
		MvcResult result = mockMvc.perform(post("/register/check")
				.param("memberID", "test"))
		.andDo(print())
		.andExpect(status().isOk())
		.andReturn();
		
		String json = result.getResponse().getContentAsString();
		Boolean success = new ObjectMapper().readValue(json, Boolean.class);
		
		assertEquals(false, success);
		
		MemberRepository.save(Member
				.builder()
				.memberID("test")
				.password("password")
				.nickname("testNickname")
				.build());
		
		// 중복된 아이디가 있을 때
		MvcResult result2 = mockMvc.perform(post("/register/check")
				.param("memberID", "test"))
		.andDo(print())
		.andExpect(status().isOk())
		.andReturn();
		
		json = result2.getResponse().getContentAsString();
		success = new ObjectMapper().readValue(json, Boolean.class);
		
		assertEquals(true, success);
	}
	
	@Test
	@Transactional
	public void testRegisterMember() throws Exception {
		
		mockMvc.perform(post("/register")
				.param("memberID", "test")
				.param("password", "password")
				.param("nickname", "nickname"))
		.andDo(print())
		.andExpect(status().isOk())
		.andReturn();
		
		assertEquals(true, MemberRepository.exists("test"));
		
	}
	
	

}
