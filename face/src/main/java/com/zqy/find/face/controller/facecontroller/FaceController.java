package com.zqy.find.face.controller.facecontroller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.zqy.exceptionHandle.exception.JsonRuntimeException;
import com.zqy.find.face.model.SearchFace;
import com.zqy.find.face.service.faceService.SearchService;
import com.zqy.find.face.service.faceService.TrainService;
@RestController
@EnableAutoConfiguration
@RequestMapping("/face")
public class FaceController {
	@Autowired
	private TrainService trainService;
	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value ="/train",method=RequestMethod.GET)
	public void train(HttpServletRequest request){

		// 定义解析器去解析request  
        CommonsMultipartResolver mutilpartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //request如果是Multipart类型、  
        if (mutilpartResolver.isMultipart(request)) {  
            //强转成 MultipartHttpServletRequest  
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;  
            //获取文件名  
            Iterator<String> it = multiRequest.getFileNames();  
            while (it.hasNext()) {  
                //获取MultipartFile类型文件  
                MultipartFile fileDetail = multiRequest.getFile(it.next());  
                if (fileDetail != null) {  
                    String fileName = "demoUpload" + fileDetail.getOriginalFilename();  
                    String path = "D:/" + fileName;  
                    File localFile = new File(path);  
                    try {
						fileDetail.transferTo(localFile);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}  
                     
                }  
            }  
        }  
		
		File file = new File("E:/face/image");
		String[] imgPaths = file.list();
		int size = imgPaths.length;
		int[] flag = new int[size];
		for(int i=0;i<size;i++){
			flag[i] = Integer.parseInt(imgPaths[i].substring(0, 1));
			imgPaths[i] = "E:/face/image/" +imgPaths[i];
		}
		try {
			trainService.trainAndSave(flag, imgPaths);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JsonRuntimeException("出错了");
		}
	}
	@RequestMapping(value ="/search",method=RequestMethod.GET)
	@ResponseBody
	public List<SearchFace> search(HttpServletResponse res){
		List<SearchFace>  list = null;
		try {
		  list = searchService.searchFace(10,"E:/face/image/4_1.jpg");
		} catch (Exception e) {
			e.printStackTrace();
			throw new JsonRuntimeException("出错了");
		}
		return list;
	}
}
