package yju.wdb.bbs;

import java.io.File;

import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload/*")
public class UploadController {

	Logger log = LoggerFactory.getLogger(UploadController.class);
	
	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload form");
	}
	
	@PostMapping("/uploadFormAction") 
	public void uploadFormPost(MultipartFile[] uploadFiles, Model model) {
		
			log.info("updad form action....");
			
			String uploadFolder = "D:\\sw\\workspace\\files";
			
			log.info("uploadFiles.length: " + uploadFiles.length);
			
			for(MultipartFile multipartFile : uploadFiles) {
				log.info("================================");
				log.info("Upload file Name : " + multipartFile.getOriginalFilename());
				log.info("Upload file Size : " + multipartFile.getSize());
				
				File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
				
				try {
					
					multipartFile.transferTo(saveFile);
					
				} catch(Exception e) {
					log.error(e.getMessage());
				}
			}
	}
	
	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax");
	}
	
	@PostMapping("/uploadAjaxAction") 
	public void uploadAjaxPost(MultipartFile[] uploadFiles, Model model) {
		
			log.info("updad Ajax action....");
			
			String uploadFolder = "D:\\sw\\workspace\\files";
			
			log.info("uploadFiles.length: " + uploadFiles.length);
			
			for(MultipartFile multipartFile : uploadFiles) {
				log.info("================================");
				log.info("Upload file Name : " + multipartFile.getOriginalFilename());
				log.info("Upload file Size : " + multipartFile.getSize());
				
				String uploadFileName = multipartFile.getOriginalFilename();
				
				// considering IE
				uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
				
				log.info("file name(pathe excluded) : " + uploadFileName);
				
				File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
				
				try {
					
					multipartFile.transferTo(saveFile);
					
				} catch(Exception e) {
					log.error(e.getMessage());
				}
			}
	}
}
