package yju.wdb.domain;

import java.util.Date;

/*VO�� Read Only�� ���ȴ�. ex) db Table�� ����� ���ڵ带 �ڹٰ�ü�� ��Ÿ����
DTO�� �Ķ���͸� �����ϴ� �뵵*/
public class BoardVO {

	private int bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updatedate;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	
	public String toString() {
		return "bno[" + bno + "], title[" + title + "], writer[" + writer + "], content[" + content + "]";
	}
	
}
