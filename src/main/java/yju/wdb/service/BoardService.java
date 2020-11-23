package yju.wdb.service;

import java.util.List;

import yju.wdb.domain.BoardVO;
import yju.wdb.domain.Criteria;

public interface BoardService {
	
	//게시글 등록
	public void register(BoardVO board);
	
	//게시글 조회
	public BoardVO get(int bno);
	
	//게시글 수정
	public void modify(BoardVO board);
	
	//게시글 삭제
	public void remove(int bno);
	
	//게시글 리스트
	//public List<BoardVO> getList(); 이건 전체 게시글을 가져오는 것
	public List<BoardVO> getList(Criteria crt);
	
	public int getTotal(Criteria crt);
	
}
