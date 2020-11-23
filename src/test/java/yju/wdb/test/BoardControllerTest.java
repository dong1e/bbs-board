package yju.wdb.test;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)

// ��Ʈ�ѷ��� test�ϱ����� �ʿ��� ������̼�
@WebAppConfiguration

@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BoardControllerTest {

	Logger log = Logger.getLogger(BoardControllerTest.class);
	
	@Autowired
	private WebApplicationContext ctx;
	
	// moc=��¥
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	//@Test
	public void testList() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn().getModelAndView()
				.getModelMap());
	}
	
	//@Test
	public void testRegister() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "�ؽ�Ʈ ���� ����")
				.param("content", "�ؽ�Ʈ ���� ����")
				.param("writer", "user00")).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	//@Test
	public void testModify() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "7")
				.param("title", "������ �ؽ�Ʈ ���� ����")
				.param("content", "������ �ؽ�Ʈ ���� ����")
				.param("writer", "user00")).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	//@Test
	public void testRemove() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "7")).andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	@Test
	public void testListPaging() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")
				.param("pageNum", "1").param("amount", "10"))
				.andReturn().getModelAndView().getModelMap());
	}
}
