package article.command;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import article.model.Article;
import article.service.WriteArticleService;
import member.service.User;
import mvc.command.CommandHandler;

public class WriteArticleHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/views/letter/newArticleForm.jsp";
	private WriteArticleService writeService = new WriteArticleService();
	private static String ARTICLE_IMAGE_REPO = "C:\\board\\article_image";

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("4. " + this.getClass() + ">> req.getMethod() >>>> " + req.getMethod());
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			System.out.println("4. " + this.getClass() + ">> req.getMethod() >>>> " + req.getMethod());
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Map<String, String> articleMap = upload(req, res);
		String title = articleMap.get("title");
		String content = articleMap.get("content");
		String nickname = articleMap.get("nickname");
		String imageFileName = articleMap.get("imageFileName");

		User user = (User) req.getSession(false).getAttribute("authUser");
		String member_id = user.getId();
		
		Article letter = new Article();
		letter.setMember_id(member_id);
		letter.setTitle(title);
		letter.setContent(content);
		letter.setNickname(nickname);
		letter.setPhoto(imageFileName);
		
		int newArticleNo = writeService.write(letter);

		req.setAttribute("newArticleNo", newArticleNo);
		
		//업로드 파일이 있을 경우 upoad 메소드를 통해 temp에 저장 - 저장된 파일을 다시 articleNO로 생성한 폴더로 이동
		if (imageFileName != null && imageFileName.length() != 0) {
			File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
			File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + newArticleNo);
			destDir.mkdirs();
			FileUtils.moveFileToDirectory(srcFile, destDir, true);
		}
		//저장 완료 후 스크립트를   response에 스크립트 붙여서 게시글 목록 보여주는 페이지로 이동시킴
		PrintWriter pw = res.getWriter();
		pw.print("<script>" + "  alert('저장 성공');" + " location.href='" + req.getContextPath()
				+ "/article/list.do';" + "</script>");

		return null;
		 
	}

	// 글쓰기 폼의 내용을 처리 - 폼 매개변수를 맵에 저장하여 반환, 업로드 파일을 임시 경로에 저장
	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 폼에서 전달된 파라미터 이름을 키로, 값으로 값으로 저장하기 위한 맵
		Map<String, String> articleMap = new HashMap<String, String>();
		String encoding = "utf-8";
		// 사진 최종 저장 경로
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		// 사진 저장해주는 라이브러리 객체 생성(아파치 commons-fileupload-1.3.3.jar) 및 설정
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		// 파일 업로드용 객체에 설정 파일 등록
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			// request를 파일 업로드용 객체의 해석 메소드를 이용하여 리스트로 만듬
			List items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				} else {
					System.out.println("사진 이름:" + fileItem.getFieldName());
					System.out.println("사진 크기:" + fileItem.getSize() + "bytes");
					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						System.out.println("fileItem.getName() >>>>>>>>>> " + fileItem.getName());
						String fileName = fileItem.getName().substring(idx + 1);
						System.out.println("파일명:" + fileName);
						articleMap.put(fileItem.getFieldName(), fileName); 

						File uploadFile = new File(currentDirPath + "\\temp\\" + fileName);
						fileItem.write(uploadFile);

					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 폼에서 넘어온 매개변수들을 저장한 맵 반환
		return articleMap;
	}

}
