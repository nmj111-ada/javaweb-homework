<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>三国演义 - 在线阅读</title>
    <!-- 注意：Style.css 在根目录，所以直接引用 -->
    <link rel="stylesheet" type="text/css" href="Style.css" id="theme-style">
</head>
<body>
    <div class="container">
        <header>
            <!-- 如果想显示封面图，可以在这里添加 -->
            <img src="images/sgyy_cover.jpg" alt="三国演义封面" style="width:200px;">
            <h1>三国演义</h1>
            <p class="author">罗贯中 著</p>
            <p class="intro">
                《三国演义》是中国古典四大名著之一，描写了从东汉末年到西晋初年之间近百年的历史风云，以描写战争为主，讲述了东汉末年的群雄割据混战和魏、蜀、吴三国之间的政治和军事斗争。
            </p>
        </header>

        <!-- 风格切换下拉框 -->
        <div class="theme-switcher">
            <label for="themeSelect">选择主题：</label>
            <select id="themeSelect">
                <option value="light">浅色背景</option>
                <option value="dark">深色背景</option>
            </select>
        </div>

        <nav class="catalog">
            <h2>目录（前五回）</h2>
            <ul>
                <li><a href="chapter1.jsp">第一回 宴桃园豪杰三结义 斩黄巾英雄首立功</a></li>
                <li><a href="chapter2.jsp">第二回 张翼德怒鞭督邮 何国舅谋诛宦官</a></li>
                <li><a href="chapter3.jsp">第三回 汉显祖许褚单枪匹马 破黄巾英雄孟获</a></li>
                <li><a href="chapter4.jsp">第四回 汉将杨彪小霸王 势倾曹营魏子春</a></li>
                <li><a href="chapter5.jsp">第五回 发矫诏诸镇应曹公 破关兵三英战吕布</a></li>
            </ul>
        </nav>
    </div>

    <!-- 注意：theme.js 在根目录，直接引用 -->
    <script src="theme.js"></script>
</body>
</html>