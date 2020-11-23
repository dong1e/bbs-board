package yju.wdb.bbs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import yju.wdb.domain.SampleVO;
import yju.wdb.domain.Ticket;

@RestController
@RequestMapping("/rest")
public class SampleRestController {
	
	Logger log = LoggerFactory.getLogger(SampleRestController.class);
	
	
	// 단순 문자 리턴
	@GetMapping(value="/getText", produces="text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE: " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요?";
	}
	
	
	// 객체 리턴
	@GetMapping(value="/getSample", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	
	// collection 타입의 객체를 리턴
	@GetMapping(value="/getList")
	public List<SampleVO> getList() {
		
		//return IntStream.range(1,10).mapToObj(i-> new SampleVO(i, i + "First", i + "Last")).collect(Collectors.toList());
		
		List<SampleVO> list = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list.add(new SampleVO(i, i + "First", i + "Last"));
		}
		return list;
	}
	
	
	// 정상적인 데이터인지 비정상적인 데이터인지 제공하면 좋겠다 싶을 때 사용하는  "ResponseEntity<>"
	// 상태정보를 같이 보낼 수 있다.
	@GetMapping(value="/check", params= {"height", "weight"})
	public ResponseEntity<SampleVO> check(int height, int weight) {
		SampleVO vo = new SampleVO(0, "" + height, "" + weight);
		
		ResponseEntity<SampleVO> result = null;
		
		if (height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo);
		}
		else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat, @PathVariable("pid") int pid) {
		return new String[] {"category: " + cat, "product id: " + pid};
	}
	
	
	@PostMapping("/ticket")
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert.............ticket: " + ticket);
		return ticket; 
	}
	
}
