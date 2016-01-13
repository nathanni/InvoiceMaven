package com.atriumwindows.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by nni on 1/13/2016.
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/download"})
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getParameter("filename");
        System.out.println(path);
        try  {
            File file  =   new  File(path);
            String filename  =  file.getName();
            String ext  =  filename.substring(filename.lastIndexOf( " . " )  +   1 ).toUpperCase();

            InputStream fis  =   new BufferedInputStream( new FileInputStream(path));
            byte [] buffer  =   new   byte [fis.available()];
            fis.read(buffer);
            fis.close();
            response.reset();
            response.addHeader( " Content-Disposition " ,  " attachment;filename= "   +   new  String(filename.getBytes()));
            response.addHeader( " Content-Length " ,  ""   +  file.length());
            OutputStream toClient  =   new BufferedOutputStream(response.getOutputStream());
            response.setContentType( "application/pdf" );
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        }  catch  (IOException ex) {
            ex.printStackTrace();
        }
    }
}
