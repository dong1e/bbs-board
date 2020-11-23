package yju.wdb.domain;

import java.util.List;

public class ReplyPageDTO {

	private int replyCnt;	// 특정 게시글의 댓글 수
	private List<ReplyVO> list;	// 게시글의 댓글 리스트
	
	public ReplyPageDTO(int replyCnt, List<ReplyVO> list) {
		this.replyCnt = replyCnt;
		this.list = list;
	}

	public int getReplyCnt() {
		return replyCnt;
	}

	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}

	public List<ReplyVO> getList() {
		return list;
	}

	public void setList(List<ReplyVO> list) {
		this.list = list;
	}
}
