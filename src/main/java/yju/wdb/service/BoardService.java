package yju.wdb.service;

import java.util.List;

import yju.wdb.domain.BoardVO;
import yju.wdb.domain.Criteria;

public interface BoardService {
	
	//�Խñ� ���
	public void register(BoardVO board);
	
	//�Խñ� ��ȸ
	public BoardVO get(int bno);
	
	//�Խñ� ����
	public void modify(BoardVO board);
	
	//�Խñ� ����
	public void remove(int bno);
	
	//�Խñ� ����Ʈ
	//public List<BoardVO> getList(); �̰� ��ü �Խñ��� �������� ��
	public List<BoardVO> getList(Criteria crt);
	
	public int getTotal(Criteria crt);
	
}
