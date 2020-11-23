package yju.wdb.test;

import java.util.List;
import java.util.stream.IntStream;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import yju.wdb.domain.Criteria;
import yju.wdb.domain.ReplyVO;
import yju.wdb.mapper.ReplyMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMappeTest {
	
	Logger log = Logger.getLogger(BoardMapperTest.class);
	
	@Autowired
	private ReplyMapper mapper;
	
	//@Test
	public void testMapper() {
		log.info(mapper.getClass().getName());
	}
	
	// 댓글 insert
	//@Test
	public void testCreate() {
		IntStream.rangeClosed(1,10).forEach(i->{
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(12643);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer " + i);
			
			mapper.insert(vo);
		});
	}
	
	// 댓글 조회
	//@Test
	public void testRead() {
		int rno = 5;
		
		ReplyVO vo = mapper.read(rno);
		
		log.info(vo);
	}
	
	// 댓글 삭제
	//@Test
	public void testDelete() {
		int rno = 11;
		
		int result = mapper.delete(rno);
		
		log.info("#of deleted records : " + result);
	}
	
	// 댓글 수정
	//@Test
	public void testUpdate() {
		int rno = 10;
		
		ReplyVO vo = mapper.read(rno);
		log.info("수정전: " + vo);
		
		vo.setReply("Updated Reply");
		
		int result = mapper.update(vo);
		
		vo = mapper.read(rno);
		log.info("# of update records : " + result + ", 수정후: " + vo);
	}
	
	@Test
	public void testList() {
		Criteria crt = new Criteria(2, 10);
		
		List<ReplyVO> replies = mapper.getListWithPaging(crt, 12643);
		
		replies.forEach(reply -> log.info(reply));
	}
}
