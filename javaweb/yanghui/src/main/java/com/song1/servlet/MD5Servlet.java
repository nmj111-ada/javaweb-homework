package com.song1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/md5")
public class MD5Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置编码，防止中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 获取用户输入的文本
        String text = request.getParameter("text");
        if (text == null || text.trim().isEmpty()) {
            out.println("<h3>请输入文字内容！</h3>");
            return;
        }

        // 计算 MD5
        String md5Hash = getMD5(text);

        // 输出 HTML 结果页面
        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>MD5 结果</title></head><body>");
        out.println("<h2>MD5 散列值计算结果</h2>");
        out.println("<p><strong>原始文本：</strong>" + escapeHtml(text) + "</p>");
        out.println("<p><strong>MD5 散列值：</strong>" + md5Hash + "</p>");
        out.println("<hr>");
        out.println("<a href='md5_input.html'>返回继续计算</a>");
        out.println("</body></html>");
    }

    /**
     * 计算字符串的 MD5 散列值（32 位十六进制字符串）
     */
    private String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | IOException e) {
            return "计算错误：" + e.getMessage();
        }
    }

    /**
     * 简单转义 HTML 特殊字符，防止 XSS
     */
    private String escapeHtml(String text) {
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&#39;");
    }
}
