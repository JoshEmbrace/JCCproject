package com.jhtacybercampus.web.controller.member.freeboard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
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


@WebServlet("/member/freeboard/edit")
@MultipartConfig(
      location="C:\\workspace\\JCCproject\\WebContent\\upload",
      fileSizeThreshold = 1024 * 1024,
      maxFileSize = 1024 * 1024 * 5,
      maxRequestSize = 1024 * 1024 * 5 * 5
      )
public class EditController extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      request.setCharacterEncoding("UTF-8");
      Integer id = Integer.parseInt(request.getParameter("id"));

      String title = request.getParameter("title");
      String content = request.getParameter("content");
      Integer writer_id = Integer.parseInt(request.getParameter("writer_id"));
      Part filePart = request.getPart("file");
     
      String urlPath = "/upload";
      String path = request.getServletContext().getRealPath(urlPath);
      String fileName = filePart.getSubmittedFileName();
      String filePath = path+File.separator+fileName; 
     

        File pathFile = new File(path);
         if(!pathFile.exists())
            pathFile.mkdirs();

         InputStream fis = filePart.getInputStream();
         OutputStream fos = new FileOutputStream("C:\\temp\\"+fileName);

         byte[] buf = new byte[1024];
         int size=0;
         while((size=fis.read(buf))!=-1) {
            fos.write(buf, 0, size);
         }

         fis.close();
         fos.close();
         
      
      FreeBoardDao fbDao = new OracleFreeBoardDao();
      FreeboardFileDao fbFileDao = new OracleFreeboardFileDao();
      FreeboardFile fbFile = new FreeboardFile();
      
      fbFile.setFreeboardId(id);
      fbFile.setName(fileName);

      
      try {
         fbDao.update(new FreeBoard(id, title, content,null, 0, writer_id));

         request.setAttribute("freeboard",fbDao.get(id));
         fbFileDao.update(fbFile);
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      request.getRequestDispatcher("/WEB-INF/view/freeboard/detail.jsp").forward(request, response);
   }


   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      FreeBoardDao fbDao = new OracleFreeBoardDao();
      FreeboardFileDao fbFileDao = new OracleFreeboardFileDao();
      Integer id = Integer.parseInt(request.getParameter("id"));
      try {
         request.setAttribute("freeboard",fbDao.get(Integer.parseInt(request.getParameter("id"))));
         request.setAttribute("files", fbFileDao.getListByFreeboardId(id));
      } catch (NumberFormatException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      request.getRequestDispatcher("/WEB-INF/view/freeboard/edit.jsp").forward(request, response);
   }
}

