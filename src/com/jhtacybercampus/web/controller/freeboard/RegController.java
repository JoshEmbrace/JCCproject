package com.jhtacybercampus.web.controller.freeboard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jhtacybercampus.web.dao.FreeBoardDao;
import com.jhtacybercampus.web.dao.FreeboardFileDao;
import com.jhtacybercampus.web.dao.oracle.OracleFreeBoardDao;
import com.jhtacybercampus.web.dao.oracle.OracleFreeboardFileDao;
import com.jhtacybercampus.web.entity.FreeBoard;
import com.jhtacybercampus.web.entity.FreeboardFile;


@WebServlet("/freeboard/reg")

@MultipartConfig(location = "D:\\temp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, // 5�ް�
maxRequestSize = 1024 * 1024 * 5 * 5 // 5�ް� 5������
)

public class RegController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardDao fbDao = new OracleFreeBoardDao();
		FreeBoard fb = new FreeBoard();
		FreeboardFileDao freeboardFileDao = new OracleFreeboardFileDao();

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int writer_id = Integer.parseInt(request.getParameter("writer_id"));
		System.out.println(writer_id);


		fb.setTitle(title);
		fb.setContent(content);
		fb.setWriter_id(writer_id);

		//D:\html5-1902
		Part filePart = request.getPart("file");
		//1.���ε� ��θ� ���
		String urlPath = "/upload";
		String path = request.getServletContext().getRealPath(urlPath);

		System.out.println("�̰��� path" + path);

		//2. ���ε�� ���ϸ� ���s
		String fileName = filePart.getSubmittedFileName();

		//3. ��α�����
		String filePath = path+File.separator+fileName; //File.separator-> "\\"
		System.out.println("�̰��� file path" + filePath);

		//4. ��ΰ� ���ٴ� ���� ����
		File pathFile = new File(path);
		if(!pathFile.exists())//�������� ������
			pathFile.mkdirs();//�������ּ���

		//5. ������ ���ϸ� ��ο� �̹� �����ϴ� ���� aa.jpg->aa(1).jpg
		//				File ? = new File(?);
		//				
		//				if(?�����Ѵٸ�) {
		//					����(Ȯ����)�� �߶� �̸��� ��� �� �������� �Ұ�ȣ()�� �ִ��� Ȯ���ϰ� ������ ��ȣ�� �˾Ƴ��� 1������ ���� �� fileName=?;
		//				}

		InputStream fis = filePart.getInputStream();
		FileOutputStream fos = new FileOutputStream("D:\\temp\\"+fileName);
		byte[] buf = new byte[1024];
		int size=0;
		while((size=fis.read(buf))!=-1) {
			fos.write(buf, 0, size);
		}

		fis.close();
		fos.close();

		int result=0;


		try {
			result= fbDao.insert(fb);

			int freeboardId = fbDao.getLastId();

			FreeboardFile freeboardFile = new FreeboardFile();
			System.out.println("�̰� freeboardFile" + freeboardFile);
			freeboardFile.setName(fileName);
			System.out.println("�̰� fileName" + fileName);
			freeboardFile.setFreeboardId(freeboardId);

			freeboardFileDao.insert(freeboardFile);
			System.out.println("�̰� freeboardFile1" + freeboardFile);
			System.out.println("�̰� fileName2" + fileName);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(title);

		if(result !=1)
			response.sendRedirect("error");
		else
			response.sendRedirect("list");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/freeboard/reg.jsp").forward(request, response);
	}

}
