package yju.wdb.exception;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model) {
		
		System.out.println("Exception Handler except invoked");
		model.addAttribute("exception", ex);
		
		return "sample/error_page";
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handler404(NoHandlerFoundException ex) {
		
		return "sample/custom404";
		
	}
	
//	@ExceptionHandler(NullPointerException.class)
//	public String except2() {
//		
//		return "";
//		
//	}
	
}
