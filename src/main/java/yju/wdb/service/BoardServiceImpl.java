package yju.wdb.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

import yju.wdb.domain.BoardVO;
import yju.wdb.domain.Criteria;
import yju.wdb.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	private Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Autowired
	private BoardMapper mapper;
	
//	public BoardServiceImpl(BoardMapper mapper) {
//		this.mapper = mapper;
//	}
	
	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey(board);
		log.info("register.........");

	}

	@Override
	public BoardVO get(int bno) {
		
		log.info("get................" + bno); 
		return mapper.read(bno);
		
	}

	@Override
	public void modify(BoardVO board) {
		
		log.info("modify......." + board);
		mapper.update(board);

	}

	@Override
	public void remove(int bno) {

		log.info("remove......" + bno);
		mapper.delete(bno);

	}

	/*
	 * @Override public List<BoardVO> getList() {
	 * log.info("getList................."); return mapper.getList(); }
	 */

	@Override
	public List<BoardVO> getList(Criteria crt) {
		
		return mapper.getListWithPaging(crt);
		
	}

	@Override
	public int getTotal(Criteria crt) {
		log.info("get total count");
		return mapper.getTotalCount(crt);
	}

}
