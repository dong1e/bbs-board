package yju.wdb.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("select now() from dual")
	public String getTime();
	
	// xml ¹æ½Ä
	public String getTime2();
	
}
