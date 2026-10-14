package com.song1.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/yanghui")
public class YangHuiServlet extends HttpServlet {

   
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应内容类型和编码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 获取用户输入的阶数 n
        String nParam = request.getParameter("n");
        int n;
        try {
            n = Integer.parseInt(nParam);
            if (n <= 0) {
                out.println("<h3>请输入正整数 n！</h3>");
                return;
            }
        } catch (NumberFormatException e) {
            out.println("<h3>参数错误，请输入有效的整数！</h3>");
            return;
        }

        // 计算杨辉三角（二维数组）
        int[][] triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;          // 每行第一个为 1
            triangle[i][i] = 1;          // 每行最后一个为 1
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        // 输出 HTML 页面
        out.println("<!DOCTYPE html>");
        out.println("<html><head><meta charset='UTF-8'><title>杨辉三角</title>");
        out.println("<style>");
        out.println("table { border-collapse: collapse; margin: 20px; }");
        out.println("td { border: 1px solid #333; padding: 8px 12px; text-align: center; }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<h2>" + n + " 阶杨辉三角</h2>");
        out.println("<table>");

        // 用表格形式输出杨辉三角
        for (int i = 0; i < n; i++) {
            out.println("<tr>");
            // 为了居中美观，可以在前面加空单元格（可选）
            for (int j = 0; j <= i; j++) {
                out.println("<td>" + triangle[i][j] + "</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<br><a href='yanghui_input.html'>返回重新输入</a>");
        out.println("</body></html>");
    }
}